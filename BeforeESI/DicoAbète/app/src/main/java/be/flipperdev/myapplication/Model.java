package be.flipperdev.myapplication;

public class Model {
    String title;
    String desc;


    public Model(String title, String desc){
        this.title = title;
        this.desc = desc;

    }

    public String getTitle(){
        return this.title;
    }

    public String getDesc(){
        return this.desc;
    }


}
