package udesc.br.exemploswidgets;
        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Toast;

public class RadioButtonActivity extends Activity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void clicouRadioButton(View v) {
        if(radioGroup.getCheckedRadioButtonId() > 0) {
            RadioButton radioButtonEscolhido = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
            Toast.makeText(RadioButtonActivity.this, radioButtonEscolhido.getText(), Toast.LENGTH_LONG).show();
        }
    }
}

