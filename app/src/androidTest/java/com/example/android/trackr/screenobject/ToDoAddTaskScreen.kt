package com.example.android.trackr.screenobject

import android.view.View
import androidx.test.espresso.DataInteraction
import com.example.android.trackr.R
import io.github.kakaocup.kakao.chipgroup.KChipGroup
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.list.KAbsListView
import io.github.kakaocup.kakao.list.KAdapterItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.spinner.KSpinner
import io.github.kakaocup.kakao.spinner.KSpinnerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher

object ToDoAddTaskScreen : Screen<ToDoAddTaskScreen>() {

    val todoAddTitle = KEditText { withId(R.id.title) }
    val todoAddDescription = KEditText { withId(R.id.description) }

    //Status spinner
    val todoAddStatusSpinner = KSpinner(
        builder = {
            withId(R.id.status)
        },
        itemTypeBuilder = {
            itemType(::KSpinnerItem)
        }
    )

    //Owner
    val todoAddOwnerChipGroup = KChipGroup { withId(R.id.owner) }

    //Owner ListView
    val todoAddOwnerListView = KAbsListView(
        builder = {
            withId(R.id.select_dialog_listview)
        },
        itemTypeBuilder = {
            itemType(::OwnerListItem)
        }
    )

    class OwnerListItem(parent: DataInteraction) : KAdapterItem<OwnerListItem>(parent),
        TextViewAssertions

    //Calendar hood items opener
    val todoAddDueDate = KTextView { withId(R.id.due_at) }

    //Calendar year open button
    val todoAddYearChange = KButton { withId(R.id.month_navigation_fragment_toggle) }

    //Calendar year changer
    val calendarAddYearSelectorRecyclerView = KRecyclerView(
        builder = { withId(R.id.mtrl_calendar_year_selector_frame) },
        itemTypeBuilder = { itemType(::CalendarYearItem) })

    class CalendarYearItem(parent: Matcher<View>) : KRecyclerItem<CalendarYearItem>(parent),
        TextViewAssertions

    //Calendar month changer
    val todoAddMonthChangePrevious = KButton { withId(R.id.month_navigation_previous) }
    val todoAddMonthChangeNext = KButton { withId(R.id.month_navigation_next) }

    //Calendar date changer
    val todoAddCalendarDateChangerButton = KButton { withId(R.id.mtrl_picker_header_toggle) }
    val todoAddCalendarDateInput = KTextInputLayout { withId(R.id.mtrl_picker_text_input_date) }

    //Calendar Ok, Cancel buttons
    val todoAddCalendarOkButton = KButton { withId(R.id.confirm_button) }
    val todoAddCalendarCancelButton = KButton { withId(R.id.cancel_button) }

    //Tags
    val todoAddTags = KTextView { withId(R.id.tag_container) }

    //Tags RecyclerListView

    val todoAddTagsListView = KAbsListView(
        builder = {
            withId(R.id.select_dialog_listview)
        },
        itemTypeBuilder = {
            itemType(::TagsListItem)
        }
    )

    class TagsListItem(parent: DataInteraction) : KAdapterItem<TagsListItem>(parent),
        TextViewAssertions

    val todoAddSaveButton = KButton { withId(R.id.action_save) }
}