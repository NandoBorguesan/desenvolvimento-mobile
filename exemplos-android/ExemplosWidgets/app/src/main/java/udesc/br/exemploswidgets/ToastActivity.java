package udesc.br.exemploswidgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ToastActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void clicouToast(View v) {
        Toast.makeText(this, "Usuário clicou no botão!", Toast.LENGTH_SHORT).show();
    }
}