package mapper;

import entity.Admin;

public interface AdminMapper {
    int insertAdmin(Admin admin);
    Admin selectAdminById(int id);
    Admin selectAdminByUsername(String username,String password);
    int updateAdmin(Admin admin);
    int deleteAdmin(int id);
}
