package com.problemhunt.shailendra;

import com.problemhunt.shailendra.responseschema.FactResponseSchema;
import com.problemhunt.shailendra.responseschema.Row;
import com.problemhunt.shailendra.interfaces.AboutInteractor;
import com.problemhunt.shailendra.interfaces.AboutPresenter;
import com.problemhunt.shailendra.interfaces.AboutView;
import com.problemhunt.shailendra.models.AboutModel;

import java.util.ArrayList;



public class AboutPresenterImpl implements AboutPresenter, AboutInteractor.FactListener {

    private AboutView factView;
    private AboutInteractor factInteractor;

    AboutPresenterImpl(AboutView factView, AboutInteractor factInteractor) {
        this.factView = factView;
        this.factInteractor = factInteractor;
        factInteractor.setFactListener(this);
    }

    @Override
    public void getFact() {
        factView.changeRefreshStatus(true);
        factInteractor.getFacts();
    }

    @Override
    public void onFactReceived(FactResponseSchema factResponseSchema) {
        factView.changeRefreshStatus(false);
        factView.showTitle(factResponseSchema.getTitle());

        if (Utils.notEmptyOrNull(factResponseSchema.getRows())) {
            ArrayList<AboutModel> factsModels = new ArrayList<>();
            for (Row row : factResponseSchema.getRows()) {
                AboutModel factsModel = new AboutModel();
                factsModel.setTitle(row.getTitle());
                factsModel.setDescription(row.getDescription());
                factsModel.setImageUrl(row.getImageHref());
                if (!factsModel.isEmpty())
                    factsModels.add(factsModel);
            }
            factView.loadRecyclerView(factsModels);
        }
    }

    @Override
    public void errorOccurred() {
        factView.changeRefreshStatus(false);
        factView.showError();
    }
}
