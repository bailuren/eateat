package controller;

import entity.Desk;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.DeskService;

import java.util.List;

@RequestMapping(value="/desk")
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class DeskController {

    @RequestMapping(value = "/selectEmptyDesk",method = RequestMethod.POST)
    @ResponseBody
    public String selectDesk(@RequestBody String req){
        JSONObject jsonObject = JSONObject.fromObject(req);
        int num = jsonObject.getInt("num");
        int type=0;
        if(num<=4)
            type=1;
        else if(num<=8)
            type=2;
        else type=3;
        List<Desk> list = DeskService.selectEmptyDesk(type);
        JSONObject object = new JSONObject();
        if(list == null){
            object.put("ok",0);
        }else{
            object.put("ok",1);
            object.put("desk",list.get(0));
            DeskService.updateDeskState1(list.get(0).getId());
        }
        return object.toString();
    }

    @RequestMapping(value = "/selectDeskAll",method = RequestMethod.POST)
    @ResponseBody
    public String selectDeskAll(){
        List<Desk> list = DeskService.selectDeskAll();
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    @RequestMapping(value = "/updateDeskState0",method = RequestMethod.POST)
    @ResponseBody
    public String updateDeskState0(@RequestBody String req){
        JSONObject jsonObject = JSONObject.fromObject(req);
        int id = jsonObject.getInt("id");
        JSONObject object  = new JSONObject();
        if(DeskService.updateDeskState0(id)){
            object.put("ok",1);
        }else{
            object.put("ok",0);
        }
        return object.toString();
    }

    @RequestMapping(value = "/deleteDesk",method = RequestMethod.POST)
    @ResponseBody
    public String deleteDesk(@RequestBody String req){
        JSONObject jsonObject = JSONObject.fromObject(req);
        int id = jsonObject.getInt("id");
        JSONObject object  = new JSONObject();
        if(DeskService.deleteDesk(id)){
            object.put("ok",1);
        }else{
            object.put("ok",0);
        }
        return object.toString();
    }
}
