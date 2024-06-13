package org.pixels.app;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Date;

/**
 * @author ：ShangzheChe
 * @date ：Created in 2024/6/9 13:53
 * @description：
 */
public class eategg {
    public static void main(String[] args) {

        try {
            Robot robot = new Robot();
            while (true) {
                PointerInfo pointerInfo = MouseInfo.getPointerInfo();
                Thread.sleep(300);
                int x = pointerInfo.getLocation().x;
                int y = pointerInfo.getLocation().y;
                Color color = robot.getPixelColor(x, y);
                // System.out.println(x + " " + y);
//               robot.mouseMove(2113, 1040);
//                robot.mouseMove(2085, 964);
//                if (color.getRed() >= 246 && color.getRed() <= 255) {
                    Date date = new Date();
                    System.out.println("颜色：RGB(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")");
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    System.out.println("mouse pressed");
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    System.out.println("mouse release");
//                }
            }
        } catch (AWTException | InterruptedException e) {
//        } catch (AWTException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
