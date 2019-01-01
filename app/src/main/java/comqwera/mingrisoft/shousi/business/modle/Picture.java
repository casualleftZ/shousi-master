package comqwera.mingrisoft.shousi.business.modle;

import android.widget.ImageView;

public class Picture {
    private String title;    //定义字符串
    private int imageId;     //定义int变量，表示图像的二进制值
    public Picture(){
        super();
    }
    public Picture(String title,int imageId)
    {
        super();
        this.title=title;
        this.imageId=imageId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
