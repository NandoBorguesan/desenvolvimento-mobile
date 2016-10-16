package udesc.br.exemplocamera;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Uri uri;
    private static final int CAPTURAR_IMAGEM = 1;
    private static final int CAPTURAR_VIDEO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void capturarImagem(View v) {
        File diretorio = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);

        String nomeImagem = diretorio.getPath() + "/" + System.currentTimeMillis() + ".jpg";
        uri = Uri.fromFile(new File(nomeImagem));

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        startActivityForResult(intent, CAPTURAR_IMAGEM);
    }

    public void capturarVideo(View v) {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 5);
        startActivityForResult(intent, CAPTURAR_VIDEO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CAPTURAR_IMAGEM) {
            if(resultCode == RESULT_OK) {
                mostrarMensagem("Imagem capturada!");
                //adicionarNaGaleria();
            } else {
                mostrarMensagem("Imagem não capturada!");
            }
        } else if(requestCode == CAPTURAR_VIDEO) {
            if(resultCode == RESULT_OK) {
                mostrarMensagem("Vídeo gravado! Armazenado em: " + data.getDataString());
                uri = data.getData();
            } else {
                mostrarMensagem("Vídeo não gravado!");
            }
        }
    }

    public void mostrarMensagem(String mensagem) {
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

    private void adicionarNaGaleria() {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

    public void visualizarImagem(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "image/jpeg");
        startActivity(intent);
    }

    public void visualizarVideo(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "video/mp4");
        startActivity(intent);
    }
}