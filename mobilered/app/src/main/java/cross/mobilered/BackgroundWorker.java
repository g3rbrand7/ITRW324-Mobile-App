package cross.mobilered;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String,Void,String>
{
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker(Context ctx)
    {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        if(type.equals("login"))
        {
            String login_url = "http://redcrossmobile.co.za/loginM.php";
            try {
                String user_name = params[1];
                String password = params[2];

                URL url = new URL(login_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);



                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("email" , "UTF-8")+"="+URLEncoder.encode(user_name, "UTF-8")+"&"+
                        URLEncoder.encode("password" , "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                outputStream.close();
                httpURLConnection.disconnect();
                httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setDoInput(true);
                InputStream inputStream = httpURLConnection.getInputStream();

               BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1" ));
                String result  = "";
                String line = "";

               while ((line = bufferedReader.readLine()) != null )
               {
                    result += line ;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();



                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                String result  = "werk nie1";
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                String result  = e.toString();
                return result;
            }

        }else if(type.equals("register"))
        {
            String login_url = "http://redcrossmobile.co.za/registerM.php";

            try {
                String user_name = params[1];
                String lname = params[2];
                String email = params[3];
                String passA = params[4];
                String passB = params[5];
                String phone = params[6];
                String allergies = params[7];
                String history = params[8];
                String address = params[9];
                String dob = params[10];
                String gender = params[11];

                URL url = new URL(login_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);


                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("name" , "UTF-8")+"="+URLEncoder.encode(user_name, "UTF-8")+"&"+
                        URLEncoder.encode("lname" , "UTF-8")+"="+URLEncoder.encode(lname, "UTF-8")
                        +"&"+URLEncoder.encode("email" , "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"+
                        URLEncoder.encode("passwordA" , "UTF-8")+"="+URLEncoder.encode(passA, "UTF-8")+"&"+
                        URLEncoder.encode("passwordB" , "UTF-8")+"="+URLEncoder.encode(passB, "UTF-8")+"&"+
                        URLEncoder.encode("phone" , "UTF-8")+"="+URLEncoder.encode(phone, "UTF-8")
                        +"&"+
                        URLEncoder.encode("allergies" , "UTF-8")+"="+URLEncoder.encode(allergies, "UTF-8")
                        +"&"+
                        URLEncoder.encode("history" , "UTF-8")+"="+URLEncoder.encode(history, "UTF-8")
                        +"&"+
                        URLEncoder.encode("address" , "UTF-8")+"="+URLEncoder.encode(address, "UTF-8")
                        +"&"+
                        URLEncoder.encode("dob" , "UTF-8")+"="+URLEncoder.encode(dob, "UTF-8")
                        +"&"+
                        URLEncoder.encode("gender" , "UTF-8")+"="+URLEncoder.encode(gender, "UTF-8");



                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1" ));
                String result  = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null )
                {
                    result += line ;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                String result  = "werk nie";
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                String result  = e.toString();
                return result;
            }

        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.setTitle("Hi");
        alertDialog.show();
    }

    @Override
    protected void onPreExecute() {
       alertDialog = new AlertDialog.Builder(context).create();
       alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
