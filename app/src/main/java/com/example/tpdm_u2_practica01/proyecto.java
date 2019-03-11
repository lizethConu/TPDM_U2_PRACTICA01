package com.example.tpdm_u2_practica01;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class proyecto {
private base db;
private int id;
private String descripcion;
private String ubicacion;
private String fecha;
private String presupuesto;
protected String error;

public proyecto(Activity activity){db = new base(activity,"civil",null,1);}


    public proyecto(int id, String descripcion, String ubicacion, String fecha, String presupuesto){
    this.id=id;
    this.descripcion=descripcion;
    this.ubicacion=ubicacion;
    this.fecha=fecha;
    this.presupuesto=presupuesto;
}

    public boolean insertar(proyecto p){
        try{
            SQLiteDatabase transaccionInsertar = db.getWritableDatabase();
            ContentValues datos = new ContentValues();
            datos.put("DESCRIPCION",p.getDescripcion());
            datos.put("UBICACION",p.getUbicacion());
            datos.put("FECHA",p.getFecha());
            datos.put("PRESUPUESTO",p.getPresupuesto());
            long resultado = transaccionInsertar.insert("PROYECTOS","IDPROYECTO",datos);
            transaccionInsertar.close();
            if(resultado == -1)return false;
        }catch (SQLiteException e){
            error=e.getMessage();
            return false;
        }
        return true;
    }

    public proyecto[] consultar(String columna, String claveBusqueda){
        proyecto[] consultaProyecto=null;
        try{
            SQLiteDatabase trasaccionCosultar = db.getReadableDatabase();
            String SQL="";
            if(columna.startsWith("DESCRIPCION")){
                SQL = "SELECT * FROM ABOGADO WHERE DESCRIPCION = '"+claveBusqueda+"'";
            }
            if(columna.startsWith("ID")) {
                SQL = "SELECT * FROM PROYECTO WHERE IDPROYECTO" + claveBusqueda;
            }
            Cursor c = trasaccionCosultar.rawQuery(SQL,null);

            if(c.moveToFirst()) {
                consultaProyecto= new proyecto[c.getCount()];
                int pos=0;
                do {
                    consultaProyecto[pos]=new proyecto(c.getInt(0), c.getString(1),
                            c.getString(2), c.getString(3),c.getString(4));
                    pos++;
                } while (c.moveToNext());
            }
            trasaccionCosultar.close();
        }catch (SQLiteException e){
            error=e.getMessage();
            return null;
        }
        return consultaProyecto;
    }

    public boolean eliminar(proyecto p){
        int resultado;
        try{
            SQLiteDatabase transaccionEliminar = db.getWritableDatabase();
            String idProyecto= p.getId()+"";
            String claves[]={idProyecto};
            resultado=transaccionEliminar.delete("PROYECTOS","idProyecto=?" ,claves);
            transaccionEliminar.close();
        }catch (SQLiteException e){
            error=e.getMessage();
            return false;
        }
        return resultado>0;
    }

    public boolean actualizar(proyecto p){
        try{
            SQLiteDatabase transaccionActualizar = db.getWritableDatabase();
            String idProyecto= p.getId()+"";
            String clave[]={idProyecto};
            ContentValues datos= new ContentValues();
            datos.put("DESCRIPCION",p.getDescripcion());
            datos.put("UBICACION",p.getUbicacion());
            datos.put("FECHA",p.getFecha());
            datos.put("PRESUPUESTO",p.getPresupuesto());
            long resultado = transaccionActualizar.update("PROYECTOS",datos,"IDPROYECTO = ?",clave);
            transaccionActualizar.close();
            if(resultado ==1)
                return false;

        }catch (SQLiteException e){
            error=e.getMessage();
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public base getDb() {
        return db;
    }

    public void setDb(base db) {
        this.db = db;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }
}
