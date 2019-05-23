package controller;


import entity.Admin;
import entity.Customer;
import mapper.AdminMapper;
import org.apache.ibatis.session.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import util.SqlSessionFactoryUtil;


@Controller
@RequestMapping(value="/client")
public class MainController {
    @RequestMapping(value="/")
    public String hello(){
        /*SqlSession session = SqlSessionFactoryUtil.getSession();
        try{
            AdminMapper adminMapper = session.getMapper(AdminMapper.class);
            Admin admin = new Admin("yuruowang","yuruowang","123456","10086");
            adminMapper.insertAdmin(admin);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }*/
        return "index";
    }


}
