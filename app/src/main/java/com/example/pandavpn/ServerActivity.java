package com.example.pandavpn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.pandavpn.Adapter.CountryListAdapter;
import com.example.pandavpn.Model.CountryListModel;

import java.util.ArrayList;

public class ServerActivity extends AppCompatActivity implements CountryListAdapter.OnItemClickListener {
    ArrayList<CountryListModel> countryList = new ArrayList<>();
    CountryListAdapter countryListAdapter;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        recyclerView = findViewById(R.id.recyclr);
        countryList.add(new CountryListModel(1, "United Estates", false));
        countryList.add(new CountryListModel(2, "Canada", false));
        countryList.add(new CountryListModel(3, "Australia", false));
        countryList.add(new CountryListModel(4, "America", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryList.add(new CountryListModel(5, "Germany", false));
        countryListAdapter = new CountryListAdapter(ServerActivity.this, countryList, this);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryListAdapter);


        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    @Override
    public void onItemClicked(CountryListModel server, int postion, boolean isSelected) {


        for (int i = 0; i < countryList.size(); i++) {
            countryList.get(i).setSelected(false);
        }

        countryList.get(postion).setSelected(true);

        countryListAdapter.notifyDataSetChanged();

    }
}