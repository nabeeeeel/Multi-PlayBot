package me.nabeeeeel.bot.preconditions

import me.jakejmattson.discordkt.api.dsl.precondition
import me.nabeeeeel.bot.services.BooleanServices.Companion.commandInProgress

fun botPrecondition() = precondition {
    if (commandInProgress)
        fail("")
}