package com.example.bruno.calculaporra;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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

import static com.example.bruno.calculaporra.R.id.config;
//import static com.example.bruno.calculaporrav2.R.id.config;

public class CalculadoraActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {




    View view;

    double respostaTotal = 0 ;
    TextView txtresposta;
    EditText txtnum1;
    EditText txtnum2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
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
        txtnum2 = (EditText) findViewById(R.id.txtnum2);
        verFundo();
    }
    public void verFundo(){
        ConfigActivity config = new ConfigActivity();
        view = findViewById(R.id.principal);
        if (config.configFundo==1)
        {
            view.setBackgroundResource(R.drawable.fundo);
        }
        if (config.configFundo==0)
        {view.setBackgroundResource(R.drawable.fundobranco);}
        if (config.configFundo==2)
        {
            view.setBackgroundResource(R.drawable.fundoverde);
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

        //MainActivity main = new MainActivity();
        //main.controlePagina(id);

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
        else if (id == R.id.imc) {

            Intent it = new Intent(this.getApplicationContext(),ImcActivity.class);
            startActivity(it);
            if (configu.configFinish==0)
            finishAffinity();

        }

        else if (id == R.id.pot) {

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

    public void verResultadoSomOitoMil ()
    {

        ConfigActivity config = new ConfigActivity();
        if (respostaPraVer>8000&&config.configEfeito==1) {
            MediaPlayer mp = MediaPlayer.create(CalculadoraActivity.this, R.raw.oitomil);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {

                    mp.release();
                }

            });
            mp.start();
        }
    }


    double respostaPraVer;

    public int verPrecisao()
    {
        return Integer.parseInt(null);
    }


    public void somar (View view)
    {


        ConfigActivity config = new ConfigActivity();

        double num1= 0, num2 = 0, resposta = 0;
        if (txtnum1.getText().toString().equals("")||txtnum1.getText().toString().equals("."))
        {
            num1=0;
        }
        else
            num1 = Double.parseDouble(txtnum1.getText().toString());




        if (txtnum2.getText().toString().equals("")||txtnum2.getText().toString().equals("."))
        {
            num2=0;
        }
        else
            num2 = Double.parseDouble(txtnum2.getText().toString());



        resposta = num1 + num2;





        if (config.configDecimal == 1) {
            txtresposta.setText(String.format("%.2f", resposta));
        }

        else if (config.configDecimal ==2)
            txtresposta.setText(String.format("%.5f", resposta));

        else if (config.configDecimal ==3)
            txtresposta.setText(String.format(String.valueOf(resposta)));

        respostaTotal = resposta;
        verConfig();

        respostaPraVer = resposta;
        verResultadoSomOitoMil();

    }

    public void subtrair (View view)
    {

        ConfigActivity config = new ConfigActivity();


        double num1= 0, num2 = 0, resposta = 0;
        if (txtnum1.getText().toString().equals("")||txtnum1.getText().toString().equals("."))
        {
            num1=0;
        }
        else
            num1 = Double.parseDouble(txtnum1.getText().toString());




        if (txtnum2.getText().toString().equals("")||txtnum2.getText().toString().equals("."))
        {
            num2=0;
        }
        else
            num2 = Double.parseDouble(txtnum2.getText().toString());

        resposta = num1 - num2;

        if (config.configDecimal == 1)
            txtresposta.setText(String.format("%.2f", resposta));

        else if (config.configDecimal ==2)
            txtresposta.setText(String.format("%.5f", resposta));

        else if (config.configDecimal ==3)
            txtresposta.setText(String.format(String.valueOf(resposta)));

        respostaTotal = resposta;
        respostaPraVer = resposta;
        verResultadoSomOitoMil();
        verConfig();

    }

    public void multiplicar (View view)
    {
        ConfigActivity config = new ConfigActivity();


        double num1= 0, num2 = 0, resposta = 0;
        if (txtnum1.getText().toString().equals("")||txtnum1.getText().toString().equals("."))
        {
            num1=0;
        }
        else
            num1 = Double.parseDouble(txtnum1.getText().toString());




        if (txtnum2.getText().toString().equals("")||txtnum2.getText().toString().equals("."))
        {
            num2=0;
        }
        else
            num2 = Double.parseDouble(txtnum2.getText().toString());

        resposta = num1 * num2;

        if (config.configDecimal == 1)
            txtresposta.setText(String.format("%.2f", resposta));

        else if (config.configDecimal ==2)
            txtresposta.setText(String.format("%.5f", resposta));

        else if (config.configDecimal ==3)
            txtresposta.setText(String.format(String.valueOf(resposta)));

        respostaTotal = resposta;
        verConfig();

        respostaPraVer = resposta;
        verResultadoSomOitoMil();

    }

    public void dividir (View view)
    {

        ConfigActivity config = new ConfigActivity();



        double num1= 0, num2 = 0, resposta = 0;
        if (txtnum1.getText().toString().equals("")||txtnum1.getText().toString().equals("."))
        {
            num1=0;
        }
        else
            num1 = Double.parseDouble(txtnum1.getText().toString());




        if (txtnum2.getText().toString().equals("")||txtnum2.getText().toString().equals("."))
        {
            num2=0;
        }
        else
            num2 = Double.parseDouble(txtnum2.getText().toString());

        resposta = num1 / num2;

        //txtnum1.setText(String.format("%.2f", resposta));
        //txtnum2.setText(String.format("0"));

        if (config.configDecimal == 1)
        txtresposta.setText(String.format("%.2f", resposta));

        else if (config.configDecimal ==2)
            txtresposta.setText(String.format("%.5f", resposta));

        else if (config.configDecimal ==3)
            txtresposta.setText(String.format(String.valueOf(resposta)));

        respostaTotal = resposta;
        verConfig();

        respostaPraVer = resposta;
        verResultadoSomOitoMil();

    }


    public void verConfig()
    {
        int configDecimal = 0;
        ConfigActivity config = new ConfigActivity();
        double num1= 0, num2 = 0, resposta = respostaTotal;
        if (config.configResposta==1)
        {

            if (config.configDecimal == 1)
                txtnum1.setText(String.format("%.2f", resposta));

            else if (config.configDecimal ==2)
                txtnum1.setText(String.format("%.5f", resposta));

            else if (config.configDecimal ==3)
                txtnum1.setText(String.format(String.valueOf(resposta)));




            txtnum2.setText(String.format(""));

        }



    }


}

