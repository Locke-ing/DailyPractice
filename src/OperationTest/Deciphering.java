package OperationTest;

import java.util.Scanner;

public class Deciphering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入密文：");
        while (sc.hasNext()) {
            String value = sc.nextLine(); //字符串
            char[] c = value.toCharArray(); //字符数组
            //遍历字符数组，进行解密
            for (int i = 0; i < c.length; i++) {
                //密文字符c
                //字符'A',输出的是其ASCII值
                if (c[i] >= 'A' && c[i] <= 'Z') {
                    //解密：左偏移5
                    //密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
                    //原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
                    //比如: F -> A => F - 5
                    //比如：B -> W => B + 21
                    c[i] = (char) (c[i] > 'E' ? (c[i] - 5) : (c[i] + 21));
                }
                //拓展：小写转成大写，大写转成小写
                //实例： 密文：aa-->VV
                /*
                if (c[i] >= 'A' && c[i] <= 'Z') {
                    c[i] = (char) (c[i] > 'E' ? (c[i] - 5) : (c[i] + 21));
                    c[i] += ('a'-'A');
                }
                if (c[i] >= 'a' && c[i] <= 'z') {
                    c[i] = (char) (c[i] > 'e' ? (c[i] - 5) : (c[i] + 21));
                    c[i] += ('A'-'a');
                }
                 */
            }
            System.out.println("输出原文为：");
            System.out.println(new String(c));
        }
    }
}
