package com.ronney.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtAlcool;
    private EditText edtGasolina;

    Double precoAlcool = 0.00;
    Double precoGasolina = 0.00;
    Double divisao = 0.00;
    String sRetorno = "";
    Boolean erro = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processUI();
    }

    private void processUI() {
        this.edtAlcool = findViewById(R.id.edtAlcool);
        this.edtGasolina = findViewById(R.id.edtGasolina);
    }

    public void calcularBotao(View view) {
        calculaPreco();
    }

    private void calculaPreco() {
        if (!processValues()) {

            if (this.divisao >= 0.7) {
                this.sRetorno = "USE GASOLINA";
            } else {
                this.sRetorno = "USE ÁLCOOL";
            }
        } else {
            sRetorno = "Números Inválidos";
        }

        geraToast(sRetorno);
    }

    private Boolean processValues() {
        this.erro = false;
        String sValorAlcool = edtAlcool.getText().toString();
        String sValorGasolina = edtGasolina.getText().toString();

        if (!sValorAlcool.isEmpty() && !sValorGasolina.isEmpty()) {
            this.precoAlcool = Double.parseDouble(sValorAlcool);
            this.precoGasolina = Double.parseDouble(sValorGasolina);
            this.divisao = this.precoAlcool / this.precoGasolina;
        } else {
            this.erro = true;
        }
        return this.erro;
    }

    private void geraToast(String mensagem) {
        Context context = getApplicationContext();
        CharSequence text = mensagem;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
