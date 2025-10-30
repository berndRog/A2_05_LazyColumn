package de.rogallab.mobile.domain.entities

import androidx.compose.runtime.Immutable
import de.rogallab.mobile.domain.utilities.newUuid
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class Person(
   val firstName: String = "",
   val lastName: String = "",
   val email: String? = "",
   val phone: String? = "",
   val imagePath: String? = null,
   val id: String = newUuid(),
)