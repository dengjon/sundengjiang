package view;

import model.House;
import service.HouseService;
import utils.Utility;

/**
 * 1. 显示界面
 * 2. 接收用户的输入
 * 3. 调用HouseService完成对房屋的各种操作
 */
public class HouseView {

    private boolean loop = true; // 控制显示主菜单
    private final HouseService houseService = new HouseService(10); //设置数组大小为10

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
                case '1' -> addHouse();
                case '2' -> System.out.println("查找");
                case '3' -> System.out.println("删除");
                case '4' -> System.out.println("修改");
                case '5' -> listHouses();
                case '6' -> {
                    System.out.println("退出");
                    loop = false;
                }
            }
        } while (loop);
    }

    public void listHouses() {
        System.out.println("=============房屋列表===============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t\t月租\t\t状态（未出租/已出租）");
        House[] houses = houseService.list();
        for (House house : houses) {
            if (house == null) {
                break;
            }
            System.out.println(house);
        }
        System.out.println("============房屋列表完毕============");
    }

    public void addHouse() {
        // 接收用户的输入，把新的house对象加入到houses数组中
        System.out.println("===========添加房屋===========");
        System.out.println("姓名：");
        String name = Utility.readString(8);
        System.out.println("电话：");
        String phone = Utility.readString(12);
        System.out.println("地址：");
        String address = Utility.readString(16);
        System.out.println("月租：");
        int rent = Utility.readInt();
        System.out.println("状态：");
        String state = Utility.readString(3);
        // 创建一个新的House对象，id由系统分配
        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("===========添加房屋成功============");
        } else {
            System.out.println("===========添加房屋失败============");
        }
    }
}
