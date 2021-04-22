@file:JvmName("BooleanServices") //This provides a name for this file, so it's not defaulted as [KotlinClassKt] in Java
package me.nabeeeeel.bot.services

class BooleanServices {

    companion object {

        //This annotation tells Kotlin to not generate the getter/setter functions in Java. Instead, this variable should be accessed directly
        //Also, this is similar to [@JvmStatic], in which it tells Java to treat this as a static variable to [KotlinClass].
        @JvmField
        var commandInProgress : Boolean = false
    }
}
