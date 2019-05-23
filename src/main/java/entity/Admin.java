package entity;

/**
 * 管理员
 */
public class Admin {
    private int id;
    private String password;
    private String name;
    private String username;
    private String phone;

    public Admin(int id, String password, String name, String username, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.username = username;
        this.phone = phone;
    }



    public Admin(String name,String username,String password,String phone) {
        this.password = password;
        this.name = name;
        this.username = username;
        this.phone = phone;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
