package mapper;

import entity.Food;

import java.io.FileOutputStream;
import java.util.List;

public interface FoodMapper {
    int insertFood(Food food);
    int updateFood(Food food);
    int deleteFood(int id);
    Food selectFoodById(int id);
    List<Food> selectFoodAll();
}
