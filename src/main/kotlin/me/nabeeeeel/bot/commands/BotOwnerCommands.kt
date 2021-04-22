package me.nabeeeeel.bot.commands

import dev.kord.common.Color
import dev.kord.core.entity.Embed
import me.jakejmattson.discordkt.api.arguments.UserArg
import me.jakejmattson.discordkt.api.dsl.commands
import me.nabeeeeel.bot.data.Configuration
import me.nabeeeeel.bot.extensions.requiredPermissionLevel
import me.nabeeeeel.bot.services.Permission


fun BotOwnerCommands(configuration: Configuration) = commands("Bot Owner") {

    command("PFP", "Profile") {
        description = "Did someone make their Profile Picture for ants? Well here ya go!"
        requiredPermissionLevel = Permission.BOT_OWNER
        execute(UserArg("@username").optional { it.author }) {
            val user = args.first
            respond {
                // thumbnail { url = user.avatar.url }
                title = "P R O F I L E  P I C  for ${user.username}"
                val s = "$user hello"
                image = user.avatar.url
                color = Color(109, 17, 17)
            }
        }
    }
}