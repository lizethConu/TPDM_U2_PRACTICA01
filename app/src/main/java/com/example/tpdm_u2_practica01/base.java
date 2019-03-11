package com.example.tpdm_u2_practica01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class base extends SQLiteOpenHelper {
    public base(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//por primera vez
        db.execSQL("CREATE TABLE PROYECTOS(IDPROYECTO INTEGER PRIMARY KEY AUTOINCREMENT," +
                " DESCRIPCION VARCHAR(200) NOT NULL," +
                "UBICACION VARCHAR(200),FECHA DATE," +
                "PRESUPUESTO FLOAT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//cuando se cambia version

    }
}
