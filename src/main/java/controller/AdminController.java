package controller;

import entity.Admin;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.AdminService;

@Controller
@RequestMapping(value="/admin")
@CrossOrigin(origins = "*",maxAge = 3600)
public class AdminController {
    /**
     * 当点击登录按钮
     * @return 跳转至登录界面
     */
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String adminLogin(){
        return "admin/login.jsp";
    }

    /**
     * 校验登录
     */
    @RequestMapping(value="/logincheck",method=RequestMethod.POST)
    @ResponseBody
    public String loginCheck(@RequestBody String req){
        JSONObject object = JSONObject.fromObject(req);
        JSONObject jsonObject = new JSONObject();
        Admin admin = AdminService.selectAdminByUsername(object.getString("username"),object.getString("password"));
        if(admin!=null) {
            jsonObject.put("ok",1);
            jsonObject.put("admin",admin);
        }
        else{
            jsonObject.put("ok",0);
        }
        return jsonObject.toString();
    }

}
