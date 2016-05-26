package smartdos.myplace.myplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class UpdateMyData extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_my_data);
    }



    public void SendUrl(String Url) throws IOException {

        String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()

        URLConnection connection = new URL(Url).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
    }

    public void sendDataToServer(Boolean MyPlaceInUse, int NeedMorePlaces) throws IOException {
        String url = "http://example.com";
        String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
        String param1 = "value1";
        String param2 = "value2";

        String query = String.format("param1=%s&param2=%s", URLEncoder.encode(param1, charset),
                URLEncoder.encode(param2, charset));

        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
    }

    @Override
    public void onClick(View v) {
        Boolean MyPlaceInUse;
        Integer NeedMorePlace;
        .getTe xt().toString()
    }
}
