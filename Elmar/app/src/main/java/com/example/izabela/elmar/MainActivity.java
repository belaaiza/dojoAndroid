package com.example.izabela.elmar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Infla a view da activity
        setContentView(R.layout.activity_main);

        //Pega o objeto da actionBar e seta a mesma para como sendo esse objeto.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Pega o floatingActionButton pelo id tranformando-o em um objeto manipulável
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //Seta um listener para o floatingActionButton, abrindo uma snackbar indicando que o usuário deve clicar nos 3 pontinhos
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clique nos tres pontinhos", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Infla o menu e adiciona itens na actionBar, no nosso caso, o item com 3 pontinhos esta no XML menu_main inflado aqui
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Pega o id do item da actionBar
        int id = item.getItemId();

        //Aqui dispara-se a açao para quando algum item da actionBar e clicado, no nosso caso os 3 pontinhos

        if (id == R.id.action_settings) {
            //Chama outro fragment, no nosso caso o BlankFragment
            //Desse jeito e so se vcs forem usar a biblioteca de suporte
            //E necessario ter um XML com o layout onde esse fragment vai se enfiar, no nosso caso e o content_teste
            //O content_teste é um layout dentro do XML content_main incluído no XML principal activity_main
            getSupportFragmentManager().beginTransaction().add(R.id.content_teste, new BlankFragment()).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
