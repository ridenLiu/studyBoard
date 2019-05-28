package exercise.date_0507;

public class MultiplicationTable {
    // 打印九九乘法表
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j +" * "+i+" = "+i*j+"\t");
            }
            System.out.println();
        }
    }
}
