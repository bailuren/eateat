package mapper;

import entity.Desk;

import java.util.List;

public interface DeskMapper {
    int insertDesk(Desk desk);
    int updateDesk(int id);
    int deleteDesk(int id);
    List<Desk> selectDeskAll();
    List<Desk> selectEmptyDesk(int type);

    int updateDeskState1(int id);
    int updateDeskState0(int id);
}
