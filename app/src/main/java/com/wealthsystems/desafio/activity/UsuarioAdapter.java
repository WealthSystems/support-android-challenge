package com.wealthsystems.desafio.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealthsystems.desafio.R;
import com.wealthsystems.desafio.model.Usuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter {

    private List<Usuario> usuarioList;
    private Context contexto;

    public UsuarioAdapter(List<Usuario> usuarios, Context contexto) {
        this.usuarioList = usuarios;
        this.contexto = contexto;
    }

    public void atualizar(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(contexto)
                .inflate(R.layout.usuario, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;

        Usuario usuario = usuarioList.get(i);

        holder.nome.setText(usuario.getNome());
        holder.cpf.setText(usuario.getCpf());
        holder.endereco.setText(usuario.getEndereco());
        holder.email.setText(usuario.getEmail());
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView nome;
        final TextView cpf;
        final TextView endereco;
        final TextView email;

        public ViewHolder(View view) {
            super(view);
            nome = (TextView) view.findViewById(R.id.nome);
            cpf = (TextView) view.findViewById(R.id.cpf);
            endereco = (TextView) view.findViewById(R.id.endereco);
            email = (TextView) view.findViewById(R.id.email);
        }

    }
}
