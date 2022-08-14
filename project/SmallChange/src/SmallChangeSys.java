import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("==========零钱通菜单===========");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退    出");

            System.out.println("请选择（1-4）：");
            String key = scanner.next();

            // 使用switch分支
            switch (key) {
                case "1" -> System.out.println("1 零钱通明细");
                case "2" -> System.out.println("2 收益入账");
                case "3" -> System.out.println("3 消费");
                case "4" -> System.out.println("4 退    出");
                default -> System.out.println("选择有误，请重新选择");
            }
        } while (loop);
    }
}
