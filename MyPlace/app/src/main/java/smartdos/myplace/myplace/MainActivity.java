package smartdos.myplace.myplace;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences1.getString("Name", "");
        if(name.equalsIgnoreCase(""))
        {
           //new user
            //inser name
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("Name","kaza");
            editor.apply();


        }
        else
        {
            //old user
            //print helo you
            // Execute some code after 2 seconds have passed
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent myIntent = new Intent(MainActivity.this, UpdateMyData.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    MainActivity.this.startActivity(myIntent);
                }
            }, 2000);

        }


    }
}
