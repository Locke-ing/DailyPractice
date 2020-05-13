package Test1;
/*
题目描述：小易打怪
难点分析：求公因数，用辗转相除法，辗转相除法的递推公式是GCD(a,b)==GCD(b,a%b)，当a%b==0时，b即为所求的最大公约数
测试用例：
怪物数量和小易初始能量： 3 50
怪物能量值：50 105 200
最终小易能量值：110
 */
import java.util.Scanner;

public class test1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num ;
        int ability ;
        while(sc.hasNext()){
            num = sc.nextInt();//怪物数量
            ability = sc.nextInt();//小易的初始能量值
            for(int i =0 ;i < num; ++i){ //输入怪物的能量值并分别PK
                int monster = sc.nextInt();
                if(monster <= ability){//小易比怪物厉害
                    ability += monster;
                }else{//怪物比小易厉害
                    ability += GCD(ability,monster);
                }
            }
            System.out.println(ability);
        }
        sc.close();
    }
    //辗转相除法，求最大公因数
    public static int GCD(int a,int b){
        int temp;
        while(b > 0){
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
