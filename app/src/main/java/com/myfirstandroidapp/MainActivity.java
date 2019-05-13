package com.myfirstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_activity_button)
    Button mainActivityButton;

    @BindView(R.id.myRecyclerView)
    RecyclerView myRecyclerView;

    private static List<String> list = new ArrayList<>();
    static {
        for (int i = 0; i < 10 ; i++) {
            list.add("item Number: " + i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            String myStateValue =
                    savedInstanceState
                            .getString("YOUR_KEY", "");
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /*setContentView(R.layout.activity_main);
        ButterKnife.bind(this); // this has to be below the setContentView() function call

        mainActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "The button has been clicked", Toast.LENGTH_SHORT).show();
            }
        });*/

        MyRecyclerViewAdapter myAdapter =
                new MyRecyclerViewAdapter(list, new MyRecyclerViewAdapter.HandleTouchEvents() {
                    @Override
                    public void onItemClickList(String dataPassedOnClick) {
                        Toast.makeText(getApplicationContext(),
                                        dataPassedOnClick,
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        RecyclerView.LayoutManager lm =
                new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
        myRecyclerView.setLayoutManager(lm);
        myRecyclerView.setAdapter(myAdapter);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("YOUR_KEY","I left my work here");
    }
}