package com.example.jolyt.mobile_shop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jolyt.mobile_shop.Database.DBOperation;
import com.example.jolyt.mobile_shop.Database.Tables.Cart;
import com.example.jolyt.mobile_shop.Database.Tables.Users;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Do not touch needed for database
        try(Realm realm = Realm.getDefaultInstance()){

        }
        //toadd object  use : new oject then new transaction and copy
        //for PK autogenerate
        //mutableRealmInteger
        //https://stackoverflow.com/questions/40174920/how-to-set-primary-key-auto-increment-in-realm-android

        Realm re = Realm.getDefaultInstance();
        DBOperation dbOp= new DBOperation(re);
        Users user = new Users();
        user.setName("théo");
        user.setId();
        dbOp.createItem(user);
        Users us = dbOp.readWithId( re.where(Users.class).max("id").intValue(), Users.class);
        Cart cart = new Cart();
        cart.setId();
        cart.setUser(us);
        cart.setName("lemachin");
        dbOp.createItem(cart);
        Cart ca = dbOp.readWithId(re.where(Cart.class).max("id").intValue(), Cart.class);
        Log.i("CartName", ca.getName());
        Log.i("UserName", ca.getUser().getName());

        for (int i = 0; i < re.where(Cart.class).findAll().size()+1; i++){
            dbOp.deleteCartId(i);
        }
        Log.i("MaxCart", ""+re.where(Cart.class).findAll().size());
        re.close();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
