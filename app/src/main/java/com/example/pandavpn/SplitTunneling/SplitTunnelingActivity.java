package com.example.pandavpn.SplitTunneling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.pandavpn.Adapter.SplitAdapter;
import com.example.pandavpn.Adapter.SplitAdapter;
import com.example.pandavpn.Model.SplitModel;
import com.example.pandavpn.R;
import com.example.pandavpn.ServerActivity;

import java.util.ArrayList;

public class SplitTunnelingActivity extends AppCompatActivity implements SplitAdapter.OnItemClickListener  {
    ArrayList<SplitModel> splistList = new ArrayList<>();
    SplitAdapter countryListAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_tunneling);

        recyclerView = findViewById(R.id.recyclr);
        splistList.add(new SplitModel(1, "Facebook", false));
        splistList.add(new SplitModel(2, "Whatsapp", false));
        splistList.add(new SplitModel(3, "Whatsapp", false));
        splistList.add(new SplitModel(4, "Whatsapp", false));
        splistList.add(new SplitModel(5, "Whatsapp", false));
        splistList.add(new SplitModel(5, "Whatsapp", false));
        splistList.add(new SplitModel(5, "Whatsapp", false));
        splistList.add(new SplitModel(5, "Whatsapp", false));
        splistList.add(new SplitModel(5, "Whatsapp", false));
        splistList.add(new SplitModel(5, "Whatsapp", false));
        splistList.add(new SplitModel(5, "Whatsapp", false));
        countryListAdapter = new SplitAdapter(SplitTunnelingActivity.this, splistList, this);

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
    public void onItemClicked(SplitModel server, int postion, boolean isSelected) {


        for (int i = 0; i < splistList.size(); i++) {
            splistList.get(i).setStatus(false);
        }

        splistList.get(postion).setStatus(true);

        countryListAdapter.notifyDataSetChanged();

    }
}