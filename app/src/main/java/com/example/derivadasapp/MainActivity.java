package com.example.derivadasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.derivadasapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {//revisar lo de la potencia
    ActivityMainBinding binding;

    private TextView mostrar;
    String unir, cadena;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mostrarTexto();
    }

    void mostrarTexto() {
        binding.num0.setOnClickListener(v -> binding.mostrar.setText(contatenar(0)));
        binding.num1.setOnClickListener(v -> binding.mostrar.setText(contatenar(1)));
        binding.num2.setOnClickListener(v -> binding.mostrar.setText(contatenar(2)));
        binding.num3.setOnClickListener(v -> binding.mostrar.setText(contatenar(3)));
        binding.num4.setOnClickListener(v -> binding.mostrar.setText(contatenar(4)));
        binding.num5.setOnClickListener(v -> binding.mostrar.setText(contatenar(5)));
        binding.num6.setOnClickListener(v -> binding.mostrar.setText(contatenar(6)));
        binding.num7.setOnClickListener(v -> binding.mostrar.setText(contatenar(7)));
        binding.num8.setOnClickListener(v -> binding.mostrar.setText(contatenar(8)));
        binding.num9.setOnClickListener(v -> binding.mostrar.setText(contatenar(9)));
        binding.terminoX.setOnClickListener(v -> binding.mostrar.setText(contatenar(10)));


        //agregados después
        binding.resta.setOnClickListener(v -> binding.mostrar.setText(contatenar(11)));
        binding.suma.setOnClickListener(v -> binding.mostrar.setText(contatenar(12)));
        binding.division.setOnClickListener(v -> binding.mostrar.setText(contatenar(13)));
        binding.punto.setOnClickListener(v -> binding.mostrar.setText(contatenar(14)));
        binding.fraccion.setOnClickListener(v -> binding.mostrar.setText(contatenar(16)));
        binding.potencia.setOnClickListener(v -> binding.mostrar.setText(contatenar(15)));
        binding.raiz.setOnClickListener(v -> binding.mostrar.setText(contatenar(17)));
        //binding.potencia.setOnClickListener(v->binding.mostrar.setText(concatenarPotencia()));
        binding.borrar.setOnClickListener(v -> binding.mostrar.setText(borrar1((String) binding.mostrar.getText())));
        binding.borrarT.setOnClickListener(v -> binding.mostrar.setText(borrarT((String) binding.mostrar.getText())));
        binding.igual.setOnClickListener(v -> comprobarRegla());

    }

    String concatenarPotencia() {//revisar esto
        unir = binding.mostrar.getText().toString();
        if (binding.num1.callOnClick()) {

            unir = unir + "¹";
        }
        return unir;
    }

    String contatenar(int op) {
        unir = binding.mostrar.getText().toString();
        switch (op) {
            case 0:
                unir = unir + "0";
                break;
            case 1:
                unir = unir + "1";
                break;
            case 2:
                unir = unir + "2";
                break;
            case 3:
                unir = unir + "3";
                break;
            case 4:
                unir = unir + "4";
                break;
            case 5:
                unir = unir + "5";
                break;
            case 6:
                unir = unir + "6";
                break;
            case 7:
                unir = unir + "7";
                break;
            case 8:
                unir = unir + "8";
                break;
            case 9:
                unir = unir + "9";
                break;
            case 10://borrar luego o verificar
                unir = unir + "x";
                break;
            case 11://borrar luego o verificar
                unir = unir + "-";
                break;
            case 12://borrar luego o verificar
                unir = unir + "+";
                break;
            case 13://borrar luego o verificar
                unir = unir + "÷";
                break;
            case 14://borrar luego o verificar
                unir = unir + ".";
                break;
            case 15://borrar luego o verificar
                unir = unir + "^";
                break;
            case 16://borrar luego o verificar
                unir = unir + "/";
                break;
            case 17://borrar luego o verificar
                unir = unir + "√";
                break;

        }
        return unir;
    }

    public void comprobarRegla() {
        String valor = (String) binding.mostrar.getText();
        String valorFinal = "";
        if (regla1(valor)) {
            Toast.makeText(this, "regla 1:  " + valor, Toast.LENGTH_SHORT).show();
        } else if (regla2(valor)) {
            Toast.makeText(this, "regla 2:  " + valor, Toast.LENGTH_SHORT).show();
        } else if (regla3(valor)) {//modificar
            Toast.makeText(this, "regla 3:  " + valor, Toast.LENGTH_SHORT).show();
        } else if (regla4(valor)) {//modificar
            Toast.makeText(this, "regla 4:  " + valor, Toast.LENGTH_SHORT).show();
        } else if (regla5(valor)) {//modificar
            Toast.makeText(this, "regla 5:  " + valor, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "ninguna regla", Toast.LENGTH_SHORT).show();
        }


    }

    public boolean regla1(String valor) {//puros numeeros -1 1 1/1 0.4 -4.0 etc esta bien
        String valorFinal = "";
        boolean regla = false;
        for (int i = 0; i < valor.length(); i++) {
            char letra = valor.charAt(i);
            if (letra == '-' || letra == '1' || letra == '2' || letra == '3' || letra == '4' || letra == '5' || letra == '6' || letra == '7' || letra == '8' || letra == '9' || letra == '0' || letra == '.' || letra == '/') {
                //valorFinal += letra;
                regla = true;
                //Toast.makeText(this,"regla 1:"+valor,Toast.LENGTH_SHORT).show();
            } else {
                regla = false;
                break;
            }
        }
        return regla;
    }

    public boolean regla2(String valor) {//pura x solamente
        String valorFinal = "";
        boolean regla = false;
        for (int i = 0; i < valor.length(); i++) {
            char letra = valor.charAt(i);
            if (letra == '-' || letra == 'x') {
                //valorFinal += letra;
                regla = true;
                //Toast.makeText(this,"regla 1:"+valor,Toast.LENGTH_SHORT).show();
            } else {
                regla = false;
                break;
            }
        }
        // 1+ x + 3b2
        return regla;
    }

    public boolean regla3(String valor) {//puros numeeros -1 1 1/1 0.4 -4.0 etc
        String valorFinal = "";
        boolean regla = false;
        for (int i = 0; i < valor.length(); i++) {
            char letra = valor.charAt(i);
            if (letra == '-' || letra == '1' || letra == '2' || letra == '3' || letra == '4' || letra == '5' || letra == '6' || letra == '7' || letra == '8' || letra == '9' || letra == '0' || letra == 'x' || letra == '/' || letra == '.') {
                //valorFinal += letra;
                regla = true;
                //Toast.makeText(this,"regla 1:"+valor,Toast.LENGTH_SHORT).show();
            } else {
                regla = false;
                break;
            }
        }
        // 1+ x + 3b2
        return regla;
    }

    //nota revisar regla 4 y 5 en el detalle de que en la regla 5 se tendria que poner -5x^2 y sale regla cuatro por el negativo
    //se tendriá que poner un if asi
    /*val2 += valor.charAt(1);
    if(val1.equals("^") || val1.equals("-")){*/ // mas o menos asi es verificar el primer y segundo caracter
    public boolean regla4(String valor) {//puros numeeros x^2
        String valorFinal = "";
        boolean regla = false;
        String val1 = "";
        val1 += valor.charAt(0);

        if(val1.equals("x") || val1.equals("-")){
            for (int i = 0; i < valor.length(); i++) {
                char letra = valor.charAt(i);
                //poner que evalue antes de un numero si hay un signo de potencia ^
                //primero variable o signo


                if(letra == '^' || letra == '1' || letra == '2' || letra == '3' || letra == '4' || letra == '5' || letra == '6' || letra == '7' || letra == '8' || letra == '9' || letra == '0'){
                    regla = true;
                } else {
                    regla = false;
                }

            }
        }

        return regla;
    }

    public boolean regla5(String valor) {//puros numeeros -1 1 1/1 0.4 -4.0 etc
        String valorFinal = "";
        boolean regla = false;
        for (int i = 0; i < valor.length(); i++) {
            char letra = valor.charAt(i);
            if (letra == '1' || letra == '2' || letra == '3' || letra == '4' || letra == '5' || letra == '6' || letra == '7' || letra == '8' || letra == '9' || letra == '0') {
                //Toast.makeText(this,"hola",Toast.LENGTH_SHORT).show();
                regla = true;
            }else if(letra == 'x'  || letra == '^' || letra == '-'){
                // Toast.makeText(this,"hola regla",Toast.LENGTH_SHORT).show();
                regla = true;
            }  else {
                regla = false;
                //Toast.makeText(this,"regla finalizadad",Toast.LENGTH_SHORT).show();

                break;
            }


        }

        return regla;
    }





    String borrar1(String valor) {
        //cadena = mostrar.getText().toString();
        String aux ="";
        if(valor.length() != 0){
            aux = valor.substring(0,valor.length()-1);
        }
        return aux;
    }

    String borrarT(String valor) {
        cadena = valor;
        if(cadena.length() != 0){
            cadena = "";
        }
        return cadena;
    }

}