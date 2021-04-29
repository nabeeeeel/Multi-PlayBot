package me.nabeeeeel.bot.commands

import dev.kord.common.Color
import dev.kord.core.behavior.channel.createMessage
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.data.Configuration
import me.nabeeeeel.bot.game.GameController
import me.nabeeeeel.bot.services.BooleanServices.Companion.commandInProgress

// creates category
fun MovementCommands(configuration: Configuration) = commands("Movement") {

    // TODO:
    command("Up", "U","${Emojis.arrowUp}") {
        description = "Move Up"
        execute {
            commandInProgress = true
            val controller = GameController()
            controller.resize()
            controller.pressUp()
            val f = controller.getScreenShot()
            respond{
                title = "Pokemon Emerald"
                // image here
                color = Color(109, 17, 17)
                description = "Move Up"
            }
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
            val f = controller.getScreenShot()
            respond{
                title = "Pokemon Emerald"
                // image here
                color = Color(109, 17, 17)
                description = "Move Down"
            }
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
            val f = controller.getScreenShot()
            respond{
                title = "Pokemon Emerald"
                // image here
                color = Color(109, 17, 17)
                description = "Move Left"
            }
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
            val f = controller.getScreenShot()
            respond{
                title = "Pokemon Emerald"
                // image here
                color = Color(109, 17, 17)
                description = "Move Right"
            }
            channel.createMessage {
                addFile(f.toPath())
            }
            commandInProgress = false
        }
    }

}