package udesc.br.exemploswidgets;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlertDialogActivity extends Activity {

    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void clicouAlertDialog(View v) {
        dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Título da caixa de diálogo");
        dialog.setMessage("Deseja confirmar a ação?");

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogActivity.this, "Ação NÃO confirmada!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogActivity.this, "Ação confirmada!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setCancelable(false);
        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        dialog.create();
        dialog.show();
    }
}

