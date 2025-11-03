package de.rogallab.mobile.ui.people.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import de.rogallab.mobile.domain.entities.Person
import de.rogallab.mobile.domain.utilities.as8
import de.rogallab.mobile.domain.utilities.logComp
import de.rogallab.mobile.domain.utilities.logDebug
import de.rogallab.mobile.domain.utilities.logInfo
import de.rogallab.mobile.domain.utilities.logVerbose
import de.rogallab.mobile.ui.MainActivity
import de.rogallab.mobile.ui.base.CollectBy
import de.rogallab.mobile.ui.people.PeopleIntent
import de.rogallab.mobile.ui.people.PersonViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.viewmodel.koinActivityViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleListScreen(
   viewModel: PersonViewModel = koinActivityViewModel(),
   modifier: Modifier = Modifier
) {
   val tag = "<-PeopleListScreen"
   val nComp = remember { mutableIntStateOf(1) }
   SideEffect { logComp(tag, "Composition #${nComp.value++}") }

   // observe the peopleUiStateFlow in the ViewModel, notify when the state changes
   // val peopleUiState by viewModel.peopleUiStateFlow.collectAsStateWithLifecycle()
   val peopleUiState = CollectBy(viewModel.peopleUiStateFlow, tag)

   // read all people from repository, when the screen is created
   LaunchedEffect(Unit) {
      logVerbose(tag, "readPeople()")
      viewModel.handlePeopleIntent(PeopleIntent.Fetch)
   }

   SideEffect{ logVerbose(tag, "Show Lazy Column (visual items)")}

   LazyColumn(
      modifier = modifier,
      verticalArrangement = Arrangement.spacedBy(4.dp)
   ) {
      items(
         items = peopleUiState.people,
         key = { it: Person -> it.id }
      ) { person ->
         SideEffect {
            logVerbose(tag, "Lazy Column, size:${peopleUiState.people.size} - Person: ${person.firstName}")}

         Row(
            modifier = Modifier
               .padding(bottom = 8.dp)
               .background(color = MaterialTheme.colorScheme.surfaceVariant)
               .fillMaxWidth()
               .clickable {
                  logDebug(tag, "Details clicked")
               },
            verticalAlignment = Alignment.CenterVertically,
         ) {
            Text(
               modifier = Modifier
                  .padding(start = 8.dp)
                  .weight(0.9f),
               text = "${person.firstName}  ${person.lastName}")
            IconButton(
               modifier = Modifier
                  .weight(0.1f),
               onClick = {
                  logDebug(tag, "Delete clicked")
               }
            ) {
               Icon(
                  imageVector = Icons.Outlined.Delete, // Icons.Rounded.Close,
                  contentDescription = "Delete person",
               )
            }
         }
      }

//         PersonListItem(
//            id = person.id,
//            firstName = person.firstName,
//            lastName = person.lastName,
//            onClicked = { id: String ->
//               logDebug(tag, "Details clicked")
//            },
//            onDeleted = { id: String ->
//               logDebug(tag, "Delete clicked}")
//               //viewModel.onProcessIntent(PersonIntent.Remove(person))
//            }
//         )
//      }

   }
}

