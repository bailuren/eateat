package mapper;

import entity.Chef;

public interface ChefMapper {
    int insertChef(Chef chef);
    int updateChef(int id);
    int deleteChef(int id);
    Chef selectChef(int id);
}
