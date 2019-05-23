package controller;

import entity.Food;
import entity.Order;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.OrderAndFoodService;
import service.OrderService;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value="/order")
@CrossOrigin(origins = "*",maxAge = 3600)
public class OrderController {

    @RequestMapping(value="/insertOrder",method = RequestMethod.POST)
    @ResponseBody
    public String insertOrder(@RequestBody Order order){
        JSONObject jsonObject = new JSONObject();
        if(OrderService.insertOrder(order)){
            OrderAndFoodService.insertOrderAndFood(order.getId(),order.getMenu());
            jsonObject.put("ok",1);
        }else{
            jsonObject.put("ok",0);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/deleteOrder",method = RequestMethod.POST)
    @ResponseBody
    public String deleteOrder(int id){
        JSONObject jsonObject = new JSONObject();
        if(OrderService.deleteOrder(id)){
            OrderAndFoodService.deleteOrderAndFood(id);
            jsonObject.put("ok",1);
        }else{
            jsonObject.put("ok",0);
        }
        return jsonObject.toString();
    }


    @RequestMapping(value="/selectOrderAll",method = RequestMethod.POST)
    @ResponseBody
    public String selectOrderAll(){
        List<Order> list = OrderService.selectOrderAll();
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
}
