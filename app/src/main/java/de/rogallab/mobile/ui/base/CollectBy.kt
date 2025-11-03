package de.rogallab.mobile.ui.base

import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import de.rogallab.mobile.domain.utilities.logVerbose
import kotlinx.coroutines.flow.StateFlow
import kotlin.toString

//   observe the personUiStateFlow in the ViewModel
//   val lifecycle = (LocalActivity.current as? ComponentActivity)?.lifecycle
//      ?: LocalLifecycleOwner.current.lifecycle
//   val personUiState by viewModel.personUiStateFlow.collectAsStateWithLifecycle(
//      lifecycle = lifecycle,
//      minActiveState = Lifecycle.State.STARTED
//   )
//   LaunchedEffect(personUiState.person) {
//      logDebug(tag, "PersonUiState: ${personUiState.person}")
//   }
@Composable
fun <T> CollectBy (uiStateFlow: StateFlow<T>, tag:String ): T {

   val lifecycleOwner = (LocalActivity.current as? ComponentActivity)
      ?: LocalLifecycleOwner.current
   val lifecycle = lifecycleOwner.lifecycle
   val uiState: T by uiStateFlow.collectAsStateWithLifecycle(
      lifecycle = lifecycle,
      minActiveState = Lifecycle.State.STARTED
   )
   LaunchedEffect(uiState) {
      logVerbose(tag, "lifecycleOwner:${lifecycleOwner.toString()} lifecycle.State:${lifecycle.currentState.toString()}")
      logVerbose(tag, "${uiState.toString()}")
   }
   return uiState
}