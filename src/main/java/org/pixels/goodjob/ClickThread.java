package org.pixels.goodjob;

import java.awt.*;

/**
 * @author ：ShangzheChe
 * @date ：Created in 2024/6/13 16:33
 * @description：
 */
public class ClickThread {

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
                    Thread.sleep(1000); // 每100毫秒检查一次
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
