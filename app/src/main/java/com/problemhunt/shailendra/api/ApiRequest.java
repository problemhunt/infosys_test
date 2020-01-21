package com.problemhunt.shailendra.api;

import com.problemhunt.shailendra.responseschema.FactResponseSchema;

import retrofit2.Call;
import retrofit2.Callback;



public class ApiRequest {
    private static ApiRequest instance;
    private final ApiInterface apiInterface;

    /**
     * Initialize the api request and api client.
     */
    private ApiRequest() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    /**
     * generate singleton instance of ApiRequest
     * @return {@link ApiRequest} indicates teh request object
     */
    public static ApiRequest getInstance() {
        if (instance == null)
            instance = new ApiRequest();
        return instance;
    }

    /**
     * Api request to get facts
     * @param callback callback for the response of the api
     */
    public void getFacts(Callback<FactResponseSchema> callback) {
        Call<FactResponseSchema> call = apiInterface.getFact();
        call.enqueue(callback);
    }
}
