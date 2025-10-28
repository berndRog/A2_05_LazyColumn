package de.rogallab.mobile.ui.people.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.rogallab.mobile.domain.utilities.logComp

@Composable
fun PersonListItem(
   id: String,                      // State ↓
   firstName: String,               // State ↓
   lastName: String,                // State ↓
   onClicked: (String) -> Unit,     // Event ↑
   onDeleted: (String) -> Unit      // Event ↑
) {
   val tag = "<- PersonListItem"
   val nComp = remember { mutableIntStateOf(1) }
   SideEffect { logComp(tag, "Composition #${nComp.value++}") }

   Column {
      Row(
         verticalAlignment = Alignment.CenterVertically,
         modifier = Modifier
            .padding(vertical = 4.dp)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable { onClicked(id) }
      ) {
         Text(
            modifier = Modifier
               .weight(0.9f).padding(start = 4.dp)
               .clickable { onClicked(id) },
            text = "$firstName $lastName",
            fontSize = 20.sp
         )

         IconButton(
            onClick = {  onDeleted(id)  }, // Event ↑
            modifier = Modifier
               .weight(0.1f).padding(end = 4.dp)
         ) {
            Icon(
               imageVector = Icons.Filled.Close,
               contentDescription = "Delete item"
            )
         }
      }
   }
}