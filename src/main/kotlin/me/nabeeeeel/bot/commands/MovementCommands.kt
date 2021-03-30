package me.nabeeeeel.bot.commands

import dev.kord.common.Color
import dev.kord.common.entity.Snowflake
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.api.arguments.UserArg
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.data.Configuration
import me.nabeeeeel.bot.game.GameController
import dev.kord.core.behavior.channel.createMessage

// creates category
fun MovementCommands(configuration: Configuration) = commands("Utility") {

    command("PFP", "Profile") {
        description = "Did someone make their Profile Picture for ants? Well here ya go!"
        execute(UserArg("@username")) {

            val user = args.first
            respond {
                // thumbnail { url = user.avatar.url }
                title = "P R O F I L E  P I C  for ${user.username}"
                val s = "$user hello"
                image = user.avatar.url
                color = Color((0..255).random(), (0..255).random(), (0..255).random())
            }
        }
    }

    command("resize") {
        description = "Resize Window"
        execute() {
            val controller : GameController = GameController()
            controller.resize()
            val f = controller.getScreenShot()
            channel.createMessage {
                addFile(f.toPath())
            }

        }
    }

    command("Up", "W", "${Emojis.arrowUp}") {
        description = "Move Up"
        execute() {
            respond{
                title = "CURRENT GAME HERE"
                // image here
                color = Color(109, 17, 17)
                description = "Move Up"
            }
        }
    }

    command("Down", "S", "${Emojis.arrowDown}") {
        description = "Move Up"
        execute() {
            respond{
                title = "CURRENT GAME HERE"
                // image here
                color = Color(109, 17, 17)
                description = "Move Down"
            }
        }
    }

    command("Left", "A", "${Emojis.arrowLeft}") {
        description = "Move Up"
        execute() {
            respond{
                title = "CURRENT GAME HERE"
                // image here
                color = Color(109, 17, 17)
                description = "Move Left"
            }
        }
    }

    command("Right", "D", "${Emojis.arrowRight}") {
        description = "Move Up"
        execute() {
            respond{
                title = "CURRENT GAME HERE"
                // image here
                color = Color(109, 17, 17)
                description = "Move Right"
            }
        }
    }

}