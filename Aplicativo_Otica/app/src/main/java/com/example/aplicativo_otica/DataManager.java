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

    public static final String TABELA_RECEITUARIO= "receituario";
    //Defini as contantes com os nomes das colunas
    public static final String COLUNA_IDOP= "id";
    public static final String COLUNA_OEPERTO = "oeperto";
    public static final String COLUNA_ODPERTO = "odperto";
    public static final String COLUNA_OELONGE = "oelonge";
    public static final String COLUNA_ODLONGE = "odlonge";
    public static final String COLUNA_OEALTURA = "oealtura";
    public static final String COLUNA_ODALTURA = "odaltura";
    public static final String COLUNA_OBSERVACAO = "observacao";



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
    public void inserirrece (String oeperto, String odperto,String oelonge,String odlonge, String oealtura, String odaltura,String observacao) {
        String query = "INSERT INTO "+ TABELA_RECEITUARIO+
                " ( "+COLUNA_OEPERTO+" , "+COLUNA_ODPERTO+" , "+COLUNA_OELONGE+" , "+COLUNA_ODLONGE +" , "+COLUNA_OEALTURA+" , "+COLUNA_ODALTURA+" , "+COLUNA_OBSERVACAO+" )"+
                " VALUES ("+"'"+oeperto+"' , '"+odperto+"' , '"+oelonge+"' , '"+odlonge+"' , '"+ oealtura+"' , '"+odaltura+"' , '"+observacao+"' );";
        Log.i("insert() = ",query);
        db.execSQL(query);
    }


    public Cursor listar(){
        String query = "SELECT * FROM "+TABELA_CLIENTE+";";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor listarrece(){
        String query = "SELECT * FROM "+TABELA_RECEITUARIO+";";
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

            String queryNovaTabelarece = "CREATE TABLE "
                    +TABELA_RECEITUARIO +"("
                    +COLUNA_IDOP +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    +COLUNA_OEPERTO+" TEXT NOT NULL,"
                    +COLUNA_ODPERTO+" TEXT NOT NULL,"
                    +COLUNA_OELONGE+" TEXT NOT NULL,"
                    +COLUNA_ODLONGE+" TEXT NOT NULL,"
                    +COLUNA_OEALTURA+" TEXT NOT NULL,"
                    +COLUNA_ODALTURA+" TEXT NOT NULL,"
                    +COLUNA_OBSERVACAO+" TEXT NOT NULL);";
            sqLiteDatabase.execSQL(queryNovaTabelarece);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

    }
}
