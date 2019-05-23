package service;

import entity.Order;
import mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import java.util.List;

public class OrderService {

    /**
     *  查询所有订单信息
     * @return
     */
    public static List<Order> selectOrderAll(){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        List<Order> list = null;
        try{
            list = orderMapper.selectOrderAll();
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    /**
     * 删除id的订单信息
     * @param id 要删除的订单的id
     * @return
     */
    public static boolean deleteOrder(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        int flag = 0;
        try {
            flag = orderMapper.deleteOrder(id);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return flag!=0;
    }

    /**
     * 创建一个订单
     * @param order
     * @return
     */
    public static boolean insertOrder(Order order){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        int flag = 0;
        try{
            flag = orderMapper.insertOrder(order);
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
