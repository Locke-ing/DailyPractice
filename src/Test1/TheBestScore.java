package Test1;
/*
题目描述：第一行：n 个学生 m 老师可以询问或者更新m次
         第二行：1~ n 个学生的成绩，学生ID也从 1 ~ n
         m 行：
         老师操作 Q 询问指定ID范围的学生成绩，输出最高成绩
         老师操作 U 更新指定ID的学生成绩
题目解析：输入学生数量，老师可操作次数，学生成绩
         循环执行m次，如果输入Q进行最大分数计算，如果输入U进行分数更新
测试实例：
输入：
3 3
1 2 3
Q 2 3
U 1 4
Q 1 3
输出：3 4
 */
import java.util.Scanner;

public class TheBestScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();//学生人数
            int m = sc.nextInt();//老师可操作次数
            int[] score = new int[n];//学生分数
            for(int i = 0; i < n ; i++){
                score[i] = sc.nextInt();
            }
            //老师询问
            for(int i = 0;i < m;i++){
               String c = sc.next();// U/Q
               int a = sc.nextInt();
               int b = sc.nextInt();
               if(c.equals("Q")){
                   int s = Math.min(a,b)-1;//开始下标
                   int e = Math.max(a,b)-1;//结束下标
                   int max =score[s];
                   //计算出[s-1,e)范围最大的值
                   for(int index = s;index <= e;index++){
                       max = Math.max(max,score[index]);
                   }
                   System.out.println(max);
               }
               if(c.equals("U")){
                   score[a-1] = b;
               }
            }
        }
    }
}
