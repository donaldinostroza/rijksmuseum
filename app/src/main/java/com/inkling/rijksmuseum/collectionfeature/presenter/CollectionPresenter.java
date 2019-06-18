package com.inkling.rijksmuseum.collectionfeature.presenter;

import com.inkling.rijksmuseum.Constants;
import com.inkling.rijksmuseum.collectionfeature.CollectionInterface;
import com.inkling.rijksmuseum.collectionfeature.repository.ArtObjectsResponse;
import com.inkling.rijksmuseum.collectionfeature.repository.RetrofitClientInstance;
import com.inkling.rijksmuseum.collectionfeature.repository.RijksmuseumDataSource;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionPresenter implements CollectionInterface.Presenter {


    private WeakReference<CollectionInterface.View> view;

    public CollectionPresenter(CollectionInterface.View view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void getCollection() {
        getCollectionByMaker("");
    }

    @Override
    public void getCollectionByMaker(String maker) {
        /*Create handle for the RetrofitInstance interface*/
        RijksmuseumDataSource service = RetrofitClientInstance.getRetrofitInstance().create(RijksmuseumDataSource.class);
        Call<ArtObjectsResponse> call = service.getArtObjectsByMaker(Constants.API_KEY, maker,
                Constants.PAGE_NUMBER, Constants.RESULT_PER_PAGE);
        call.enqueue(new Callback<ArtObjectsResponse>() {
            @Override
            public void onResponse(Call<ArtObjectsResponse> call, Response<ArtObjectsResponse> response) {

                if(response.body() != null && response.body().getArtObjects() != null){
                    getView().showCollection(response.body().getArtObjects());
                } else{
                    getView().showError();
                }
            }

            @Override
            public void onFailure(Call<ArtObjectsResponse> call, Throwable t) {
                getView().showError();
            }
        });
    }

    public CollectionInterface.View getView() {
        //TODO manage null value
        return view.get();
    }
}
