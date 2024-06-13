package org.pixels.app;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;

/**
 * @author ：ShangzheChe
 * @date ：Created in 2024/6/11 23:58
 * @description：
 */
public class getCakeUper {


    public static void pressMouse(Robot robot) {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("按下鼠标");
    }

    public static ArrayList<Integer> getColor(PointerInfo pointerInfo, Robot robot) {
        ArrayList<Integer> colors = new ArrayList<>();
        int x = pointerInfo.getLocation().x;
        int y = pointerInfo.getLocation().y;
        Color color = robot.getPixelColor(x, y);
        colors.add(color.getRed());
        colors.add(color.getGreen());
        return colors;
    }

}
