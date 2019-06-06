package com.wealthsystems.desafio.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wealthsystems.desafio.DAO.UsuarioDAO;
import com.wealthsystems.desafio.R;
import com.wealthsystems.desafio.model.Usuario;

public class AdicionarUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_usuario);
        configureActions();
    }

    private void configureActions() {
        Button btnGravar = findViewById(R.id.btnGravar) ;

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = findViewById(R.id.inptNome);
                EditText cpf = findViewById(R.id.inptCpf);
                EditText endereco = findViewById(R.id.inptEndereco);
                EditText email = findViewById(R.id.inptEmail);

                Usuario usuario = new Usuario();
                usuario.setNome(nome.getText().toString());
                usuario.setCpf(cpf.getText().toString());
                usuario.setEndereco(endereco.getText().toString());
                usuario.setEmail(email.getText().toString());

                UsuarioDAO dao = new UsuarioDAO(AdicionarUsuarioActivity.this);
                dao.insert(usuario);

                AdicionarUsuarioActivity.this.finish();
            }
        });


    }

}
