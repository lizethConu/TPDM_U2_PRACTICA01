package com.example.tpdm_u2_practica01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Main5Activity extends AppCompatActivity {
    EditText busqueda;
    RadioButton id;
    RadioButton descripcion;
    Button consultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        busqueda=findViewById(R.id.busqueda);
        id=findViewById(R.id.id);
        descripcion=findViewById(R.id.descripcion);
        consultar=findViewById(R.id.consultar);

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }
        });
    }

    private void consultar() {

    }
}
