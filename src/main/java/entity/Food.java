package entity;

/**
 * 菜品
 */
public class Food {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
    private int id;
    private double price;
    private int type;
    private Integer num;
    private String name;

    public Food(){

    }
    public Food(int id, String name,double price, int type,Integer num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.num = num;
    }

    public Food(String name,double price, int type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
    public Food(int id,String name,double price, int type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
