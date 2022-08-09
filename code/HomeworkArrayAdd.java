// 目标：插入一个数之后仍然能够保持数组的顺序
import java.util.Scanner;
public class HomeworkArrayAdd {
    public static void main(String[] args) {
        int[] arr = {10, 12, 45, 90};
        int insertIndex = -1;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("输入要插入的数：");
        int insertNum = myScanner.nextInt();
        myScanner.close();
        System.out.println("==============");
        int[] arrNew = new int[arr.length + 1];
        // locate
        for (int i=0; i<arr.length; i++) {
            if (insertNum < arr[i]) {
                insertIndex = i;
                break;
            } else if (i == arr.length - 1) {
                // 如果所有的数都比目标数小
                insertIndex = i + 1;
            }
        }
        // insert
        for (int i=0, j=0; i<arrNew.length; i++) {
            if (i == insertIndex) {
                arrNew[i] = insertNum;
            } else {
                arrNew[i] = arr[j];
                j++; // 单独的计数用于避免arr下标溢出问题
            }
            System.out.println(arrNew[i]);
        }
        // 释放数据空间
        arr = arrNew;
    }
    
}
