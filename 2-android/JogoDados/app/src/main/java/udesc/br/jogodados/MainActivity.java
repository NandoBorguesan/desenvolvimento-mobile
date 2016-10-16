package udesc.br.jogodados;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ImageView dado;
    private static final String NOME_ARQUIVO = "estatisticas";
    TextView textEstatisticas;

    private int qtdLancamentos = 0;
    private int somaLancamentos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dado = (ImageView) findViewById(R.id.imageView);
        textEstatisticas = (TextView) findViewById(R.id.textEstatisticas);

        recuperaEstatisticas();
    }

    public void lancamento(View view) {
        int valor = (int) (Math.floor(Math.random() * 6) + 1);
        int imageId;

        switch(valor) {
            case 1:
                imageId = R.drawable.face1;
                break;
            case 2:
                imageId = R.drawable.face2;
                break;
            case 3:
                imageId = R.drawable.face3;
                break;
            case 4:
                imageId = R.drawable.face4;
                break;
            case 5:
                imageId = R.drawable.face5;
                break;
            case 6:
                imageId = R.drawable.face6;
                break;
            default:
                imageId = R.drawable.face6;
                break;
        }

        dado.setImageResource(imageId);
        qtdLancamentos++;
        somaLancamentos += valor;

        salvaEstatisticas();
    }

    public void salvaEstatisticas() {
        SharedPreferences sharedPreferences = getSharedPreferences(NOME_ARQUIVO, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("qtdLancamentos", qtdLancamentos);
        editor.putInt("somaLancamentos", somaLancamentos);
        editor.commit();

        atualizaCampos();
    }

    public void recuperaEstatisticas() {
        SharedPreferences sharedPreferences = getSharedPreferences(NOME_ARQUIVO, 0);
        if(sharedPreferences.contains("qtdLancamentos")) {
            qtdLancamentos = sharedPreferences.getInt("qtdLancamentos", 0);
            somaLancamentos = sharedPreferences.getInt("somaLancamentos", 0);
        }
        atualizaCampos();
    }

    public void atualizaCampos() {
        if(qtdLancamentos != 0)
            textEstatisticas.setText("Média: " + ((float) somaLancamentos/(float) qtdLancamentos) + "\nTotal de lançamentos: " + qtdLancamentos);
        else {
            textEstatisticas.setText("Média: " + 0 + "\nTotal de lançamentos: " + qtdLancamentos);
        }
    }

    public void zerar(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(NOME_ARQUIVO, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        qtdLancamentos = 0;
        somaLancamentos = 0;
        editor.putInt("qtdLancamentos", qtdLancamentos);
        editor.putInt("somaLancamentos", somaLancamentos);
        editor.commit();

        recuperaEstatisticas();
    }
}
