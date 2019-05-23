package mapper;

import entity.Board;

public interface BoardMapper {
    public int insertBoard(Board board);
    public int updateBoard(int id);
    public int deleteBoard(int id);
    public Board selectBoard(int id);
}
