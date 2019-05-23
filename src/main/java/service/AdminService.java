package service;

import entity.Admin;
import mapper.AdminMapper;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

public class AdminService {
    private static SqlSession session = SqlSessionFactoryUtil.getSession();
    private static AdminMapper adminMapper = session.getMapper(AdminMapper.class);

    public static boolean insertAdmin(Admin admin){
        int id  = adminMapper.insertAdmin(admin);
        admin.setId(id);
        return true;
    }

    public static boolean deleteAdmin(int id){
        adminMapper.deleteAdmin(id);
        return true;
    }

    public static boolean updateAdmin(Admin admin){
        adminMapper.updateAdmin(admin);
        return true;
    }

    public static Admin selectAdminById(int id){
        Admin admin = adminMapper.selectAdminById(id);
        return admin;
    }

    public static Admin selectAdminByUsername(String username,String password){
        Admin admin = adminMapper.selectAdminByUsername(username,password);
        return admin;
    }
}
