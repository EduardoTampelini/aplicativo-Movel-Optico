package com.example.aplicativo_otica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class ClienteInsertFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v = inflater.inflate(R.layout.cliente_insert, container, false);


        // aqui vai o código do banco de dados
        DataManager dm = new DataManager(getActivity());
        Button btn = v.findViewById(R.id.btnCliente);
        EditText nome = v.findViewById(R.id.editNome);
        EditText cpf = v.findViewById(R.id.editCpf);
        EditText fone = v.findViewById(R.id.editFone);

        //pegar evento de click do botão

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dm.inserir(nome.getText().toString(),cpf.getText().toString(),fone.getText().toString());

            }
        });

        return v;
    }
}

