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

    public static Point getLocation() {
        // 获取鼠标的屏幕位置
        Point mouseLocationOnScreen = MouseInfo.getPointerInfo().getLocation();
        return mouseLocationOnScreen;
    }

    // 线程来持续监控鼠标位置
    private static class MouseLocationThread extends Thread {
        @Override
        public void run() {
            while (true) {
                // 获取当前鼠标位置
                Point mouseLocationOnScreen = MouseInfo.getPointerInfo().getLocation();

                // 打印鼠标位置
                System.out.println("当前鼠标位置: (" + mouseLocationOnScreen.x + ", " + mouseLocationOnScreen.y + ")");

                // 暂停一段时间，避免输出过快
                try {
                    Thread.sleep(100); // 每100毫秒检查一次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    // 启动监控鼠标位置的线程
    public static void startMonitoring() {
        new MouseLocationThread().start();
    }

    public static void main(String[] args) {
        // 开始监控鼠标位置
        startMonitoring();

        // 注意：由于这是一个无限循环的线程，你可能需要提供一个退出机制（比如捕获特定的键盘事件来停止线程）
        // 这里为了示例简单，我们假设程序将一直运行直到被外部终止
    }
}
