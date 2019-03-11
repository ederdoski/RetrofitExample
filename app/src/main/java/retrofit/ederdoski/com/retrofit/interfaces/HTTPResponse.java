package retrofit.ederdoski.com.retrofit.interfaces;

import android.util.Log;

import java.util.List;

public abstract class HTTPResponse {

    private static boolean debug = true;

    public void onSuccess(List<?> result){};

    public void onSuccess(Object result){};

    public void onSuccess(String result){};

    public void onForbidden(Object result){
        Log.e("HTTPResponse", "FORBIDDEN");
    }

    public void onException(Exception e){
        Log.e("HTTPResponse", String.valueOf(e));
    }

    public void onError(String data){
        Log.e("HTTPResponse",data);
    }

}

