package udesc.br.exemploswidgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckBoxActivity extends Activity {

    CheckBox checkBacon, checkBatata, checkMaionese, checkCookies;
    TextView textConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        checkBacon = (CheckBox) findViewById(R.id.checkBacon);
        checkBatata = (CheckBox) findViewById(R.id.checkBatata);
        checkMaionese = (CheckBox) findViewById(R.id.checkMaionese);
        checkCookies = (CheckBox) findViewById(R.id.checkCookies);

        textConfirmacao = (TextView) findViewById(R.id.textConfirmacao);
    }

    public void clicouCheckBox(View v) {
        String confirmacao = "Adicionais escolhidos:\n\n";

        if (checkBacon.isChecked()) confirmacao += checkBacon.getText() + "\n";
        if (checkBatata.isChecked()) confirmacao += checkBatata.getText() + "\n";
        if (checkMaionese.isChecked()) confirmacao += checkMaionese.getText() + "\n";
        if (checkCookies.isChecked()) confirmacao += checkCookies.getText() + "\n";

        textConfirmacao.setText(confirmacao);
    }
}

