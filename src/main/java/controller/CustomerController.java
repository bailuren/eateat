package controller;

import entity.Customer;
import entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;
import net.sf.json.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="/customer")
@CrossOrigin(origins="*",maxAge = 3600)
public class CustomerController {

    /**
     * 当点击登录按钮
     * @return 跳转至登录界面
     */
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
            return "customer/login.jsp";
    }


    /**
     * 当点击登录时
     * @return 返回成功
     */
    @RequestMapping(value="/loginCheck",method=RequestMethod.POST)
    @ResponseBody
    public String loginCheck(@RequestBody String req){
        JSONObject object = JSONObject.fromObject(req);
        String username = object.getString("username");
        String password = object.getString("password");
        Customer customer = CustomerService.selectCustomerByUsername(username,password);
        JSONObject jsonObject = new JSONObject();
        if(customer!=null) {
            jsonObject.put("ok",1);
            jsonObject.put("customer",customer);
        }
        else{
            jsonObject.put("ok",0);
        }
        return jsonObject.toString();
    }

    /**
     * 注册页面
     * @return 跳转至注册界面
     */
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(){
        return "register.jsp";
    }

    /**
     *  注册检查
     * @return 返回登录界面
     */
    @RequestMapping(value="/registerCheck",method=RequestMethod.POST)
    @ResponseBody
    public String registerCheck(@RequestBody String req){
        JSONObject object = JSONObject.fromObject(req);
        String username = object.getString("username");
        String password = object.getString("password");
        String phone = object.getString("phone");
        String birthday = object.getString("birthday");
        Customer customer = new Customer(username,password,phone,birthday);
        JSONObject jsonObject = new JSONObject();
        if(CustomerService.insertCustomer(customer)){
            jsonObject.put("ok",1);
            jsonObject.put("customer",customer);
        }else{
            jsonObject.put("ok",0);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value="/selectCustomerAll",method = RequestMethod.POST)
    @ResponseBody
    public String selectCustomerAll(){
        List<Customer> list = CustomerService.selectCustomerAll();
        JSONArray jsonArray = null;
        if(list == null){

        }else{
            jsonArray = JSONArray.fromObject(list);
        }
        return jsonArray.toString();
    }
    @RequestMapping(value="/updateCustomer",method = RequestMethod.POST)
    @ResponseBody
    public String updateCustomer(@RequestBody Customer customer){
        /*JSONObject object = JSONObject.fromObject(req);
        int id = object.getInt("id");*/
        System.out.println(customer.toString()+"\n\n\n\n");
        JSONObject jsonObject = new JSONObject();
        if(CustomerService.updateCustomer(customer)){
            jsonObject.put("ok",1);
        }else{
            jsonObject.put("ok",0);
        }
        return jsonObject.toString();
    }
}
