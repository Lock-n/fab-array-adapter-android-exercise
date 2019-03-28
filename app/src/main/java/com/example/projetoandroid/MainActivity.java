package com.example.projetoandroid;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mFab;
    ListView listView;
    static List<Aluno> alunoList;
    AlunoListAdapter alunoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (alunoList == null)
            alunoList = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listView);

        alunoListAdapter = new AlunoListAdapter(this, R.layout.aluno_item, alunoList);
        listView.setAdapter(alunoListAdapter);

        mFab = (FloatingActionButton) findViewById(R.id.fab);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewAlunoActivity.class);

                int requestCode = getResources().getInteger(R.integer.requestCode);
                startActivityForResult(intent, requestCode);
            }
        });
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        Log.d("TAG", "onActivityResult called and notifyDataSetChanged called as well");
        alunoListAdapter.notifyDataSetChanged();
    }
}
