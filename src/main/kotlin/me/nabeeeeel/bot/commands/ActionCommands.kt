package me.nabeeeeel.bot.commands

import dev.kord.common.Color
import dev.kord.common.entity.Snowflake
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.api.arguments.UserArg
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.data.Configuration
import me.nabeeeeel.bot.game.GameController
import dev.kord.core.behavior.channel.createMessage
import me.nabeeeeel.bot.services.BooleanServices
import me.nabeeeeel.bot.services.BooleanServices.Companion.commandInProgress
import java.awt.Robot


fun ActionCommands(configuration: Configuration) = commands("Actions") {

    command("resize") {
        description = "Resize Window"
        execute() {
            commandInProgress = true
            val controller = GameController()
            controller.resize()
            val f = controller.getScreenShot()
            channel.createMessage {
                addFile(f.toPath())
            }
            commandInProgress= false
        }
    }

    command("A", "${Emojis.regionalIndicatorA}") {
        description = "Press the 'A' button!"
        execute() {
            commandInProgress = true
            val controller = GameController()
            controller.resize()
            controller.pressA()
            val f = controller.getScreenShot()
            respond{
                title = "Pokemon Emerald"
                // image here
                color = Color(109, 17, 17)
                description = "Pressed A"
            }
            channel.createMessage {
                addFile(f.toPath())
            }
            commandInProgress= false
        }
    }

    command("B", "${Emojis.regionalIndicatorB}") {
        description = "Press the 'B' button!"
        execute() {
            commandInProgress = true
            val controller = GameController()
            controller.resize()
            controller.pressB()
            val f = controller.getScreenShot()
            respond{
                title = "Pokemon Emerald"
                // image here
                color = Color(109, 17, 17)
                description = "Pressed B"
            }
            channel.createMessage {
                addFile(f.toPath())
            }
            commandInProgress= false
        }
    }

    command("Start") {
        description = "Press the 'Start' button!"
        execute() {
            commandInProgress = true
            val controller = GameController()
            controller.resize()
            controller.pressStart()
            val f = controller.getScreenShot()
            respond{
                title = "Pokemon Emerald"
                // image here
                color = Color(109, 17, 17)
                description = "Pressed Start"
            }
            channel.createMessage {
                addFile(f.toPath())
            }
            commandInProgress= false
        }
    }

    command("Select") {
        description = "Press the 'Select' button!"
        execute() {
            commandInProgress = true
            val controller = GameController()
            controller.resize()
            controller.pressSelect()
            val f = controller.getScreenShot()
            respond{
                title = "Pokemon Emerald"
                // image here
                color = Color(109, 17, 17)
                description = "Pressed Select"
            }
            channel.createMessage {
                addFile(f.toPath())
            }
            commandInProgress= false
        }
    }
}