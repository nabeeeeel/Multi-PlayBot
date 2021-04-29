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

    private val standardDelay : Int = 500

    fun delayBot(bot: Robot, time: Int = standardDelay) {
        bot.delay(time)
    }

    fun getScreenShot() : File {
        val (mouseX, mouseY) = listOf(100, 100)
        val (sX, sY) = listOf(19, 72)
        val (xOffset,yOffSet) = listOf(-2, 45)

        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        bot.mouseMove(mouseX, mouseY)
        bot.mousePress(mask)
        bot.mouseRelease(mask)

        delayBot(bot)

        val screenSize = Toolkit.getDefaultToolkit().screenSize
        val captureRect = Rectangle(sX, sY, screenSize.width / 4 - xOffset, (screenSize.height / 3 - yOffSet))
        val screenFullImage: BufferedImage = bot.createScreenCapture(captureRect)
        val file = File("screen-capture.png")
        val status: Boolean = ImageIO.write(screenFullImage, "png", file)


        return file
    }

    fun findScreen(bot: Robot, mask: Int) {
        val (mouseX, mouseY) = listOf(70, 70)
        bot.mouseMove(mouseX, mouseY)
        bot.mousePress(mask)
        //bot.mouseRelease(mask)
    }

    fun resize() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)
        bot.keyPress(KeyEvent.VK_2)
        delayBot(bot, 100)
        bot.keyRelease(KeyEvent.VK_2)
    }

    fun pressUp() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)

        bot.keyPress(KeyEvent.VK_W)
        delayBot(bot, 5)
        bot.keyRelease(KeyEvent.VK_W)

    }

    fun pressDown() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)

        bot.keyPress(KeyEvent.VK_S)
        delayBot(bot, 5)
        bot.keyRelease(KeyEvent.VK_S)
    }

    fun pressRight() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)

        bot.keyPress(KeyEvent.VK_D)
        delayBot(bot, 5)
        bot.keyRelease(KeyEvent.VK_D)
    }

    fun pressLeft() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)

        bot.keyPress(KeyEvent.VK_A)
        delayBot(bot, 5)
        bot.keyRelease(KeyEvent.VK_A)
    }

    fun pressA() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)
        bot.keyPress(KeyEvent.VK_L)
        //bot.keyRelease(KeyEvent.VK_L)
    }

    fun pressB() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)

        bot.keyPress(KeyEvent.VK_K)
        //bot.keyRelease(KeyEvent.VK_K)
    }

    fun pressSelect() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)

        bot.keyPress(KeyEvent.VK_BACK_SPACE)
        //bot.keyRelease(KeyEvent.VK_BACK_SPACE)
    }

    fun pressStart() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)

        bot.keyPress(KeyEvent.VK_ENTER)
        //bot.keyRelease(KeyEvent.VK_ENTER)

    }

    fun pressL() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)

        bot.keyPress(KeyEvent.VK_I)
        bot.keyRelease(KeyEvent.VK_I)
    }

    fun pressR() {
        val bot = Robot()
        val mask: Int = InputEvent.BUTTON1_DOWN_MASK
        findScreen(bot, mask)

        bot.keyPress(KeyEvent.VK_O)
        bot.keyRelease(KeyEvent.VK_O)
    }

    val me = listOf("hi", "hello")
}
