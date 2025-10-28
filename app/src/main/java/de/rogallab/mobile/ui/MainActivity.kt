package de.rogallab.mobile.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.rogallab.mobile.domain.utilities.logInfo
import de.rogallab.mobile.ui.base.BaseActivity
import de.rogallab.mobile.ui.people.PersonViewModel
import de.rogallab.mobile.ui.people.composables.PeopleListScreen
import de.rogallab.mobile.ui.people.composables.PersonScreen
import de.rogallab.mobile.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(TAG) {

   // lazy initialization of the ViewModel with koin
   private val _personViewModel: PersonViewModel by viewModel()

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      enableEdgeToEdge()

      setContent {

         AppTheme {
            Scaffold(
               contentWindowInsets = WindowInsets.safeDrawing,
               modifier = Modifier
                  .padding(top = 8.dp)
                  .padding(horizontal = 16.dp)
                  .fillMaxSize()
            ) { innerPadding ->
//               TestLazyColumn(
//                  modifier = Modifier
//                     .padding(innerPadding)
//                     .padding(top = 8.dp)
//                     .fillMaxSize()
//               )

//               PersonScreen(
//                  viewModel = _personViewModel,
//                  modifier = Modifier
//                     .padding(innerPadding)
//                     .fillMaxSize()
//               )
               PeopleListScreen(
                  viewModel = _personViewModel,
                  modifier = Modifier
                     .padding(innerPadding)
                     .fillMaxSize()
               )
               logInfo(TAG, "personViewModel: ${_personViewModel.hashCode()}")
            }
         }
      }
   }

   companion object {
      private const val TAG = "<-MainActivity"
   }
}

@Preview(showBackground = true)
@Composable
fun Preview() {

   val viewModel = koinViewModel<PersonViewModel>()

   AppTheme {
      Scaffold(
         contentWindowInsets = WindowInsets.safeDrawing,
         modifier = Modifier
            .padding(top = 8.dp)
            .padding(horizontal = 16.dp)
            .fillMaxSize()
      ) { innerPadding ->
//       LazyColumnTest()
//         TaskItem1(
//            id = 1,                            // State ↓
//            label = "Task",                      // State ↓
//            onClose = {},              // Event ↑  IconButton
//            onClicked = {}            // Event ↑  TaskItem
//         )

         PeopleListScreen(
            viewModel = viewModel,
            modifier = Modifier
               .padding(innerPadding)
         )
      }
   }
}