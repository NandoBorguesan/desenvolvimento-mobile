package udesc.br.geometria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CirculoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
    }

    public void calcula(View v) {
        double raio = Double.parseDouble(((EditText) findViewById(R.id.raio)).getText().toString());

        double circunferencia = 2 * Math.PI * raio;
        double area = Math.PI * Math.pow(raio, 2);

        TextView textResultado = (TextView) findViewById(R.id.textResultado);
        textResultado.setText("O valor da área é " + area + " e o valor da circunferência é " + circunferencia);
    }
}
