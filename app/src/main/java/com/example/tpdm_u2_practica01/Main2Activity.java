package com.example.tpdm_u2_practica01;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText descripcion;
    EditText ubicacion;
    EditText fecha;
    EditText presupuesto;
    Button inserta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        
        descripcion=findViewById(R.id.descripcion);
        ubicacion=findViewById(R.id.ubicacion);
        fecha=findViewById(R.id.fecha);
        presupuesto=findViewById(R.id.presupuesto);
        inserta=findViewById(R.id.inserta);
        
        inserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();
            }
        });
    }

    private void insertar() {
        String mensaje="";
        proyecto p=new proyecto(this);
        boolean respuesta = p.insertar(new proyecto(-1,descripcion.getText().toString(),
                ubicacion.getText().toString(),fecha.getText().toString(),presupuesto.getText().toString()));
        if(respuesta){
            mensaje= "se pudo insertar el proyecto con la descripcion "+descripcion.getText().toString();
        }
        else{
            mensaje="Error no se pudo crear el abogado, respuesta de SQLite"+p.error;
        }
        AlertDialog.Builder alerta =new AlertDialog.Builder(this);
        alerta.setTitle("ATENCION").setMessage(mensaje).setPositiveButton("ok",null).show();
    }
}
