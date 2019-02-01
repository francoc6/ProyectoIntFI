package com.example.christianfranco.basedatos;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.christianfranco.basedatos.DialogPre.DialogIni;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Status extends AppCompatActivity {
    //TextView PGR,PG,Ppresion,Ppeso,TGR,TG,Tpresion,Tpeso;
    TextView GT, HT, CT, TT, COLT, COLLT, PEST, CIRT, PAT, IMT, PGT;
    TextView GR, HR, CR, TR, COLR, COLLR, PESR, CIRR, PAR, IMR, PGR;
    String g;
    Integer edad;
    Float imc = 0f;

    SharedPreferences usuariognr;//lo uso para obtener el usuario almacenado
    Boolean ban = false;

    ArrayList<String> res = new ArrayList<String>();

    public static String respuestaG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        usuariognr = getSharedPreferences("Guardarusuario", MODE_PRIVATE);//instancio el objeto para obtener usuario
        final String usuario = usuariognr.getString("usuario", "vacio");

        final DialogIni dialog = new DialogIni();


        GT = (TextView) findViewById(R.id.GT);
        PGT = (TextView) findViewById(R.id.pgT);
        HT = (TextView) findViewById(R.id.HT);
        CT = (TextView) findViewById(R.id.CT);
        TT = (TextView) findViewById(R.id.TT);
        COLT = (TextView) findViewById(R.id.COLT);
        COLLT = (TextView) findViewById(R.id.COLLT);
        PEST = (TextView) findViewById(R.id.PEST);
        CIRT = (TextView) findViewById(R.id.CIRT);
        PAT = (TextView) findViewById(R.id.PAT);
        IMT = (TextView) findViewById(R.id.IMT);

        GR = (TextView) findViewById(R.id.GR);
        PGR = (TextView) findViewById(R.id.pgR);
        HR = (TextView) findViewById(R.id.HR);
        CR = (TextView) findViewById(R.id.CR);
        TR = (TextView) findViewById(R.id.TR);
        COLR = (TextView) findViewById(R.id.COLR);
        COLLR = (TextView) findViewById(R.id.COLLR);
        PESR = (TextView) findViewById(R.id.PESR);
        CIRR = (TextView) findViewById(R.id.CIRR);
        PAR = (TextView) findViewById(R.id.PAR);
        IMR = (TextView) findViewById(R.id.IMR);

        res = obtenerdatos(usuario);//se obtienen todas las variables y el genero del usuario

        if (ban == false) {
            //color();
            asignarcolores(g, edad);
        }

        GT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show(getSupportFragmentManager(), "dialogo");
            }
        });

    }


    //obtengo los ultimos valores de las variables del usuario
    Conectar conectar = new Conectar();

    public ArrayList<String> obtenerdatos(String u) {
        ArrayList<String> resul = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        try {
            Statement pedir = conectar.conectarabase().createStatement();
            ResultSet res = null;
            for (int x = 1; x < 11; x++) {//ya que hay 10 variables
                res = pedir.executeQuery("select Valor from Variables_db where Usuario='" + u + "' AND Tipo='" + x + "'");
                while (res.next()) {
                    temp.add(res.getString("Valor"));
                }
                if (temp.size() == 0) {
                    resul.add("Sin Registro");
                } else {
                    // resul.add(res.getString(res.getFetchSize()));
                    resul.add(temp.get(temp.size() - 1));
                }
                temp.clear();
            }

            res = pedir.executeQuery("select Genero from RegistroUsuarios_db where Usuario='" + u + "'");
            res.next();
            g = res.getString("Genero");
            res = pedir.executeQuery("select Edad from RegistroUsuarios_db where Usuario='" + u + "'");
            res.next();
            edad = Integer.valueOf(res.getString("Edad"));
            res.close();
            GR.setText(resul.get(0));
            HR.setText(resul.get(1));
            CR.setText(resul.get(2));
            TR.setText(resul.get(3));
            COLR.setText(resul.get(4));
            COLLR.setText(resul.get(5));
            PESR.setText(resul.get(6));
            CIRR.setText(resul.get(7));
            PAR.setText(resul.get(8));
            PGR.setText(resul.get(9));

            res = pedir.executeQuery("select Talla from RegistroUsuarios_db where Usuario='" + u + "'");
            res.next();
            Float talla = Float.valueOf(res.getString("Talla"));
            res.close();

            if (resul.get(6).equals("Sin Registro")) {
                IMR.setText("No se ha ingresado peso");

            } else {
                Float peso = Float.valueOf(resul.get(6));
                Float re = peso / (talla * talla);
                imc = re;
                IMR.setText(re.toString());
            }

        } catch (SQLException e) {
            ban = true;
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            Intent go = new Intent(Status.this, Menu.class);
            startActivity(go);
            finish();
        }
        return resul;
    }


    public void asignarcolores(String g, Integer e) {
        //Glucosa
        if (res.get(0).equals("Sin Registro")) {
            //no hace nada, si no hay registro
        } else {
            if (Float.valueOf(res.get(0)) < 100) {//verde
                GT.setBackgroundResource(R.color.VERDE);
            } else {//rojo
                GT.setBackgroundResource(R.color.ROJO);
            }
        }
        //hemoglobina
        if (res.get(1).equals("Sin Registro")) {

        } else {
            if (Float.valueOf(res.get(1)) < 5.7) {//verde
                HT.setBackgroundResource(R.color.VERDE);
            } else {//rojo
                HT.setBackgroundResource(R.color.ROJO);
            }
        }

        //COLESTEROL

        if (res.get(2).equals("Sin Registro")) {

        } else {
            if (Float.valueOf(res.get(2)) < 200) {//verde
                CT.setBackgroundResource(R.color.VERDE);
            } else {//rojo
                CT.setBackgroundResource(R.color.ROJO);
            }
        }
        //trigliceridos
        if (res.get(3).equals("Sin Registro")) {

        } else {
            if (Float.valueOf(res.get(3)) < 100) {//verde
                TT.setBackgroundResource(R.color.VERDE);
            } else {//rojo
                TT.setBackgroundResource(R.color.ROJO);
            }
        }
        //colesterol hdl
        if (res.get(4).equals("Sin Registro")) {

        } else {
            if (g.equals("Hombre")) {
                if (Float.valueOf(res.get(4)) >= 40) {//verde
                    COLT.setBackgroundResource(R.color.VERDE);
                } else {//rojo
                    COLT.setBackgroundResource(R.color.ROJO);
                }
            } else {
                if (Float.valueOf(res.get(4)) >= 50) {//verde
                    COLT.setBackgroundResource(R.color.VERDE);
                } else {//rojo
                    COLT.setBackgroundResource(R.color.ROJO);
                }
            }
        }
        //colesterol LDL
        if (res.get(5).equals("Sin Registro")) {

        } else {
            if (Float.valueOf(res.get(5)) < 130) {//VERDE
                COLLT.setBackgroundResource(R.color.VERDE);
            } else {//ROJO
                COLLT.setBackgroundResource(R.color.ROJO);
            }
        }

        //CIRCUNFERENCIA CINTURA
        if (res.get(7).equals("Sin Registro")) {

        } else {
            if (g.equals("Hombre")) {
                if (Float.valueOf(res.get(7)) < 94) {//VERDE
                    CIRT.setBackgroundResource(R.color.VERDE);
                } else if (Float.valueOf(res.get(7)) >= 94 && Float.valueOf(res.get(7)) <= 102) {//AMARILLO
                    CIRT.setBackgroundResource(R.color.AMARILLO);
                } else if (Float.valueOf(res.get(7)) > 102) {//ROJO
                    CIRT.setBackgroundResource(R.color.ROJO);
                }
            } else {
                if (Float.valueOf(res.get(7)) < 80) {//VERDE
                    CIRT.setBackgroundResource(R.color.VERDE);
                } else if (Float.valueOf(res.get(7)) >= 80 && Float.valueOf(res.get(7)) <= 88) {//AMARILLO
                    CIRT.setBackgroundResource(R.color.AMARILLO);
                } else if (Float.valueOf(res.get(7)) > 88) {//ROJO
                    CIRT.setBackgroundResource(R.color.ROJO);
                }
            }
        }
        //presion
        if (res.get(8).equals("Sin Registro")) {

        } else {
            String[] parts = res.get(8).split("/");
            if (Float.valueOf(parts[0]) < 120 && Float.valueOf(parts[1]) < 80) {//verde
                PAT.setBackgroundResource(R.color.VERDE);
            } else if (Float.valueOf(parts[0]) > 120 && Float.valueOf(parts[0]) < 129 && Float.valueOf(parts[1]) < 80) {//amarillo
                PAT.setBackgroundResource(R.color.AMARILLO);
            } else if ((Float.valueOf(parts[0]) > 130) | Float.valueOf(parts[1]) > 80) {//rojo
                PAT.setBackgroundResource(R.color.ROJO);
            }
        }

        if (res.get(9).equals("Sin Registro")) {

        } else {
            if (g.equals("Hombre")) {
                if (e >= 20 && e <= 39) {
                    if (Float.valueOf(res.get(9)) >= 8 && Float.valueOf(res.get(9)) <= 20) {//VERDE
                        PGT.setBackgroundResource(R.color.VERDE);
                    } else if (Float.valueOf(res.get(9)) > 20) {//ROJO
                        PGT.setBackgroundResource(R.color.ROJO);
                    }
                } else if (e >= 40 && e <= 59) {
                    if (Float.valueOf(res.get(9)) >= 11 && Float.valueOf(res.get(9)) <= 22) {//VERDE
                        PGT.setBackgroundResource(R.color.VERDE);
                    } else if (Float.valueOf(res.get(9)) > 22) {//ROJO
                        PGT.setBackgroundResource(R.color.ROJO);
                    }
                } else if (e >= 60 && e <= 79) {
                    if (Float.valueOf(res.get(9)) >= 13 && Float.valueOf(res.get(9)) <= 25) {//VERDE
                        PGT.setBackgroundResource(R.color.VERDE);
                    } else if (Float.valueOf(res.get(9)) > 25) {//ROJO
                        PGT.setBackgroundResource(R.color.ROJO);
                    }
                }
            } else {
                if (e >= 20 && e <= 39) {
                    if (Float.valueOf(res.get(9)) >= 21 && Float.valueOf(res.get(9)) <= 33) {//VERDE
                        PGT.setBackgroundResource(R.color.VERDE);
                    } else if (Float.valueOf(res.get(9)) > 33) {//ROJO
                        PGT.setBackgroundResource(R.color.ROJO);
                    }
                } else if (e >= 40 && e <= 59) {
                    if (Float.valueOf(res.get(9)) >= 23 && Float.valueOf(res.get(9)) <= 34) {//VERDE
                        PGT.setBackgroundResource(R.color.VERDE);
                    } else if (Float.valueOf(res.get(9)) > 34) {//ROJO
                        PGT.setBackgroundResource(R.color.ROJO);
                    }
                } else if (e >= 60 && e <= 79) {
                    if (Float.valueOf(res.get(9)) >= 24 && Float.valueOf(res.get(9)) <= 36) {//VERDE
                        PGT.setBackgroundResource(R.color.VERDE);
                    } else if (Float.valueOf(res.get(9)) > 36) {//ROJO
                        PGT.setBackgroundResource(R.color.ROJO);
                    }
                }
            }

        }

        if (imc != 0) {
            if (imc > 18.5 && imc < 24.9) {//VERDE
                IMT.setBackgroundResource(R.color.VERDE);
            } else if (imc >= 25 && imc <= 29.9) {//AMARILLO
                IMT.setBackgroundResource(R.color.AMARILLO);
            } else if (imc >= 30) {//ROJO
                IMT.setBackgroundResource(R.color.ROJO);
            }
        }
    }

    //boton fisico
    @Override
    public void onBackPressed() {//al presionarlo regresa al menu principal, solo si no esta contando pasos, obligando que utilicen el btn de  la app regresar
        Intent menu = new Intent(Status.this, Menu.class);
        startActivity(menu);
        finish();
    }
}
