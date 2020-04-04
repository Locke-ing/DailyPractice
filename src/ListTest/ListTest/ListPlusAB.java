package ListTest.ListTest;

//定义ListNode类
 class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

}
public class ListPlusAB {
    public static  ListNode plusAB(ListNode a,ListNode b) {
        //将链表转换为整数
        int aVal = listNodeConvertIntVal(a);
        int bVal = listNodeConvertIntVal(b);

        //计算求和
        int sumVal = aVal+bVal;

        //将整数转换为链表
        return intValConvertListNode(sumVal);
    }

    //实现链表转换整数
    //例如：4->3->2->1   返回 1234
    public static int listNodeConvertIntVal(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = node;
        while(cur != null) {
            sb.append(cur.val);
            cur = cur.next;
        }
        //sb.reverse().toString(); 反转的字符串
        //parseInt(); 解析字符串将其转换为整型
        return Integer.parseInt(sb.reverse().toString());  //装箱

    }

    //实现整数转换为链表
    public  static ListNode intValConvertListNode(int val) {
        //String.valueOf().toCharArray();先转换为字符串,然后转换为字符数组
        char[] arr = String.valueOf(val).toCharArray();

        // 因为要反转,所以链表的头结点是数组的最后一个元素
        ListNode node = new ListNode(Integer.parseInt(String.valueOf(arr[arr.length-1])));
        ListNode cur = node;
        //整数反转存储到链表中
        for(int i = arr.length-2; i >=0; i--) {
            ListNode newNode = new ListNode(Integer.parseInt(String.valueOf(arr[i])));
            cur.next = newNode;
            cur = newNode;
        }
        return node;
    }

    //测试
    public static void main (String[] args) {
        //创建链表a,b
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(6);
        a1.next=a2;
        a2.next=a3;
        a3.next=null;

        ListNode b1 = new ListNode(7);
        ListNode b2 = new ListNode(8);
        ListNode b3 = new ListNode(9);
        b1.next=b2;
        b2.next=b3;
        b3.next=null;

       // ListNode c = plusAB(a1, b1);
        // System.out.println(c);
        System.out.println(plusAB(a1,b1));
    }
}
