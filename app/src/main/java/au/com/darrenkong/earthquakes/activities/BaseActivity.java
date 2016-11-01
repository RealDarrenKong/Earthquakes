/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

import au.com.darrenkong.earthquakes.R;
import au.com.darrenkong.earthquakes.presenters.Presenter;
import butterknife.BindView;

import static butterknife.ButterKnife.bind;

/**
 * Created by dkong on 31/10/2016.
 */
public abstract class BaseActivity
        extends AppCompatActivity
        implements BaseUi {

    @BindView(R.id.toolbar)
    @Nullable
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        bind(this);
        inject();

        if (toolbar != null) {
            setActionBar(toolbar);
        }

        if (getPresenter() != null) {
            getPresenter().onCreate(savedInstanceState);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getPresenter() != null) {
            getPresenter().onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (getPresenter() != null) {
            getPresenter().onPause();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (getPresenter() != null) {
            getPresenter().onDestroy();
        }
    }

    protected abstract void inject();

    @LayoutRes
    protected abstract int getLayoutResource();

    //Presenters should be injected in each child activity
    @Nullable
    public abstract Presenter getPresenter();

    @Override
    public void showError() {

    }

    @Override
    public void showError(@StringRes int titleId, @StringRes int messageId) {

    }

    @Override
    public void showLoadingState() {

    }

    @Override
    public void showLoadingState(@StringRes int res) {

    }

    @Override
    public void hideLoadingState() {

    }
}
