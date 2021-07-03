package com.example.android.trackr.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.ToDoDetailsScreen
import com.example.android.trackr.screenobject.ToDoEditScreen
import com.example.android.trackr.screenobject.ToDoListScreen
import com.example.android.trackr.shared.R.drawable.*
import org.junit.Rule
import org.junit.Test

class ChangeOwnerAvatarTest: TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkChangingOwnerAvatar() {

        run {

            step("Check first To Do child Owner`s avatar and follow to details screen") {

                ToDoListScreen {
                    todoList.childAt<ToDoListScreen.ToDoItem>(1) {
                        todoImageOwnerAvatar {
                            isDisplayed()
                            hasDrawable(ic_likeable_lark)
                        }
                        click()
                    }
                }
            }

            step("Follow to edit Screen, change Owner, Save ad follow to ToDo`s list Screen") {

                ToDoDetailsScreen {
                    editToDoButton {
                        click()
                    }
                }

                ToDoEditScreen {

                    todoEditOwnerChipGroup {
                        click()
                    }

                    todoEditOwnerListView.childAt<ToDoEditScreen.OwnerListItem>(2) {
                        click()
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
            }

            //Bug here, avatar is changed to correct but the test is failed on check avatar
            //If you set ic_daring_dove in the first step and run this test again without dropping data, it will pass without fail.
            step("Check that first To Do child Owner`s avatar has changed") {

                ToDoListScreen {

                    todoList.childAt<ToDoListScreen.ToDoItem>(1) {
                        todoImageOwnerAvatar {
                            isDisplayed()
                            hasDrawable(ic_peaceful_puffin)
                        }
                    }
                }
            }
        }
    }
}