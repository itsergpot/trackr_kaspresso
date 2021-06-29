package com.example.android.trackr.test

import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.AddToDoTaskScreen
import com.example.android.trackr.screenobject.ToDoListScreen
import io.github.kakaocup.kakao.spinner.KSpinnerItem
import org.junit.Rule
import org.junit.Test

class AddToDoTest : TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    //Добавить TODO и проверить что она добавилась
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
                    todoTitle {
                        replaceText("ToDoTitle")
                    }

                    todoDescription {
                        replaceText("ToDoDescription")
                    }

                    todoStatusSpinner {
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

                step("Change ToDo`s owner") {
                    AddToDoTaskScreen {

                        todoOwnerChipGroup {
                            click()
                        }

                        todoOwnerListView.childAt<AddToDoTaskScreen.OwnerListItem>(0) {
                            isDisplayed()
                            hasText("Daring Dove")
                        }

                        todoOwnerListView.childAt<AddToDoTaskScreen.OwnerListItem>(1) {
                            isDisplayed()
                            hasText("Likeable Lark")
                        }

                        todoOwnerListView.childAt<AddToDoTaskScreen.OwnerListItem>(2) {
                            isDisplayed()
                            hasText("Peaceful Puffin")
                            click()
                        }
                    }
                }

                step("Change due date") {
                    AddToDoTaskScreen {

                        todoDueDate {
                            click()
                        }

                        todoYearChange {
                            click()
                        }

                        calendarYearSelectorRecyclerView {
                            isDisplayed()
                            childWith<AddToDoTaskScreen.CalendarYearItem> { withText("2023") } perform {
                                click()
                            }
                        }

                        todoMonthChangeNext {
                            click()
                        }

                        calendarDayCalendarListView {
                            isDisplayed()
                            childWith<AddToDoTaskScreen.DayListItem> { withText("5") } perform {
                                click()
                            }
                        }
                    }

                }
            }

        }

    }


    @Test
    fun test() {

        ToDoListScreen {
            addToDoButton {
                click()
            }
        }

        AddToDoTaskScreen {

            todoDueDate {
                click()
            }

            calendarDayCalendarListView.childAt<AddToDoTaskScreen.DayListItem>(4) {
                isDisplayed()
                hasText("5")
                click()
            }


        }
    }
}
