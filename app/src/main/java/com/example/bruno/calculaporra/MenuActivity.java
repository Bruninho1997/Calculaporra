package com.example.bruno.calculaporra;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
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
        {

            view.setBackgroundResource(R.drawable.fundobranco);

        }

        if (config.configFundo==2)
        {

            view.setBackgroundResource(R.drawable.fundoverde);

        }

    }


    public void calculadora (View view)
    {
        fazerSom();
        Intent it = new Intent(this.getApplicationContext(),CalculadoraActivity.class);
        startActivity(it);
    }

    public void fatorial (View view)
    {fazerSom();
        Intent it = new Intent(this.getApplicationContext(),FatorialActivity.class);
        startActivity(it);
    }

    public void raiz (View view)
    {fazerSom();
        Intent it = new Intent(this.getApplicationContext(),RaizActivity.class);
        startActivity(it);
    }

    public void metricaskloc (View view)
    {fazerSom();
        Intent it = new Intent(this.getApplicationContext(),metricaLOC.class);
        startActivity(it);
    }

    public void porcentagem (View view)
    {fazerSom();
        Intent it = new Intent(this.getApplicationContext(),PorcentagemActivity.class);
        startActivity(it);
    }

    public void velocidademedia (View view)
    {fazerSom();
        Intent it = new Intent(this.getApplicationContext(),velocidadeMediaActivity.class);
        startActivity(it);
    }

    public void configuracoes (View view)
    {fazerSom();
        Intent it = new Intent(this.getApplicationContext(),ConfigActivity.class);
        startActivity(it);
    }

    public void novidades (View view)
    {fazerSom();
        Intent it = new Intent(this.getApplicationContext(),sobreAtualizacoesActivity.class);
        startActivity(it);
    }

    public void imc (View view)
    {fazerSom();
        Intent it = new Intent(this.getApplicationContext(),ImcActivity.class);
        startActivity(it);
    }

    public void pot (View view)
    {fazerSom();
        Intent it = new Intent(this.getApplicationContext(),PotencializacaoActicity.class);
        startActivity(it);
    }



    public void sobre (View view)
    {fazerSom();
        controleVersao controle = new controleVersao();
        String texto = "DEV : BRUNO HENRIQUE\nFUNDO : GABRYELLE FRANCISCA\nv" + controle.versao;
        Context contexto = getApplicationContext();

        int duracao = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();
    }

    public void fazerSom ()
    {
        MediaPlayer mp = MediaPlayer.create(MenuActivity.this, R.raw.ring);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                mp.release();
            }

        });
        mp.start();
    }
}
