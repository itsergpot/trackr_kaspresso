package com.example.android.trackr.screenobject

import android.view.View
import androidx.test.espresso.DataInteraction
import com.example.android.trackr.R
import io.github.kakaocup.kakao.chipgroup.KChipGroup
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.image.KImageView
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

object ToDoEditScreen: Screen<ToDoEditScreen>() {

    val todoEditBackButton = KImageView {
        isDescendantOfA {
            withId(R.id.app_bar)
        }
        withContentDescription("Back")
    }

    val todoEditTitle = KEditText { withId(R.id.title) }
    val todoEditDescription = KEditText { withId(R.id.description) }

    //Status spinner
    val todoEditStatusSpinner = KSpinner(
        builder = {
            withId(R.id.status)
        },
        itemTypeBuilder = {
            itemType(::KSpinnerItem)
        }
    )

    //Owner
    val todoEditOwnerChipGroup = KChipGroup { withId(R.id.owner) }

    //Owner ListView
    val todoEditOwnerListView = KAbsListView(
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
    val todoEditDueDate = KTextView { withId(R.id.due_at) }

    //Calendar year open button
    val todoEditYearChange = KButton { withId(R.id.month_navigation_fragment_toggle) }

    //Calendar year changer
    val calendarEditYearSelectorRecyclerView = KRecyclerView(
        builder = { withId(R.id.mtrl_calendar_year_selector_frame) },
        itemTypeBuilder = { itemType(::CalendarYearItem) })

    class CalendarYearItem(parent: Matcher<View>) : KRecyclerItem<CalendarYearItem>(parent),
        TextViewAssertions

    //Calendar month changer
    val todoEditMonthChangePrevious = KButton { withId(R.id.month_navigation_previous) }
    val todoEditMonthChangeNext = KButton { withId(R.id.month_navigation_next) }

    //Calendar date changer
    val todoEditCalendarDateChangerButton = KButton { withId(R.id.mtrl_picker_header_toggle) }
    val todoEditCalendarDateInput = KTextInputLayout { withId(R.id.mtrl_picker_text_input_date) }

    //Calendar Ok, Cancel buttons
    val todoEditCalendarOkButton = KButton { withId(R.id.confirm_button) }
    val todoEditCalendarCancelButton = KButton { withId(R.id.cancel_button) }

    //Tags
    val todoEditTags = KTextView { withId(R.id.tag_container) }

    //Tags RecyclerListView

    val todoEditTagsListView = KAbsListView(
        builder = {
            withId(R.id.select_dialog_listview)
        },
        itemTypeBuilder = {
            itemType(::TagsListItem)
        }
    )

    class TagsListItem(parent: DataInteraction) : KAdapterItem<TagsListItem>(parent),
        TextViewAssertions

    val todoEditSaveButton = KButton { withId(R.id.action_save) }

}