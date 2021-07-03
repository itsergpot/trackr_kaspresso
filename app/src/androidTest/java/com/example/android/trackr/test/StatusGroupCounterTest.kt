package com.example.android.trackr.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.ToDoListScreen
import org.junit.Rule
import org.junit.Test

class StatusGroupCounterTest: TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkStatusGroupCounter() {
        run {

            step("Archive ToDos in `In progress` category") {

                ToDoListScreen {
                    todoList.childAt<ToDoListScreen.ToDoItem>(2) {
                        todoSwipe {
                            swipeLeft()
                        }
                    }
                }

                ToDoListScreen {
                    todoList.childAt<ToDoListScreen.ToDoItem>(1) {
                        todoSwipe {
                            swipeLeft()
                        }
                    }
                }
            }

            step("Check counter of `In progress` category") {

                ToDoListScreen {
                    todoList.childAt<ToDoListScreen.ToDoItem>(0) {
                        todoStatusCategory {
                            hasText("In progress (0)")
                        }
                    }
                }
            }
        }
    }
}