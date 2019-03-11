package com.example.tpdm_u2_practica01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    EditText descripcion;
    EditText ubicacion;
    EditText fecha;
    EditText presupuesto;
    Button actualiza;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        descripcion=findViewById(R.id.descripcion);
        ubicacion=findViewById(R.id.ubicacion);
        fecha=findViewById(R.id.fecha);
        presupuesto=findViewById(R.id.presupuesto);
        actualiza=findViewById(R.id.Actualiza);

        actualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizar();
            }
        });
    }

    private void actualizar() {
        proyecto p= new proyecto(this);
        String mensaje;
        boolean respuesta = p.actualizar(new proyecto (id,descripcion.getText().toString(),
                ubicacion.getText().toString(),fecha.getText().toString(),presupuesto.getText().toString()
        ));

        if(respuesta){
            mensaje="se actualizo correctamente el proyecto ";
        }else{
            mensaje="Error algo salio mal: "+p.error;
        }
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG);
    }
}
