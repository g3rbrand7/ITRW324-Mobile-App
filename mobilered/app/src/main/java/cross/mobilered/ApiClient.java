package cross.mobilered;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    public static final String Base_URL = "http://www.redcrossmobile.co.za/" ;
    public static Retrofit retrofit = null;

    public static Retrofit getAPiClient()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(Base_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }



}
