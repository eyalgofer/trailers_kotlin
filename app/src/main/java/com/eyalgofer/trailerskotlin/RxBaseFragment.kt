package com.eyalgofer.trailerskotlin

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by eyalgofer on 10/08/2017.
 */
open class RxBaseFragment() : Fragment() {

    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }
}