package retrofit.ederdoski.com.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import retrofit.ederdoski.com.retrofit.api.ApiRequest;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.addLogAdapter(new AndroidLogAdapter());

        //---- GET Generate models of JsonObject

        ApiRequest.getUserWithModel("1");

        //---- GET Obtain json in format String with Parameter and User Query for replace api..?parameter1

        ApiRequest.getUserTextPlane("2");

        //---- POST with Body and Models

        ApiRequest.addPosts();

        //---- POST with FormUrlEncoded and Field

        ApiRequest.registerUser();

        //---- PUT with FormUrlEncoded and Field

        ApiRequest.updateUser("1");

    }

}
