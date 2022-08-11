public class RecursionExercise {
    public static void main(String[] args) {
        Test t = new Test();
        int value = t.fibonacci(8);
        System.out.println(value);
    }
}

class Test {
    public int fibonacci(int n) {
        if (n >= 1) {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fibonacci(n - 1) + fibonacci(n-2);
            }
        } else {
            System.out.println("输入的数要求不小于1");
            return 0;
        }
    }
}