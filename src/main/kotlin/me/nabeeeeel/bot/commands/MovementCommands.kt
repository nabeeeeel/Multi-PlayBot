package me.nabeeeeel.bot.commands

import dev.kord.core.behavior.channel.createMessage
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.data.Configuration
import me.nabeeeeel.bot.game.GameController
import me.nabeeeeel.bot.services.BooleanServices.Companion.commandInProgress

// creates category
fun MovementCommands(configuration: Configuration) = commands("Movement") {

    // TODO:
    command("Up", "U", "${Emojis.arrowUp}") {
        description = "Move Up"
        execute {
            commandInProgress = true
            val controller = GameController()
            controller.resize()
            controller.pressUp()
            reactWith(Emojis.arrowUp)
            val f = controller.getScreenShot()

            channel.createMessage {
                addFile(f.toPath())
            }

            commandInProgress = false
        }
    }

    // TODO:
    command("Down", "D", "${Emojis.arrowDown}") {
        description = "Move Down"
        execute {
            commandInProgress = true
            val controller = GameController()
            controller.resize()
            controller.pressDown()
            reactWith(Emojis.arrowDown)
            val f = controller.getScreenShot()

            channel.createMessage {
                addFile(f.toPath())
            }

            commandInProgress = false
        }
    }

    // TODO:
    command("Left", "L", "${Emojis.arrowLeft}") {
        description = "Move Left"
        execute {
            commandInProgress = true
            val controller = GameController()
            controller.resize()
            controller.pressLeft()
            reactWith(Emojis.arrowLeft)
            val f = controller.getScreenShot()

            channel.createMessage {
                addFile(f.toPath())
            }

            commandInProgress = false
        }
    }

    // TODO:
    command("Right", "R", "${Emojis.arrowRight}") {
        description = "Move Right"
        execute {
            commandInProgress = true
            val controller = GameController()
            controller.resize()
            controller.pressRight()
            reactWith(Emojis.arrowRight)
            val f = controller.getScreenShot()

            channel.createMessage {
                addFile(f.toPath())
            }

            commandInProgress = false
        }
    }

}