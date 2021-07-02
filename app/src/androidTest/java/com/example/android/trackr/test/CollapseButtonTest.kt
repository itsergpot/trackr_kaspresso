package com.example.android.trackr.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.ToDoListScreen
import com.example.android.trackr.shared.R.drawable.ic_daring_dove
import com.example.android.trackr.shared.R.drawable.ic_likeable_lark
import org.junit.Rule
import org.junit.Test

class CollapseButtonTest : TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkCollapseInteraction() {

        run {

            step("Minimize category") {
                ToDoListScreen {

                    todoList.childAt<ToDoListScreen.ToDoItem>(0) {
                        todoCollapseButton {
                            click()
                        }
                    }
                }
            }

            step("Check if `in progress` ToDos are not presented") {
                ToDoListScreen {
                    todoList.childAt<ToDoListScreen.ToDoItem>(2) {

                        todoTitle {
                            isDisplayed()
                            hasText("New mocks for tablet")
                        }

                        todoStarButton {
                            isDisplayed()
                        }

                        todoImageOwnerAvatar {
                            isDisplayed()
                            hasDrawable(resId = ic_daring_dove)
                        }

                        todoOwnerName {
                            isDisplayed()
                            hasText("Owner: Daring Dove")
                        }

                        todoDueDate {
                            isDisplayed()
                            hasText("Due Jul 9, 2021")
                        }

                        todoTagsChipGroup {
                            hasSize(4)
                            hasChip("2.4 release")
                            hasChip("UI/UX")
                        }
                    }
                }
            }

            step("Expand category") {
                ToDoListScreen {

                    todoList.childAt<ToDoListScreen.ToDoItem>(0) {
                        todoCollapseButton {
                            click()
                        }
                    }
                }
            }

            step("Check if `in progress` ToDo is presented") {
                ToDoListScreen {
                    todoList.childAt<ToDoListScreen.ToDoItem>(1) {

                        todoTitle {
                            isDisplayed()
                            hasText("Support display modes")
                        }

                        todoStarButton {
                            isDisplayed()
                        }

                        todoImageOwnerAvatar {
                            isDisplayed()
                            hasDrawable(resId = ic_likeable_lark)
                        }

                        todoOwnerName {
                            isDisplayed()
                            hasText("Owner: Likeable Lark")
                        }

                        todoDueDate {
                            isDisplayed()
                            hasText("Due tomorrow")
                        }

                        todoTagsChipGroup {
                            hasSize(4)
                            hasChip("2.3 release")
                            hasChip("eng")
                            hasChip("VisD")
                        }
                    }
                }
            }
        }
    }
}

