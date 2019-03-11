package com.example.tpdm_u2_practica01;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    proyecto vector[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=findViewById(R.id.listaproyecto);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // mostrarAlerta(position);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pop,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.insertarp:
                Intent inserta= new Intent(this,Main2Activity.class);
                startActivity(inserta);
                break;
            case R.id.eliminarp:
                Intent elimina= new Intent(this,Main3Activity.class);
                startActivity(elimina);
                break;
            case R.id.actualizarp:
                Intent actualiza= new Intent(this,Main4Activity.class);
                startActivity(actualiza);
                break;
            case R.id.consultarp:
                Intent consulta= new Intent(this,Main5Activity.class);
                startActivity(consulta);
                break;
        }



        return super.onOptionsItemSelected(item);
    }
}
