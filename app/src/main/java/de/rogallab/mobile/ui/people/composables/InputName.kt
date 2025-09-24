package de.rogallab.mobile.ui.people.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import de.rogallab.mobile.domain.utilities.logDebug
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun InputName(   // with local state
   name: String,                     // State ↓
   onNameChange: (String) -> Unit,   // Event ↑
   label: String = "Name"
) {

   TextField(
      modifier = Modifier
         .fillMaxWidth()
         .onFocusChanged { focusState ->
            if (!focusState.isFocused) {
               logDebug("<-InputName", "focus changed name:$name")
               onNameChange(name) // Event ↑
            }
         },
      value = name,
      onValueChange = { it: String ->
         logDebug("<-InputName", "onValueChange: $it")
         onNameChange(it) // Event ↑
      },
      label = { Text(text = label) },
      singleLine = true,
      isError =  name.length > 20,
      supportingText = {
         if (name.length > 20) {
            Text("Zu lang (maximal 20 Zeichen)")
         }
      },
      keyboardActions = KeyboardActions(
         onAny = {
               logDebug("<-InputName", "keyboardActions, onNameChange:$name")
               onNameChange(name) // Event ↑
         }
      ),
   )
}
