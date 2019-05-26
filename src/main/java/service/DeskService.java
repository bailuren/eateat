package service;

import entity.Desk;
import mapper.DeskMapper;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import java.util.List;

public class DeskService {
    public static List<Desk> selectEmptyDesk(int type){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        DeskMapper deskMapper = session.getMapper(DeskMapper.class);
        List<Desk> list = null;
        try{
            list = deskMapper.selectEmptyDesk(type);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    public static boolean updateDeskState1(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        DeskMapper deskMapper = session.getMapper(DeskMapper.class);
        int flag = 0;
        try{
            flag = deskMapper.updateDeskState1(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0;
    }

    public static boolean updateDeskState0(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        DeskMapper deskMapper = session.getMapper(DeskMapper.class);
        int flag = 0;
        try{
            flag = deskMapper.updateDeskState0(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0;
    }

    public static boolean deleteDesk(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        DeskMapper deskMapper = session.getMapper(DeskMapper.class);
        int flag = 0;
        try{
            flag = deskMapper.deleteDesk(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0;
    }

    public static List<Desk> selectDeskAll(){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        DeskMapper deskMapper = session.getMapper(DeskMapper.class);
        List<Desk> list = null;
        try{
            list = deskMapper.selectDeskAll();
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
