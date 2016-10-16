package udesc.br.exemplosharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText editKm, editData;
    private TextView textDados;
    private static final String ARQUIVO_PREFERENCIAS = "arquivo_preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editKm = (EditText) findViewById(R.id.editKm);
        editData = (EditText) findViewById(R.id.editData);
        textDados = (TextView) findViewById(R.id.textDados);

        recuperaPreferencias();
    }

    public void salvar(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(editKm.getText().toString().equals("") || editData.getText().toString().equals("")) {
            Toast.makeText(this, "Preencha com os dados solicitados", Toast.LENGTH_LONG).show();
        } else {
            editor.putString("km", editKm.getText().toString());
            editor.putString("data", editData.getText().toString());
            editor.commit();
        }
        recuperaPreferencias();
    }

    public void recuperaPreferencias(){
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);
        if(sharedPreferences.contains("km")) {
            String km = sharedPreferences.getString("km", "");
            String data = sharedPreferences.getString("data", "");
            textDados.setText("Em " + data + ", a quilometragem era " + km + "km.");
        } else {
            textDados.setText("Nenhum dado armazenado!");
        }
    }
}
