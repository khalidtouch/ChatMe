package com.khalidtouch.chatme.core.ui

import androidx.compose.foundation.gestures.DraggableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.khalidtouch.chatme.core.designsystem.components.ReadState
import com.khalidtouch.chatme.core.designsystem.components.TabState
import com.khalidtouch.chatme.core.designsystem.components.TabType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainTabViewModel @Inject constructor() : ViewModel() {
    private val _selectedTabIndex: MutableLiveData<Int> = MutableLiveData(0)
    val selectedTabIndex: LiveData<Int> = _selectedTabIndex
    val Tabs = MainTabs.values().toList()
    var isSwipeLeft: Boolean = false
    private val draggableState = DraggableState { delta ->
        isSwipeLeft = delta > 0
    }
    private val _dragState = MutableLiveData<DraggableState>(draggableState)
    val dragState: LiveData<DraggableState> = _dragState

    fun updateTabIndexBasedOnSwipe() {
        _selectedTabIndex.value = when (isSwipeLeft) {
            true -> Math.floorMod(_selectedTabIndex.value!!.plus(1), Tabs.size)
            false -> Math.floorMod(_selectedTabIndex.value!!.minus(1), Tabs.size)
        }
    }

    fun updateTabIndex(i: Int) {
        _selectedTabIndex.value = i
    }

}


enum class MainTabs(val state: TabState) {
    Chats(
        state = TabState(
            type = TabType.CHATS,
            state = ReadState.Unread
        )
    ),
    Status(
        state = TabState(
            type = TabType.EXTRAS,
            state = ReadState.Read
        )
    ),
    Calls(
        state = TabState(
            type = TabType.EXTRAS,
            state = ReadState.Unread
        )
    )
}