package cross.mobilered;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements View.OnClickListener{
private EditText Name, LastName , Email , Password, Password2 , Phone , Allergies , History , Address , DOB , Gender ;
private Button btnRegister;
private TextView btnLogin;
public static ApiInterface apiInterface;
    public static PrefConfig prefConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        prefConfig = new PrefConfig(this);
        btnRegister = (Button)findViewById(R.id.signup_btn_register);
        Email = (EditText)findViewById(R.id.signup_email);
        Password = (EditText)findViewById(R.id.signup_password);
        Password2 = (EditText)findViewById(R.id.signup_password2);
        Name = (EditText)findViewById(R.id.signup_name);
        LastName = (EditText)findViewById(R.id.signup_surname);
        Phone = (EditText)findViewById(R.id.signup_number);
        Allergies = (EditText)findViewById(R.id.signup_allergies);
        History = (EditText)findViewById(R.id.signup_history);
        Address = (EditText)findViewById(R.id.signup_address);
        DOB = (EditText)findViewById(R.id.signup_dob);
        Gender = (EditText)findViewById(R.id.signup_gender);
        btnLogin = (TextView) findViewById(R.id.signup_btn_login);

        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        apiInterface = ApiClient.getAPiClient().create(ApiInterface.class);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.signup_btn_register)
        {
            performRegistation();

        }else if (v.getId() == R.id.signup_btn_login)
        {
            startActivity(new Intent(Register.this,Login.class));
            finish();
        }
    }

    public void performRegistation()
    {
        String name = Name.getText().toString();
        String lastname = LastName.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String password2 = Password2.getText().toString();
        String phone = Phone.getText().toString();
        String allergies = Allergies.getText().toString();
        String history = History.getText().toString();
        String address = Address.getText().toString();
        String dob = DOB.getText().toString();
        String gender = Gender.getText().toString();

        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,name , lastname , email , password , password2 , phone , allergies , history , address , dob , gender);


        name = "";
        lastname = "";
        email = "";
        password = "";
        phone = "";
        allergies = "";
        history = "";
        address = "";
        dob = "";
        gender = "";

    }
}
