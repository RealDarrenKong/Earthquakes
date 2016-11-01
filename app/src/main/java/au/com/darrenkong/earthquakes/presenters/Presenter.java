/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.presenters;

import android.os.Bundle;

/**
 * Created by dkong on 31/10/2016.
 */
public interface Presenter {
    /**
     * Method that performs tasks on creation of a view getComponent.
     *
     * @param savedInstanceState
     *         the saved instance state
     */
    void onCreate(Bundle savedInstanceState);

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's (Activity or Fragment)
     * onResume() method.
     */
    void onResume();

    /**
     * Method that controls the lifecycle of the view. It should be called in the view's (Activity or Fragment)
     * onPause() method.
     */
    void onPause();


    /**
     * Method that controls the lifecycle of the view. It should be called in the view's (Activity or Fragment)
     * onDestroy() method.
     */
    void onDestroy();
}