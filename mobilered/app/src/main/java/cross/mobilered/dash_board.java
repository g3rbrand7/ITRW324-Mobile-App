package cross.mobilered;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class dash_board extends AppCompatActivity implements View.OnClickListener {

    private Button btnAbout , btnShop , btnCart , btnLogout ;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        btnAbout = (Button)findViewById(R.id.dashboard_btn_about);
        btnShop = (Button)findViewById(R.id.dashboard_btn_shop);
        btnCart = (Button)findViewById(R.id.dashboard_btn_cart);
        btnLogout = (Button)findViewById(R.id.dashboard_btn_logout);


    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.dashboard_btn_about)
        {
            startActivity(new Intent(dash_board.this,About.class));
            finish();
        }else if(v.getId() == R.id.dashboard_btn_shop)
        {
            //startActivity(new Intent(dash_board.this,About.class));
          //  finish();

        }else if(v.getId() == R.id.dashboard_btn_cart)
        {
           // startActivity(new Intent(dash_board.this,About.class));
           // finish();

        }else if(v.getId() == R.id.dashboard_btn_logout)
        {
            startActivity(new Intent(dash_board.this,Login.class));
            finish();

        }

    }
    }

