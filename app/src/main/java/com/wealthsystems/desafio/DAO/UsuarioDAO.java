package com.wealthsystems.desafio.DAO;

import android.content.Context;

import com.wealthsystems.desafio.model.Usuario;

public class UsuarioDAO extends GenericDAO {

    public UsuarioDAO(Context context) {
        super(context, Usuario.class);
    }
}
