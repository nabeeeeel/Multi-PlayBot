package me.nabeeeeel.bot.game

import java.awt.event.InputEvent

import java.awt.Robot
import java.awt.event.KeyEvent
import javax.imageio.ImageIO

import java.awt.image.BufferedImage

import java.awt.Rectangle
import java.awt.Toolkit
import java.awt.geom.Rectangle2D
import java.io.File
import java.awt.Dimension





class GameController {

    fun getScreenShot() : File {
        val (mouseX, mouseY) = listOf(100, 100)
        val (sX, sY) = listOf(8, 53)
        val (yOffSet, xOffset) = listOf(53, 8)

        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        bot.mouseMove(mouseX, mouseY)
        bot.mousePress(mask)
        bot.mouseRelease(mask)
        bot.keyPress(KeyEvent.VK_2)
        bot.keyRelease(KeyEvent.VK_2)

        val screenSize = Toolkit.getDefaultToolkit().screenSize
        val captureRect = Rectangle(sX, sY, screenSize.width / 4 - xOffset, (screenSize.height / 3 - yOffSet))
        val screenFullImage: BufferedImage = bot.createScreenCapture(captureRect)
        val file = File("screen-capture.png")
        val status: Boolean = ImageIO.write(screenFullImage, "png", file)


        return file
    }

    fun resize() {
        val (mouseX, mouseY) = listOf(50, 20)
        val (sX, sY) = listOf(8, 53)
        val (yOffSet, xOffset) = listOf(53, 8)

        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        bot.mouseMove(mouseX, mouseY)
        bot.mousePress(mask)
        bot.mouseRelease(mask)
        bot.keyPress(KeyEvent.VK_2)
        bot.keyRelease(KeyEvent.VK_2)
    }

    val me = listOf("hi", "hello")
}
