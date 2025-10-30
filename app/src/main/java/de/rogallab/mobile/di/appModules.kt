package de.rogallab.mobile.di

import de.rogallab.mobile.data.IDataStore
import de.rogallab.mobile.data.local.dataStore.DataStore
import de.rogallab.mobile.data.repositories.PersonRepository
import de.rogallab.mobile.domain.IPersonRepository
import de.rogallab.mobile.domain.utilities.logInfo
import de.rogallab.mobile.ui.people.PersonViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val defModules: Module = module {
   val tag = "<-defModules"

   logInfo(tag, "single    -> DataStore: IDataStore")
   single<IDataStore> {
      DataStore(
         context = androidContext(),
         directoryName = null,
         fileName = null
      )
   }

   logInfo(tag, "single    -> PersonRepository: IPersonRepository")
   single<IPersonRepository> {
      PersonRepository(
         _dataStore = get<IDataStore>()
      )
   }

   logInfo(tag, "viewModel -> PersonViewModel")
   viewModel {
      PersonViewModel(
         _repository = get<IPersonRepository>(),
      )
   }
}

val appModules: Module = module {
   try {
      val testedModules = defModules
      requireNotNull(testedModules) {
         "defineModules failed"
      }
      logInfo("<-appModules", "include testedModules")
      includes(
         testedModules,
         //testedUiModules,
         //useCaseModules
      )
   } catch (e: Exception) {
      logInfo("<-appModules", e.message!!)
   }
}