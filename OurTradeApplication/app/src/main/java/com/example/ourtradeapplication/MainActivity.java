package com.example.ourtradeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_OurTradeApplication);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        findViewById(R.id.likesBtn).setOnClickListener(view -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_fragment, LikesScreenFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack("likes")
                    .commit();
        });

        findViewById(R.id.chatsBtn).setOnClickListener(view -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_fragment, ChatsScreenFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack("chats")
                    .commit();
        });

        findViewById(R.id.userBtn).setOnClickListener(view -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_fragment, UserScreenFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack("user")
                    .commit();
        });

        findViewById(R.id.goodsBtn).setOnClickListener(view -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_fragment, TradeScreenFragment.class,null)
                    .setReorderingAllowed(true)
                    .addToBackStack("trade")
                    .commit();
        });

    }
}