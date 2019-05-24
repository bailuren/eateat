package controller;

import entity.Desk;
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
        }
        return object.toString();
    }
}
