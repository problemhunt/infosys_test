package com.problemhunt.shailendra.interfaces;

import com.problemhunt.shailendra.models.AboutModel;

import java.util.ArrayList;



public interface AboutView {

    void showTitle(String title);

    void loadRecyclerView(ArrayList<AboutModel> factsModel);

    void changeRefreshStatus(boolean showRefresh);

    void showError();
}
