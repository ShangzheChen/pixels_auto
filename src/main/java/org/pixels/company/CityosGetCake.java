package org.pixels.company;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Date;

/**
 * @author ：ShangzheChe
 * @date ：Created in 2024/6/7 14:47
 * @description：get cake auto
 */
public class CityosGetCake {

    public static void main(String[] args) {

        try {
            Robot robot = new Robot();

            int time = 0;
            while (true) {
                PointerInfo pointerInfo = MouseInfo.getPointerInfo();
                int x = pointerInfo.getLocation().x;
                int y = pointerInfo.getLocation().y;
                Color color = robot.getPixelColor(x, y);

                Thread.sleep(1000);
                time = time + 1;
                System.out.println(time);

                System.out.println("颜色：RGB(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")");
                robot.mouseMove(2085, 964); // 做蛋糕按钮

                if (color.getRed() >= 246 && color.getRed() <= 255) {
                    time = 0;
                    Date date = new Date();
                    System.out.println("颜色：RGB(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")");
                    pressMouse(robot);
                    System.out.println(date);
                } else if (time >= 130) {
                    Date date = new Date();
                    robot.mouseMove(2306, 453);
                    pressMouse(robot);
                    System.out.println("时间超时，关闭做蛋糕界面   ：" + date);
                    Thread.sleep(2000);
                    robot.mouseMove(2072, 1081);
                    pressMouse(robot);
                    System.out.println("打开做蛋糕界面   ：" + date);
                    Thread.sleep(2000);
                    time = 0;
                }
            }
        } catch (AWTException | InterruptedException e) {
//        } catch (AWTException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void pressMouse(Robot robot) {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("按下鼠标");
    }
}

