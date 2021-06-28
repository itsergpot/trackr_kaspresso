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
import org.hamcrest.Matcher

object ToDoListScreen: Screen<ToDoListScreen>() {

    val addToDoButton = KButton { withId(R.id.add) }

    val todos = KRecyclerView(
        builder = {
            withId(R.id.tasks_list)
        },
        itemTypeBuilder = {
            itemType(::TodoItem)
        }
    )

    class TodoItem(parent: Matcher<View>) : KRecyclerItem<TodoItem>(parent) {

        val todoTitle = KTextView(parent) { withId(R.id.title) }
        val todoStarButton = KButton(parent) { withId(R.id.star) }
        val todoImageOwnerAvatar = KImageView(parent) { withId(R.id.owner_avatar) }
        val todoOwnerName = KTextView(parent) { withId(R.id.owner) }
        val todoDueDate = KTextView(parent) { withId(R.id.due_date) }

        val todoTagGroup = KChipGroup(parent) { withId(R.id.chip_group) }

    }
}