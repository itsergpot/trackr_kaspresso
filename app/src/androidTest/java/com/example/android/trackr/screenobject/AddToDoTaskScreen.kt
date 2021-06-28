package com.example.android.trackr.screenobject

import androidx.test.espresso.DataInteraction
import com.example.android.trackr.R
import io.github.kakaocup.kakao.chipgroup.KChipGroup
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.list.KAbsListView
import io.github.kakaocup.kakao.list.KAdapterItem
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.spinner.KSpinner
import io.github.kakaocup.kakao.spinner.KSpinnerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions

object AddToDoTaskScreen: Screen<AddToDoTaskScreen>() {

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

    class OwnerListItem(parent: DataInteraction) : KAdapterItem<OwnerListItem>(parent), TextViewAssertions

    //Calendar
    val todoDueDate = KTextView { withId(R.id.due_at) }

    //Tags
    val todoTags = KTextView { withId(R.id.tag_container) }
    val todoTagsChipGroup = KChipGroup { withId(R.id.tags) }
}