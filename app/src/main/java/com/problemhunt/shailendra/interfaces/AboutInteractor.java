package com.problemhunt.shailendra.interfaces;

import com.problemhunt.shailendra.responseschema.FactResponseSchema;


public interface AboutInteractor {

    void getFacts();

    void setFactListener(FactListener factListener);



    interface FactListener {
        void onFactReceived(FactResponseSchema factResponseSchema);

        void errorOccurred();
    }
}
