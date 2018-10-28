package cross.mobilered;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface
{
    @GET("registerM.php")
    Call<User> performRegistration(@Query("name") String Name , @Query("lname") String LName, @Query("email") String Email
            , @Query("password") String password , @Query("phone") String number , @Query("allergies") String Allergies , @Query("history") String History,
                                   @Query("address") String Address,@Query("dob") String DOB , @Query("gender") String Gender);

    @GET("loginM.php")
    Call<User> performUserLogin(@Query("email") String Email,@Query("password") String password);

}
