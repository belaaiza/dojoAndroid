package com.example.izabela.elmar;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BlankFragment extends Fragment implements View.OnClickListener{

    Button botao;
    EditText name;
    String nomeDigitado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Infla a view do fragment, o XML com o layout é o fragment_blank
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        //Aqui pegamos o botão do XML pelo seu id que é "button" e transformamos em um objeto manipulável
        botao = (Button) view.findViewById(R.id.button);

        //Aqui nós setamos o listener para o botão, o listener é quem fica "escutando" pra ver quando o botão será clicado
        botao.setOnClickListener(this);

        //Aqui pegamos o EditText que é uma caixa de texto, do XML pelo seu id que é "editText" e transformamos em um objeto manipulável
        name = (EditText) view.findViewById(R.id.editText);

        return view;
    }


    //Este é o método onClick que somos obrigados a escrever porque estamos implementando a interface OnClickListener
    //Aqui vamos colocar o que queremos que aconteça quando o usuário clica no botão
    @Override
    public void onClick(View v) {

            //Aqui comparamos se a view clicada foi o botão que queríamos, caso tivesse outros botões, faríamos outros ifs para verificar qual foi clicado
            if(v == botao) {

                //Aqui nós pegamos o texto digitado pela pessoa no campo de texto da tela, que salvamos como name
                //O texto vem do tipo Editable, por isso, transformamos para String com o to.String()
                nomeDigitado = name.getText().toString();

                //O Toast mostra uma mensagenzinha na tela, ele aparecerá quando a pessoa clicar no botão
                Toast.makeText(getActivity(), "Bem-vindo "+nomeDigitado, Toast.LENGTH_LONG).show();
            }

    }
}
