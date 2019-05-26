package controller;

import entity.Food;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.FoodService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="/food")
@CrossOrigin(origins = "*",maxAge = 3600)
public class FoodController {

    @RequestMapping(value = "/selectFoodAll",method = RequestMethod.POST)
    @ResponseBody()
    public String selectFoodAll(){
        List<Food> list = FoodService.selectFoodAll();
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    @RequestMapping(value="/insertFood",method = RequestMethod.POST)
    @ResponseBody
    public String insertFood(@RequestBody String req){
        JSONObject object = JSONObject.fromObject(req);
        Food food = new Food(object.getString("name"),object.getDouble("price"),object.getInt("type"));
        JSONObject jsonObject = new JSONObject();
        if(FoodService.insertFood(food)){
            jsonObject.put("ok",1);
        }else{
            jsonObject.put("ok",0);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/updateFood",method = RequestMethod.POST)
    @ResponseBody
    public String updateFood(@RequestBody String req){
        JSONObject object =JSONObject.fromObject(req);
        Food food = new Food(object.getInt("id"),object.getString("name"),
                object.getDouble("price"),object.getInt("type"));
        JSONObject jsonObject = new JSONObject();
        if(FoodService.updateFood(food)){
            jsonObject.put("ok",1);
        }else{
            jsonObject.put("ok",0);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/deleteFood",method = RequestMethod.POST)
    @ResponseBody
    public String deleteFood(@RequestBody String req){
        JSONObject object = JSONObject.fromObject(req);
        JSONObject jsonObject = new JSONObject();
        if(FoodService.deleteFood(object.getInt("id"))){
            jsonObject.put("ok",1);
        }else{
            jsonObject.put("ok",0);
        }
        return jsonObject.toString();
    }
}
