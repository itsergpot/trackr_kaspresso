package com.example.android.trackr.screenobject

import android.view.View
import com.example.android.trackr.R
import io.github.kakaocup.kakao.chipgroup.KChipGroup
import io.github.kakaocup.kakao.common.views.KSwipeView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher

object ToDoListScreen : Screen<ToDoListScreen>() {

    val addToDoButton = KButton { withId(R.id.add) }

    val todoList: KRecyclerView = KRecyclerView({
        withId(R.id.tasks_list)
    }, itemTypeBuilder = {
        itemType(::ToDoItem)
    })

    class ToDoItem(parent: Matcher<View>) : KRecyclerItem<ToDoItem>(parent), TextViewAssertions {
        val todoTitle = KTextView(parent) { withId(R.id.title) }
        val todoStarButton = KButton(parent) { withId(R.id.star) }
        val todoImageOwnerAvatar = KImageView(parent) { withId(R.id.owner_avatar) }
        val todoOwnerName = KTextView(parent) { withId(R.id.owner) }
        val todoDueDate = KTextView(parent) { withId(R.id.due_date) }
        val todoTagsChipGroup = KChipGroup(parent) { withId(R.id.chip_group) }
        val todoCollapseButton = KImageView(parent) { withId(R.id.expand) }
        val todoStatusCategory = KTextView(parent) {
            isDescendantOfA { withId(R.id.tasks_list) }
            isDescendantOfA { withId(R.id.header_content) }
            withId(-1)
        }

        //To Do swipe action
        val todoSwipe = KSwipeView { withMatcher(parent) }
    }

    //Snack Bar
    val snackBarUndoButton = KTextView {
        withId(R.id.snackbar_action)
        withText("Undo")
    }

    //Bottom 3DotsMenu
    val todo3DotsButton = KImageView {
        isDescendantOfA {
            withId(R.id.bottomAppBar)
        }
        withContentDescription("More options")
    }

    //3DotsMenu items
    val todo3DotsButtonArchive = KTextView {
        withId(R.id.title)
        withText("Archive")
    }

    val todo3DotsButtonSettings = KTextView {
        withId(R.id.title)
        withText("Settings")
    }
}