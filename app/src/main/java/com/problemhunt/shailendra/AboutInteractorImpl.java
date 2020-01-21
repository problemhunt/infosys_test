package com.problemhunt.shailendra;

import com.problemhunt.shailendra.responseschema.FactResponseSchema;
import com.problemhunt.shailendra.api.ApiRequest;
import com.problemhunt.shailendra.interfaces.AboutInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class AboutInteractorImpl implements AboutInteractor {

    private AboutInteractor.FactListener factListener;

    @Override
    public void setFactListener(FactListener factListener) {
        this.factListener = factListener;
    }

    /**
     * Makes the api call to get facts
     */
    @Override
    public void getFacts() {
        ApiRequest.getInstance().getFacts(new Callback<FactResponseSchema>() {
            @Override
            public void onResponse(Call<FactResponseSchema> call, Response<FactResponseSchema> response) {
                call.request();
                factListener.onFactReceived(response.body());
            }

            @Override
            public void onFailure(Call<FactResponseSchema> call, Throwable t) {
                factListener.errorOccurred();
            }
        });
    }
}
