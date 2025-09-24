package de.rogallab.mobile.di

import de.rogallab.mobile.data.local.DataStore
import de.rogallab.mobile.data.local.Seed
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

   logInfo(tag, "single    -> Seed")
   single<Seed> {
      Seed()
   }

   logInfo(tag, "single    -> DataStore")
   single {
      DataStore(
         _context = androidContext(),  // dependency injection of Android context
         _seed = get<Seed>()           // dependency injection of Seed
      )
   }

   logInfo(tag, "single    -> PersonRepository: IPersonRepository")
   single<IPersonRepository> {
      PersonRepository(
         _dataStore = get<DataStore>()  // dependency injection of DataStore
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