package entity;

import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class Order {
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Integer getChefId() {
        return chefId;
    }

    public void setChefId(Integer chefId) {
        this.chefId = chefId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public List<Food> getMenu() {
        return menu;
    }

    public void setMenu(List<Food> menu) {
        this.menu = menu;
    }

    private int id;
    private int deskId;
    private int state;
    private int customerId;
    private Integer chefId;
    private double totalPrice;
    private String time;
    private List<Food> menu;

    public Order(int id, int deskId, double totalPrice, String time,int state, int customerId, int chefId, List<Food> menu) {
        this.id = id;
        this.deskId = deskId;
        this.state = state;
        this.customerId = customerId;
        this.chefId = chefId;
        this.totalPrice = totalPrice;
        this.time = time;
        this.menu = menu;
    }

    public Order(int id, int deskId, int state, int customerId, double totalPrice, String time, List<Food> menu) {
        this.id = id;
        this.deskId = deskId;
        this.state = state;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.time = time;
        this.menu = menu;
    }

    public Order(int id, int deskId, double totalPrice, String time,int state, int customerId)  {
        this.id = id;
        this.deskId = deskId;
        this.state = state;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.time = time;
    }
    public Order(int id, int deskId, double totalPrice, String time,int state, int customerId,Integer chefId)  {
        this.id = id;
        this.deskId = deskId;
        this.state = state;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.time = time;
        this.chefId = chefId;
    }

    public Order(int id, int deskId, double totalPrice, String time, List<Food> menu) {
        this.id = id;
        this.deskId = deskId;
        this.totalPrice = totalPrice;
        this.time = time;
        this.menu = menu;
    }
    public Order(int deskId, int state, int customerId, double totalPrice, String time, List<Food> menu) {
        this.deskId = deskId;
        this.totalPrice = totalPrice;
        this.time = time;
        this.menu = menu;
        this.state = state;
        this.customerId = customerId;
    }

    public Order(){}

}
