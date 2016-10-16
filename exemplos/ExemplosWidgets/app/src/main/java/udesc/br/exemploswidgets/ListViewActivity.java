package udesc.br.exemploswidgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends Activity {

    private ListView listaDisciplinas;
    private String[] disciplinas = {
            "Programação I",
            "Programação II",
            "Estruturas de Dados",
            "Engenharia de Software",
            "Gerência de Projetos",
            "Teste de Software",
            "Empreendedorismo",
            "Inteligência Artificial",
            "Cálculo Diferencial e Integral",
            "Matemática Discreta",
            "Qualidade de Software"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listaDisciplinas = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                disciplinas
        );
        listaDisciplinas.setAdapter(adapter);

        listaDisciplinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String disciplinaClicada = (String) listaDisciplinas.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), disciplinaClicada, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
