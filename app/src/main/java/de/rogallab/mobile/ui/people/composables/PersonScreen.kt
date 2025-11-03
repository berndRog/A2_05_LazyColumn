package de.rogallab.mobile.ui.people.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import de.rogallab.mobile.domain.utilities.logComp
import de.rogallab.mobile.ui.base.CollectBy
import de.rogallab.mobile.ui.people.PersonViewModel
import de.rogallab.mobile.ui.people.PersonIntent

@Composable  // MVI pattern
fun PersonScreen(
   viewModel: PersonViewModel,
   modifier: Modifier = Modifier
) {
   val tag = "<-PersonScreen"
   val nComp = remember { mutableIntStateOf(1) }
   SideEffect { logComp(tag, "Composition #${nComp.value++}") }

// val personUiState by viewModel.personUiStateFlow.collectAsStateWithLifecycle()
   val personUiState = CollectBy(viewModel.personUiStateFlow, tag)

   Column(
      modifier = modifier.fillMaxSize()
   ) {
      InputName(
         name = personUiState.person.firstName,  // State ↓
         onNameChange = { firstName: String ->   // Event ↑
            viewModel.handlePersonIntent(PersonIntent.FirstNameChange(firstName))
         },
         label = "Vorname"
      )
      InputName(
         name = personUiState.person.lastName,   // State ↓
         onNameChange = { lastName: String ->    // Event ↑
            viewModel.handlePersonIntent(PersonIntent.LastNameChange(lastName))
         },
         label = "Nachname"
      )
   }

}