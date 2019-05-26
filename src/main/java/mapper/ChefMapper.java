package mapper;

import entity.Chef;

import java.util.List;

public interface ChefMapper {
    int insertChef(Chef chef);
    int updateChef(int id);
    int deleteChef(int id);
    Chef selectChef(String username,String password);
    int selectChefOrderNum(int id);
    List<Chef> selectChefAll();
}
