package mapper;

import entity.Order;

import java.util.List;

public interface OrderMapper {
    int updateOrderState(int orderId,int chefId);
    int deleteOrder(int id);
    List<Order> selectOrderAll();
    int insertOrder(Order order);
    int selectFoodNum(int orderId,int foodId);
    List<Order> selectOrderUndo();
    List<Order> selectOrderByCustomerId(int id);

    List<Order> selectOrderByChefId(int id);
}
