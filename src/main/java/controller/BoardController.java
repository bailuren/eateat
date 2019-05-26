package controller;

import entity.Board;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.BoardService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@RequestMapping(value = "/board")
@CrossOrigin(origins = "*",maxAge = 3600)
public class BoardController {

    @RequestMapping(value = "/insertBoard",method = RequestMethod.POST)
    @ResponseBody
    public String insertBoard(@RequestBody String req){
        JSONObject jsonObject = JSONObject.fromObject(req);
        String message = jsonObject.getString("message");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = format.getCalendar();
        Board board = new Board(calendar.toString(),message);
        if(BoardService.insertBorad(board)){
            jsonObject.put("ok",1);
        }else{
            jsonObject.put("ok",0);
        }
        return jsonObject.toString();
    }
}
