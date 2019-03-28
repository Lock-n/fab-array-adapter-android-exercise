package com.example.projetoandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AlunoListAdapter extends ArrayAdapter<Aluno> {
    private List<Aluno> alunoList;
    private Context context;

    public AlunoListAdapter(Context context, int resource, List<Aluno> objects) {
        super(context, resource, objects);

        alunoList = objects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunoList.size();
    }

    @Override
    public Aluno getItem(int position) {
        return alunoList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno aluno = alunoList.get(position);

        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.aluno_item, parent, false);

        TextView nome, email, telefone;
        nome = (TextView) convertView.findViewById(R.id.txtNome);
        email = (TextView) convertView.findViewById(R.id.txtEmail);
        telefone = (TextView) convertView.findViewById(R.id.txtTelefone);

        nome.setText(aluno.getNome());
        email.setText(aluno.getEmail());
        telefone.setText(aluno.getTelefone());

        return convertView;
    }

    @Override
    public boolean isEmpty() {
        return (alunoList.isEmpty());
    }

    @Override
    public void add(Aluno object) {
        super.add(object);

        alunoList.add(object);
    }
}
