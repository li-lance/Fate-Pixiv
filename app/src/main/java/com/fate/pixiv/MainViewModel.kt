package com.driver.tsla

import androidx.lifecycle.ViewModel
import com.driver.tsla.IMainViewModel.Errors.ErrorsState
import com.driver.tsla.IMainViewModel.Inputs.InputsState
import com.driver.tsla.IMainViewModel.Outputs.OutputsState
import com.driver.tsla.data.Pokemon
import com.driver.tsla.services.ApiService
import com.fate.core.Environment
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Author：lance.li on 3/5/21 13:38
 * email：foryun@live.com
 */
interface IMainViewModel {
  interface Inputs {
    fun setId(id: String)

    data class InputsState(
      val id: String = "un",
      val application: String = "test",
    )
  }

  interface Outputs {
    data class OutputsState(
      val list: MutableList<Pokemon> = mutableListOf()
    )
  }

  interface Errors {
    data class ErrorsState(val error: String = "")
  }

  @HiltViewModel
  class MainViewModel @Inject constructor(
    private val environment: Environment,
    private val apiService: ApiService
  ) : ViewModel(), Inputs, Outputs, Errors {
    val inputsState = MutableStateFlow(InputsState())
    val outputsState = MutableSharedFlow<OutputsState>()
    val errorsState = MutableSharedFlow<ErrorsState>()

    val inputs: Inputs = this
    val outputs: Outputs = this
    val errors: Errors = this

    init {
      st()
    }

    fun st() {
//    Logger.e { state.application }
    }

    override fun setId(id: String) {
      inputsState.map {
        it.copy(id = "uuid")
      }.asNullableFlow()
    }
  }
}

fun <T> kotlinx.coroutines.flow.Flow<T>.asNullableFlow(): kotlinx.coroutines.flow.Flow<T?> = flow {
  emit(null)
  collect { emit(it) }
}