package com.example.listapp;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] fruits;
    String[] prices;
    String[] descriptions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = findViewById(R.id.mylistView);
        fruits = res.getStringArray(R.array.fruits);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.description);

        BaseAdapter itemAdapter = new ItemAdapter(this, fruits, prices, descriptions);
        myListView.setAdapter(itemAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.listapp.ITEM_INDEX", position);
                startActivity(showDetailActivity);
            }
        });
    }
}
