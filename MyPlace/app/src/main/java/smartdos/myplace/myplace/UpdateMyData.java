package smartdos.myplace.myplace;

import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.sax.TextElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Switch;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class UpdateMyData extends AppCompatActivity implements View.OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private NumberPicker NumberOfNeedPlaces;
    private Switch mySwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_my_data);
        /*
        ATTENTION: This was auto-generated to implement the App Indexing API.
        See https://g.co/AppIndexing/AndroidStudio for more information.
        */
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void SendUrl(String Url) throws IOException {

        String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()

        URLConnection connection = new URL(Url).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);

        InputStream response = connection.getInputStream();
    }

    public void sendDataToServer(Boolean MyPlaceInUse, Integer NeedMorePlaces) throws IOException {
        String url = "http://example.com/";
        String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
        String param1 = "value1";
        String param2 = "value2";

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences.getString("Name", "");

        String query = String.format("Name=%s&InUse=%s&NeedMore=%s",
                URLEncoder.encode(name, charset),
                URLEncoder.encode(MyPlaceInUse.toString(), charset),
                URLEncoder.encode(NeedMorePlaces.toString(), charset));

        SendUrl(url + "?" + query);
    }

    @Override
    public void onClick(View v) {
        Boolean MyPlaceInUse;
        Integer NeededMorePlace;
        setContentView(R.layout.activity_update_my_data);

        mySwitch = (Switch) findViewById(R.id.switch1);
        NumberOfNeedPlaces = (NumberPicker) findViewById(R.id.numberPicker2);


        MyPlaceInUse = mySwitch.isChecked();
        NeededMorePlace = NumberOfNeedPlaces.getValue();

        try {
            sendDataToServer(MyPlaceInUse,NeededMorePlace);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "UpdateMyData Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://smartdos.myplace.myplace/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "UpdateMyData Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://smartdos.myplace.myplace/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

