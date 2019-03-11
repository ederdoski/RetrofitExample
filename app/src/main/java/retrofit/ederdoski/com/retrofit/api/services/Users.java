package retrofit.ederdoski.com.retrofit.api.services;

import java.util.List;

import retrofit.ederdoski.com.retrofit.models.responses_api.ResponseRegisterUser;
import retrofit.ederdoski.com.retrofit.models.responses_api.ResponsesUpdateUser;
import retrofit.ederdoski.com.retrofit.models.responses_api.ResponsesUser;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Users {

    @GET("/api/unknown/{id}")
    Call<ResponsesUser> getUserWithModel(@Path("id") String id);

    @GET("/api/users?/")
    Call<String> getUserTextPlane(@Query("page") String id);

    @FormUrlEncoded
    @POST("/api/register/")
    Call<ResponseRegisterUser> registerUser(@Field("email") String email, @Field("password") String pass);

    @FormUrlEncoded
    @PUT("/api/users/{id}")
    Call<ResponsesUpdateUser> updateUser(@Path("id") String id, @Field("name") String name, @Field("job") String job);

}
