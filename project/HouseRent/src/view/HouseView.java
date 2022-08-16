package view;

import utils.Utility;

/**
 * 1. 显示界面
 * 2. 接收用户的输入
 * 3. 调用HouseService完成对房屋的各种操作
 */
public class HouseView {

    private boolean loop = true; // 控制显示主菜单

    public void mainMenu() {
        do {
            System.out.println("==================房屋出租菜单================");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 源");
            System.out.println("\t\t\t3 删除房屋信息");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");
            System.out.println("请输入你的选择（1-6）：");

            // 接受用户的选择
            char key = Utility.readChar();
            switch (key) {
                case '1' -> System.out.println("新增");
                case '2' -> System.out.println("查找");
                case '3' -> System.out.println("删除");
                case '4' -> System.out.println("修改");
                case '5' -> System.out.println("房屋列表");
                case '6' -> {
                    System.out.println("退出");
                    loop = false;
                }
            }
        } while (loop);
    }
}
