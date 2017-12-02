package com.joybar.androidrouter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.joybar.compiler.RouterInject;
import com.joybar.librouter.Router;
import com.joybar.librouter.Router.RouteTable;
import com.joybar.librouter.Rule;
import com.me.obo.map.RouteMap$$moduleshop;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);
        initRouter1();
        //initRouter2();
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_main_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.getRouterService().buildRule(new Rule("user", "user_main")).navigate(MainActivity.this);
                RouteMap$$moduleshop.GoToShop_main("obo",23).navigate(MainActivity.this);
            }
        });
    }


    private void initRouter1() {
        RouterInject.inject("com.joybar.moduleuser.MainActivity");
        RouterInject.inject("com.joybar.moduleshop.MainActivity");
    }

    private void initRouter2() {

//        Router.registerRouter("user", "user_main", com.joybar.moduleuser.MainActivity.class);
//        Router.registerRouter("shop", "shop_main", com.joybar.moduleshop.MainActivity.class);

        Router.registerRouter(new RouteTable() {
            @Override
            public List<Rule> buildRuleList() {
                List<Rule> ruleList = new ArrayList<>();
                ruleList.add(new Rule("user", "user_main", com.joybar.moduleuser.MainActivity.class));
                ruleList.add(new Rule("shop", "shop_main", com.joybar.moduleshop.MainActivity.class));
                return ruleList;
            }


        });

    }
}

