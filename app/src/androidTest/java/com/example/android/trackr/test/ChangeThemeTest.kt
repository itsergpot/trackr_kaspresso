package com.example.android.trackr.test

import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.android.trackr.MainActivity
import com.example.android.trackr.screenobject.AppSettingsScreen
import com.example.android.trackr.screenobject.ToDoListScreen
import org.junit.Rule
import org.junit.Test

class ChangeThemeTest : TestCaseTimer() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkThemeChanging() {
        before {

            ToDoListScreen {

                todo3DotsButton {
                    click()
                }

                todo3DotsButtonSettings {
                    click()
                }
            }

        }.after {

            //Nothing here

        }.run {

            AppSettingsScreen {

                step("Tap on mode changer and change to Dark mode") {

                    appSettingsList.childAt<AppSettingsScreen.SettingsItem>(0) {
                        isDisplayed()
                        hasDescendant { withText("Dark Mode") }
                        perform {
                            click()
                        }
                    }

                    themeSettingsListView.childAt<AppSettingsScreen.ThemeSettingsListItem>(0) {
                        isDisplayed()
                        withText("Enabled")
                        perform {
                            click()
                        }
                    }

                    pressBack()
                }

                step("Follow to ToDoList and check if theme was applied") {

                    ToDoListScreen {

                        todoList {
                            hasDescendant { withBackgroundColor("#1C2A3A") }
                        }
                    }
                }
            }
        }
    }
}

