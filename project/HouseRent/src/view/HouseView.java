package view;

import utils.Utility;

/**
 * 1. ��ʾ����
 * 2. �����û�������
 * 3. ����HouseService��ɶԷ��ݵĸ��ֲ���
 */
public class HouseView {

    private boolean loop = true; // ������ʾ���˵�

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
                case '1' -> System.out.println("����");
                case '2' -> System.out.println("����");
                case '3' -> System.out.println("ɾ��");
                case '4' -> System.out.println("�޸�");
                case '5' -> System.out.println("�����б�");
                case '6' -> {
                    System.out.println("�˳�");
                    loop = false;
                }
            }
        } while (loop);
    }
}
