package com.example.android.trackr.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.ToDoArchiveListScreen
import com.example.android.trackr.screenobject.ToDoDetailsScreen
import com.example.android.trackr.screenobject.ToDoEditScreen
import com.example.android.trackr.screenobject.ToDoListScreen
import io.github.kakaocup.kakao.spinner.KSpinnerItem
import org.junit.Rule
import org.junit.Test

class ArchiveToDoTest : TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkArchiveToDo() {

        before {

            ToDoListScreen {

                todoList.childAt<ToDoListScreen.ToDoItem>(1) {
                    click()
                }
            }

            ToDoDetailsScreen {
                editToDoButton {
                    click()
                }
            }

            ToDoEditScreen {
                todoEditStatusSpinner {

                    open()

                    childAt<KSpinnerItem>(3) {
                        isVisible()
                        hasText("Archived")
                        click()
                    }
                }

                todoEditSaveButton {
                    click()
                }
            }

            ToDoDetailsScreen {
                todoDetailsBackButton {
                    click()
                }
            }

            ToDoListScreen {

                todo3DotsButton {
                    click()
                }

                todo3DotsButtonArchive {
                    click()
                }
            }

        }.after {

            //Nothing here

        }.run {

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