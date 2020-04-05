package RecursionTest;

import java.util.Scanner;

public class CountRabbits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份：");
        while(sc.hasNext()){ //hasNext判断是否有输入项
            int n = sc.nextInt();
            System.out.println("兔子总数：\n"+rabbit(n));
        }sc.close(); //使用资源后进行释放
    }
    public static int rabbit(int n){
        if(n<=2) //月份小于等于2只有一个兔子
            return 1;
        else{
             return rabbit(n-1)+rabbit(n-2);
            }
    }
}
