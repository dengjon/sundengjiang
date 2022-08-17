package service;

import model.House;

/**
 * 定义House[]，保存House对象
 * 1. 相应HouseView的调用
 * 2. 完成对房屋信息的各种操作（增删改查）
 */
public class HouseService {

    private final House[] houses; // 保存House对象
    private int houseNum = 1; // 记录当前房屋数量
    private int idCounter = 1; // 记录当前的id增长

    public HouseService(int size) {
        houses = new House[size]; //当创建一个HouseService对象时，指定数组大小
        houses[0] = new House(1, "jack", "112",
                "海淀区北交", 2000, "未出租"); // 初始化数组，用于测试
    }

    public House[] list() {
        return houses; // 返回House数组
    }

    public boolean add(House newHouse) {
        // 判断是否可以继续添加
        if (houseNum == houses.length) {
            System.out.println("数组已满，不能再添加");
            return false;
        }
        houses[houseNum++] = newHouse; // 向house[]数组中加入一个house对象
        newHouse.setId(++idCounter); // idCounter自增之后使用setter方法更新id
        return true;
    }

    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        if (index < houseNum - 1) {
            for (int i = index; i < houseNum - 1; i++) {
                houses[i] = houses[i + 1];
            }
        }
        houses[--houseNum] = null; // 把当前非空的列表最后一个置空，并自减
        return true;
    }

    public House findById(int findId) {
        for (int i = 0; i < houseNum; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

}
