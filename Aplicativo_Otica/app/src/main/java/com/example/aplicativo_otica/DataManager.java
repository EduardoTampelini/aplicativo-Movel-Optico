package com.example.aplicativo_otica;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataManager {
    //declarar a base de dados
    private SQLiteDatabase db;
    //define as constantes para conexão com o banco
    public static final String DB_NAME= "bd_app_optico";
    public static final int DB_VERSION = 1;
    public static final String TABELA_CLIENTE= "cliente";
    //Defini as contantes com os nomes das colunas
    public static final String COLUNA_ID= "id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_CPF = "cpf";
    public static final String  COLUNA_FONE = "fone";

    //criaro construtor da classe
    public DataManager(Context context){
        //criar uma instancia da nossa helper
        NossoSQLiteOpenHelper helper = new NossoSQLiteOpenHelper(context);
        //Obtem uma base de dados editavel
        db = helper.getWritableDatabase();
    }
    //inserindoum registro
    public void inserir (String nome, String cpf, String fone){
        String query = "INSERT INTO "+ TABELA_CLIENTE+
                " ( "+COLUNA_NOME+" , "+COLUNA_CPF+" , "+COLUNA_FONE+" )"+
                " VALUES ("+"'"+nome+"' , '"+cpf+"' , '"+fone+"');";
        Log.i("insert() = ",query);
        db.execSQL(query);
    }


    public Cursor listar(){
        String query = "SELECT * FROM "+TABELA_CLIENTE+";";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    //Busca Registro
    public Cursor consulta(String nome){
        String query = "SELECT "+COLUNA_ID+","+COLUNA_NOME+","+COLUNA_CPF+","+COLUNA_FONE+
                " FROM "+TABELA_CLIENTE+" WHERE "+COLUNA_NOME+" = '"+nome+"';";
        Log.i("consultar() = ",query);
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    private class NossoSQLiteOpenHelper extends SQLiteOpenHelper {
        //Cria o metodo Construtor da classe
        public NossoSQLiteOpenHelper(Context context){
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase){
            String queryNovaTabela = "CREATE TABLE "
                    +TABELA_CLIENTE +"("
                    +COLUNA_ID +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    +COLUNA_NOME+" TEXT NOT NULL,"
                    +COLUNA_CPF+" TEXT NOT NULL,"
                    +COLUNA_FONE+" TEXT NOT NULL);";
            sqLiteDatabase.execSQL(queryNovaTabela);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

    }
}
