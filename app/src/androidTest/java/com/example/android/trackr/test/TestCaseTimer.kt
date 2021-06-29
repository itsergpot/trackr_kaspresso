package com.example.android.trackr.test

import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

open class TestCaseTimer: TestCase(getBuilder()) {

    companion object {
        private val myBuilder: Kaspresso.Builder
            get() = Kaspresso.Builder.simple().apply {
                flakySafetyParams = FlakySafetyParams.default().apply {
                    timeoutMs = 3000L
                }
            }
        fun getBuilder() = myBuilder
    }
}