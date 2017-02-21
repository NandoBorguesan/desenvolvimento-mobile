package udesc.br.exemplocontentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buscarContatos(View v) {
        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        String[] projection = new String[] {ContactsContract.Contacts.DISPLAY_NAME};
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            String nome = cursor.getString(cursor.getColumnIndex(projection[0]));
            Log.i("Nome do contato", nome);
            cursor.moveToNext();
        }
    }

    public void buscarContatosFiltroA(View v) {
        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        String[] projection = new String[] {ContactsContract.Contacts.DISPLAY_NAME};
        String selection = ContactsContract.Contacts.DISPLAY_NAME + " like ?";
        String[] selectionArgs = new String[] {"A%"};
        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME + " ASC";

        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            String nome = cursor.getString(cursor.getColumnIndex(projection[0]));
            Log.i("Nome do contato", nome);
            cursor.moveToNext();
        }
    }
}
