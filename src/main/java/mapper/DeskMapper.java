package mapper;

import entity.Desk;

import java.util.List;

public interface DeskMapper {
    int insertDesk(Desk desk);
    int updateDesk(int id);
    int deleteDesk(int id);
    Desk selectDesk(int id);
    List<Desk> selectAllDesk();
    List<Desk> selectEmptyDesk();
}
