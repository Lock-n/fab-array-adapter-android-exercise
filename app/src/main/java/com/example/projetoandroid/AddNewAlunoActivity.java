package com.example.projetoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class AddNewAlunoActivity extends AppCompatActivity {

    EditText mEmail, mNome, mTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_aluno);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Adicionar Aluno");
            actionBar.setDisplayShowTitleEnabled(true);
        }

        mNome = (EditText) findViewById(R.id.etNome);
        mEmail = (EditText) findViewById(R.id.etEmail);
        mTelefone = (EditText) findViewById(R.id.etTelefone);
        Button mBtnAdicionar = (Button) findViewById(R.id.btnAdicionar);
        mBtnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNome.getText().toString().isEmpty() && mEmail.getText().toString().isEmpty() && mTelefone.getText().toString().isEmpty()) {
                    Toast.makeText(AddNewAlunoActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Aluno aluno = new Aluno();

                aluno.setEmail(mEmail.getText().toString());
                aluno.setNome(mNome.getText().toString());
                aluno.setTelefone(mTelefone.getText().toString());

                MainActivity.alunoList.add(aluno);

                Log.d("LOG", "Item added to alunoList");
                Log.d("LOG", "alunoList: " + MainActivity.alunoList.toString());

                Toast.makeText(AddNewAlunoActivity.this, "Adicionado com sucesso!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
