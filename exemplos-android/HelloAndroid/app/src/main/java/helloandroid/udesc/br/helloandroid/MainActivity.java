package helloandroid.udesc.br.helloandroid;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText campoNome;
    private TextView labelMensagem;
    private String saudacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.campoNome = (EditText) findViewById(R.id.campoNome);
        this.labelMensagem = (TextView) findViewById(R.id.labelMensagem);
        this.saudacao = getResources().getString(R.string.saudacao);
    }

    public void mostrarMensagem(View v) {
        Editable texto = this.campoNome.getText();
        String msg = saudacao + " " + texto.toString() + "!";
        this.labelMensagem.setText(msg);
    }
}
