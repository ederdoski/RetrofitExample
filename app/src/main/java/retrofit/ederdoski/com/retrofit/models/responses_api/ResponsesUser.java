package retrofit.ederdoski.com.retrofit.models.responses_api;

import retrofit.ederdoski.com.retrofit.models.Address;

public class ResponsesUser {

     /*"data": {
        "id": 2,
                "name": "fuchsia rose",
                "year": 2001,
                "color": "#C74375",
                "pantone_value": "17-2031"
    }*/

   private data data;

    public ResponsesUser(retrofit.ederdoski.com.retrofit.models.responses_api.data data) {
        this.data = data;
    }

    public retrofit.ederdoski.com.retrofit.models.responses_api.data getData() {
        return data;
    }

    public void setData(retrofit.ederdoski.com.retrofit.models.responses_api.data data) {
        this.data = data;
    }
}
