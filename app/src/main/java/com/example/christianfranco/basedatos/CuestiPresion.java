package com.example.christianfranco.basedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CuestiPresion extends AppCompatActivity {

    private RadioButton p11, p12;
    private RadioButton p21, p22,p23,p24,p25,p26,p27,p28,p29,p210;
    private RadioButton p31, p32,p33,p34,p35;
    private RadioButton p41, p42;
    private RadioButton p51, p52,p53,p54;
    private RadioButton p61, p62;
    private RadioButton p71, p72, p73, p74,p75;
    private Button Aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuesti_presion);

        p11 = (RadioButton) findViewById(R.id.i11);
        p12 = (RadioButton) findViewById(R.id.i12);
        p21 = (RadioButton) findViewById(R.id.i21);
        p22 = (RadioButton) findViewById(R.id.i22);
        p23 = (RadioButton) findViewById(R.id.i23);
        p24 = (RadioButton) findViewById(R.id.i24);
        p25 = (RadioButton) findViewById(R.id.i25);
        p26 = (RadioButton) findViewById(R.id.i26);
        p27 = (RadioButton) findViewById(R.id.i27);
        p28 = (RadioButton) findViewById(R.id.i28);
        p29 = (RadioButton) findViewById(R.id.i29);
        p210 = (RadioButton) findViewById(R.id.i210);
        p31 = (RadioButton) findViewById(R.id.i31);
        p32 = (RadioButton) findViewById(R.id.i32);
        p33 = (RadioButton) findViewById(R.id.i33);
        p34 = (RadioButton) findViewById(R.id.i34);
        p35 = (RadioButton) findViewById(R.id.i35);
        p41 = (RadioButton) findViewById(R.id.i41);
        p42 = (RadioButton) findViewById(R.id.i42);
        p51 = (RadioButton) findViewById(R.id.i51);
        p52 = (RadioButton) findViewById(R.id.i52);
        p53 = (RadioButton) findViewById(R.id.i53);
        p54 = (RadioButton) findViewById(R.id.i54);
        p61 = (RadioButton) findViewById(R.id.i61);
        p62 = (RadioButton) findViewById(R.id.i62);
        p71 = (RadioButton) findViewById(R.id.i71);
        p72 = (RadioButton) findViewById(R.id.i72);
        p73 = (RadioButton) findViewById(R.id.i73);
        p74 = (RadioButton) findViewById(R.id.i74);
        p75 = (RadioButton) findViewById(R.id.i75);

        Aceptar=(Button)findViewById(R.id.btnAceptar);


        Aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int g=gen();
                int t = total();
                String re=res(g,t);//resultado
                Toast.makeText(getApplicationContext(),re, Toast.LENGTH_SHORT).show();
                Intent op = new Intent(CuestiPresion.this, Menu.class);
                startActivity(op);
                finish();

            }
        });
    }

    public int gen() {
        Integer g = 0;
        if (p11.isChecked()) {
            g = 1;//hombre
        } else {
            g = 2;//mujer
        }
        return g;
    }

    public int age(Integer g) {
        Integer r = 0;
        if (g == 1) {//hombre
            if (p21.isChecked()) {
                r += -9;
            } else if (p22.isChecked()) {
                r += -4;
            } else if (p23.isChecked()) {
                r += 0;
            } else if (p24.isChecked()) {
                r += 3;
            } else if (p25.isChecked()) {
                r += 6;
            } else if (p26.isChecked()) {
                r += 8;
            } else if (p27.isChecked()) {
                r += 10;
            } else if (p28.isChecked()) {
                r += 11;
            } else if (p29.isChecked()) {
                r += 12;
            } else if (p210.isChecked()) {
                r += 13;
            }
        } else {//mujer
            if (p21.isChecked()) {
                r += -7;
            } else if (p22.isChecked()) {
                r += -3;
            } else if (p23.isChecked()) {
                r += 0;
            } else if (p24.isChecked()) {
                r += 3;
            } else if (p25.isChecked()) {
                r += 6;
            } else if (p26.isChecked()) {
                r += 8;
            } else if (p27.isChecked()) {
                r += 10;
            } else if (p28.isChecked()) {
                r += 12;
            } else if (p29.isChecked()) {
                r += 14;
            } else if (p210.isChecked()) {
                r += 16;
            }
        }
        return r;
    }

    public int col(Integer g, Integer e) {
        Integer r = 0;
        if (g == 1) {//hombre
            if (p31.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 0;
                } else if (e == 0 | e == -3) {
                    r = 0;
                } else if (e == -6 | e == 8) {
                    r = 0;
                } else if (e == -10 | e == 11) {
                    r = 0;
                } else if (e == 12 | e == 13) {
                    r = 0;
                }
            } else if (p32.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 4;
                } else if (e == 0 | e == -3) {
                    r = 3;
                } else if (e == -6 | e == 8) {
                    r = 2;
                } else if (e == -10 | e == 11) {
                    r = 1;
                } else if (e == 12 | e == 13) {
                    r = 0;
                }
            } else if (p33.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 7;
                } else if (e == 0 | e == -3) {
                    r = 5;
                } else if (e == -6 | e == 8) {
                    r = 3;
                } else if (e == -10 | e == 11) {
                    r = 1;
                } else if (e == 12 | e == 13) {
                    r = 0;
                }
            } else if (p34.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 9;
                } else if (e == 0 | e == -3) {
                    r = 6;
                } else if (e == -6 | e == 8) {
                    r = 4;
                } else if (e == -10 | e == 11) {
                    r = 2;
                } else if (e == 12 | e == 13) {
                    r = 1;
                }
            } else if (p35.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 11;
                } else if (e == 0 | e == -3) {
                    r = 8;
                } else if (e == -6 | e == 8) {
                    r = 5;
                } else if (e == -10 | e == 11) {
                    r = 3;
                } else if (e == 12 | e == 13) {
                    r = 1;
                }
            }
        } else {//mujer
            if (p31.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 0;
                } else if (e == 0 | e == -3) {
                    r = 0;
                } else if (e == -6 | e == 8) {
                    r = 0;
                } else if (e == -10 | e == 11) {
                    r = 0;
                } else if (e == 12 | e == 13) {
                    r = 0;
                }
            } else if (p32.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 4;
                } else if (e == 0 | e == -3) {
                    r = 3;
                } else if (e == -6 | e == 8) {
                    r = 2;
                } else if (e == -10 | e == 11) {
                    r = 1;
                } else if (e == 12 | e == 13) {
                    r = 1;
                }
            } else if (p33.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 8;
                } else if (e == 0 | e == -3) {
                    r = 6;
                } else if (e == -6 | e == 8) {
                    r = 4;
                } else if (e == -10 | e == 11) {
                    r = 2;
                } else if (e == 12 | e == 13) {
                    r = 1;
                }
            } else if (p34.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 11;
                } else if (e == 0 | e == -3) {
                    r = 8;
                } else if (e == -6 | e == 8) {
                    r = 5;
                } else if (e == -10 | e == 11) {
                    r = 3;
                } else if (e == 12 | e == 13) {
                    r = 2;
                }
            } else if (p35.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 13;
                } else if (e == 0 | e == -3) {
                    r = 10;
                } else if (e == -6 | e == 8) {
                    r = 7;
                } else if (e == -10 | e == 11) {
                    r = 4;
                } else if (e == 12 | e == 13) {
                    r = 2;
                }
            }
        }
        return r;
    }

    public int fuma(Integer g, Integer e) {
        Integer r = 0;
        if (g == 1) {//hombre
            if (p41.isChecked()) {//si
                if (e == -9 | e == -4) {
                    r = 8;
                } else if (e == 0 | e == -3) {
                    r = 5;
                } else if (e == -6 | e == 8) {
                    r = 3;
                } else if (e == -10 | e == 11) {
                    r = 1;
                } else if (e == 12 | e == 13) {
                    r = 1;
                }
            } else if (p42.isChecked()) {//no
                if (e == -9 | e == -4) {
                    r = 0;
                } else if (e == 0 | e == -3) {
                    r = 0;
                } else if (e == -6 | e == 8) {
                    r = 0;
                } else if (e == -10 | e == 11) {
                    r = 0;
                } else if (e == 12 | e == 13) {
                    r = 0;
                }
            }
        } else {//mujer
            if (p41.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 9;
                } else if (e == 0 | e == -3) {
                    r = 7;
                } else if (e == -6 | e == 8) {
                    r = 4;
                } else if (e == -10 | e == 11) {
                    r = 2;
                } else if (e == 12 | e == 13) {
                    r = 1;
                }
            } else if (p42.isChecked()) {
                if (e == -9 | e == -4) {
                    r = 0;
                } else if (e == 0 | e == -3) {
                    r = 0;
                } else if (e == -6 | e == 8) {
                    r = 0;
                } else if (e == -10 | e == 11) {
                    r = 0;
                } else if (e == 12 | e == 13) {
                    r = 0;
                }
            }
        }
        return r;
    }

    public int hdl() {
        Integer r = 0;
        if (p51.isChecked()) {//si
            r = -1;
        } else if (p52.isChecked()) {//no
            r = 0;
        } else if (p53.isChecked()) {//no
            r = 1;
        } else if (p54.isChecked()) {//no
            r = 2;
        }
        return r;
    }

    public int tratado() {
        Integer r = 0;
        if (p61.isChecked()) {
            r = 1;//si
        } else {
            r = 2;//no
        }
        return r;
    }

    public int sys(Integer g, Integer t) {
        Integer r = 0;
        if (g == 1) {
            if (t == 1) {
                if (p71.isChecked()) {
                    r = 0;
                } else if (p72.isChecked()) {
                    r = 1;
                } else if (p73.isChecked()) {
                    r = 2;
                } else if (p74.isChecked()) {
                    r = 2;
                } else if (p75.isChecked()) {
                    r = 3;
                }
            } else {
                if (p71.isChecked()) {
                    r = 0;
                } else if (p72.isChecked()) {
                    r = 0;
                } else if (p73.isChecked()) {
                    r = 1;
                } else if (p74.isChecked()) {
                    r = 1;
                } else if (p75.isChecked()) {
                    r = 2;
                }
            }
        } else {
            if (t == 1) {
                if (p71.isChecked()) {
                    r = 0;
                } else if (p72.isChecked()) {
                    r = 3;
                } else if (p73.isChecked()) {
                    r = 4;
                } else if (p74.isChecked()) {
                    r = 5;
                } else if (p75.isChecked()) {
                    r = 6;
                }
            } else {
                if (p71.isChecked()) {
                    r = 0;
                } else if (p72.isChecked()) {
                    r = 1;
                } else if (p73.isChecked()) {
                    r = 2;
                } else if (p74.isChecked()) {
                    r = 3;
                } else if (p75.isChecked()) {
                    r = 4;
                }
            }
        }
        return r;
    }

    public int total() {
        Integer r = 0;
        int g = gen();//1 h, 2m
        int e = age(g);
        int c = col(g, e);
        int f = fuma(g, e);
        int h = hdl();
        int t = tratado();
        int s = sys(g, t);
        return r = e + c + f + h + s;
    }

    /*
    el texto de respuesta acorde a la puntuacion
     */
    public String res(int g,int t){
        String re="";
        if(g==1){//h
            if(t<5){
                re="Hay un riesgo de 1%";
            }else if(t<7){
                re="Hay un riesgo de 2%";
            }else if(t==7){
                re="Hay un riesgo de 3%";
            }else if(t==8){
                re="Hay un riesgo de 4%";
            }else if(t==9){
                re="Hay un riesgo de 5%";
            }else if(t==10){
                re="Hay un riesgo de 6%";
            }else if(t==11){
                re="Hay un riesgo de 8%";
            }else if(t==12){
                re="Hay un riesgo de 10%";
            }else if(t==13){
                re="Hay un riesgo de 12%";
            }else if(t==14){
                re="Hay un riesgo de 16%";
            }else if(t==15){
                re="Hay un riesgo de 20%";
            }else if(t==16){
                re="Hay un riesgo de 25%";
            }else if(t>16){
                re="Hay un riesgo de 30%";
            }
        }else {//m
            if(t<9){
                re="Hay un riesgo de 1%";
            }else if(t==9){
                re="Hay un riesgo de 1%";
            }else if(t==10){
                re="Hay un riesgo de 1%";
            }else if(t==11){
                re="Hay un riesgo de 1%";
            }else if(t==12){
                re="Hay un riesgo de 1%";
            }else if(t==13){
                re="Hay un riesgo de 2%";
            }else if(t==14){
                re="Hay un riesgo de 2%";
            }else if(t==15){
                re="Hay un riesgo de 3%";
            }else if(t==16){
                re="Hay un riesgo de 4%";
            }else if(t==17){
                re="Hay un riesgo de 5%";
            }else if(t==18){
                re="Hay un riesgo de 6%";
            }else if(t==19){
                re="Hay un riesgo de 8%";
            }else if(t==20){
                re="Hay un riesgo de 11%";
            }else if(t==21){
                re="Hay un riesgo de 14%";
            }else if(t==22){
                re="Hay un riesgo de 17%";
            }else if(t==23){
                re="Hay un riesgo de 22%";
            }else if(t==24){
                re="Hay un riesgo de 27%";
            }else if(t>24){
                re="Hay un riesgo de 30%";
            }
        }
        return re;
    }

    /*
    al presionarlo regresa al menu principal, solo si no esta contando pasos, obligando que utilicen el btn de  la app regresar
     */
    public void onBackPressed() {
        Intent menu = new Intent(CuestiPresion.this, Menu.class);
        startActivity(menu);
        finish();
    }

}