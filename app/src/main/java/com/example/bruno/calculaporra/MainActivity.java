package com.example.bruno.calculaporra;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.example.bruno.calculaporra.R.id.config;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //CONFIGURAÇÕES

    static int x;


    //CONFIGURAÇÕES
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
//
//
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


        carregarConfiguracao();







    }

    public void carregarConfiguracao(){
        ConfigActivity config = new ConfigActivity();


        config.configFinish = 0;
        config.configResposta=1;
        config.configDecimal = 3;
        config.configRespostaPorcentagem = 0 ;
        config.configMenu = 0;

        try {
            FileInputStream fin = openFileInput("configuracaoPrecisao");
            int c;
            String temp;
            temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            config.configDecimal = Integer.parseInt(temp);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }


        try {
            FileInputStream fin = openFileInput("configMenu");
            int c;
            String temp;
            temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            config.configMenu = Integer.parseInt(temp);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }


        try {
            FileInputStream fin = openFileInput("configuracaoFinish");
            int c;
            String temp;
            temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            config.configFinish = Integer.parseInt(temp);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }


        try {
            FileInputStream fin = openFileInput("configuracaoBackGround");
            int c;
            String temp="";
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

        try {
            FileInputStream fin = openFileInput("configResposta");
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            config.configResposta = Integer.parseInt(temp);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fin = openFileInput("configRespostaPorcentagem");
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            config.configRespostaPorcentagem = Integer.parseInt(temp);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (config.configMenu ==1)
        {

            Intent it = new Intent(this.getApplicationContext(),MenuActivity.class);
            startActivity(it);
            finishAffinity();
        }
    }






    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //controlePagina controleP = new controlePagina();

        controlePagina(id);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void controlePagina(int id){

        ConfigActivity configu = new ConfigActivity();

        if (id == R.id.calculadora) {

            Intent it = new Intent(this.getApplicationContext(),CalculadoraActivity.class);
            startActivity(it);
            //if (configu.configFinish==0)
            //finishAffinity();

        } else if (id == R.id.metricaLOC) {

            Intent it = new Intent(this.getApplicationContext(),metricaLOC.class);
            startActivity(it);
            //if (configu.configFinish==0)
            //finishAffinity();

        } else if (id == R.id.imc) {

            Intent it = new Intent(this.getApplicationContext(),ImcActivity.class);
            startActivity(it);
            //if (configu.configFinish==0)
            //finishAffinity();

        }

        else if (id == R.id.raiz) {
            Intent it = new Intent(this.getApplicationContext(),RaizActivity.class);
            startActivity(it);
            //if (configu.configFinish==0)
            //finishAffinity();

        }else if (id == config) {

            Intent it = new Intent(this.getApplicationContext(),ConfigActivity.class);
            startActivity(it);
            //if (configu.configFinish==0)
            //finishAffinity();

        }else if (id == R.id.fatorial) {
            Intent it = new Intent(this.getApplicationContext(),FatorialActivity.class);
            startActivity(it);
            //if (configu.configFinish==0) finishAffinity();

        } else if (id == R.id.porcentagem) {
            Intent it = new Intent(this.getApplicationContext(),PorcentagemActivity.class);
            startActivity(it);
            //if (configu.configFinish==0)
            //finishAffinity();

        }else if (id == R.id.pot) {

            Intent it = new Intent(this.getApplicationContext(),PotencializacaoActicity.class);
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
            //if (configu.configFinish==0) finishAffinity();

        } else if (id == R.id.atualizacoes) {
            Intent it = new Intent(this.getApplicationContext(),sobreAtualizacoesActivity.class);
            startActivity(it);

        }



    }


    public void menu(View view)
    {
        Context context = getApplicationContext();
        CharSequence text = "Você pode alterar a tela inicial para ir diretamente ao Menu ao iniciar o aplicativo nas configurações!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent it = new Intent(this.getApplicationContext(),MenuActivity.class);
        startActivity(it);
        finishAffinity();
    }





}
