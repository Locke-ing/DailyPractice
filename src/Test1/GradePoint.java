package Test1;

import java.util.Scanner;

public class GradePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int creditPoint[] = new int[n];//相应课程的学分
        int coursePoint[] = new int[n]; //课程的实际得分

        for(int i = 0;i < n;i++){
           creditPoint[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++){
            coursePoint[i] = sc.nextInt();
        }
        sc.close();
        System.out.printf("%.2f",creditPointAverage(creditPoint,coursePoint));
    }

    //各课程学分绩点
    public static double pointOfEachCourse(int grade) {
        double point = 0.0;
        if (grade >= 90 && grade <= 100) {
            point = 4.0;
        } else if (grade >= 85 && grade <= 89) {
            point = 3.7;
        } else if (grade >= 82 && grade <= 84) {
            point = 3.3;
        } else if (grade >= 78 && grade <= 81) {
            point = 3.0;
        } else if (grade >= 75 && grade <= 77) {
            point = 2.7;
        } else if (grade >= 72 && grade <= 74) {
            point = 2.3;
        } else if (grade >= 68 && grade <= 71) {
            point = 2.0;
        } else if (grade >= 64 && grade <= 67) {
            point = 1.5;
        } else if (grade >= 60 && grade <= 63) {
            point = 1.0;
        } else if (grade <= 60) {
            point = 0.0;
        }
        return (double) point;
    }
    //计算平均学分绩点
    public static double creditPointAverage(int[] creditPoint,int[] coursePoint) {
        double creditPointTotal = 0;//所有学科绩点之和
        double CoursePointTotal = 0;//所有课程学分之和
        for (int i = 0; i < creditPoint.length; i++) {//遍历
            creditPointTotal += creditPoint[i] * pointOfEachCourse(coursePoint[i]);
            CoursePointTotal += creditPoint[i];
        }
    return (double) creditPointTotal/CoursePointTotal;
    }
}
