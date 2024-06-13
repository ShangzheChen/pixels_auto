package org.pixels.app;

/**
 * @author ：ShangzheChe
 * @date ：Created in 2024/6/1 11:59
 * @description：点击屏幕
 */

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Date;

public class getTheFuckingFlour {
    public static void main(String[] args) {

        try {
            Robot robot = new Robot();
            while (true) {
                PointerInfo pointerInfo = MouseInfo.getPointerInfo();
//                获取当前鼠标坐标
                int x = pointerInfo.getLocation().x;
                int y = pointerInfo.getLocation().y;
//                System.out.println("当前鼠标坐标：(" + x + ", " + y + ")");
                Color color = robot.getPixelColor(x, y);

                robot.mouseMove(2085, 964);
                if (color.getRed() >= 246 && color.getRed() <= 255) {
//                    Thread.sleep(1000);
                    Date date = new Date();
                    System.out.println("颜色：RGB(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")");
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    System.out.println("mouse pressed");
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    System.out.println("mouse release");
                    System.out.println(date);
                }
//                Thread.sleep(5000);
            }
        } catch (AWTException  e) {
            e.printStackTrace();
        }
    }

}
