package de.rogallab.mobile.test.di

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import de.rogallab.mobile.data.IDataStore
import de.rogallab.mobile.data.local.dataStore.DataStore
import de.rogallab.mobile.data.repositories.PersonRepository
import de.rogallab.mobile.domain.IPersonRepository
import de.rogallab.mobile.domain.utilities.logInfo
import de.rogallab.mobile.domain.utilities.newUuid
import de.rogallab.mobile.ui.people.PersonViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import kotlin.random.Random

val defModulesTest: Module = module {
   val tag = "<-defModulesTest"

   logInfo(tag, "test single    -> InstrumentationRegistry.getInstrumentation().targetContext")
   single<Context> {
      InstrumentationRegistry.getInstrumentation().targetContext
   }

   // use factory to get a new instance each time (to avoid data conflicts in tests)
   logInfo(tag, "test single    -> DataStore: DataStore")
   single<IDataStore> {
      DataStore(
         context = get<Context>(),
         directoryName = "androidTest",
         fileName = "testPeople_${newUuid()}"
      )
   }

   logInfo(tag, "test single    -> PersonRepository: IPersonRepository")
   single<IPersonRepository> {
      PersonRepository(
         _dataStore = get<IDataStore>()  // dependency injection of DataStore
      )
   }

   logInfo(tag, "test viewModel -> PersonViewModel")
   factory {
      PersonViewModel(
         _repository = get<IPersonRepository>(),
      )
   }
}