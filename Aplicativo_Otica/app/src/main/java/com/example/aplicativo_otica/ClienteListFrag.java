package com.example.aplicativo_otica;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ClienteListFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v = inflater.inflate(R.layout.cliente_list, container, false);

        // aqui vai o código do banco de dados
        //Cria um objeto DataManager(permite acesso a tabelas e s queries)
        DataManager dm = new DataManager(getActivity());
        //Busca a textView e atribui para a variavel textResultado
        TextView textResutados = v.findViewById(R.id.txtClientes);
        //busca os registros na tabela
        Cursor c = dm.listar();
        //String para manipular os resultados
        String resultados = "";
        //Itera por todos os registros encontrados
        while (c.moveToNext()){
            //adiciona resultado a String
            resultados += (c.getString(1)+" - "+c.getString(2)+" - "+c.getString(3)+"\n");

        }
        //Exibe os resultados na TextView
        textResutados.setText(resultados);

        return v;
    }
}
