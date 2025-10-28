package de.rogallab.mobile.ui.people.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import de.rogallab.mobile.domain.entities.Person
import de.rogallab.mobile.domain.utilities.as8
import de.rogallab.mobile.domain.utilities.logComp
import de.rogallab.mobile.domain.utilities.logDebug
import de.rogallab.mobile.domain.utilities.logInfo
import de.rogallab.mobile.domain.utilities.logVerbose
import de.rogallab.mobile.ui.people.PeopleIntent
import de.rogallab.mobile.ui.people.PersonViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleListScreen(
   viewModel: PersonViewModel,
   modifier: Modifier = Modifier
) {
   val tag = "<-PeopleListScreen"
   val nComp = remember { mutableIntStateOf(1) }
   SideEffect { logComp(tag, "Composition #${nComp.value++}") }

   // observe the peopleUiStateFlow in the ViewModel, notify when the state changes
   val peopleUiState by viewModel.peopleUiStateFlow.collectAsStateWithLifecycle()

   // read all people from repository, when the screen is created
   LaunchedEffect(Unit) {
      logVerbose(tag, "readPeople()")
      viewModel.handlePeopleIntent(PeopleIntent.Fetch)
   }

   LazyColumn(
      modifier = modifier,
      verticalArrangement = Arrangement.spacedBy(4.dp)
   ) {
      items(
         items = peopleUiState.people,
         key = { it: Person -> it.id }
      ) { person ->
         PersonListItem(
            id = person.id,
            firstName = person.firstName,
            lastName = person.lastName,
            onClicked = { id: String ->
               logInfo(tag, "Person clicked: ${id.as8()}")
            },
            onDeleted = { id: String ->
               logDebug(tag, "Person deleted: ${id.as8()}")
               //viewModel.onProcessIntent(PersonIntent.Remove(person))
            }
         )
      }

   }
}