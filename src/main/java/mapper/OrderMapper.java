package mapper;

import entity.Food;
import entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteOrder(int id);
    List<Order> selectOrderAll();
    int insertOrder(Order order);
}
