package service;

import entity.Admin;
import mapper.AdminMapper;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

public class AdminService {

    public static boolean insertAdmin(Admin admin){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        int flag = 0;
        try {
            flag = adminMapper.insertAdmin(admin);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag != 0;
    }

    public static boolean deleteAdmin(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        int flag = 0;
        try {
            flag = adminMapper.deleteAdmin(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag != 0;
    }

    public static boolean updateAdmin(Admin admin){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        int flag = 0;
        try {
            flag = adminMapper.updateAdmin(admin);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag != 0;
    }

    public static Admin selectAdminById(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        Admin admin = null;
        try {
            admin = adminMapper.selectAdminById(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return admin;
    }

    public static Admin selectAdminByUsername(String username,String password){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        Admin admin = null;
        try {
            admin = adminMapper.selectAdminByUsername(username,password);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return admin;
    }
}
