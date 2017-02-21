package udesc.br.pesomarte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


//Caso 1
public class MarteActivity extends AppCompatActivity {

    public static final String EXTRA_PESO_USUARIO = "pesomarte.EXTRA_PESO_USUARIO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marte);

        TextView textPesoMarte = (TextView) findViewById(R.id.textPesoMarte);

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_PESO_USUARIO)) {
            double pesoInformado = intent.getDoubleExtra(EXTRA_PESO_USUARIO, 0d);
            double pesoCalculado = pesoInformado * 0.38;
            textPesoMarte.setText("Seu peso em Marte é: " + pesoCalculado);
        } else {
            textPesoMarte.setText("O peso não foi recebido!");
        }
    }
}

//Caso 2
/*
public class MarteActivity extends AppCompatActivity {

    public static final String EXTRA_PESO_USUARIO = "pesomarte.EXTRA_PESO_USUARIO";
    public static final String ACAO_EXIBIR_PESO = "pesomarte.ACAO_EXIBIR_PESO";
    public static final String CATEGORIA_PESO = "pesomarte.CATEGORIA_PESO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marte);

        TextView textPesoMarte = (TextView) findViewById(R.id.textPesoMarte);

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_PESO_USUARIO)) {
            double pesoInformado = intent.getDoubleExtra(EXTRA_PESO_USUARIO, 0d);
            double pesoCalculado = pesoInformado * 0.38;
            textPesoMarte.setText("Seu peso em Marte é: " + pesoCalculado);
        } else {
            textPesoMarte.setText("O peso não foi recebido!");
        }
    }
}
*/