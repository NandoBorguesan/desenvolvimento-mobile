package udesc.br.exemploswidgets;

        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.CompoundButton;
        import android.widget.ImageView;
        import android.widget.ToggleButton;

public class ToggleButtonActivity extends Activity {

    private ToggleButton toggleButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setVisibility(ImageView.INVISIBLE);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    imageView.setVisibility(ImageView.VISIBLE);
                else
                    imageView.setVisibility(ImageView.INVISIBLE);
            }
        });
    }
}

