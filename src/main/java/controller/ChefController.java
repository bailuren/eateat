package controller;

import entity.Chef;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ChefService;

import java.util.List;

@Controller
@RequestMapping(value = "/chef")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ChefController {

    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    @ResponseBody
    public String loginCheck(@RequestBody String req){
        JSONObject jsonObject = JSONObject.fromObject(req);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        Chef chef = ChefService.selectChef(username,password);
        JSONObject object = new JSONObject();
        if(chef == null){
            object.put("ok",0);
        }else{
            object.put("ok",1);
            object.put("chef",chef);
        }
        return object.toString();
    }

    @RequestMapping(value="/selectChefAll",method = RequestMethod.POST)
    @ResponseBody
   public String selectChefAll(){
        List<Chef> list = ChefService.selectChefAll();
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
   }
}
