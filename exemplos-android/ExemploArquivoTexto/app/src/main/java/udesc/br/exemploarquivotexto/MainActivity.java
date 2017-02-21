package udesc.br.exemploarquivotexto;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    EditText editTexto;
    String nomeArquivo = "meuArquivo.txt";
    String nomePasta = "minhaPasta";
    TextView textInterno, textExterno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTexto = (EditText) findViewById(R.id.editTexto);
        textInterno = (TextView) findViewById(R.id.textInterno);
        textExterno = (TextView) findViewById(R.id.textExterno);

        leInterno();
        leExterno();
    }

    public void armazenaInterno(View v) {
        String mensagem = editTexto.getText().toString();
        try {
            FileOutputStream fos = openFileOutput(nomeArquivo, MODE_PRIVATE);
            fos.write(mensagem.getBytes());
            fos.close();
            Toast.makeText(getApplicationContext(), "Arquivo salvo com sucesso!", Toast.LENGTH_SHORT).show();
            leInterno();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void armazenaExterno(View v) {
        String estado = Environment.getExternalStorageState();
        if(estado.equals(Environment.MEDIA_MOUNTED)) {
            File root = Environment.getExternalStorageDirectory();
            File diretorio = new File(root.getAbsolutePath() + "/" + nomePasta);
            if(!diretorio.exists())
                diretorio.mkdir();

            File arquivo = new File(diretorio, nomeArquivo);
            String mensagem = editTexto.getText().toString();

            try {
                FileOutputStream fos = new FileOutputStream(arquivo);
                fos.write(mensagem.getBytes());
                fos.close();
                Toast.makeText(getApplicationContext(), "Arquivo salvo com sucesso!", Toast.LENGTH_SHORT).show();
                leExterno();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Cartão de memória não encontrado!", Toast.LENGTH_SHORT).show();
        }
    }

    public void leInterno() {
        String mensagem = "";
        try {
            FileInputStream fis = openFileInput(nomeArquivo);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String linha = reader.readLine();
            while (linha != null) {
                mensagem += linha + "\n";
                linha = reader.readLine();
            }

            textInterno.setText(mensagem);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leExterno() {
        String estado = Environment.getExternalStorageState();
        if(estado.equals(Environment.MEDIA_MOUNTED)) {
            File root = Environment.getExternalStorageDirectory();
            File diretorio = new File(root.getAbsolutePath() + "/" + nomePasta);
            File arquivo = new File(diretorio, nomeArquivo);

            String mensagem = "";

            try {
                FileInputStream fis = new FileInputStream(arquivo);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

                String linha = reader.readLine();
                while (linha != null) {
                    mensagem += linha + "\n";
                    linha = reader.readLine();
                }

                textExterno.setText(mensagem);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Cartão de memória não encontrado!", Toast.LENGTH_SHORT).show();
        }
    }
}
