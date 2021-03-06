package com.example.android.trackr.screenobject

import com.example.android.trackr.R
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object ToDoDetailsScreen: Screen<ToDoDetailsScreen>() {

    val todoDetailsBackButton = KImageView {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        withContentDescription("Back")
    }

    val editToDoButton = KButton { withId(R.id.edit) }

    //To do Content

    val todoStarButton = KButton { withId(R.id.star) }
    val todoStatus = KTextView { withId(R.id.status) }
    val todoOwnerName = KTextView { withId(R.id.owner) }
    val todoCreator = KTextView { withId(R.id.creator) }
    val todoDueDate = KTextView { withId(R.id.due_date) }

    //TODO Scratch
    // The screen does not have a resource to explicitly compute the Description attribute
    val todoDescription = KTextView {
        isDescendantOfA { withId(R.id.scrolling_content) }
        isDescendantOfA { withId(R.id.content) }
        isDisplayed()
        withText("Once upon a time")
    }

}