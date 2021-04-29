package me.nabeeeeel.bot.commands

import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.entity.ReactionEmoji
import dev.kord.x.emoji.DiscordEmoji
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.api.dsl.CommandEvent
import me.jakejmattson.discordkt.api.dsl.DiscordContext
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.services.BooleanServices.Companion.commandInProgress
import me.nabeeeeel.bot.services.ControllerService

fun buttonCommands(controller: ControllerService) = commands("Button") {
    suspend fun CommandEvent<*>.pressButton(reaction: DiscordEmoji, action: (ControllerService) -> Unit) {
        commandInProgress = true

        controller.resize()
        action.invoke(controller)
        reactWith(reaction)

        channel.createMessage {
            addFile(controller.getScreenShot().toPath())
        }

        commandInProgress = false
    }

    command("Up", "U", "${Emojis.arrowUp}") {
        description = "Move Up"
        execute {
            pressButton(Emojis.arrowUp) { it.pressUp() }
        }
    }

    command("Down", "D", "${Emojis.arrowDown}") {
        description = "Move Down"
        execute {
            pressButton(Emojis.arrowDown) { it.pressDown() }
        }
    }

    command("Left", "L", "${Emojis.arrowLeft}") {
        description = "Move Left"
        execute {
            pressButton(Emojis.arrowLeft) { it.pressLeft() }
        }
    }

    command("Right", "R", "${Emojis.arrowRight}") {
        description = "Move Right"
        execute {
            pressButton(Emojis.arrowRight) { it.pressRight() }
        }
    }

    command("A", "${Emojis.regionalIndicatorA}") {
        description = "Press the 'A' button!"
        execute {
            pressButton(Emojis.regionalIndicatorA) { it.pressA() }
        }
    }

    command("B", "${Emojis.regionalIndicatorB}") {
        description = "Press the 'B' button!"
        execute {
            pressButton(Emojis.regionalIndicatorB) { it.pressB() }
        }
    }

    command("Start") {
        description = "Press the 'Start' button!"
        execute {
            pressButton(Emojis.ballotBoxWithCheck) { it.pressStart() }
        }
    }

    command("Select") {
        description = "Press the 'Select' button!"
        execute {
            pressButton(Emojis.ballotBoxWithCheck) { it.pressSelect() }
        }
    }
}