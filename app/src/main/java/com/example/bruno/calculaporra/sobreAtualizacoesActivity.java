package com.example.bruno.calculaporra;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class sobreAtualizacoesActivity extends AppCompatActivity {

    public String log;
    TextView INFO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_atualizacoes);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        //getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Sobre as atualizações");
        //getSupportActionBar().hide();

        controleVersao controleversao = new controleVersao();
        INFO = (TextView) findViewById(R.id.txtInfo);

        log = controleversao.mudancas;

        INFO.setText(String.format(log));
    }

//    @Override
//    public void onBackPressed(){ //Botão BACK padrão do android
//        this.finish(); //O efeito ao ser pressionado do botão (no caso abre a activity)
//        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
//        return;
//    }

//    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
//        switch (item.getItemId()) {
//            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
//                this.finish();  //O efeito ao ser pressionado do botão (no caso abre a activity)
//                //finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
//                break;
//            default:break;
//        }
  //      return true;
//    }
}
