package udesc.br.geometria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TrapezioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapezio);
    }

    public void calcula(View v) {
        double baseMenor = Double.parseDouble(((EditText) findViewById(R.id.baseMenor)).getText().toString());
        double baseMaior = Double.parseDouble(((EditText) findViewById(R.id.baseMaior)).getText().toString());
        double altura = Double.parseDouble(((EditText) findViewById(R.id.altura)).getText().toString());

        double resultado = ((baseMaior + baseMenor) * altura) / 2;

        TextView textResultado = (TextView) findViewById(R.id.textResultado);
        textResultado.setText("O valor da área é: " + resultado);
    }
}
