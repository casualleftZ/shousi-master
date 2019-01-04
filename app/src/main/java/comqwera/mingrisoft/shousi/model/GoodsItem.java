package comqwera.mingrisoft.shousi.model;

import comqwera.mingrisoft.shousi.DAO.FoodDAO;
import comqwera.mingrisoft.shousi.activity.activity.ShoppingCartActivity;

import java.util.ArrayList;

public class GoodsItem {
    public int id;
    public int typeId;  //
    public int rating;
    public String name;
    public String typeName;
    public float price;
    public int count;
    public String f_picture;

    public GoodsItem(int id, float price, String name, int typeId, String typeName, String f_picture,int rating) {
        this.id = id;       //食物编号
        this.price = price;//种类价格
        this.name = name;   //食物名称
        this.typeId = typeId;  //种类编号
        this.typeName = typeName;//种类名称
        this.f_picture=f_picture;  //图片
        this.rating=rating;     //销量
    }

    private static ArrayList<GoodsItem> goodsList;
    private static ArrayList<GoodsItem> typeList;

    private static void initData(){
        goodsList = new ArrayList<>();
        typeList = new ArrayList<>();
        GoodsItem item = null;
        FoodDAO foodDAO=new FoodDAO(ShoppingCartActivity.mshoppingCartActivity);
        int k=1;
        for(int i=1;i<7;i++) {

            Food food[]=foodDAO.findall("f_type_id",i);
            if(food.length==0){
                for (int j = 0; j <5 ; j++) {
                    item = new GoodsItem(100 * i + i, 3, "蛇皮", i, "主食" + i,"tupiandaitianjia",22);
                    goodsList.add(item);
                }
            }

            else{
                for (int j = 0; j <food.length ; j++) {
                String a = food[j].getF_name();
//                String a="鸡";
                if (a == null) {
                    item = new GoodsItem(100 * i + j, 3, "蛇皮", i, "主食" + i,"tupiandaitianjia",22);
                    goodsList.add(item);
                } else {
                    item = new GoodsItem(100 * i + j, food[j].getF_price(), a, i, food[j].getF_type(),food[j].getF_url(),food[j].getF_sellcount());
                    goodsList.add(item);
                }

            }
            }
            typeList.add(item);

        }
    }

    public static ArrayList<GoodsItem> getGoodsList(){
        if(goodsList==null){
            initData();
        }
        return goodsList;
    }
    public static ArrayList<GoodsItem> getTypeList(){
        if(typeList==null){
            initData();
        }
        return typeList;
    }
}
