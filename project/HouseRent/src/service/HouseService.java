package service;

import model.House;

/**
 * ����House[]������House����
 * 1. ��ӦHouseView�ĵ���
 * 2. ��ɶԷ�����Ϣ�ĸ��ֲ�������ɾ�Ĳ飩
 */
public class HouseService {

    private final House[] houses; // ����House����
    private int houseNum = 1; // ��¼��ǰ��������
    private int idCounter = 1; // ��¼��ǰ��id����

    public HouseService(int size) {
        houses = new House[size]; //������һ��HouseService����ʱ��ָ�������С
        houses[0] = new House(1, "jack", "112",
                "����������", 2000, "δ����"); // ��ʼ�����飬���ڲ���
    }

    public House[] list() {
        return houses; // ����House����
    }

    public boolean add(House newHouse) {
        // �ж��Ƿ���Լ������
        if (houseNum == houses.length) {
            System.out.println("�������������������");
            return false;
        }
        houses[houseNum++] = newHouse; // ��house[]�����м���һ��house����
        newHouse.setId(++idCounter); // idCounter����֮��ʹ��setter��������id
        return true;
    }

}
