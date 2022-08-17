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
                case '2' -> findHouse();
                case '3' -> delHouse();
                case '4' -> updateHouse();
                case '5' -> listHouses();
                case '6' -> exit();
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

    public void delHouse() {
        System.out.println("===========删除房屋信息============");
        System.out.println("请输入待删除房屋的编号（-1退出）：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("============放弃删除房屋信息============");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("=============删除房屋信息成功===========");
            } else {
                System.out.println("===========删除房屋信息失败，ID不存在=========");
            }
        } else {
            System.out.println("============放弃删除房屋信息============");
        }
    }

    public void findHouse() {
        System.out.println("----------查找房屋信息----------");
        System.out.println("请输入要查找的ID：");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("----------查找的房屋ID不存在---------");
        }
    }

    public void updateHouse() {
        System.out.println("----------修改房屋-----------");
        System.out.println("请输入待修改房屋的编号(-1退出)：");
        int updateId = Utility.readInt();
        // 这里的house是一个引用类型，返回的结果是地址，因此在这里修改会对原来的house进行修改
        House house = houseService.findById(updateId);
        if (updateId == -1) {
            System.out.println("----------放弃修改----------");
            return;
        }
        if (house == null) {
            System.out.println("---------查找的房屋ID不存在----------");
            return;
        }
        System.out.println("姓名（" + house.getName() + "）：");
        String name = Utility.readString(8, ""); //如果用户回车，返回空串
        if (!"".equals(name)) {
            house.setName(name);
        }
        System.out.println("电话（" + house.getPhone() + "）：");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.println("地址（" + house.getAddress() + "）：");
        String address = Utility.readString(10, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.println("月租（" + house.getRent() + "）：");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.println("状态（" + house.getName() + "）：");
        String state = Utility.readString(10, "");
        if (!"".equals(state)) {
            house.setState(state);
        }

    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }
}
