package ru.wb.ui.ui.screens.profile.view

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.UserData
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel

internal class ProfileViewScreenViewModel(
    private val getUserData: GetUserDataUseCase
): BaseViewModel<ProfileViewScreenViewModel.Event>() {
    private val _userData = MutableStateFlow(UserData.defaultObject)
    private val userData: StateFlow<UserData> = _userData

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    fun getUserFlow(): StateFlow<UserData> = userData

    fun getStateFlow(): StateFlow<BaseState> = state

    private fun startLoading() = viewModelScope.launch {
        _state.emit(BaseState.LOADING)
        getUserData.execute(id = _userData.value.id).collect {
            when {
                it.id.isEmpty() -> BaseState.ERROR
                else -> {
                    _state.emit(BaseState.SUCCESS)
                    _userData.emit(it)
                }
            }
        }
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
        }
    }
}