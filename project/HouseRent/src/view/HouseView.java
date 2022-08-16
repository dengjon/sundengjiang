package view;

import model.House;
import service.HouseService;
import utils.Utility;

/**
 * 1. ��ʾ����
 * 2. �����û�������
 * 3. ����HouseService��ɶԷ��ݵĸ��ֲ���
 */
public class HouseView {

    private boolean loop = true; // ������ʾ���˵�
    private final HouseService houseService = new HouseService(10); //���������СΪ10

    public void mainMenu() {
        do {
            System.out.println("==================���ݳ���˵�================");
            System.out.println("\t\t\t1 �� �� �� Դ");
            System.out.println("\t\t\t2 �� �� �� Դ");
            System.out.println("\t\t\t3 ɾ��������Ϣ");
            System.out.println("\t\t\t4 �޸ķ�����Ϣ");
            System.out.println("\t\t\t5 �� �� �� ��");
            System.out.println("\t\t\t6 ��      ��");
            System.out.println("���������ѡ��1-6����");

            // �����û���ѡ��
            char key = Utility.readChar();
            switch (key) {
                case '1' -> addHouse();
                case '2' -> System.out.println("����");
                case '3' -> System.out.println("ɾ��");
                case '4' -> System.out.println("�޸�");
                case '5' -> listHouses();
                case '6' -> {
                    System.out.println("�˳�");
                    loop = false;
                }
            }
        } while (loop);
    }

    public void listHouses() {
        System.out.println("=============�����б�===============");
        System.out.println("���\t\t����\t\t�绰\t\t��ַ\t\t\t����\t\t״̬��δ����/�ѳ��⣩");
        House[] houses = houseService.list();
        for (House house : houses) {
            if (house == null) {
                break;
            }
            System.out.println(house);
        }
        System.out.println("============�����б����============");
    }

    public void addHouse() {
        // �����û������룬���µ�house������뵽houses������
        System.out.println("===========��ӷ���===========");
        System.out.println("������");
        String name = Utility.readString(8);
        System.out.println("�绰��");
        String phone = Utility.readString(12);
        System.out.println("��ַ��");
        String address = Utility.readString(16);
        System.out.println("���⣺");
        int rent = Utility.readInt();
        System.out.println("״̬��");
        String state = Utility.readString(3);
        // ����һ���µ�House����id��ϵͳ����
        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("===========��ӷ��ݳɹ�============");
        } else {
            System.out.println("===========��ӷ���ʧ��============");
        }
    }
}
