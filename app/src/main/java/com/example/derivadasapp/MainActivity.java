package com.example.derivadasapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.derivadasapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {//revisar lo de la potencia
    ActivityMainBinding binding;

    private TextView mostrar;
    String unir, cadena;
    ArrayList<String> ecuaciones = new ArrayList<>();

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
        binding.parentesisIzq.setOnClickListener(v -> binding.mostrar.setText(contatenar(18)));
        binding.parentesisDer.setOnClickListener(v -> binding.mostrar.setText(contatenar(19)));
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
            case 18://borrar luego o verificar
                unir = unir + "(";
                break;
            case 19://borrar luego o verificar
                unir = unir + ")";
                break;

        }
        return unir;
    }

    public void comprobarRegla() {
        //mostrarResultado();
        String valor = (String) binding.mostrar.getText();
        String valorFinal = "";
        if (regla1(valor)) {
            mostrarResultado("Regla 1",valor);
            //Toast.makeText(this, "regla 1:  " + valor, Toast.LENGTH_SHORT).show();
        } else if (regla2(valor)) {
            mostrarResultado("Regla 2",valor);
            //Toast.makeText(this, "regla 2:  " + valor, Toast.LENGTH_SHORT).show();
        } else if (regla3(valor)) {//modificar
            mostrarResultado("Regla 3",valor);
            //Toast.makeText(this, "regla 3:  " + valor, Toast.LENGTH_SHORT).show();
        } else if (regla4(valor)) {//modificar
            mostrarResultado("Regla 4",valor);
            //Toast.makeText(this, "regla 4:  " + valor, Toast.LENGTH_SHORT).show();
        } else if (regla5(valor)) {//modificar
            mostrarResultado("Regla 5",valor);
            //Toast.makeText(this, "regla 5:  " + valor, Toast.LENGTH_SHORT).show();
        } else if (regla6(valor)) {//modificar
            mostrarResultado("Regla 6",valor);
            //Toast.makeText(this, "regla 6:  " + valor, Toast.LENGTH_SHORT).show();
        } else if (regla7(valor)) {//modificar
            mostrarResultado("Regla 7",valor);
            //Toast.makeText(this, "regla 6:  " + valor, Toast.LENGTH_SHORT).show();
        }else if (regla8(valor)) {//modificar
            mostrarResultado("Regla 8",valor);
            //Toast.makeText(this, "regla 6:  " + valor, Toast.LENGTH_SHORT).show();
        }else {
            mostrarResultado("No coincide con ninguna regla",valor);
            //Toast.makeText(this, "ninguna regla", Toast.LENGTH_SHORT).show();
        }

        //numero(valor);
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
    public boolean regla4(String valor) {//puros numeeros x^2 // parece ya estar bien
        String valorFinal = "";
        boolean regla = false;
        String val1 = "", val2 = "", val3 = "";
        val1 += valor.charAt(0);
        val2 += valor.charAt(1);
        val3 += valor.charAt(2);
        //boolean numeros = !val1.equals("1") || !val1.equals("2") || !val1.equals("3") || !val1.equals("4") || !val1.equals("5") || !val1.equals("6") || !val1.equals("7") || !val1.equals("8") || !val1.equals("9") || !val1.equals("0");
        if (val1.equals("1") || val1.equals("2") || val1.equals("3") || val1.equals("4") || val1.equals("5") || val1.equals("6") || val1.equals("7") || val1.equals("8") || val1.equals("9") || val1.equals("0") || val2.equals("1") || val2.equals("2") || val2.equals("3") || val2.equals("4") || val2.equals("5") || val2.equals("6") || val2.equals("7") || val2.equals("8") || val2.equals("9") || val2.equals("0")){
            regla = false;
            //Toast.makeText(this, "No entra en regla 4", Toast.LENGTH_SHORT).show();
            return false;

        }
        if (val1.equals("x") || val1.equals("-") || val2.equals("^") || val2.equals("x") || val3.equals("^")) {//aqui seria poner el signo de potencia pero con la pos 1 o 2
            for (int i = 2; i < valor.length(); i++) {
                char letra = valor.charAt(i);
                //poner que evalue antes de un numero si hay un signo de potencia ^
                //primero variable o signo


                if (letra == '^' || letra == '1' || letra == '2' || letra == '3' || letra == '4' || letra == '5' || letra == '6' || letra == '7' || letra == '8' || letra == '9' || letra == '0') {
                    regla = true;
                } else {
                    regla = false;
                    break;
                }

            }
        }

        else{
            regla = false;
            return false;

        }

        return regla;
    }

    public boolean regla5(String valor) {//puros numeeros -1 1 1/1 0.4 -4.0 etc // en valor(0) tiene que ser - o n de afuerzas no el 0 ni 1
        String valorFinal = "";
        boolean regla = false;
        String valorPos0="",valorPos1="",valorPos2="",valorPos3="";
        valorPos0 += valor.charAt(0);
        valorPos1 += valor.charAt(1);
        valorPos2 += valor.charAt(2);
        //boolean pos0 = valorPos0.equals('-') || valorPos0.equals('1') || valorPos0.equals('2') || valorPos0.equals('3') || valorPos0.equals('4') || valorPos0.equals('5') || valorPos0.equals('6') || valorPos0.equals('7') || valorPos0.equals('8') || valorPos0.equals('9');
        //boolean pos1 = valorPos0.equals('1') || valorPos0.equals('2') || valorPos0.equals('3') || valorPos0.equals('4') || valorPos0.equals('5') || valorPos0.equals('6') || valorPos0.equals('7') || valorPos0.equals('8') || valorPos0.equals('9') ||  valorPos0.equals('0');
        String val1 = "", val2 = "", val3 = "";
        val1 += valor.charAt(0);
        val2 += valor.charAt(1);
        val3 += valor.charAt(2);
        //boolean numeros = !val1.equals("1") || !val1.equals("2") || !val1.equals("3") || !val1.equals("4") || !val1.equals("5") || !val1.equals("6") || !val1.equals("7") || !val1.equals("8") || !val1.equals("9") || !val1.equals("0");
        if (val1.equals("1") || val1.equals("2") || val1.equals("3") || val1.equals("4") || val1.equals("5") || val1.equals("6") || val1.equals("7") || val1.equals("8") || val1.equals("9") || val1.equals("0") || val2.equals("1") || val2.equals("2") || val2.equals("3") || val2.equals("4") || val2.equals("5") || val2.equals("6") || val2.equals("7") || val2.equals("8") || val2.equals("9") || val2.equals("0")){
            regla = true;
            //Toast.makeText(this, "Regla 5 siuuu", Toast.LENGTH_SHORT).show();
            //return true;
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

        }



        /*if(pos0 && pos1){//numeros del 2 al 9
            regla = true;
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
        }else {
            regla = false;

            //Toast.makeText(this,"regla finalizadad",Toast.LENGTH_SHORT).show();

        }*/
        return regla;
    }

    public boolean regla6(String valor){//prueba de testeo es practicamente -4x+3x-x+√12 que tenga mas de dos elementos separados por signo
        String ecuacion = "";
        boolean regla = false;
        //verificar que inicie con signo
        /*if(valor.charAt(0) == '+' || valor.charAt(0) == '-'){//verificamos si tiene algun signo
            regla = true;
        }*/

        for(int i=0;i<valor.length();i++){//poner que no acepta () ni /
            ecuacion += valor.charAt(i);
            if(valor.charAt(i) == '(' || valor.charAt(i) == ')' || valor.charAt(i) == '/'){
                regla = false;
            }

            if((valor.charAt(i) == '-' && valor.charAt(i+1) == '-') || (valor.charAt(i) == '+' && valor.charAt(i+1) == '+') ){
                //Toast.makeText(this, "REgla 6 mal", Toast.LENGTH_SHORT).show();
                regla = false;
                break;
            }else if(valor.charAt(i) == '-' || valor.charAt(i) == '+'){
                ecuaciones.add(ecuacion);
                //Toast.makeText(this, "separación", Toast.LENGTH_SHORT).show();
                ecuacion="";
                regla = true;
            }

        }
        //imprimir();
        return regla;
    }

    public boolean regla7(String valor) {//multiplicacion
        String valorFinal = "";
        boolean regla = false;
        for (int i = 0; i < valor.length(); i++) {
            char letra = valor.charAt(i);
            if (letra == '(' ) {//COMPROMAR QUE HAYA MULTIPLICACION
                //regla = true;
            }else if( letra== ')' ){//PARA QUE AL INGRESAR PARENTESIS NO PONGA REGLA 7
                //regla = true;
            }else if (letra == '+'||letra == '-'|| letra== 'x'||letra== '^' || letra == '1' || letra == '2' || letra == '3' || letra == '4' || letra == '5' || letra == '6' || letra == '7' || letra == '8' || letra == '9' || letra == '0') {
                regla = true;
            }  else {
                regla = false;
                break;
            }
        }
        return regla;
    }

    public boolean regla8(String valor) {//FRACION
        String valorFinal = "";
        boolean regla = false;
        for (int i = 0; i < valor.length(); i++) {
            char letra = valor.charAt(i);
            if (letra== '^'||letra == '(' || letra == ')' || letra=='-'||letra=='+'||letra=='x'|| letra == '1' || letra == '2' || letra == '3' || letra == '4' || letra == '5' || letra == '6' || letra == '7' || letra == '8' || letra == '9' || letra == '0') {
                //regla = false;
            }else if(letra == '/' ){
                regla = true;
            }  else {
                regla = false;
                break;
            }
        }
        return regla;
    }



    public void imprimir(){
        for (int i=0;i<ecuaciones.size();i++){
            Toast.makeText(this,ecuaciones.get(i), Toast.LENGTH_SHORT).show();
        }
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

    public void mostrarResultado(String regla,String ecuacion){
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setMessage("Valor de la ecuacion: "+ecuacion)
        .setCancelable(true)
        .setPositiveButton("Regresar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog titulo = alerta.create();
        titulo.setTitle(regla);
        titulo.show();

    }


}