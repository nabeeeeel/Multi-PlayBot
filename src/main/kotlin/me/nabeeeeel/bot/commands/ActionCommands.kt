package me.nabeeeeel.bot.commands

import dev.kord.core.behavior.channel.createMessage
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.services.BooleanServices.Companion.commandInProgress
import me.nabeeeeel.bot.services.ControllerService

fun actionCommands() = commands("Actions") {
    command("resize") {
        description = "Resize Window"
        execute {
            commandInProgress = true
            val controller = ControllerService()
            controller.resize()
            val f = controller.getScreenShot()

            channel.createMessage {
                addFile(f.toPath())
            }

            commandInProgress = false
        }
    }
}