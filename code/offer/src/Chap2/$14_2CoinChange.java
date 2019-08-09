package Chap2;

/*
题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，再给一个总金额 n，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，则回答 -1 。
比如说，k = 3，面值分别为 1，2，5，总金额 n = 11，那么最少需要 3 枚硬币，即 11 = 5 + 5 + 1 。
*
 */

/*
        F(n) =    0                                                ,  当  n=0 时
        F(n) =    1  +   【 F ( n-Ci )  的min 】  , 当  n>0 时
 */

import java.util.HashMap;
import java.util.Map;

public class $14_2CoinChange {
    static int[] c ={1,2,5};
    static Map<Integer,Integer> memo2 = new HashMap<>();
    static Map<Integer,Integer> memo3 = new HashMap<>();

    /*
        1. 根据方程写出暴力递归的解法
    */
    public static  int  Solution1_Force (int n) {
        if (n==0) return 0;
        int min =-2;
        for (int i=0;i<c.length;i++) {
            if (c[i]>n) {
                continue;
            } else if (c[i]==n) {
                return 1;
            } else {
                int temp = Solution1_Force  (n-c[i] );
                if (temp ==-1) continue;
                min = min ==-2 ? temp+1 :Math.min(temp+1,min);
            }
        }
        return min==-2 ? -1 : min ;
    }

    /*
        2. 将子问题的递归结果存入备忘录中（memo中）
    */
    public static  int Solution2_Memo(int n) {
        if ( memo2.containsKey(n) ) return memo2.get(n);
        if (n==0) return 0;
        int min =-2;
        for (int i=0;i<c.length;i++) {
            memo2.put(c[i],1);
            if (c[i]>n) continue;
            int  temp = memo2.containsKey(n) ? memo2.get(n) : Solution2_Memo(n-c[i] );
            if (temp ==-1) continue;
            min = min ==-2 ? temp+1 :Math.min(temp+1,min);
        }
        memo2.put(n,min==-2 ? -1 : min);
        return min==-2 ? -1 : min ;
    }

    /*
        3. 加入对n的循环，使递归操作变为对备忘录数据的读取，目的是把全部n放入备忘录中，最后再memo.get(n)即可。
    */
    public static  int Solution3_Dp(int n) {
        memo3.put(0,0);
        for (int i=1;i<=n;i++) {
            int min=-2;
            for (int j=0;j<c.length;j++) {
                if (c[j]>i) continue;
                int temp = memo3.get(i-c[j]);
                min = min ==-2 ? temp+1 :Math.min(temp+1,min);
            }
            memo3.put(i,min==-2 ? -1 : min);
        }
        return memo3.get(n);
    }

    public  static void main (String[] args) {
        System.out.println( Solution1_Force (6));
        System.out.println( Solution2_Memo(6));
        System.out.println( Solution3_Dp(6));
        System.out.println(memo2);

    }
}
