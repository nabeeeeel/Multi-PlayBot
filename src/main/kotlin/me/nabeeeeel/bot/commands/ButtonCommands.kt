package me.nabeeeeel.bot.commands

import dev.kord.core.behavior.channel.createMessage
import dev.kord.x.emoji.DiscordEmoji
import dev.kord.x.emoji.Emojis
import me.jakejmattson.discordkt.api.dsl.CommandEvent
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.services.BooleanServices.Companion.commandInProgress
import me.nabeeeeel.bot.services.ControllerService

private var hasStarted: Boolean = false

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

    fun pressMenuButton(action: (ControllerService) -> Unit) : String {
        commandInProgress = true

        controller.resize()
        action.invoke(controller)
        val imagePath = "file:///${controller.getScreenShot().absolutePath}"
        println(imagePath)

        return imagePath.also { commandInProgress = false }
    }

    command("start") {
        description = "Start game"
        execute {
            if (hasStarted) {
                respond("The game has already been started")
                return@execute
            }

            hasStarted = true

            respondMenu {
                page {
                    title = "Pokemon Emerald"
                }

                reaction(Emojis.regionalIndicatorA) {
                    image = pressMenuButton { it.pressA() }
                }

                reaction(Emojis.regionalIndicatorB) {
                    image = pressMenuButton { it.pressB() }
                }

                reaction(Emojis.arrowUp) {
                    image = pressMenuButton { it.pressUp() }
                }

                reaction(Emojis.arrowDown) {
                    image = pressMenuButton { it.pressDown() }
                }

                reaction(Emojis.arrowLeft) {
                    image = pressMenuButton { it.pressLeft() }
                }

                reaction(Emojis.arrowRight) {
                    image = pressMenuButton { it.pressRight() }
                }
            }
        }
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