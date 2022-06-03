package com.example.aplicativo_otica;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // faz referencia ao layout que estamos criando
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //cria objeto que controla os drawers
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,0,0);
        //chama os listeners, ou gerenciadores de eventos
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //editando o que acontece quando aperta o botão botar
    //Se o drawer estiver aberto feche o drawer
    //caso contrário execulta o comportamento normal
    @Override
    public void onBackPressed(){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super .onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //manipular os dados da barra de ação
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super .onOptionsItemSelected(item);
    }

    //manipular os eventos do menu de navegação (View Navigation)
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        //criar uma transaction, ou seja um conjunto de operações com fragmentos diferentes
        FragmentTransaction transaction  = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();
        if(id == R.id.nav_cliente_insert){
            //criar um novo fragmento
            ClienteInsertFrag fragment = new ClienteInsertFrag();
            transaction.replace(R.id.fragmentHolder, fragment);
        }else if(id == R.id.nav_cliente_listar){
            //criar um novo fragmento
            ClienteListFrag fragment = new ClienteListFrag();
            transaction.replace(R.id.fragmentHolder, fragment);
        }else if(id == R.id.nav_receop_insert){
            //criar um novo fragmento
            ReceituarioInsertFrag fragment = new ReceituarioInsertFrag();
            transaction.replace(R.id.fragmentHolder, fragment);
        }else if(id == R.id.nav_receop_listar){
            //criar um novo fragmento
            ReceituarioListFrag fragment = new ReceituarioListFrag();
            transaction.replace(R.id.fragmentHolder, fragment);
        }

        //armazena a seleção do usuario
        transaction.addToBackStack(null);
        transaction.commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}