package me.nabeeeeel.bot.game

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import java.io.File
import javax.imageio.ImageIO

class GameController {
    private val bot = Robot()
    private val standardDelay = 500

    fun getScreenShot(): File {
        val (mouseX, mouseY) = listOf(100, 100)
        val (sX, sY) = listOf(19, 72)
        val (xOffset, yOffSet) = listOf(-2, 45)

        val mask = InputEvent.BUTTON1_DOWN_MASK
        bot.mouseMove(mouseX, mouseY)
        bot.mousePress(mask)
        bot.mouseRelease(mask)
        bot.delay(standardDelay)

        val screenSize = Toolkit.getDefaultToolkit().screenSize
        val captureRect = Rectangle(sX, sY, screenSize.width / 4 - xOffset, (screenSize.height / 3 - yOffSet))
        val screenFullImage = bot.createScreenCapture(captureRect)
        val file = File("screen-capture.png")
        ImageIO.write(screenFullImage, "png", file)

        return file
    }

    private fun findScreen() {
        val (mouseX, mouseY) = listOf(70, 70)
        bot.mouseMove(mouseX, mouseY)
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK)
    }

    private fun pressKey(key: Int) {
        findScreen()
        bot.keyPress(key)
        bot.delay(5)
        bot.keyRelease(key)
    }

    fun resize() = pressKey(KeyEvent.VK_2)
    fun pressUp() = pressKey(KeyEvent.VK_W)
    fun pressDown() = pressKey(KeyEvent.VK_S)
    fun pressLeft() = pressKey(KeyEvent.VK_A)
    fun pressRight() = pressKey(KeyEvent.VK_D)
    fun pressA() = pressKey(KeyEvent.VK_L)
    fun pressB() = pressKey(KeyEvent.VK_K)
    fun pressSelect() = pressKey(KeyEvent.VK_BACK_SPACE)
    fun pressStart() = pressKey(KeyEvent.VK_ENTER)
}