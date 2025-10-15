package de.rogallab.mobile.data.local

import de.rogallab.mobile.domain.entities.Person
import de.rogallab.mobile.domain.utilities.newUuid
import java.util.Locale
import kotlin.random.Random

class Seed {

   var people: MutableList<Person> = mutableListOf<Person>()

   init {
      val firstNames = mutableListOf(
         "Arne", "Berta", "Cord", "Dagmar", "Ernst", "Frieda", "Günter", "Hanna",
         "Ingo", "Johanna", "Klaus", "Luise", "Martin", "Nadja", "Otto", "Patrizia",
         "Quirin", "Rebecca", "Stefan", "Tanja", "Uwe", "Veronika", "Walter", "Xaver",
         "Yvonne", "Zwantje")
      val lastNames = mutableListOf(
         "Arndt", "Bauer", "Conrad", "Diehl", "Engel", "Fischer", "Graf", "Hoffmann",
         "Imhoff", "Jung", "Klein", "Lang", "Meier", "Neumann", "Olbrich", "Peters",
         "Quart", "Richter", "Schmidt", "Thormann", "Ulrich", "Vogel", "Wagner", "Xander",
         "Yakov", "Zander")
      val random = Random(0)
      for (index in firstNames.indices) {
//         var indexFirst = random.nextInt(firstNames.size)
//         var indexLast = random.nextInt(lastNames.size)
         val firstName = firstNames[index]
         val lastName = lastNames[index]
         val uuidString = String.format(Locale.ROOT, "%02d000000-0000-0000-0000-000000000000", index+1)
         val person = Person(firstName, lastName, uuidString)
         people.add(person)
      }
   }
}