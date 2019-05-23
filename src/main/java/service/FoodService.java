package service;

import entity.Food;
import mapper.FoodMapper;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import java.util.List;

public class FoodService {

    /**
     * 创建菜品
     * @param food
     * @return
     */
    public static boolean insertFood(Food food){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        FoodMapper foodMapper = session.getMapper(FoodMapper.class);
        int flag = 0;
        try{
            flag = foodMapper.insertFood(food);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0;
    }

    /**
     * 更新菜品
     * @param food
     * @return
     */
    public static boolean updateFood(Food food){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        FoodMapper foodMapper = session.getMapper(FoodMapper.class);
        int flag = 0;
        try{
            flag = foodMapper.updateFood(food);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0;
    }

    /**
     * 删除菜品
     * @param id
     * @return
     */
    public static boolean deleteFood(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        FoodMapper foodMapper = session.getMapper(FoodMapper.class);
        int flag = 0;
        try {
            flag = foodMapper.deleteFood(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0;
    }

    /**
     * 通过ID查询菜品
     * @param id
     * @return
     */
    public static Food selectFoodById(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        FoodMapper foodMapper = session.getMapper(FoodMapper.class);
        Food food = null;
        try {
            food = foodMapper.selectFoodById(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return food;
    }

    /**
     * 查看所有菜品
     * @return
     */
    public static List<Food> selectFoodAll(){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        FoodMapper foodMapper = session.getMapper(FoodMapper.class);
        List<Food> list = null;
        try {
            list = foodMapper.selectFoodAll();
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
}
