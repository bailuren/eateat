package controller;


import entity.Food;
import entity.Order;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.OrderAndFoodService;
import service.OrderService;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {
    @RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
    @ResponseBody
    public String insertOrder(@RequestBody String req) {
        JSONObject object = JSONObject.fromObject(req);
        JSONArray jsonArray = object.getJSONArray("menu");
        List<Food> menu = JSONArray.toList(jsonArray, new Food(), new JsonConfig());
        Order order = new Order(object.getInt("deskId"), object.getInt("state"),
                object.getInt("customerId"), object.getDouble("totalPrice"),
                object.getString("time"), menu);
        JSONObject jsonObject = new JSONObject();
        if (OrderService.insertOrder(order) && OrderAndFoodService.insertOrderAndFood(order.getId(), order.getMenu())) {
            jsonObject.put("ok", 1);
        } else {
            jsonObject.put("ok", 0);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public String deleteOrder(@RequestBody String req) {
        JSONObject object = JSONObject.fromObject(req);
        int id = object.getInt("id");
        JSONObject jsonObject = new JSONObject();
        if (OrderService.deleteOrder(id)) {
            OrderAndFoodService.deleteOrderAndFood(id);
            jsonObject.put("ok", 1);
        } else {
            jsonObject.put("ok", 0);
        }
        return jsonObject.toString();
    }


    @RequestMapping(value = "/selectOrderAll", method = RequestMethod.POST)
    @ResponseBody
    public String selectOrderAll() {
        List<Order> list = OrderService.selectOrderAll();
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    @RequestMapping(value = "/selectOrderByCustomerId", method = RequestMethod.POST)
    @ResponseBody
    public String selectOrderByCustomerId(@RequestBody String req) {
        JSONObject jsonObject = JSONObject.fromObject(req);
        int id = jsonObject.getInt("id");
        JSONArray jsonArray = null;
        List<Order> list = OrderService.selectOrderByCustomerId(id);
        JSONObject object = new JSONObject();
        if (list == null) {
            object.put("ok", 0);
        } else {
            object.put("ok", 1);
            jsonArray = JSONArray.fromObject(list);
            object.put("list", jsonArray);
        }
        return object.toString();
    }

    @RequestMapping(value = "/selectOrderUndo", method = RequestMethod.POST)
    @ResponseBody
    public String selectOrderUndo() {
        List<Order> list = OrderService.selectOrderUndo();
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    @RequestMapping(value = "/updateOrderState", method = RequestMethod.POST)
    @ResponseBody
    public String updateOrderState(@RequestBody String req) {
        synchronized (req) {
            JSONObject jsonObject = JSONObject.fromObject(req);
            int chefId = jsonObject.getInt("chefId");
            int orderId = jsonObject.getInt("orderId");
            JSONObject object = new JSONObject();
            if (OrderService.selectOrderChefId(orderId) == 0) {
                if (OrderService.updateOrderState(orderId, chefId)) {
                    object.put("ok", 1);
                } else {
                    object.put("ok", 0);
                }
            } else {
                object.put("ok", 0);
            }
            return object.toString();
        }
    }

    @RequestMapping(value = "/updateOrderState1", method = RequestMethod.POST)
    @ResponseBody
    public String updateOrderState1(@RequestBody String req) {
        JSONObject jsonObject = JSONObject.fromObject(req);
        int orderId = jsonObject.getInt("orderId");
        JSONObject object = new JSONObject();
        if (OrderService.updateOrderState1(orderId)) {
            object.put("ok", 1);
        } else {
            object.put("ok", 0);
        }
        return object.toString();
    }

    @RequestMapping(value = "/selectOrderByChefId", method = RequestMethod.POST)
    @ResponseBody
    public String selectOrderByChefId(@RequestBody String req) {
        JSONObject jsonObject = JSONObject.fromObject(req);
        int id = jsonObject.getInt("id");
        List<Order> list = OrderService.selectOrderByChefId(id);
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
}
