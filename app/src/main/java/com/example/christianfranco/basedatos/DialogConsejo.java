package com.example.christianfranco.basedatos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class DialogConsejo extends DialogFragment {

    ImageView c11,c12,c13,c14,c15;



    /*
    se configuran las imagen dependiendo del status
     */
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_consejo, container, false);


        c11=(ImageView)view.findViewById(R.id.c11);
        c12=(ImageView)view.findViewById(R.id.c12);
        c13=(ImageView)view.findViewById(R.id.c13);
        c14=(ImageView)view.findViewById(R.id.c14);
        c15=(ImageView)view.findViewById(R.id.c15);

        if(Status.g1==3 && Status.g2==0){//PROBLEMAS ANTROPOMÉTRICOS (% GRASA ALTERADO, PRESIÓN ALTA, C.CINTURA ALTERADO)
            c11.setImageResource(R.drawable.g11);
            c12.setImageResource(R.drawable.g12);
            c13.setImageResource(R.drawable.g13);
            c14.setImageResource(R.drawable.g14);
            c15.setImageResource(R.drawable.g15);

        }else if(Status.g1==0 &&Status.g2==3){//PROBLEMAS BIOQUÍMICOS (COLESTEROL TOTAL, HEMOGLOBINA GLICOSILADA, TRIGLICÉRIDOS ALTERADOS)
            c11.setImageResource(R.drawable.g21);
            c12.setImageResource(R.drawable.g22);
            c13.setImageResource(R.drawable.g23);
            c14.setImageResource(R.drawable.g24);
            c15.setImageResource(R.drawable.g25);
        }else if(Status.g1==3 && Status.g2==3){//BIOQUÍMICOS & ANTROPOMÉTRICOS (% GRASA ALTERADO, PRESIÓN ALTA, C.CINTURA ALTERADO, COLESTEROL TOTAL, HEMOGLOBINA GLICOSILADA, TRIGLICÉRIDOS ALTERADOS)
            c11.setImageResource(R.drawable.g31);
            c12.setImageResource(R.drawable.g32);
            c13.setImageResource(R.drawable.g33);
            c14.setImageResource(R.drawable.g34);
            c15.setImageResource(R.drawable.g35);
        }else{//RECOMENDACIONES DEL ESTILO DE VIDA PREVENTIVAS
            c11.setImageResource(R.drawable.g41);
            c12.setImageResource(R.drawable.g42);
            c13.setImageResource(R.drawable.g43);
            c14.setImageResource(R.drawable.g44);
            c15.setImageResource(R.drawable.g45);
        }
        return view;
    }
}
