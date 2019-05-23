package controller;

import entity.Desk;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DeskService;

import java.util.List;

@RequestMapping(value="/desk")
@Controller
public class DeskController {

    @RequestMapping(value = "/selectDesk",method = RequestMethod.POST)
    @ResponseBody
    public String selectDesk(){
        List<Desk> list = null;
        list = DeskService.selectEmptyDesk();
        if(list == null){
            
        }else{

        }
    }
}
