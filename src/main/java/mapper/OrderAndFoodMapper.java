package mapper;

import entity.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderAndFoodMapper {
    int insertOrderAndFood(int id,@Param("menu") List<Food> menu);
    int deleteOrderAndFood(int id);
}
