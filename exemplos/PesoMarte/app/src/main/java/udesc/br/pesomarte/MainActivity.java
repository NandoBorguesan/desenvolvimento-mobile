package udesc.br.pesomarte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//Caso 1
public class MainActivity extends AppCompatActivity {

    private EditText editPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editPeso = (EditText) findViewById(R.id.editPeso);
    }

    public void pesoMarte(View v) {
        Intent intent = new Intent(this, MarteActivity.class);

        double peso = Double.parseDouble(editPeso.getText().toString());
        intent.putExtra(MarteActivity.EXTRA_PESO_USUARIO, peso);

        startActivity(intent);
    }
}


// Caso 2
/*
public class MainActivity extends AppCompatActivity {

    private EditText editPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editPeso = (EditText) findViewById(R.id.editPeso);
    }

    public void pesoMarte(View v) {
        Intent intent = new Intent(MarteActivity.ACAO_EXIBIR_PESO);
        intent.addCategory(MarteActivity.CATEGORIA_PESO);

        double peso = Double.parseDouble(editPeso.getText().toString());
        intent.putExtra(MarteActivity.EXTRA_PESO_USUARIO, peso);

        startActivity(intent);
    }
}
*/