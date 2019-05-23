package service;

import entity.Customer;
import mapper.CustomerMapper;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

import java.util.List;

public class CustomerService {

    public static boolean insertCustomer(Customer customer){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        CustomerMapper customerMapper =session.getMapper(CustomerMapper.class);
        int flag = 0;
        try{
            flag = customerMapper.insertCustomer(customer);
            session.commit();
        }catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0;
    }

    public static Customer selectCustomerById(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        CustomerMapper customerMapper =session.getMapper(CustomerMapper.class);
        Customer customer = null;
        try {
            customer = customerMapper.selectCustomerById(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return customer;
    }

    public static List<Customer> selectCustomerAll(){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        CustomerMapper customerMapper =session.getMapper(CustomerMapper.class);
        List<Customer> list = null;
        try{
            list = customerMapper.selectCustomerAll();
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
    public static Customer selectCustomerByUsername(String username,String password){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        CustomerMapper customerMapper =session.getMapper(CustomerMapper.class);
        Customer customer = null;
        try {
            customer = customerMapper.selectCustomerByUsername(username, password);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return customer;
    }
    public static boolean updateCustomer(Customer customer){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        CustomerMapper customerMapper =session.getMapper(CustomerMapper.class);
        int flag = 0;
        try {
            flag = customerMapper.updateCustomer(customer);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0;
    }

    public static boolean deleteCustomer(int id){
        SqlSession session = SqlSessionFactoryUtil.getSession();
        CustomerMapper customerMapper =session.getMapper(CustomerMapper.class);
        int flag = 0;
        try {
            flag = customerMapper.deleteCustomer(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return flag!=0;
    }

}
