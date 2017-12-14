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
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.bruno.calculaporra.R.id.config;
//import static com.example.bruno.calculaporrav2.R.id.config;

public class ConfigActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    String temp;

    View view;
    TextView txtnum1Resp;
    TextView txtnum1RespPorcentagem;
    TextView txtprecisao;
    static int configResposta=1;
    static int configRespostaPorcentagem=0;
    static int configDecimal=3;
    static int configFundo = 2;
    static int configFinish = 1;
    static int configMenu = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
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

        txtprecisao = (TextView) findViewById(R.id.txtPrecisao);
        txtnum1Resp = (TextView) findViewById(R.id.txtNum1Resp);
        txtnum1RespPorcentagem = (TextView) findViewById(R.id.txtNum1RespPorcentagem);


        verconfig();


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

        }else if (id == R.id.pot) {

            Intent it = new Intent(this.getApplicationContext(),PotencializacaoActicity.class);
            startActivity(it);
            if (configu.configFinish==0)
                finishAffinity();

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void config1true (View view)
    {
        configResposta = 1;

        salvarconfig1();

        verconfig();


    }

    public void salvarconfig1()
    {
        String filename = "configResposta";
        String string = String.valueOf(configResposta);
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void config1false (View view)
    {
        configResposta = 0;
        salvarconfig1();



        verconfig();



    }

    public void config4true (View view)
    {
        configRespostaPorcentagem = 1;
        salvarconfig2();
        verconfig();


    }

    public void configMenutrue (View view)
    {
        configMenu = 1;
        salvarconfig3();
        verconfig();


    }

    public void configMenufalse (View view)
    {
        configMenu = 0;
        salvarconfig3();
        verconfig();


    }

    public void salvarconfig2()
    {
        String filename = "configRespostaPorcentagem";
        String string = String.valueOf(configRespostaPorcentagem);
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void salvarconfig3()
    {
        String filename = "configMenu";
        String string = String.valueOf(configMenu);
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void config4false (View view)
    {
        configRespostaPorcentagem = 0;
        salvarconfig2();
        verconfig();



    }

    public void salvarconfigPrecisao()
    {

        String configuracaoPrecisao = "configuracaoPrecisao";

        String configDecimalString = String.valueOf(configDecimal);

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(configuracaoPrecisao, Context.MODE_PRIVATE);
            outputStream.write(configDecimalString.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void config2low (View view)
    {
        configDecimal = 1;

        salvarconfigPrecisao();


        verconfig();

    }

    public void config2med (View view)
    {

        configDecimal = 2;

        salvarconfigPrecisao();



        verconfig();

    }

    public void config2high (View view)
    {

        configDecimal = 3;
        salvarconfigPrecisao();




        verconfig();

    }

    public void mostrarToast ()
    {
        String texto = null;
        Context contexto = getApplicationContext();
        if (configResposta==1)
            texto = "NÚMERO 1 RECEBERÁ RESPOSTA";
        else if (configResposta==0)
            texto = "NÚMERO 1 NÃO RECEBERÁ RESPOSTA";
        int duracao = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();
    }

    public void mostrarToast2 ()
    {
        String texto = null;
        Context contexto = getApplicationContext();
        if (configDecimal==1)
            texto = "PRECISÃO : BAIXA";
        else if (configDecimal==2)
            texto = "PRECISÃO : MÉDIA";

        else if (configDecimal==3)
            texto = "PRECISÃO : RECOMENDADA";

        int duracao = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();
    }


    public void verconfig() {



        verconfigDecimal();
        verconfigPrecisao();
        verconfigFinish();
        verconfigMenu();
        alterarFundo();




    }

    public int verconfigDecimalPorra()
    {

        try {
            FileInputStream fin = openFileInput("configuracaoPrecisao");
            int c;
            String temp;
            temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            configDecimal = Integer.parseInt(temp);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        return configDecimal;

    }

    View view1, view2, view3;

    public void verconfigDecimal()
    {



        //int x = verconfigDecimalPorra();
        //configDecimal = x;

        view1 = findViewById(R.id.config1low);
        view2 = findViewById(R.id.config1med);
        view3 = findViewById(R.id.config1high);

        //if (configFundo==1)
        //{
//
//            view.setBackgroundResource(R.drawable.fundo);
//        }



        if (configDecimal==3)
        {

            txtprecisao.setText(String.format("Precisão dos resultados"));
            view3.setBackgroundResource(R.drawable.fundovermelho);
            view2.setBackgroundResource(R.drawable.fundopreto);
            view1.setBackgroundResource(R.drawable.fundopreto);


        }

        if (configDecimal==2)
        {

            txtprecisao.setText(String.format("Precisão dos resultados"));
            view2.setBackgroundResource(R.drawable.fundovermelho);
            view3.setBackgroundResource(R.drawable.fundopreto);
            view1.setBackgroundResource(R.drawable.fundopreto);

        }

        if (configDecimal==1)
        {

            txtprecisao.setText(String.format("Precisão dos resultados"));
            view1.setBackgroundResource(R.drawable.fundovermelho);
            view2.setBackgroundResource(R.drawable.fundopreto);
            view3.setBackgroundResource(R.drawable.fundopreto);

        }



    }




    View view4, view5, view6, view7, view8, view9, view10, view11;

    public void verconfigFinish()
    {
        view8 = findViewById(R.id.config4on);
        view9 = findViewById(R.id.config4off);


        if (configFinish==1)
        {
            //txtnum1Resp.setText(String.format("Resposta ir para Número 1 na Calculadora"));
            view8.setBackgroundResource(R.drawable.fundovermelho);
            view9.setBackgroundResource(R.drawable.fundopreto);

        }
        if (configFinish==0)
        {
            //txtnum1Resp.setText(String.format("Resposta ir para Número 1 na Calculadora"));
            view9.setBackgroundResource(R.drawable.fundovermelho);
            view8.setBackgroundResource(R.drawable.fundopreto);

        }


    }

    public void verconfigMenu()
    {
        view10 = findViewById(R.id.configMenuon);
        view11 = findViewById(R.id.configMenuoff);


        if (configMenu==1)
        {
            //txtnum1Resp.setText(String.format("Resposta ir para Número 1 na Calculadora"));
            view10.setBackgroundResource(R.drawable.fundovermelho);
            view11.setBackgroundResource(R.drawable.fundopreto);

        }
        if (configMenu==0)
        {
            //txtnum1Resp.setText(String.format("Resposta ir para Número 1 na Calculadora"));
            view11.setBackgroundResource(R.drawable.fundovermelho);
            view10.setBackgroundResource(R.drawable.fundopreto);

        }


    }

    public void verconfigPrecisao()
    {

        view4 = findViewById(R.id.config2on);
        view5 = findViewById(R.id.config2off);
        view6 = findViewById(R.id.config3on);
        view7 = findViewById(R.id.config3off);


        //if (configFundo==1)
        //{
//
//            view.setBackgroundResource(R.drawable.fundo);
//        }



        if (configResposta==1)
        {
            txtnum1Resp.setText(String.format("Resposta ir para Número 1 na Calculadora"));
            view4.setBackgroundResource(R.drawable.fundovermelho);
            view5.setBackgroundResource(R.drawable.fundopreto);

        }

        if (configRespostaPorcentagem == 1)
        {
            txtnum1RespPorcentagem.setText(String.format("Resposta ir para Número 1 na Porcentagem"));
            view6.setBackgroundResource(R.drawable.fundovermelho);
            view7.setBackgroundResource(R.drawable.fundopreto);
        }
        if (configRespostaPorcentagem == 0)
        {
            txtnum1RespPorcentagem.setText(String.format("Resposta ir para Número 1 na Porcentagem"));
            view7.setBackgroundResource(R.drawable.fundovermelho);
            view6.setBackgroundResource(R.drawable.fundopreto);
        }


        if (configResposta==0)
        {


            txtnum1Resp.setText(String.valueOf("Resposta ir para Número 1 na Calculadora"));
            view5.setBackgroundResource(R.drawable.fundovermelho);
            view4.setBackgroundResource(R.drawable.fundopreto);
        }

    }

    public void restaurarPadrao(View view)
    {
        configResposta=1;
        configDecimal = 3;
        configFundo = 2;
        configRespostaPorcentagem = 0 ;
        verconfig();
    }


    public void planoDeFundo1(View view)
    {
        configFundo=1;

        String configuracaoBackGground = "configuracaoBackGround";

        String configFundoString = String.valueOf(configFundo);

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(configuracaoBackGground, Context.MODE_PRIVATE);
            outputStream.write(configFundoString.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        alterarFundo();
    }

    public void planoDeFundo0(View view)
    {
        configFundo=0;

        String filename = "configuracaoBackGround";

        String configFundoString = String.valueOf(configFundo);

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(configFundoString.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        alterarFundo();
    }

    public void planoDeFundo2(View view)
    {
        configFundo=2;

        String configuracaoBackGground = "configuracaoBackGround";

        String configFundoString = String.valueOf(configFundo);

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(configuracaoBackGground, Context.MODE_PRIVATE);
            outputStream.write(configFundoString.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        alterarFundo();
    }

    public void salvarconfigFinish()
    {
        String configuracaoFinish = "configuracaoFinish";

        String string = String.valueOf(configFinish);

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(configuracaoFinish, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void config5true(View view)
    {
        configFinish = 1;
        salvarconfigFinish();
        verconfig();
    }

    public void config5false(View view)
    {
        configFinish = 0;
        salvarconfigFinish();
        verconfig();
    }


    public void alterarFundo (){



        try {
            FileInputStream fin = openFileInput("configuracaoBackGround");
            int c;
            temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            configFundo = Integer.parseInt(temp);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        view = findViewById(R.id.principal);

        if (configFundo==1)
        {

            view.setBackgroundResource(R.drawable.fundo);
        }

        if (configFundo==0)
        {

            view.setBackgroundResource(R.drawable.fundobranco);

        }

        if (configFundo==2)
        {

            view.setBackgroundResource(R.drawable.fundoverde);

        }
    }


    public void comosalvar()
    {
        // SALVAR DADO NO ARMAZENAMENTO INTERNO
        String configuracaoBackGground = "configuracaoBackGround";
        String i = "0";
        int x = 0;
        FileOutputStream outputStream1;

        try {
            outputStream1 = openFileOutput(configuracaoBackGground, Context.MODE_PRIVATE);
            outputStream1.write(i.getBytes());
            outputStream1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }









        //LER DADO SALVO NO ARMAZENAMENTO INTERNO

        try {
            FileInputStream fin = openFileInput(i);
            int c;
            temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




//===============================================================================


        // SALVAR DADO NO ARMAZENAMENTO INTERNO
        String filename = "myfile";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }









        //LER DADO SALVO NO ARMAZENAMENTO INTERNO

        try {
            FileInputStream fin = openFileInput(filename);
            int c;
            temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
//========================================================================================



    public void precarregamento()
    {
        try {
            FileInputStream fin = openFileInput("configuracaoBackGround");
            int c;
            temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            configFundo = Integer.parseInt(temp);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }









        try {
            FileInputStream fin = openFileInput("configuracaoPrecisao");
            int c;
            String temp;
            temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c); //Chamar a String na hora de exibir
            }

            configDecimal = Integer.parseInt(temp);

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


}
