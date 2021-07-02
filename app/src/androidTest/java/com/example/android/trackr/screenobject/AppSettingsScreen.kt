package com.example.android.trackr.screenobject

import android.view.View
import androidx.test.espresso.DataInteraction
import com.example.android.trackr.R
import io.github.kakaocup.kakao.list.KAbsListView
import io.github.kakaocup.kakao.list.KAdapterItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher

object AppSettingsScreen: Screen<AppSettingsScreen>() {

    //App settings list
    val appSettingsList: KRecyclerView = KRecyclerView({
        withId(R.id.recycler_view)
    }, itemTypeBuilder = {
        itemType(::SettingsItem)
    })

    class SettingsItem(parent: Matcher<View>) : KRecyclerItem<SettingsItem>(parent),
        TextViewAssertions

    //Theme changer window

    val themeSettingsListView = KAbsListView(
        builder = {
            withId(R.id.select_dialog_listview)
        },
        itemTypeBuilder = {
            itemType(::ThemeSettingsListItem)
        }
    )

    class ThemeSettingsListItem(parent: DataInteraction) : KAdapterItem<ThemeSettingsListItem>(parent),
        TextViewAssertions
}