package udesc.br.geometria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TrianguloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);
    }

    public void calcula(View v) {
        double catetoA = Double.parseDouble(((EditText) findViewById(R.id.catetoA)).getText().toString());
        double catetoB = Double.parseDouble(((EditText) findViewById(R.id.catetoB)).getText().toString());
        double resultado = Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2));

        TextView textResultado = (TextView) findViewById(R.id.textResultado);
        textResultado.setText("O valor da hipotenusa é: " + resultado);
    }
}
