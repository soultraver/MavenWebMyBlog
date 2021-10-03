package com.lhlz.model;

public class Category {
    private int id;
    private String main_id_name;
    private String sub_id_name;
    private String catagory_created_at;

    public Category() {
    }

    public Category(int id, String main_id_name, String sub_id_name, String catagory_created_at) {
        this.id = id;
        this.main_id_name = main_id_name;
        this.sub_id_name = sub_id_name;
        this.catagory_created_at = catagory_created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain_id_name() {
        return main_id_name;
    }

    public void setMain_id_name(String main_id_name) {
        this.main_id_name = main_id_name;
    }

    public String getSub_id_name() {
        return sub_id_name;
    }

    public void setSub_id_name(String sub_id_name) {
        this.sub_id_name = sub_id_name;
    }

    public String getCatagory_created_at() {
        return catagory_created_at;
    }

    public void setCatagory_created_at(String catagory_created_at) {
        this.catagory_created_at = catagory_created_at;
    }
}
