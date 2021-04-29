package me.nabeeeeel.bot.commands

import dev.kord.core.behavior.channel.createMessage
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.services.BooleanServices.Companion.commandInProgress
import me.nabeeeeel.bot.services.ControllerService

fun buttonCommands(controller: ControllerService) = commands("Button") {
    command("Up", "U", "${Emojis.arrowUp}") {
        description = "Move Up"
        execute {
            commandInProgress = true
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

    command("Down", "D", "${Emojis.arrowDown}") {
        description = "Move Down"
        execute {
            commandInProgress = true
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

    command("Left", "L", "${Emojis.arrowLeft}") {
        description = "Move Left"
        execute {
            commandInProgress = true
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

    command("Right", "R", "${Emojis.arrowRight}") {
        description = "Move Right"
        execute {
            commandInProgress = true
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

    command("A", "${Emojis.regionalIndicatorA}") {
        description = "Press the 'A' button!"
        execute {
            commandInProgress = true
            controller.resize()
            controller.pressA()
            reactWith(Emojis.regionalIndicatorA)
            val f = controller.getScreenShot()

            channel.createMessage {
                addFile(f.toPath())
            }

            commandInProgress = false
        }
    }

    command("B", "${Emojis.regionalIndicatorB}") {
        description = "Press the 'B' button!"
        execute {
            commandInProgress = true
            controller.resize()
            controller.pressB()
            reactWith(Emojis.regionalIndicatorB)
            val f = controller.getScreenShot()

            channel.createMessage {
                addFile(f.toPath())
            }

            commandInProgress = false
        }
    }

    command("Start") {
        description = "Press the 'Start' button!"
        execute {
            commandInProgress = true
            controller.resize()
            controller.pressStart()
            reactWith(Emojis.whiteCheckMark)
            val f = controller.getScreenShot()

            channel.createMessage {
                addFile(f.toPath())
            }

            commandInProgress = false
        }
    }

    command("Select") {
        description = "Press the 'Select' button!"
        execute {
            commandInProgress = true
            controller.resize()
            controller.pressSelect()
            reactWith(Emojis.whiteCheckMark)
            val f = controller.getScreenShot()

            channel.createMessage {
                addFile(f.toPath())
            }

            commandInProgress = false
        }
    }
}