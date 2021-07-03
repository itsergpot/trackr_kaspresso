package com.example.android.trackr.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.ToDoArchiveListScreen
import com.example.android.trackr.screenobject.ToDoListScreen
import org.junit.Rule
import org.junit.Test

class ArchiveToDoViaSwipeTest: TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkToDoSideSwipeToArchive() {
        run {

            step("Swipe ToDo to Archive") {

                ToDoListScreen {
                    todoList.childAt<ToDoListScreen.ToDoItem>(1) {
                        todoTitle {
                            hasText("Support display modes")
                        }

                        todoSwipe {
                            swipeLeft()
                        }
                    }
                }
            }

            step("Check if ToDo is disappeared") {

                ToDoListScreen {
                    todoList.childAt<ToDoListScreen.ToDoItem>(1) {
                        todoTitle {
                            hasText("Let users set bg color")
                        }
                    }
                }
            }

            step("Check the ToDo archive for the archived ToDo in the first step") {

                ToDoListScreen {
                    todo3DotsButton {
                        click()
                    }

                    todo3DotsButtonArchive {
                        click()
                    }
                }

                ToDoArchiveListScreen {
                    toolBarArchive {
                        hasDescendant { withText("Archive") }
                        isDisplayed()
                    }


                    todoArchiveList {
                        hasSize(4)
                    }

                    todoArchiveList.firstChild<ToDoArchiveListScreen.ToDoItem> {
                        todoArchiveTitle {
                            hasText("Support display modes")
                        }
                    }
                }

            }
        }
    }
}