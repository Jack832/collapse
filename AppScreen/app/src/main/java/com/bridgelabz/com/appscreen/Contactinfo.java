package com.bridgelabz.com.appscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgelabz4 on 25/1/16.
 */
public class Contactinfo extends AppCompatActivity {
    Toolbar toolbar4;
    RecyclerView horizontal, horizontal2, horizontal3;
    ViewAdapter adapterRec1;
    Adapter2 adapter2;
    Adapter3 adapter3;

    public static List<MyData> getdata() {
        List<MyData> data = new ArrayList<>();
        int icon[] = {R.drawable.doc2, R.drawable.home, R.drawable.doc1, R.drawable.doc2, R.drawable.home
                , R.drawable.doc1, R.drawable.doc2, R.drawable.home, R.drawable.doc1};

        for (int i = 0; i < icon.length; i++) {
            MyData current = new MyData();
            current.mainIcon = icon[i];
            data.add(current);
        }
        return data;

    }

    public static List<MyData> getdataall() {
        List<MyData> data = new ArrayList<>();
        int icon[] = {R.drawable.doc1, R.drawable.doc2, R.drawable.doc1, R.drawable.doc2, R.drawable.doc1,
                R.drawable.doc2, R.drawable.doc1, R.drawable.doc2, R.drawable.doc1,};
        String title[] = {"document1", "document2", "document3", "document4", "document5", "document6",
                "document7", "document8", "document9"};
        for (int i = 0; i < icon.length && i < title.length; i++) {
            MyData current = new MyData();
            current.mainIcon = icon[i];
            current.mainTitle = title[i];
            data.add(current);
        }
        return data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactinfox);
        toolbar4 = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar4);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar4.setBackgroundResource(R.drawable.earth);
        toolbar4.setTitle("SOURABH");


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager
                (this, LinearLayoutManager.HORIZONTAL, false);
        horizontal = (RecyclerView) findViewById(R.id.RV1);
        horizontal.setLayoutManager(linearLayoutManager);
        adapter2 = new Adapter2(getApplication(), getdata());
        horizontal.setAdapter(adapter2);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager
                (this, LinearLayoutManager.HORIZONTAL, false);
        horizontal2 = (RecyclerView) findViewById(R.id.RV2);
        horizontal2.setLayoutManager(linearLayoutManager1);
        adapter3 = new Adapter3(getApplication(), getdata());

        horizontal2.setAdapter(adapter3);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager
                (this, LinearLayoutManager.VERTICAL, false);
        horizontal3 = (RecyclerView) findViewById(R.id.RV3);
        horizontal3.setLayoutManager(linearLayoutManager2);
        adapterRec1 = new ViewAdapter(getApplication(), getdataall());
        horizontal3.setAdapter(adapterRec1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.edit1) {
            Toast.makeText(getApplication(), "hello " +
                    "edit click", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}