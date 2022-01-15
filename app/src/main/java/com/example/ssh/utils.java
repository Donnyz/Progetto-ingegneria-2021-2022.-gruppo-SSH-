package com.example.ssh;

import android.content.Context;
import android.content.Intent;

public class utils {
    Intent i;
    Context c;

    private utils(Intent i,Context c){
        i = i;
        c = c;
    }

    public static Intent new_intent(Persona p, Class c, Context context){
        Intent i = new Intent(context,c);
        i.putExtra("cognomePersona",p.getCognome());
        i.putExtra("NomePersona",p.getNome());
        i.putExtra("IdPersona",p.getId());
        i.putExtra("insegna",p.getInsegna());
        return i;
    }

    public static Persona ottieni(Intent i){
        Persona p = new Persona();
        if(i.getStringExtra("NomePersona")!=null){
            p.setNome(i.getStringExtra("NomePersona"));
        }
        if(i.getStringExtra("cognomePersona")!=null){
            p.setCognome(i.getStringExtra("cognomePersona"));
        }
        if(i.getStringExtra("IdPersona")!=null){
            p.setId(i.getStringExtra("IdPersona"));
        }
        if(i.getStringExtra("insegna")!=null){
            p.setInsegna(i.getBooleanExtra("insegna",false));
        }

        return p;
    }

}
