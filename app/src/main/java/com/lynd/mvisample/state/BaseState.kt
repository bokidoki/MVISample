package com.lynd.mvisample.state

open class BaseState {
	//	loading state
	object OnLoading : BaseState()
	object FinishLoadingState : BaseState()

	//	data state
	class ErrorState(err: String) : BaseState()
}