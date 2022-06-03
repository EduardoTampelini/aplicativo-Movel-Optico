package com.example.aplicativo_otica;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ReceituarioListFrag extends Fragment {
    @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
    View v = inflater.inflate(R.layout.receituario_list, container, false);

    // aqui vai o código do banco de dados
    //Cria um objeto DataManager(permite acesso a tabelas e s queries)
    DataManager dm = new DataManager(getActivity());
    //Busca a textView e atribui para a variavel textResultado
    TextView textResutados = v.findViewById(R.id.txtReceituarios);
    //busca os registros na tabela
    Cursor c = dm.listarrece();
    //String para manipular os resultados
    String resultados = "";
    //Itera por todos os registros encontrados
    while (c.moveToNext()){
        //adiciona resultado a String
        resultados += (c.getString(1)+" - "+c.getString(2)+" - "+c.getString(3)+" - "+c.getString(4)+" - "+c.getString(5)+" - "+c.getString(6)+" - "+c.getString(7)+"\n");

    }
    //Exibe os resultados na TextView
    textResutados.setText(resultados);

    return v;
}
}
