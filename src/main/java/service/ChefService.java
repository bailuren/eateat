package service;

import entity.Chef;
import mapper.ChefMapper;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import java.util.List;

public class ChefService {
    public static Chef selectChef(String username,String password){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        ChefMapper chefMapper = session.getMapper(ChefMapper.class);
        Chef chef = null;
        try{
            chef = chefMapper.selectChef(username,password);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return chef;
    }

    public static int selectChefOrderNum(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        ChefMapper chefMapper = session.getMapper(ChefMapper.class);
        int flag = 0;
        try{
            flag = chefMapper.selectChefOrderNum(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag;
    }

    public static List<Chef> selectChefAll(){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        ChefMapper chefMapper = session.getMapper(ChefMapper.class);
        List<Chef> list =null;
        try{
            list = chefMapper.selectChefAll();
            for(Chef chef : list){
                int num = chefMapper.selectChefOrderNum(chef.getId());
                chef.setOrderNum(num);
            }
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
