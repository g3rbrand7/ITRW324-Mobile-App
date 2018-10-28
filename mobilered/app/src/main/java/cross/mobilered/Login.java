package cross.mobilered;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private  TextView btnSignup;
    private Button btnLogin ;
    private EditText Email , Password ;
    public static ApiInterface apiInterface;
    public static PrefConfig prefConfig;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignup = (TextView)findViewById(R.id.login_btn_signup);
        btnLogin = (Button)findViewById(R.id.login_btn_login);
        Email = (EditText)findViewById(R.id.login_email);
        Password = (EditText)findViewById(R.id.login_password);
        btnSignup.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        apiInterface = ApiClient.getAPiClient().create(ApiInterface.class);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.login_btn_signup)
        {
            startActivity(new Intent(Login.this,Register.class));
            finish();
        }else if(v.getId() == R.id.login_btn_login)
        {
            LoginNow();

        }

    }

    private void LoginNow() {
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,email , password);
        finish();
        startActivity(new Intent(Login.this,dash_board.class));
        finish();


    }




    private void performLogin()
    {

        String email = Email.getText().toString();
        String password = Password.getText().toString();

       Call<User> call = apiInterface.performUserLogin(email , password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
            if(response.body().getResponse().equals("ok"))
            {
                //prefConfig.displayToast("login success.");
            }
            else if(response.body().getResponse().equals("failed"))
            {
              //  prefConfig.displayToast("login error.");
            }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
