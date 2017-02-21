package udesc.br.cadastropessoas;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import udesc.br.cadastropessoas.dados.BaseDados;
import udesc.br.cadastropessoas.modelo.Pessoa;

public class ConsultaActivity extends AppCompatActivity {

    ListView listViewPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        listViewPessoas = (ListView) findViewById(R.id.listViewPessoas);
        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                BaseDados.consultaPessoas()
        );
        listViewPessoas.setAdapter(adapter);

        listViewPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConsultaActivity.this);
                dialog.setTitle("Informações da pessoa");
                dialog.setMessage(BaseDados.consultaPessoaPosicao(position).dadosCompletos());
                dialog.setIcon(android.R.drawable.ic_menu_info_details);

                dialog.create();
                dialog.show();
            }
        });
    }

    public void voltar(View view) {
        startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
    }
}
