package udesc.br.exemplomenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.menuCadastro:
                startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
                break;
            case R.id.menuConsulta:
                startActivity(new Intent(getApplicationContext(), ConsultaActivity.class));
                break;
            case R.id.menuOutra:
                startActivity(new Intent(getApplicationContext(), OutraActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
