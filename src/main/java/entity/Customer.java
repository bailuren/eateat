package entity;

import java.util.Date;

/**
 * 顾客
 */
public class Customer {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String birthday;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public Customer(){}

    public Customer(int id, String password, String username, String phone, String birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.birthday = birthday;
    }
    public Customer(int id, String username, String phone, String birthday) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.birthday = birthday;
    }

    public Customer(String username, String password, String phone, String birthday) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
