package API.runtime;

import java.io.IOException;

public class Runtime_1 {
    /**
     * Runtime类
     * 一.
     * 1. Runtime类代表Java程序的运行时环境,每个Java程序都有一个对应的Runtime实例.
     * 2. 该对象不能直接创建,可用过Runtime.getRuntime()获取
     */
    public static void main(String[] args) throws IOException {
//        getRuntimeInfo();
//        executeByCmd();
    }

    /**
     *
     */
    private static void getRuntimeInfo() {
        // 获取Java程序关联的运行时对象
        Runtime rt = Runtime.getRuntime();
        System.out.println("剩余内存数: " + rt.freeMemory() / 1024 / 1024 + "m");
        System.out.println("总内存数: " + (rt.totalMemory() / 1024 / 1024) + "m");
        System.out.println("处理器数量: " + rt.availableProcessors());
    }

    /**
     * 运行与平台相关的命令
     */
    private static void executeByCmd() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("calc"); // 启动计算器
        rt.exec("notepad.exe");// 启动记事本
    }
}

