package retrofit.ederdoski.com.retrofit.api.services;

import retrofit.ederdoski.com.retrofit.models.parameters_api.ParameterPosts;
import retrofit.ederdoski.com.retrofit.models.responses_api.ResponseRegisterUser;
import retrofit.ederdoski.com.retrofit.models.responses_api.ResponsesPosts;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Posts {

    @POST("/api/users")
    Call<ResponsesPosts> addPosts(@Body ParameterPosts ppo);

    @DELETE("posts/")
    Call<Void> deletePosts();

}
