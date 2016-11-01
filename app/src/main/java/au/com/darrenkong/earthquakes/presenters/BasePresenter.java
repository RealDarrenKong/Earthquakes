/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.presenters;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import javax.inject.Inject;

import au.com.darrenkong.earthquakes.activities.BaseUi;


/**
 * Created by dkong on 31/10/2016.
 */
public abstract class BasePresenter<T extends BaseUi>
        implements Presenter {

    T mUi;

    @Inject
    protected T mInjectedUi;

    @CallSuper
    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @CallSuper
    @Override
    public void onResume() {

    }

    @CallSuper
    @Override
    public void onPause() {

    }

    @CallSuper
    @Override
    public void onDestroy() {

    }

    protected T getUi() {
        return mInjectedUi;
    }
}
