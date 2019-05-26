package service;

import entity.Board;
import mapper.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

public class BoardService {

    public static boolean insertBorad(Board board){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        BoardMapper boardMapper = session.getMapper(BoardMapper.class);
        int flag = 0;
        try{
            flag = boardMapper.insertBoard(board);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0;
    }
}
