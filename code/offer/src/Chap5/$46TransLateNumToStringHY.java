package Chap5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个数字，我们按照如下的规则把它翻译成字符串
 >   0 -> a
 >   1 -> b
 >   2 -> c
 >   ...
 >   25 -> z
 >
 >   一个数字可能有多种翻译，比如12258有五种，分别是"bccfi", "bwfi","bczi","mcfi", "mzi".
     请实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class $46TransLateNumToStringHY {
    static Map<Integer,Character> map = new HashMap();
    static List<String> res =new ArrayList<>();

    void howMuchMethods (char[] arr) {

        StringBuilder sb1 =new StringBuilder();
        sb1.append(map.get(Integer.valueOf(String.valueOf(arr[0]))));
        recursion(arr,1,sb1);
        if (arr.length>2) {
            int temp = Integer.valueOf(String.valueOf(arr[0]) + String.valueOf(arr[1]));
            if (temp <=25) {
                StringBuilder sb2 =new StringBuilder();
                sb2.append(map.get(temp));
                recursion(arr,2,sb2);
            }
        }


    }

    void recursion (char[] arr, int indexBegin, StringBuilder sb) {
        if (indexBegin==arr.length-1) {
            sb.append(map.get(Integer.valueOf(String.valueOf(arr[indexBegin]))));
            res.add(sb.toString());
        }

        if (indexBegin<arr.length-1) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(map.get(Integer.valueOf(String.valueOf(arr[indexBegin]))));
            recursion(arr,indexBegin+1,newSb);
            if (indexBegin<arr.length-2) {
                int temp = Integer.valueOf(String.valueOf(arr[indexBegin]) + String.valueOf(arr[indexBegin+1]));
                if (temp <=25) {
                    sb.append(map.get(temp));
                    recursion(arr,indexBegin+2,sb);
                }
            }

        }
    }


    public static void main(String[] args) {
        $46TransLateNumToStringHY t =new $46TransLateNumToStringHY();
        map.put(0,'a');
        map.put(1,'b');
        map.put(2,'c');
        map.put(3,'d');
        map.put(4,'e');
        map.put(5,'f');
        map.put(6,'g');
        map.put(7,'h');
        map.put(8,'i');
        map.put(9,'j');
        map.put(10,'k');
        map.put(11,'l');
        map.put(12,'m');
        map.put(13,'n');
        map.put(14,'o');
        map.put(15,'p');
        map.put(16,'q');
        map.put(17,'r');
        map.put(18,'s');
        map.put(19,'t');
        map.put(20,'u');
        map.put(21,'v');
        map.put(22,'w');
        map.put(23,'x');
        map.put(24,'y');
        map.put(25,'z');
        char[] arr ={'1','2','2','5','8'};
        t.howMuchMethods(arr);
        System.out.println(res.toString());
    }



}
