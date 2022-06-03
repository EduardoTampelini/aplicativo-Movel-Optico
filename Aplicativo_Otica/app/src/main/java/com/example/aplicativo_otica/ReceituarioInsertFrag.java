package com.example.aplicativo_otica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class ReceituarioInsertFrag extends Fragment {
    @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
    View v = inflater.inflate(R.layout.receituairo_insert, container, false);


    // aqui vai o código do banco de dados
    DataManager dm = new DataManager(getActivity());
    Button btn = v.findViewById(R.id.btnReceituario);
    EditText oeperto = v.findViewById(R.id.txtOEperto);
    EditText odperto = v.findViewById(R.id.txtODperto);
    EditText oelonge = v.findViewById(R.id.txtOElonge);
    EditText oedlonge = v.findViewById(R.id.txtODlonge);
    EditText oealtura = v.findViewById(R.id.txtAlturaOE);
    EditText odaltura = v.findViewById(R.id.txtAlturaOD);
    EditText observacao = v.findViewById(R.id.txtObservacao);


    //pegar evento de click do botão

    btn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            dm.inserirrece(oeperto.getText().toString(),odperto.getText().toString(),oelonge.getText().toString(),oedlonge.getText().toString(),oealtura.getText().toString(),odaltura.getText().toString(),observacao.getText().toString());

        }
    });

    return v;
}
}
