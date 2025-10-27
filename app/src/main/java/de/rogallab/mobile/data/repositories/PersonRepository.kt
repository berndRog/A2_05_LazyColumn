package de.rogallab.mobile.data.repositories

import de.rogallab.mobile.data.IDataStore
import de.rogallab.mobile.domain.IPersonRepository
import de.rogallab.mobile.domain.entities.Person
import de.rogallab.mobile.domain.utilities.logInfo
import kotlin.text.insert

class PersonRepository(
   private val _dataStore: IDataStore  // ctor injection
) : IPersonRepository {

   override fun getAll(): Result<List<Person>> =
      tryCatching { _dataStore.selectAll() }

   override fun getAllSortedBy(selector: (Person) -> String?): Result<List<Person>> =
      tryCatching { _dataStore.selectAllSortedBy(selector) }

   override fun getWhere(predicate: (Person) -> Boolean): Result<List<Person>> =
      tryCatching { _dataStore.selectWhere(predicate) }

   override fun findById(id: String): Result<Person?> =
      tryCatching { _dataStore.findById(id) }

   override fun findBy(predicate: (Person) -> Boolean): Result<Person?> =
      tryCatching { _dataStore.findBy(predicate) }

   override fun create(person: Person): Result<Unit> =
      tryCatching { _dataStore.insert(person) }

   override fun update(person: Person): Result<Unit> =
      tryCatching { _dataStore.update(person) }

   override fun remove(person: Person): Result<Unit> =
      tryCatching { _dataStore.delete(person) }

}