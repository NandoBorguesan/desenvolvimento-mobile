package udesc.br.cadastronotas;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    SQLiteDatabase bancoDados;
    EditText edDisciplina, edNota;
    TextView textNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edDisciplina = (EditText) findViewById(R.id.edDisciplina);
        edNota = (EditText) findViewById(R.id.edNota);
        textNotas = (TextView) findViewById(R.id.textNotas);

        bancoDados = openOrCreateDatabase("cadastro_notas", MODE_PRIVATE, null);
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS notas (disciplina VARCHAR, nota DECIMAL(2,1))");

        atualizarNotas();
    }

    public void salvar(View v) {
        String disciplina = edDisciplina.getText().toString();
        double nota = Double.parseDouble(edNota.getText().toString());
        bancoDados.execSQL("INSERT INTO notas (disciplina, nota) VALUES ('" + disciplina + "', " + nota + ")");

        edDisciplina.setText("");
        edNota.setText("");

        Toast.makeText(getApplicationContext(), "Registro salvo!", Toast.LENGTH_SHORT).show();

        atualizarNotas();
    }

    public void atualizarNotas() {
        Cursor cursor = bancoDados.rawQuery("SELECT * FROM notas", null);

        String texto = "";
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            texto += cursor.getString(cursor.getColumnIndex("disciplina"));
            texto += ": " + cursor.getString(cursor.getColumnIndex("nota"));
            texto += "\n";
            cursor.moveToNext();
        }

        textNotas.setText(texto);
    }
}
