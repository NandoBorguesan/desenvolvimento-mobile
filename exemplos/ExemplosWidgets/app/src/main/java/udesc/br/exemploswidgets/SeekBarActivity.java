package udesc.br.exemploswidgets;

        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.SeekBar;
        import android.widget.TextView;
        import android.widget.Toast;

public class SeekBarActivity extends Activity {

    SeekBar seekBar;
    TextView textNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textNota = (TextView) findViewById(R.id.textNota);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textNota.setText("Nota: " + progress + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}

