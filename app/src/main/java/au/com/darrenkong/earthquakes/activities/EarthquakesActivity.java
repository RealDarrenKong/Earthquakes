package au.com.darrenkong.earthquakes.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

import javax.inject.Inject;

import au.com.darrenkong.earthquakes.EarthquakesApplication;
import au.com.darrenkong.earthquakes.R;
import au.com.darrenkong.earthquakes.adapter.EarthquakesAdapter;
import au.com.darrenkong.earthquakes.dagger.component.DaggerEarthquakesComponent;
import au.com.darrenkong.earthquakes.dagger.module.EarthquakesModule;
import au.com.darrenkong.earthquakes.model.Earthquakes.Earthquake;
import au.com.darrenkong.earthquakes.presenters.EarthquakesPresenter;
import au.com.darrenkong.earthquakes.presenters.EarthquakesPresenter.EarthquakesUi;
import au.com.darrenkong.earthquakes.presenters.Presenter;
import butterknife.BindView;

public class EarthquakesActivity
        extends BaseActivity
        implements EarthquakesUi {

    @Inject
    EarthquakesPresenter mEarthquakesPresenter;

    @Inject
    RecyclerView.LayoutManager mLayoutManager;

    @BindView(R.id.recycler_earthquakes)
    RecyclerView mRecyclerEarthquakes;

    private EarthquakesAdapter mEarthquakesAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupRecyclerView();
        // TODO: 1/11/2016 add filters on screen to retrieve earthquakes based on user input
        // TODO: 1/11/2016 add earthquake details screen with mapview
        // TODO: 1/11/2016 add tests
    }

    @Override
    protected void inject() {
        DaggerEarthquakesComponent
                .builder()
                .appComponent(EarthquakesApplication.getInstance().getApplicationComponent())
                .earthquakesModule(new EarthquakesModule(this, this))
                .build()
                .inject(this);
    }

    @LayoutRes
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_earthquakes;
    }

    @Nullable
    @Override
    public Presenter getPresenter() {
        return mEarthquakesPresenter;
    }

    @Override
    public void showItems(Earthquake[] items) {
        mEarthquakesAdapter.setItems(Arrays.asList(items));
    }

    private void setupRecyclerView() {
        mRecyclerEarthquakes.setLayoutManager(mLayoutManager);
        mEarthquakesAdapter = mEarthquakesPresenter.getAdapter(this);
        mRecyclerEarthquakes.setAdapter(mEarthquakesAdapter);
    }
}
