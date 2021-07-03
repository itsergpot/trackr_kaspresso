package com.example.android.trackr.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.ToDoDetailsScreen
import com.example.android.trackr.screenobject.ToDoEditScreen
import com.example.android.trackr.screenobject.ToDoListScreen
import org.junit.Rule
import org.junit.Test

class ChangeToDoDescriptionTest: TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkToDoDescriptionChanging() {
        run {

            step("Follow to ToDo details screen") {

                ToDoListScreen {
                    todoList.childAt<ToDoListScreen.ToDoItem>(1) {
                        click()
                    }
                }
            }

            step("Follow to edit Screen, change description, Save ad follow to ToDo`s details Screen") {

                ToDoDetailsScreen {
                    editToDoButton {
                        click()
                    }
                }

                ToDoEditScreen {
                    todoEditDescription {
                        replaceText("Once upon a time")
                    }

                    todoEditSaveButton {
                        click()
                    }
                }
            }

            step("Check applied description text") {

                ToDoDetailsScreen {
                    todoDescription {
                        hasText("Once upon a time")
                    }
                }
            }
        }

    }
}