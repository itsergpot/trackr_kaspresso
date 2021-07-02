package com.example.android.trackr.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.ToDoListScreen
import org.junit.Rule
import org.junit.Test

class StarFillingTest: TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkStarFilling() {
        run {

            step("Tap star icon, check filled state, tap star icon, check unfilled state") {
                ToDoListScreen {

                    todoList.childAt<ToDoListScreen.ToDoItem>(1) {
                        todoStarButton {
                            hasContentDescription("Unstarred")
                            click()
                            hasContentDescription("Starred")
                            click()
                            hasContentDescription("Unstarred")
                        }
                    }
                }
            }
        }

    }
}