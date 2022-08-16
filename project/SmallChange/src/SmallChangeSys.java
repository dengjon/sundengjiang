import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    /*
    1. 先完成显示菜单，并可以选择菜单，给出对应的提示；
    2. 完成零钱通明细；
    3. 完成收益入账；
    4. 消费；
     */
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        // 零钱通明细
        String details = "============零钱通明细============";
        // 收益入账
        double money = 0;
        double balance = 0; // 余额
        Date date = null; // java.util.Date，表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //用于日期格式化
        // 消费
        String note = "";
        do {
            System.out.println("============零钱通菜单===========");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退    出");

            System.out.println("请选择（1-4）：");
            String key = scanner.next();

            // 使用switch分支
            switch (key) {
                case "1" -> System.out.println(details);
                case "2" -> {
                    System.out.println("收益入账金额：");
                    money = scanner.nextDouble();
                    balance += money;
                    date = new Date();
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + '\t' + balance;
                    System.out.println(details);
                }
                case "3" -> {
                    System.out.println("消费金额：");
                    money = scanner.nextDouble();
                    balance -= money;
                    System.out.println("消费说明：");
                    note = scanner.next();
                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;

                }
                case "4" -> {
                    System.out.println("===========退出了零钱通===========");
                    loop = false;
                }
                default -> System.out.println("选择有误，请重新选择");
            }
        } while (loop);
    }
}
