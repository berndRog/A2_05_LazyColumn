package de.rogallab.mobile.data

import de.rogallab.mobile.domain.entities.Person
import kotlinx.serialization.json.Json
import java.io.File

fun initJsonFile(pathName: String): MutableList<Person> {
   // Json serializer
   val json = Json {
      prettyPrint = true
      ignoreUnknownKeys = true
   }
   File(pathName).writeText("") // clear file
   File(pathName).writeText(jsonString) // write jsonString to file
   // decode people from given JSON String
   return json.decodeFromString<MutableList<Person>>(jsonString)
}

val jsonString = "[\n" +
   "    {\n" +
   "        \"firstName\": \"Cord\",\n" +
   "        \"lastName\": \"Conrad\",\n" +
   "        \"email\": \"cord.conrad@yahoo.com\",\n" +
   "        \"phone\": \"02090 449-4317\",\n" +
   "        \"id\": \"89570803-0270-4b0d-9d4d-7eaa32b325d2\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Arne\",\n" +
   "        \"lastName\": \"Arndt\",\n" +
   "        \"email\": \"arne.arndt@freenet.de\",\n" +
   "        \"phone\": \"08253 607-668\",\n" +
   "        \"id\": \"92905fcb-8de3-4ec6-bc4b-a2de92397155\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Dagmar\",\n" +
   "        \"lastName\": \"Diehl\",\n" +
   "        \"email\": \"dagmar.diehl@yahoo.com\",\n" +
   "        \"phone\": \"01378 441-85\",\n" +
   "        \"id\": \"bb69d8b7-bc8d-4cc8-8f41-192ba3b2dd69\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Berta\",\n" +
   "        \"lastName\": \"Bauer\",\n" +
   "        \"email\": \"berta.bauer@gmail.com\",\n" +
   "        \"phone\": \"08826 412-6657\",\n" +
   "        \"id\": \"59d43933-9d36-48c5-94ce-d63b7f057842\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Ernst\",\n" +
   "        \"lastName\": \"Engel\",\n" +
   "        \"email\": \"ernst.engel@freenet.de\",\n" +
   "        \"phone\": \"06032 115-4373\",\n" +
   "        \"id\": \"d22dd863-af44-4555-882a-d360bae0dcc0\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Frieda\",\n" +
   "        \"lastName\": \"Fischer\",\n" +
   "        \"email\": \"frieda.fischer@gmail.com\",\n" +
   "        \"phone\": \"07892 511-1404\",\n" +
   "        \"id\": \"2edd0aa9-808d-4d22-8fc3-a0f3039f3659\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Günter\",\n" +
   "        \"lastName\": \"Graf\",\n" +
   "        \"email\": \"günter.graf@gmx.de\",\n" +
   "        \"phone\": \"02534 841-1038\",\n" +
   "        \"id\": \"658d7205-29b0-401b-9158-76ee1121ea02\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Hanna\",\n" +
   "        \"lastName\": \"Hoffmann\",\n" +
   "        \"email\": \"hanna.hoffmann@icloud.com\",\n" +
   "        \"phone\": \"01433 307-8585\",\n" +
   "        \"id\": \"bc2ec88d-38b7-4ec6-bf05-d9525fea6511\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Ingo\",\n" +
   "        \"lastName\": \"Imhoff\",\n" +
   "        \"email\": \"ingo.imhoff@mailbox.org\",\n" +
   "        \"phone\": \"04715 913-7426\",\n" +
   "        \"id\": \"bfb555d3-02b5-4fd4-81e5-685bc461d394\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Johanna\",\n" +
   "        \"lastName\": \"Jung\",\n" +
   "        \"email\": \"johanna.jung@gmail.com\",\n" +
   "        \"phone\": \"02666 545-2071\",\n" +
   "        \"id\": \"d0b61c37-5257-4ec6-9329-ae52140dca95\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Klaus\",\n" +
   "        \"lastName\": \"Klein\",\n" +
   "        \"email\": \"klaus.klein@mailbox.org\",\n" +
   "        \"phone\": \"03438 965-8188\",\n" +
   "        \"id\": \"2c725a4d-911e-44b9-82ea-b8db41e44b4a\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Luise\",\n" +
   "        \"lastName\": \"Lang\",\n" +
   "        \"email\": \"luise.lang@icloud.com\",\n" +
   "        \"phone\": \"04293 450-3325\",\n" +
   "        \"id\": \"2e530b39-a5e9-4ba3-9efc-d0bee6148462\"\n" +
   "    }\n" +
   "]"


/*
val jsonString = "[\n" +
   "    {\n" +
   "        \"firstName\": \"Cord\",\n" +
   "        \"lastName\": \"Conrad\",\n" +
   "        \"email\": \"cord.conrad@yahoo.com\",\n" +
   "        \"phone\": \"02090 449-4317\",\n" +
   "        \"id\": \"89570803-0270-4b0d-9d4d-7eaa32b325d2\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Arne\",\n" +
   "        \"lastName\": \"Arndt\",\n" +
   "        \"email\": \"arne.arndt@freenet.de\",\n" +
   "        \"phone\": \"08253 607-668\",\n" +
   "        \"id\": \"92905fcb-8de3-4ec6-bc4b-a2de92397155\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Dagmar\",\n" +
   "        \"lastName\": \"Diehl\",\n" +
   "        \"email\": \"dagmar.diehl@yahoo.com\",\n" +
   "        \"phone\": \"01378 441-85\",\n" +
   "        \"id\": \"bb69d8b7-bc8d-4cc8-8f41-192ba3b2dd69\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Berta\",\n" +
   "        \"lastName\": \"Bauer\",\n" +
   "        \"email\": \"berta.bauer@gmail.com\",\n" +
   "        \"phone\": \"08826 412-6657\",\n" +
   "        \"id\": \"59d43933-9d36-48c5-94ce-d63b7f057842\"\n" +
   "    },\n" +

   "    {\n" +
   "        \"firstName\": \"Ernst\",\n" +
   "        \"lastName\": \"Engel\",\n" +
   "        \"email\": \"ernst.engel@freenet.de\",\n" +
   "        \"phone\": \"06032 115-4373\",\n" +
   "        \"id\": \"d22dd863-af44-4555-882a-d360bae0dcc0\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Frieda\",\n" +
   "        \"lastName\": \"Fischer\",\n" +
   "        \"email\": \"frieda.fischer@gmail.com\",\n" +
   "        \"phone\": \"07892 511-1404\",\n" +
   "        \"id\": \"2edd0aa9-808d-4d22-8fc3-a0f3039f3659\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Günter\",\n" +
   "        \"lastName\": \"Graf\",\n" +
   "        \"email\": \"günter.graf@gmx.de\",\n" +
   "        \"phone\": \"02534 841-1038\",\n" +
   "        \"id\": \"658d7205-29b0-401b-9158-76ee1121ea02\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Hanna\",\n" +
   "        \"lastName\": \"Hoffmann\",\n" +
   "        \"email\": \"hanna.hoffmann@icloud.com\",\n" +
   "        \"phone\": \"01433 307-8585\",\n" +
   "        \"id\": \"bc2ec88d-38b7-4ec6-bf05-d9525fea6511\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Ingo\",\n" +
   "        \"lastName\": \"Imhoff\",\n" +
   "        \"email\": \"ingo.imhoff@mailbox.org\",\n" +
   "        \"phone\": \"04715 913-7426\",\n" +
   "        \"id\": \"bfb555d3-02b5-4fd4-81e5-685bc461d394\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Johanna\",\n" +
   "        \"lastName\": \"Jung\",\n" +
   "        \"email\": \"johanna.jung@gmail.com\",\n" +
   "        \"phone\": \"02666 545-2071\",\n" +
   "        \"id\": \"d0b61c37-5257-4ec6-9329-ae52140dca95\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Klaus\",\n" +
   "        \"lastName\": \"Klein\",\n" +
   "        \"email\": \"klaus.klein@mailbox.org\",\n" +
   "        \"phone\": \"03438 965-8188\",\n" +
   "        \"id\": \"2c725a4d-911e-44b9-82ea-b8db41e44b4a\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Luise\",\n" +
   "        \"lastName\": \"Lang\",\n" +
   "        \"email\": \"luise.lang@icloud.com\",\n" +
   "        \"phone\": \"04293 450-3325\",\n" +
   "        \"id\": \"2e530b39-a5e9-4ba3-9efc-d0bee6148462\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Martin\",\n" +
   "        \"lastName\": \"Meier\",\n" +
   "        \"email\": \"martin.meier@yahoo.com\",\n" +
   "        \"phone\": \"06211 508-793\",\n" +
   "        \"id\": \"a643cfdd-1bec-4fc7-afdf-33326406f724\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Nadja\",\n" +
   "        \"lastName\": \"Neumann\",\n" +
   "        \"email\": \"nadja.neumann@mailbox.org\",\n" +
   "        \"phone\": \"01761 784-9477\",\n" +
   "        \"id\": \"db0f4509-6235-4830-b908-de60187f5b08\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Otto\",\n" +
   "        \"lastName\": \"Olbrich\",\n" +
   "        \"email\": \"otto.olbrich@mailbox.org\",\n" +
   "        \"phone\": \"06356 663-489\",\n" +
   "        \"id\": \"cd21045f-8c89-4901-8575-b4cedf7059fc\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Patrizia\",\n" +
   "        \"lastName\": \"Peters\",\n" +
   "        \"email\": \"patrizia.peters@outlook.com\",\n" +
   "        \"phone\": \"09890 293-5927\",\n" +
   "        \"id\": \"0a0b64fa-7242-4ee3-b127-8bb11e0bb684\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Quirin\",\n" +
   "        \"lastName\": \"Quart\",\n" +
   "        \"email\": \"quirin.quart@freenet.de\",\n" +
   "        \"phone\": \"03318 895-8522\",\n" +
   "        \"id\": \"1f0dab0f-3d3f-46d3-a574-4fc5e6daefa3\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Rebecca\",\n" +
   "        \"lastName\": \"Richter\",\n" +
   "        \"email\": \"rebecca.richter@yahoo.com\",\n" +
   "        \"phone\": \"08941 589-5388\",\n" +
   "        \"id\": \"72daf2a9-b0b4-4c9a-b6c3-d889adcb3410\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Stefan\",\n" +
   "        \"lastName\": \"Schmidt\",\n" +
   "        \"email\": \"stefan.schmidt@gmx.de\",\n" +
   "        \"phone\": \"03232 119-8662\",\n" +
   "        \"id\": \"4c04274c-2b32-4654-beaf-93f5014626e0\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Tanja\",\n" +
   "        \"lastName\": \"Thormann\",\n" +
   "        \"email\": \"tanja.thormann@icloud.com\",\n" +
   "        \"phone\": \"08175 408-8019\",\n" +
   "        \"id\": \"10add880-635e-41a6-aed5-745325caf4f4\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Uwe\",\n" +
   "        \"lastName\": \"Ulrich\",\n" +
   "        \"email\": \"uwe.ulrich@yahoo.com\",\n" +
   "        \"phone\": \"01372 166-1165\",\n" +
   "        \"id\": \"56516882-7456-41f3-bbf0-3796ef33d036\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Veronika\",\n" +
   "        \"lastName\": \"Vogel\",\n" +
   "        \"email\": \"veronika.vogel@t-online.de\",\n" +
   "        \"phone\": \"04948 328-1720\",\n" +
   "        \"id\": \"5487cc8d-b754-49fe-8d6a-6d7bbe7dc809\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Walter\",\n" +
   "        \"lastName\": \"Wagner\",\n" +
   "        \"email\": \"walter.wagner@mailbox.org\",\n" +
   "        \"phone\": \"03773 198-6882\",\n" +
   "        \"id\": \"673241f8-ab50-47cc-a06c-c07498ea2518\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Xaver\",\n" +
   "        \"lastName\": \"Xander\",\n" +
   "        \"email\": \"xaver.xander@freenet.de\",\n" +
   "        \"phone\": \"04454 646-7113\",\n" +
   "        \"id\": \"d0c63155-d1e2-4c6b-be09-72bbc8b95926\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Yvonne\",\n" +
   "        \"lastName\": \"Yakov\",\n" +
   "        \"email\": \"yvonne.yakov@mailbox.org\",\n" +
   "        \"phone\": \"04136 782-9495\",\n" +
   "        \"id\": \"5c72e263-421f-49d8-8c89-3196bd31f13c\"\n" +
   "    },\n" +
   "    {\n" +
   "        \"firstName\": \"Zwantje\",\n" +
   "        \"lastName\": \"Zander\",\n" +
   "        \"email\": \"zwantje.zander@web.de\",\n" +
   "        \"phone\": \"08251 758-480\",\n" +
   "        \"id\": \"1beaa237-f46c-446a-9478-f18895b5b2c6\"\n" +
   "    }\n" +
   "]"
 */