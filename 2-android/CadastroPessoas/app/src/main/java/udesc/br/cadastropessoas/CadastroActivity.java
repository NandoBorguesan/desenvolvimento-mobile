package udesc.br.cadastropessoas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import udesc.br.cadastropessoas.dados.BaseDados;

public class CadastroActivity extends AppCompatActivity {

    EditText editNome, editProfissao;
    RadioGroup radioGroupSexo;
    SeekBar seekBarIdade;
    TextView textIdadeSelecionada;
    int idade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = (EditText) findViewById(R.id.editNome);
        editProfissao = (EditText) findViewById(R.id.editProfissao);
        radioGroupSexo = (RadioGroup) findViewById(R.id.radioGroupSexo);
        seekBarIdade = (SeekBar) findViewById(R.id.seekBarIdade);
        textIdadeSelecionada = (TextView) findViewById(R.id.textIdadeSelecionada);

        seekBarIdade.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                idade = progress;
                textIdadeSelecionada.setText("Idade selecionada: " + idade);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public void salvar(View view) {
        String nome = editNome.getText().toString();
        String profissao = editProfissao.getText().toString();

        char sexo = '-';
        switch(radioGroupSexo.getCheckedRadioButtonId()) {
            case R.id.rbMasculino:
                sexo = 'M';
                break;
            case R.id.rbFeminino:
                sexo = 'F';
                break;
        }

        BaseDados.addPessoa(nome, profissao, sexo, idade);

        editNome.setText("");
        editProfissao.setText("");
        radioGroupSexo.clearCheck();
        seekBarIdade.setProgress(0);
    }

    public void consultar(View view) {
        startActivity(new Intent(getApplicationContext(), ConsultaActivity.class));
    }
}
