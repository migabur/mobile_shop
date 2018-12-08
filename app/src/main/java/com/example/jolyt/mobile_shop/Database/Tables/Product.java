package com.example.jolyt.mobile_shop.Database.Tables;

import com.example.jolyt.mobile_shop.Database.DBOperation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Product extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private Shelf shelf;
    private String commentary;

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = DBOperation.GeneratePrimKey(Product.class);
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
}
