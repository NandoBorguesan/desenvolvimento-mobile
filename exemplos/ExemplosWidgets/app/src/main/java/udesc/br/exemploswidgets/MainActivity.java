package udesc.br.exemploswidgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicouBotao(View view) {
        int id = view.getId();

        switch(id) {
            case R.id.btToast:
                startActivity(new Intent(this, ToastActivity.class));
                break;
            case R.id.btListView:
                startActivity(new Intent(this, ListViewActivity.class));
                break;
            case R.id.btAlertDialog:
                startActivity(new Intent(this, AlertDialogActivity.class));
                break;
            case R.id.btCheckBox:
                startActivity(new Intent(this, CheckBoxActivity.class));
                break;
            case R.id.btRadioButton:
                startActivity(new Intent(this, RadioButtonActivity.class));
                break;
            case R.id.btSeekBar:
                startActivity(new Intent(this, SeekBarActivity.class));
                break;
            case R.id.btToggleButton:
                startActivity(new Intent(this, ToggleButtonActivity.class));
                break;
            case R.id.btScrollView:
                startActivity(new Intent(this, ScrollViewActivity.class));
                break;
        }
    }
}
