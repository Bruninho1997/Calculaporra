package com.example.bruno.calculaporra;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.example.bruno.calculaporra.R.id.config;
//import static com.example.bruno.calculaporrav2.R.id.config;

public class FatorialActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView txtresposta;
    EditText txtnum1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatorial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        txtresposta = (TextView) findViewById(R.id.txtresposta);
        txtnum1 = (EditText) findViewById(R.id.txtnum1);


        verFundo();

    }





    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        ConfigActivity configu = new ConfigActivity();

        if (id == R.id.calculadora) {

            Intent it = new Intent(this.getApplicationContext(),CalculadoraActivity.class);
            startActivity(it);
            if (configu.configFinish==0)
                finishAffinity();

        } else if (id == R.id.metricaLOC) {

            Intent it = new Intent(this.getApplicationContext(),metricaLOC.class);
            startActivity(it);
            if (configu.configFinish==0)
                finishAffinity();

        }

        else if (id == R.id.raiz) {
            Intent it = new Intent(this.getApplicationContext(),RaizActivity.class);
            startActivity(it);
            if (configu.configFinish==0)
                finishAffinity();

        }else if (id == config) {

            Intent it = new Intent(this.getApplicationContext(),ConfigActivity.class);
            startActivity(it);
            if (configu.configFinish==0)
                finishAffinity();

        }else if (id == R.id.fatorial) {
            Intent it = new Intent(this.getApplicationContext(),FatorialActivity.class);
            startActivity(it);
            if (configu.configFinish==0) finishAffinity();

        } else if (id == R.id.porcentagem) {
            Intent it = new Intent(this.getApplicationContext(),PorcentagemActivity.class);
            startActivity(it);
            if (configu.configFinish==0)
                finishAffinity();

        }
        else if (id == R.id.sobre) {
            controleVersao controle = new controleVersao();
            String texto = "DEV : BRUNO HENRIQUE\nFUNDO : GABRYELLE FRANCISCA\nv" + controle.versao;
            Context contexto = getApplicationContext();

            int duracao = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();

        } else if (id == R.id.velocidadeMedia) {
            Intent it = new Intent(this.getApplicationContext(),velocidadeMediaActivity.class);
            startActivity(it);
            if (configu.configFinish==0) finishAffinity();

        } else if (id == R.id.atualizacoes) {
            Intent it = new Intent(this.getApplicationContext(),sobreAtualizacoesActivity.class);
            startActivity(it);

        } else if (id == R.id.imc) {

            Intent it = new Intent(this.getApplicationContext(),ImcActivity.class);
            startActivity(it);
            if (configu.configFinish==0)
                finishAffinity();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void fatorial (View view)
    {

        double num1= 0, num2 = 0, resposta = 1;
        if (txtnum1.getText().toString().equals("")||txtnum1.getText().toString().equals("."))
        {
            num1=0;
        }
        else
            num1 = Double.parseDouble(txtnum1.getText().toString());


        double x;
        for (x=num1; x>1; x--)
        {
            resposta = resposta * x;
        }


        txtresposta.setText(String.format("%.0f",resposta));

    }


    //AQUI ELE VERÁ O FUNDO
    View view;


    public void verFundo(){

        ConfigActivity config = new ConfigActivity();

        try {
            FileInputStream fin = openFileInput("configuracaoBackGround");
            int c;
            String temp;
            temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            config.configFundo = Integer.parseInt(temp);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        view = findViewById(R.id.principal);

        if (config.configFundo==1)
        {

            view.setBackgroundResource(R.drawable.fundo);
        }

        if (config.configFundo==0)
        {

            view.setBackgroundResource(R.drawable.fundobranco);

        }

        if (config.configFundo==2)
        {

            view.setBackgroundResource(R.drawable.fundoverde);

        }

    }

}
