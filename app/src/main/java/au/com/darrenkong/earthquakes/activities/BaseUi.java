/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.activities;

import android.support.annotation.StringRes;

/**
 * Created by dkong on 31/10/2016.
 */
public interface BaseUi {

    /**
     * Show error.
     */
    void showError();

    /**
     * Show error.
     *
     * @param titleId
     *         the title id
     * @param messageId
     *         the message id
     */
    void showError(@StringRes int titleId, @StringRes int messageId);

    /**
     * Show loading state.
     */
    void showLoadingState();

    /**
     * Show loading state.
     *
     * @param res
     *         the res
     */
    void showLoadingState(@StringRes int res);

    /**
     * Hide loading state.
     */
    void hideLoadingState();
}
