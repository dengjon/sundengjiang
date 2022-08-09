import java.util.Scanner;
public class ArrayAdd {
    public static void main(String[] args) {
        try (Scanner myScanner = new Scanner(System.in)) {
            // init array
            int arr[] = {1, 2, 3};
            do {
                int[] arrNew = new int[arr.length + 1];
                for (int i=0; i<arr.length; i++) {
                    arrNew[i] = arr[i];
                }
                // 将新的元素加入到arrNew的末尾
                System.out.println("请输入需要添加的元素");
                int addNum = myScanner.nextInt();
                arrNew[arrNew.length - 1] = addNum;
                // 让arr指向arrNew
                arr = arrNew;
                System.out.println("=======arr扩容后的元素情况========");
                for (int i=0; i<arrNew.length; i++) {
                    System.out.println(arr[i] + "\t");
                }
                // 问用户是否继续添加
                System.out.println("是否继续添加 y/n");
                char key = myScanner.next().charAt(0); // 第一个字符
                if (key == 'n') {
                    break;
                }
            } while (true);
        }
        System.out.println("你退出了添加...");
    }
}