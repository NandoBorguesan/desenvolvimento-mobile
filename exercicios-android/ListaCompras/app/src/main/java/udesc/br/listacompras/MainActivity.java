package udesc.br.listacompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String NOME_ARQUIVO = "listaCompras.txt";
    private EditText editLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLista = (EditText) findViewById(R.id.editLista);
        recuperar();
    }

    public void salvar(View view) {
        try {
            FileOutputStream fos = openFileOutput(NOME_ARQUIVO, MODE_PRIVATE);
            fos.write(editLista.getText().toString().getBytes());
            fos.close();
            Toast.makeText(getApplicationContext(), "Lista de compras salva!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recuperar() {
        try {
            FileInputStream fis = openFileInput(NOME_ARQUIVO);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String mensagem = "";
            String linha = reader.readLine();
            while(linha != null) {
                mensagem += linha + "\n";
                linha = reader.readLine();
            }
            editLista.setText(mensagem);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
