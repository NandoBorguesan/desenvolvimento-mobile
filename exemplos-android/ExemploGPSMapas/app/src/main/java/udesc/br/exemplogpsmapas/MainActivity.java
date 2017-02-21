package udesc.br.exemplogpsmapas;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private TextView textProvedor, textLatitude, textLongitude;
    private WebView mapa;
    private String urlBase = "http://maps.googleapis.com/maps/api/staticmap" +
                             "?size=320x340&sensor=true&markers=color:red|%s,%s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textProvedor = (TextView) findViewById(R.id.textProvedor);
        textLatitude = (TextView) findViewById(R.id.textLatitude);
        textLongitude = (TextView) findViewById(R.id.textLongitude);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        Listener listener = new Listener();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(getApplicationContext(), "Aplicação não possui permissão para acesso ao GPS", Toast.LENGTH_LONG).show();
            return;
        }

        long tempoAtualizacao = 0;
        float distancia = 0;

        locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                tempoAtualizacao, distancia,
                listener);

        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                tempoAtualizacao, distancia,
                listener);

        mapa = (WebView) findViewById(R.id.mapa);
    }

    public void verMapa(View v) {
        Uri uri = Uri.parse("geo:" + textLatitude.getText() + "," + textLongitude.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null)
            startActivity(mapIntent);
        else
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private class Listener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            String latitude = String.valueOf(location.getLatitude());
            String longitude = String.valueOf(location.getLongitude());

            textProvedor.setText(location.getProvider());
            textLatitude.setText(latitude);
            textLongitude.setText(longitude);

            String url = String.format(urlBase, latitude, longitude);
            mapa.loadUrl(url);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}

        @Override
        public void onProviderEnabled(String provider) {}

        @Override
        public void onProviderDisabled(String provider) {}
    }
}
