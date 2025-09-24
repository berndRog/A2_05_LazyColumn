package de.rogallab.mobile.ui.people

import androidx.lifecycle.ViewModel
import de.rogallab.mobile.domain.IPersonRepository
import de.rogallab.mobile.domain.entities.Person
import de.rogallab.mobile.domain.utilities.logDebug
import de.rogallab.mobile.domain.utilities.logError
import de.rogallab.mobile.ui.base.updateState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// New version of PersonViewModel using updateState inline function
class PersonViewModel(
   private val _repository: IPersonRepository
): ViewModel() {

   // StateFlow PersonScreen
   private val _personUiStateFlow: MutableStateFlow<PersonUiState> = MutableStateFlow(PersonUiState())
   val personUiStateFlow: StateFlow<PersonUiState> = _personUiStateFlow.asStateFlow()

   // transform intent into an action
   fun handlePersonIntent(intent: PersonIntent) {
      when (intent) {
         is PersonIntent.FirstNameChange -> onFirstNameChange(intent.firstName)
         is PersonIntent.LastNameChange -> onLastNameChange(intent.lastName)
         is PersonIntent.FetchById -> fetchById(intent.id)
         is PersonIntent.Create -> create()
         is PersonIntent.Update -> update()
         is PersonIntent.Remove -> remove(intent.person)
      }
   }

   private fun onFirstNameChange(firstName: String) {
      updateState(_personUiStateFlow) {
         copy(person = person.copy(firstName = firstName.trim())) }
   }

   private fun onLastNameChange(lastName: String) {
      updateState(_personUiStateFlow) {
         copy(person = person.copy(lastName = lastName.trim())) }
   }

   private fun fetchById(id: String) {
      logDebug(TAG, "fetchById() $id")
      _repository.findById(id)
         .onSuccess { person ->
            updateState(_personUiStateFlow) { copy(person = person?: Person()) } // if null, create an empty
         }
         .onFailure { logError(TAG, it.message ?: "Error in fetchById") }
   }

   private fun create() {
      logDebug(TAG, "createPerson")
      _repository.create(_personUiStateFlow.value.person)
         .onSuccess { fetch() } // reread all people
         .onFailure { logError(TAG, it.message ?: "Error in create") }
   }

   private fun update() {
      logDebug(TAG, "updatePerson()")
      _repository.update(_personUiStateFlow.value.person)
         .onSuccess { fetch() } // reread all people
         .onFailure { logError(TAG, it.message ?: "Error in update") }
   }

   private fun remove(person: Person) {
      logDebug(TAG, "removePerson()")
      _repository.remove(person)
         .onSuccess { fetch() } // reread all people
         .onFailure { logError(TAG, it.message ?: "Error in remove") }
   }

   // StateFlow PeopleListScreen
   private var _peopleUiStateFlow: MutableStateFlow<PeopleUiState> = MutableStateFlow(PeopleUiState())
   val peopleUiStateFlow: StateFlow<PeopleUiState> = _peopleUiStateFlow.asStateFlow()

   // transform intent into an action
   fun handlePeopleIntent(intent: PeopleIntent) {
      when (intent) {
         is PeopleIntent.Fetch -> fetch()
      }
   }

   // read all people from repository
   private fun fetch() {
      logDebug(TAG, "fetch")
      _repository.getAll()
         .onSuccess { people ->
            updateState(_peopleUiStateFlow) { copy(people = people ?: emptyList()) }
         }
         .onFailure { logError(TAG, it.message ?: "Error in fetch") }
   }

   companion object {
      private const val TAG = "<-PersonViewModel"
   }
}