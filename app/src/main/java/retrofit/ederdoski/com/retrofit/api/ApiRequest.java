package retrofit.ederdoski.com.retrofit.api;

import android.util.Log;

import com.orhanobut.logger.Logger;

import java.util.List;

import retrofit.ederdoski.com.retrofit.api.services.Posts;
import retrofit.ederdoski.com.retrofit.api.services.Users;
import retrofit.ederdoski.com.retrofit.interfaces.HTTPResponse;
import retrofit.ederdoski.com.retrofit.models.responses_api.ResponseRegisterUser;
import retrofit.ederdoski.com.retrofit.models.responses_api.ResponsesUpdateUser;
import retrofit.ederdoski.com.retrofit.models.responses_api.ResponsesUser;
import retrofit.ederdoski.com.retrofit.models.parameters_api.ParameterPosts;
import retrofit.ederdoski.com.retrofit.models.responses_api.ResponsesPosts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRequest {

    private static Integer[] aResponsesSucces    = { 200, 201, 204 };
    private static Integer[] aResponsesForbidden = { 401, 403, 422 };
    private static Integer[] aResponsesError     = { 404, 405 };

    public static void getUserTextPlane(String userID){

        Users apiUser = ApiConfig.getClient().create(Users.class);
        Call<String> userObject = apiUser.getUserTextPlane(userID);

        userObject.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                httpManager(response.code(), response.body(), "", new HTTPResponse() {
                    @Override
                    public void onSuccess(String result) {
                        super.onSuccess(result);
                        Logger.json(result);
                    }
                });

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                httpManager(500, "", t.toString(), new HTTPResponse() {
                    @Override
                    public void onError(String data) {
                        super.onError(data);
                        Log.e("onError ", t.toString());
                    }
                });
            }

        });
    }

    public static void getUserWithModel(String userID){

        Users apiUser = ApiConfig.getClient().create(Users.class);
        Call<ResponsesUser> userObject = apiUser.getUserWithModel(userID);

        userObject.enqueue(new Callback<ResponsesUser>() {
            @Override
            public void onResponse(Call<ResponsesUser> call, Response<ResponsesUser> response) {

                httpManager(response.code(), response.body(), "", new HTTPResponse() {
                    @Override
                    public void onSuccess(Object result) {
                        super.onSuccess(result);

                        Logger.d("getUserWithModel --> "+ "ID: "+((ResponsesUser) result).getData().getId()+" Name: "+((ResponsesUser) result).getData().getName());

                    }
                });

            }

            @Override
            public void onFailure(Call<ResponsesUser> call, Throwable t) {
                httpManager(500, "", t.toString(), new HTTPResponse() {
                    @Override
                    public void onError(String data) {
                        super.onError(data);
                        Log.e("onError ", t.toString());
                    }
                });
            }

        });
    }

    public static void addPosts(){

        Posts apiUser = ApiConfig.getClient().create(Posts.class);
        Call<ResponsesPosts> userObject = apiUser.addPosts(new ParameterPosts("morpheus", "leader"));

        userObject.enqueue(new Callback<ResponsesPosts>() {
            @Override
            public void onResponse(Call<ResponsesPosts> call, Response<ResponsesPosts> response) {

                httpManager(response.code(), response.body(), "", new HTTPResponse() {
                    @Override
                    public void onSuccess(Object result) {
                        super.onSuccess(result);

                       Logger.d("addPosts --> ID: "+ ((ResponsesPosts) result).getId()+ " CreatedAt: " + ((ResponsesPosts) result).getCreatedAt());

                    }
                });

            }

            @Override
            public void onFailure(Call<ResponsesPosts> call, Throwable t) {
                httpManager(500, "", t.toString(), new HTTPResponse() {
                    @Override
                    public void onError(String data) {
                        super.onError(data);
                        Log.e("onError ", t.toString());
                    }
                });
            }

        });
    }

    public static void registerUser(){

        Users apiUser = ApiConfig.getClient().create(Users.class);
        Call<ResponseRegisterUser> userObject = apiUser.registerUser("correo@correo.com", "1234");

        userObject.enqueue(new Callback<ResponseRegisterUser>() {
            @Override
            public void onResponse(Call<ResponseRegisterUser> call, Response<ResponseRegisterUser> response) {

                httpManager(response.code(), response.body(), "", new HTTPResponse() {
                    @Override
                    public void onSuccess(Object result) {
                        super.onSuccess(result);

                       Logger.d("registerUser --> TOKEN: "+((ResponseRegisterUser) result).getToken());

                    }
                });

            }

            @Override
            public void onFailure(Call<ResponseRegisterUser> call, Throwable t) {
                httpManager(500, "", t.toString(), new HTTPResponse() {
                    @Override
                    public void onError(String data) {
                        super.onError(data);
                        Log.e("onError ", t.toString());
                    }
                });
            }

        });
    }

    public static void updateUser(String id){

        Users apiUser = ApiConfig.getClient().create(Users.class);
        Call<ResponsesUpdateUser> userObject = apiUser.updateUser(id, "jose", "bartender");

        userObject.enqueue(new Callback<ResponsesUpdateUser>() {
            @Override
            public void onResponse(Call<ResponsesUpdateUser> call, Response<ResponsesUpdateUser> response) {

                httpManager(response.code(), response.body(), "", new HTTPResponse() {
                    @Override
                    public void onSuccess(Object result) {
                        super.onSuccess(result);

                        Logger.d("updateUser --> JOB: "+((ResponsesUpdateUser) result).getJob());

                    }
                });

            }

            @Override
            public void onFailure(Call<ResponsesUpdateUser> call, Throwable t) {
                httpManager(500, "", t.toString(), new HTTPResponse() {
                    @Override
                    public void onError(String data) {
                        super.onError(data);
                        Log.e("onError ", t.toString());
                    }
                });
            }

        });
    }



    private static void httpManager(int response, List<?> listResult, String error, HTTPResponse httpResponse) {

        boolean onError = true;

        for (Integer aResponsesSucce : aResponsesSucces) {
            if (aResponsesSucce.equals(response)) {
                httpResponse.onSuccess(listResult);
                onError = false;
            }
        }

        for (Integer anAResponsesForbidden : aResponsesForbidden) {
            if (anAResponsesForbidden.equals(response)) {
                httpResponse.onForbidden(listResult);
                onError = false;
            }
        }

        for (Integer anAResponsesError : aResponsesError) {
            if (anAResponsesError.equals(response)) {
                httpResponse.onError(error);
                onError = false;
            }
        }

        if (onError){
            httpResponse.onError(error);
        }

    }

    private static void httpManager(int response, Object objResult, String error, HTTPResponse httpResponse){

        boolean onError = true;

        for (Integer aResponsesSucce : aResponsesSucces) {
            if (aResponsesSucce.equals(response)) {
                httpResponse.onSuccess(objResult);
                onError = false;
            }
        }

        for (Integer anAResponsesForbidden : aResponsesForbidden) {
            if (anAResponsesForbidden.equals(response)) {
                httpResponse.onForbidden(objResult);
                onError = false;
            }
        }

        for (Integer anAResponsesError : aResponsesError) {
            if (anAResponsesError.equals(response)) {
                httpResponse.onError(error);
                onError = false;
            }
        }

        if (onError){
            httpResponse.onError(error);
        }
    }

    private static void httpManager(int response, String result, String error, HTTPResponse httpResponse){

        boolean onError = true;

        for (Integer aResponsesSucce : aResponsesSucces) {
            if (aResponsesSucce.equals(response)) {
                httpResponse.onSuccess(result);
                onError = false;
            }
        }

        for (Integer anAResponsesForbidden : aResponsesForbidden) {
            if (anAResponsesForbidden.equals(response)) {
                httpResponse.onForbidden(result);
                onError = false;
            }
        }

        for (Integer anAResponsesError : aResponsesError) {
            if (anAResponsesError.equals(response)) {
                httpResponse.onError(error);
                onError = false;
            }
        }

        if (onError){
            httpResponse.onError(error);
        }
    }

}
