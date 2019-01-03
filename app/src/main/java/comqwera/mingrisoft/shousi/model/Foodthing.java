package comqwera.mingrisoft.shousi.model;

public class Foodthing {
    private String food_name;
    private int food_count;
    private float food_num_money;
    public Foodthing(String food_name,int food_count,float food_num_money){
        this.food_name=food_name;
        this.food_count=food_count;
        this.food_num_money=food_num_money;
    }

    public String getFood_name() {
        return food_name;
    }

    public int getFood_count() {
        return food_count;
    }

    public float getFood_num_money() {
        return food_num_money;
    }
}
