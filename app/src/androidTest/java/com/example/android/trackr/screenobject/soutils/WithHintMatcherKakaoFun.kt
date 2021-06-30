package com.example.android.trackr.screenobject.soutils

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

fun withHintCustomMatcher(matcher: String): Matcher<View> {
    return ViewMatchers.withHint(matcher)
}