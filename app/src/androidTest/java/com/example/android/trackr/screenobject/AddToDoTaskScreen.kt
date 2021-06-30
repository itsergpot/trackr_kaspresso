package com.example.android.trackr.screenobject

import android.view.View
import androidx.test.espresso.DataInteraction
import com.example.android.trackr.R
import com.example.android.trackr.screenobject.soutils.withHintCustomMatcher
import io.github.kakaocup.kakao.chipgroup.KChipGroup
import io.github.kakaocup.kakao.edit.KEditText
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

object AddToDoTaskScreen : Screen<AddToDoTaskScreen>() {

    val todoTitle = KEditText { withId(R.id.title) }
    val todoDescription = KEditText { withId(R.id.description) }

    //Status spinner
    val todoStatusSpinner = KSpinner(
        builder = {
            withId(R.id.status)
        },
        itemTypeBuilder = {
            itemType(::KSpinnerItem)
        }
    )

    //Owner
    val todoOwnerChipGroup = KChipGroup { withId(R.id.owner) }

    //Owner ListView
    val todoOwnerListView = KAbsListView(
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
    val todoDueDate = KTextView { withId(R.id.due_at) }

    //Calendar year open button
    val todoYearChange = KButton { withId(R.id.month_navigation_fragment_toggle) }

    //Calendar year changer
    val calendarYearSelectorRecyclerView = KRecyclerView(
        builder = { withId(R.id.mtrl_calendar_year_selector_frame) },
        itemTypeBuilder = { itemType(::CalendarYearItem) })

    class CalendarYearItem(parent: Matcher<View>) : KRecyclerItem<CalendarYearItem>(parent),
        TextViewAssertions

    //Calendar month changer
    val todoMonthChangePrevious = KButton { withId(R.id.month_navigation_previous) }
    val todoMonthChangeNext = KButton { withId(R.id.month_navigation_next) }

    //Calendar date changer
    val todoCalendarDateChangerButton = KButton { withId(R.id.mtrl_picker_header_toggle) }
    val todoCalendarDateInput = KEditText { withMatcher(withHintCustomMatcher("Date")) }



    //Calendar Ok, Cancel buttons
    val todoCalendarOkButton = KButton { withId(R.id.confirm_button) }
    val todoCalendarCancelButton = KButton { withId(R.id.cancel_button) }

    //Tags
    val todoTags = KTextView { withId(R.id.tag_container) }

    //Tags RecyclerListView

    val tag = KTextView { withId(android.R.id.text1) }

    val todoTagsListView = KRecyclerView(
        builder = {
            withId(R.id.select_dialog_listview)
        },
        itemTypeBuilder = {
            itemType(::TagsListItem)
        }
    )

    class TagsListItem(parent: Matcher<View>) : KRecyclerItem<TagsListItem>(parent),
        TextViewAssertions {
            val tagTitle = KTextView(parent) { withId(android.R.id.text1) }
        }
}