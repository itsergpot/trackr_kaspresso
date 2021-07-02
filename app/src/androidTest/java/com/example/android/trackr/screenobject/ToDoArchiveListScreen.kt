package com.example.android.trackr.screenobject

import android.view.View
import com.example.android.trackr.R
import io.github.kakaocup.kakao.chipgroup.KChipGroup
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.hamcrest.Matcher

object ToDoArchiveListScreen: Screen<ToDoArchiveListScreen>() {

    val toolBarArchive = KToolbar { withId(R.id.toolbar) }


    val todoArchiveList: KRecyclerView = KRecyclerView({
        withId(R.id.archived_tasks)
    }, itemTypeBuilder = {
        itemType(::ToDoItem)
    })

    class ToDoItem(parent: Matcher<View>) : KRecyclerItem<ToDoItem>(parent) {
        val todoArchiveTitle = KTextView(parent) { withId(R.id.title) }
        val todoArchiveStarButton = KButton(parent) { withId(R.id.star) }
        val todoArchiveImageOwnerAvatar = KImageView(parent) { withId(R.id.owner_avatar) }
        val todoArchiveOwnerName = KTextView(parent) { withId(R.id.owner) }
        val todoArchiveDueDate = KTextView(parent) { withId(R.id.due_date) }
        val todoArchiveTagsChipGroup = KChipGroup(parent) { withId(R.id.chip_group) }
    }

}