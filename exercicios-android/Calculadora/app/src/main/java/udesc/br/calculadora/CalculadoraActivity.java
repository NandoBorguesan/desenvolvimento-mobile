package udesc.br.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    TextView visor;
    TextView visorSuperior;

    double numero1 = 0, numero2 = 0;
    String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        visor = (TextView) findViewById(R.id.visor);
        visorSuperior = (TextView) findViewById(R.id.visorSuperior);
    }

    public void clicouNumero(View v) {
        Button bt = (Button) v;
        String numero = bt.getText().toString();
        visor.setText(visor.getText().toString() + numero);
    }

    public void clicouOperacao(View v) {
        if(operacao.equals("")) {
            Button bt = (Button) v;
            operacao = bt.getText().toString();
            numero1 = Double.parseDouble(visor.getText().toString());
            visorSuperior.setText(numero1 + " " + operacao);
            visor.setText("");
        } else {
            clicouIgual(v);
            clicouOperacao(v);
        }
    }

    public void clicouIgual(View v) {
        if(operacao.equals("")) {
            if(visor.getText().toString().equals(""))
                visor.setText(numero1 + "");
        } else {
            if(visor.getText().toString().equals(""))
                numero2 = 0;
            else
                numero2 = Double.parseDouble(visor.getText().toString());

            visorSuperior.setText("");
            double resultado = 0;

            switch (operacao) {
                case "+":
                    resultado = numero1 + numero2;
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "*":
                    resultado = numero1 * numero2;
                    break;
                case "/":
                    resultado = numero1 / numero2;
                    break;
            }

            visor.setText(resultado + "");
            operacao = "";
        }
    }

    public void clicouLimpar(View v) {
        numero1 = 0;
        numero2 = 0;
        operacao = "";
        visorSuperior.setText("");
        visor.setText("");
    }
}
