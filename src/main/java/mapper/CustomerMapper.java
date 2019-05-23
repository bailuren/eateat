package mapper;

import entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    //插入顾客
    int insertCustomer(Customer customer);
    //更新顾客
    int updateCustomer(Customer customer);
    //通过账号密码查找用户
    Customer selectCustomerByUsername(@Param("username") String username, @Param("password") String password);
    //通过id查找用户
    Customer selectCustomerById(int id);
    //查询所有的顾客信息
    List<Customer> selectCustomerAll();
    //删除顾客
    int deleteCustomer(int id);
}
