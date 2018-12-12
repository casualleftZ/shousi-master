package comqwera.mingrisoft.shousi.user_fuzhu;

public class User {
    private String xinxi;
    private String information;
    public User(String xinxi,String information){
        this.xinxi=xinxi;
        this.information=information;

    }
    public String getXinxi(){
        return xinxi;
    }

    public String getInformation() {
        return information;
    }
}
