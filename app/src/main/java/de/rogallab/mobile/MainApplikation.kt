package de.rogallab.mobile

import android.app.Application
import de.rogallab.mobile.data.IDataStore
import de.rogallab.mobile.di.appModules
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

   override fun onCreate() {
      super.onCreate()

      // Initialize any global state or dependencies here
      // Composition Root for Koin
      startKoin {
         androidLogger(Level.DEBUG)
         androidContext(androidContext = this@MainApplication)
         modules(appModules)
      }

      val dataStore = get<IDataStore>()
      dataStore.initialize()

   }

   companion object {
      private const val TAG = "<-MainApplication"
   }
}