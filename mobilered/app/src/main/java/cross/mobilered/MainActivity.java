package cross.mobilered;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static PrefConfig prefConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefConfig = new PrefConfig(this);



        if(prefConfig.readLoginStatus())
        {
            Intent intent = new Intent(this, dash_board.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }

    }
}
