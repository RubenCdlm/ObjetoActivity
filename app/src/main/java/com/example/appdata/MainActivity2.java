package com.example.appdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

     private TextView ImcResult;
     private TextView envjResult;
     private TextView valorResult;
     private TextView nombreCliente;
     private Button BtnEnvj;
     private Button BtnImc;
     private Button BtnValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImcResult = (TextView) findViewById(R.id.ImcResult);
        BtnImc = (Button) findViewById(R.id.BtnImc);

        envjResult = (TextView) findViewById(R.id.envjResult);
        BtnEnvj = (Button) findViewById(R.id.BtnEnvj);

        valorResult = (TextView) findViewById(R.id.valorResult);
        BtnValor = (Button) findViewById(R.id.BtnValor);

        nombreCliente = (TextView) findViewById(R.id.nombreCliente);

        Bundle objEnviado = getIntent().getExtras();
        Usuario user = null;


        if(objEnviado != null){
            user = (Usuario) objEnviado.getSerializable("usuario");

            double resultImc = user.getpesoPersona()/(user.getestaturaPersona()*user.getestaturaPersona());
            final int[] resulEnvj = {user.getedadPersona()};
            double resulaTributar = user.getdineroPersona()*0.19;
            nombreCliente.setText(user.getnombrePersona()+' '+user.getapellidoPersona());

            BtnImc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImcResult.setText(String.valueOf(resultImc)); ;
                }
            });
            BtnEnvj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    envjResult.setText(String.valueOf(++resulEnvj[0])); ;
                }
            });
            BtnValor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valorResult.setText(String.valueOf(resulaTributar)); ;
                }
            });

        }

    }

    public void regresar(View view){
        finish();
    }
}