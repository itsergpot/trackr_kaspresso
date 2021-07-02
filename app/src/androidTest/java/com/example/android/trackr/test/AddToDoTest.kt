package com.example.android.trackr.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.AddToDoTaskScreen
import com.example.android.trackr.screenobject.ToDoListScreen
import io.github.kakaocup.kakao.spinner.KSpinnerItem
import org.junit.Rule
import org.junit.Test
import com.example.android.trackr.shared.R.drawable.ic_peaceful_puffin

class AddToDoTest : TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAddToDo() {

        run {
            step("Follow to Adding ToDo screen") {
                ToDoListScreen {
                    addToDoButton {
                        click()
                    }
                }
            }

            step("Fill ToDo title, description, select status") {
                AddToDoTaskScreen {
                    todoAddTitle {
                        replaceText("ToDoTitle")
                    }

                    todoAddDescription {
                        replaceText("ToDoDescription")
                    }

                    todoAddStatusSpinner {
                        isVisible()
                        hasSize(4)

                        open()

                        childAt<KSpinnerItem>(0) {
                            isVisible()
                            hasText("Not started")
                        }

                        childAt<KSpinnerItem>(2) {
                            isVisible()
                            hasText("Completed")
                        }

                        childAt<KSpinnerItem>(3) {
                            isVisible()
                            hasText("Archived")
                        }

                        childAt<KSpinnerItem>(1) {
                            isVisible()
                            hasText("In progress")
                            click()
                        }
                    }
                }
            }

            step("Change ToDo`s owner") {
                AddToDoTaskScreen {

                    todoAddOwnerChipGroup {
                        click()
                    }

                    todoAddOwnerListView.childAt<AddToDoTaskScreen.OwnerListItem>(0) {
                        isDisplayed()
                        hasText("Daring Dove")
                    }

                    todoAddOwnerListView.childAt<AddToDoTaskScreen.OwnerListItem>(1) {
                        isDisplayed()
                        hasText("Likeable Lark")
                    }

                    todoAddOwnerListView.childAt<AddToDoTaskScreen.OwnerListItem>(2) {
                        isDisplayed()
                        hasText("Peaceful Puffin")
                        click()
                    }
                }
            }

            step("Change due date") {
                AddToDoTaskScreen {

                    todoAddDueDate {
                        click()
                    }

                    todoAddCalendarDateChangerButton {
                        click()
                    }

                    todoAddCalendarDateInput {
                        edit {
                            replaceText("07/22/2021")
                        }
                    }

                    todoAddCalendarOkButton {
                        click()
                    }
                }
            }

            step("Add tags") {
                AddToDoTaskScreen {

                    todoAddTags {
                        click()
                    }

                    todoAddTagsListView.childAt<AddToDoTaskScreen.TagsListItem>(0) {
                        isDisplayed()
                        hasText("2.3 release")
                        click()
                    }

                    todoAddTagsListView.childAt<AddToDoTaskScreen.TagsListItem>(1) {
                        isDisplayed()
                        hasText("2.4 release")
                        click()
                    }

                    todoAddTagsListView.childAt<AddToDoTaskScreen.TagsListItem>(2) {
                        isDisplayed()
                        hasText("a11y")
                        click()
                    }

                    pressBack()

                    todoAddSaveButton {
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Check created todo") {

                AddToDoTaskScreen {

                    ToDoListScreen.todoList.childAt<ToDoListScreen.ToDoItem>(0) {
                        hasDescendant { withText("In progress (3)") }
                    }

                    ToDoListScreen.todoList.childAt<ToDoListScreen.ToDoItem>(2) {
                        todoTitle {
                            isDisplayed()
                            hasText("ToDoTitle")
                        }

                        todoStarButton {
                            isDisplayed()
                        }

                        todoImageOwnerAvatar {
                            isDisplayed()
                            hasDrawable(resId = ic_peaceful_puffin)
                        }

                        todoOwnerName {
                            isDisplayed()
                            hasText("Owner: Peaceful Puffin")
                        }

                        todoDueDate {
                            isDisplayed()
                            hasText("Due Jul 22, 2021")
                        }

                        todoTagsChipGroup {
                            hasSize(4)
                            hasChip("2.3 release")
                            hasChip("2.4 release")
                            hasChip("a11y")
                        }
                    }
                }
            }
        }
    }
}

