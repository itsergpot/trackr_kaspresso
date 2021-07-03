package com.example.android.trackr.test


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.ToDoListScreen
import io.github.kakaocup.kakao.screen.Screen.Companion.idle
import org.junit.Rule
import org.junit.Test

class RestoreArchivedToDoViaSnackBarTest : TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkRestoreToDoAfterArchive() {
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

            step("Press Undo button on Snack Bar") {

                ToDoListScreen {
                    snackBarUndoButton {
                        click()
                    }
                }
            }

            step("Check if 1 ToDo child matches the 1 step child") {

                ToDoListScreen {
                    todoList.childAt<ToDoListScreen.ToDoItem>(1) {
                        todoTitle {
                            hasText("Support display modes")
                        }
                    }
                }
            }
        }
    }
}
