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
        resultados += (" Esquerdo  Perto: "+c.getString(1)+" Direito Perto: "+c.getString(2)+"\n Esquerdo Longe:"+c.getString(3)+" Direito  Longe: "+c.getString(4)+"\n Esquerdo Altura:"+c.getString(5)+" Direito Altura "+c.getString(6)+"\n Cliente: "+c.getString(8)+"\n Obs: "+c.getString(7)+"\n");

    }
    //Exibe os resultados na TextView
    textResutados.setText(resultados);

    return v;
}
}
