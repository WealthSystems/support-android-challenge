package com.wealthsystems.desafio.DAO;

import android.content.Context;

public class DatabaseManager {

    private static DatabaseManager instance;
    private DataBaseHelper helper;

    public static void init(Context ctx) {
        if (null == instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseManager(Context ctx) {
        helper = new DataBaseHelper(ctx);
    }

    public DataBaseHelper getHelper() {
        return helper;
    }
}
