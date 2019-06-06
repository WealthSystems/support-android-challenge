package com.wealthsystems.desafio.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.wealthsystems.desafio.DAO.DatabaseManager;
import com.wealthsystems.desafio.DAO.UsuarioDAO;
import com.wealthsystems.desafio.R;
import com.wealthsystems.desafio.model.Usuario;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseManager.init(this);

        initGUI();
        configureActions();
    }

    private void initGUI() {
        UsuarioDAO dao = new UsuarioDAO(this);
        List<Usuario> usuarioList = dao.getAll();

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(new UsuarioAdapter(usuarioList, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);
    }

    private void configureActions() {
        Button btnAdicionar = findViewById(R.id.adicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AdicionarUsuarioActivity.class);
                MainActivity.this.startActivityForResult(myIntent, 35);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        UsuarioDAO dao = new UsuarioDAO(this);
        List<Usuario> usuarioList = dao.getAll();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        UsuarioAdapter adapter = (UsuarioAdapter) recyclerView.getAdapter();
        adapter.atualizar(usuarioList);
    }
}
