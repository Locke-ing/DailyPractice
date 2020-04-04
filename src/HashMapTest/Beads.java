package HashMapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Beads {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);

            //商人输入
            System.out.println("请输入：");
            String have = sc.nextLine();
            //小红输入
            System.out.println("请输入：");
            String need = sc.nextLine();

            //商人手上每种珠子数量的统计(对珠子进行分类)
            Map<Character, Integer> h = new HashMap<>();
            for(char c : have.toCharArray()) {
                if(h.containsKey(c)) {
                    h.put(c, h.get(c)+1);
                }else {
                    h.put(c,1);
                }
            }

            //小红手上每种珠子数量的统计(对珠子进行分类)
            Map<Character, Integer> n = new HashMap<>();
            for (char c : need.toCharArray()) {
                if (n.containsKey(c)) {
                    n.put(c, n.get(c) + 1);
                } else {
                    n.put(c, 1);
                }
            }

            //计算差值，以小红珠子为参考
            boolean Result = true;
            int lack = 0;
            for (Entry<Character, Integer> en : n.entrySet()) { //遍历小红珠子对象的集合
                char k = en.getKey(); // 小红珠子的种类
                int v = en.getValue();// 小红珠子的数量
                //h.get(k),根据珠子的种类获取其数量
                if (h.containsKey(k) && h.get(k) < v) {//商人的珠子包含用户的珠子但是不够
                    Result = false;
                    lack += v - h.get(k);//计算差值： lack=lack+v-h.get(k);
                } else if (!h.containsKey(k)) {//商人的珠子不包含用户的珠子
                    Result = false;
                    lack += v;
                }
            }

            if (Result){
                System.out.println("Yes " + (have.length() - need.length()));//商家的珠子包含小红的珠子
            } else {
                System.out.println("No " + lack);
            }
        }
    }
