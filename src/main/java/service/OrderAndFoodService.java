package service;

import entity.Food;
import mapper.OrderAndFoodMapper;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import java.util.List;

public class OrderAndFoodService {
    public static boolean insertOrderAndFood(int id, List<Food> menu){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        OrderAndFoodMapper orderAndFoodMapper = session.getMapper(OrderAndFoodMapper.class);
        int flag = 0;
        try{
            flag = orderAndFoodMapper.insertOrderAndFood(id,menu);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0?true:false;
    }

    public static boolean deleteOrderAndFood(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        OrderAndFoodMapper orderAndFoodMapper = session.getMapper(OrderAndFoodMapper.class);
        int flag = 0;
        try {
            flag = orderAndFoodMapper.deleteOrderAndFood(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0?true:false;
    }

}
