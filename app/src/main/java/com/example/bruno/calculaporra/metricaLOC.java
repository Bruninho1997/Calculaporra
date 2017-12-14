package com.example.bruno.calculaporra;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.example.bruno.calculaporra.R.id.config;

public class metricaLOC extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    TextView txtprodutividade;
    TextView txtcorrecao;
    TextView txtdocumentacao;
    TextView txtCustoLOC;
    EditText txtErros, txtPagsDoc, txtKLOC, txtDinheiro, txtEsforco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metricaloc);
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

        txtDinheiro = (EditText) findViewById(R.id.txtDinheiro);
        txtErros = (EditText) findViewById(R.id.txtErros);
        txtPagsDoc = (EditText) findViewById(R.id.txtPagsDoc);
        txtKLOC = (EditText) findViewById(R.id.txtKLOC);
        txtEsforco = (EditText) findViewById(R.id.txtEsforco);
        txtCustoLOC = (TextView) findViewById(R.id.CustoLOC);
        txtdocumentacao = (TextView) findViewById(R.id.txtdocumentacao);
        txtcorrecao = (TextView) findViewById(R.id.correcao);
        txtprodutividade = (TextView) findViewById(R.id.produtividade);


        verFundo();

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

        } else if (id == R.id.imc) {

            Intent it = new Intent(this.getApplicationContext(),ImcActivity.class);
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
            if (configu.configFinish==0) finishAffinity();

        } else if (id == R.id.atualizacoes) {
            Intent it = new Intent(this.getApplicationContext(),sobreAtualizacoesActivity.class);
            startActivity(it);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void calcular(View view)
    {
        double dinheiro, pessoas, erros, pags, KLOC, esforco, custoloc, documentacao, correcao, produtividade;

        if (txtDinheiro.getText().toString().equals("")||txtDinheiro.getText().toString().equals("."))
        {
            dinheiro=0;
        }
        else
            dinheiro = Double.parseDouble(txtDinheiro.getText().toString());

        if (txtErros.getText().toString().equals("")||txtErros.getText().toString().equals("."))
        {
            erros=0;
        }
        else
            erros = Double.parseDouble(txtErros.getText().toString());

        if (txtPagsDoc.getText().toString().equals("")||txtPagsDoc.getText().toString().equals("."))
        {
            pags=0;
        }
        else
            pags = Double.parseDouble(txtPagsDoc.getText().toString());

        if (txtKLOC.getText().toString().equals("")||txtKLOC.getText().toString().equals("."))
        {
            KLOC=0;
        }
        else
            KLOC = Double.parseDouble(txtKLOC.getText().toString());

        if (txtEsforco.getText().toString().equals("")||txtEsforco.getText().toString().equals("."))
        {
            esforco=0;
        }
        else
            esforco = Double.parseDouble(txtEsforco.getText().toString());

        double LOC = KLOC*1000;
        produtividade = KLOC/esforco;
        correcao = erros/KLOC;
        custoloc = dinheiro/LOC;
        documentacao = pags/KLOC;

        ConfigActivity config = new ConfigActivity();
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

        if (config.configDecimal == 1) {
            txtprodutividade.setText(String.format("%.2f", produtividade));
            txtcorrecao.setText(String.format("%.2f", correcao));
            txtCustoLOC.setText(String.format("%.2f", custoloc));
            txtdocumentacao.setText(String.format("%.2f", documentacao));
        }
        else if (config.configDecimal ==2){
            txtprodutividade.setText(String.format("%.5f",produtividade));
            txtcorrecao.setText(String.format("%.5f",correcao));
            txtCustoLOC.setText(String.format("%.5f",custoloc));
            txtdocumentacao.setText(String.format("%.5f",documentacao));
        }


        else if (config.configDecimal ==3) {
            txtprodutividade.setText(String.format(String.valueOf(produtividade)));
            txtcorrecao.setText(String.format(String.valueOf(correcao)));
            txtCustoLOC.setText(String.format(String.valueOf(custoloc)));
            txtdocumentacao.setText(String.format(String.valueOf(documentacao)));
        }



    }


    public void infoEsforco (View view){
        Snackbar.make(view, "ESFORCO = Quantidade de pessoas necessárias para terminar o projeto em um mês", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void infoValor (View view){
        Snackbar.make(view, "VALOR EM $ = Valor do projeto em dinheiro", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void infoKLOC (View view){
        Snackbar.make(view, "KLOC = Mil linhas de códigos (1 KLOC = 1000 linhas de código) ", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void infopags (View view){
        Snackbar.make(view, "pags.docum. = Quantidade de páginas de documentação do projeto", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void infoErros (View view){
        Snackbar.make(view, "ERROS = Quantidade de erros", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
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
