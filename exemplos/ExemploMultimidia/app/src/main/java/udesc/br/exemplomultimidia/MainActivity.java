package udesc.br.exemplomultimidia;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer player;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.videoView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        liberarPlayer();
    }

    public void liberarPlayer() {
        if(player != null)
            player.release();
    }

    public void executar(View v) {
        if(player == null) {
            player = MediaPlayer.create(this, R.raw.musica);
        }
        if(!player.isPlaying())
            player.start();
    }

    public void pausar(View v) {
        if(player != null) {
            if (player.isPlaying())
                player.pause();
        }
    }

    public void parar(View v) {
        if(player != null) {
            if (player.isPlaying())
                player.stop();

            liberarPlayer();
            player = null;
        }
    }

    public void executarVideo(View v) {
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(uri);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.start();
    }
}
