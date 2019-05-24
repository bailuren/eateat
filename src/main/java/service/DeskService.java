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
}
