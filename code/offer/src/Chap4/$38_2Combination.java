package Chap4;

import java.util.*;

/**
 * 求字符的所有组合,允许组合中有重复元素
 */
public class $38_2Combination {
    /**
     * 其实就是求C(n, m) 其中n == str.length; m == num
     *
     * @param str 字符序列
     * @param num 选几个字符进行组合
     * @return C(n, m)的集合
     */
    public List<String> combinationAccordingToNum(String str, int num) {
        List<String> list = new ArrayList<>();
        if (str == null || str.length() == 0 || num > str.length()) {
            return list;
        }
        StringBuilder sb = new StringBuilder();

        collect(str, sb, num, list);
        return list;
    }

    /**
     * 求所有组合情况
     */
    public List<String> combination(String str) {
        List<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        StringBuilder sb = new StringBuilder();

        // 收集字符个数为i的组合
        for (int i = 1; i <= str.length(); i++) {
            collect(str, sb, i, list);
        }
        return list;
    }

    private void collect(String str, StringBuilder sb, int number, List<String> list) {
        // 两个if顺序不可交换，否则C(n, n)不会存入到list中：即collect("", sb, 0)时，要先判断num==0存入后，再判断str.length ==0决定不再递归
        if (number == 0) {
            if (!list.contains(sb.toString()))
                // 字符已经去重过，无需判断 !list.contains
                list.add(sb.toString());
            return;
        }

        // 当str为""时候直接返回，不然下一句charAt(0)就会越界
        if (str.length() == 0) {
            return;
        }

        // 公式C(n, m) = C(n-1, m-1)+ C(n-1, m)
        // 第一个字符是组合中的第一个字符，在剩下的n-1个字符中选m-1个字符
        sb.append(str.charAt(0)); // 第一个字符选中
        collect(str.substring(1), sb, number - 1, list);
        sb.deleteCharAt(sb.length() - 1); // 取消选中第一个字符
        // 第一个字符不是组合中的第一个字符，在剩下的n-1个字符中选m个字符
        collect(str.substring(1), sb, number, list);
    }

//    public void hypre (String hy) {
//        char[] hychar = hy.toCharArray();
//        hy(hychar,2,0);
//    }
//
//    public void hy (char[] hychar, int maxSeat , int begin){
//        if (maxSeat==0 || maxSeat == hychar.length) {
//            System.out.println(String.valueOf(hychar));
//            return ;
//        }
//        if (begin==maxSeat) {
//            System.out.println(String.valueOf(hychar).substring(0,maxSeat));
//            return ;
//        }
//        if (maxSeat==1) {
//            int end = hychar.length-1;
//            for (int i =begin;i<=end;i++) {
//                swaphy(hychar,begin,i);
//                hy(hychar,maxSeat,begin+1);
//                swaphy(hychar,begin,i);
//            }
//        } else {
//
//
//
//        }
//
//        int end = hychar.length-1;
//        for (int i =begin;i<=end;i++) {
//            swaphy(hychar,begin,i);
//            hy(hychar,maxSeat,begin+1);
//            swaphy(hychar,begin,i);
//        }
//
//    }
//
//    void swaphy (char[] chars,int begin,int end) {
//        char temp = chars[begin];
//        chars[begin] = chars[end];
//        chars[end] = temp;
//    }

    /*
    *  hy 需要被操作的字符串
    *  m 顶数
    * */
    public void hypre (String hy,int m) {
        char[] hychar = hy.toCharArray();
        StringBuilder sb =new StringBuilder(m);
        hy(hychar,0,hychar.length-1, m,sb);
    }

    /*
    * hychar 即将要操作的数组，
    * n_begin 数组中需要被操作的范围的begin下标
    * n_end 数组中需要被操作的范围的end下标
    * m 顶数
    * 存放结果的StringBuilder
    * */
    public void hy (char[] hychar , int n_begin, int n_end , int m , StringBuilder sb) {
        System.out.println(n_begin+"  "+n_end+" "+sb );
        if (n_end-n_begin+1 < m) {
            return;
        }
        if (n_end-n_begin+1 < 1) {
            return;
        }
        // C11
        if (n_end-n_begin+1 ==1) {
            System.out.println(sb.append(hychar[n_begin]));
            return;
        }
        // Cnn
        if (n_end-n_begin+1 ==m) {
            System.out.println(sb.append(String.valueOf(hychar).substring(n_begin)));
            return;
        }
        //Cn0
        if (m==0) {
            System.out.println(sb.append(String.valueOf(hychar).substring(n_begin)));
            return;
        }
        //Cn1
        if (m==1) {
            for (int i = n_begin;i<=n_end;i++) {
                System.out.println(sb.append(hychar[i]));
                sb.deleteCharAt(sb.length()-1);
            }
        } else {
            // 操作范围内第一个字符没有入选
            hy(hychar,n_begin+1,n_end,m,new StringBuilder(sb));
            // 操作范围内第一个字符入选
            hy(hychar,n_begin+1,n_end,m-1,new StringBuilder(sb).append(hychar[n_begin]));
        }


    }



    public static void main(String[] args) {
        $38_2Combination c = new $38_2Combination();
//        System.out.println(c.combination("abcca"));
//        System.out.println(c.combination("abc"));
//        System.out.println(c.combinationAccordingToNum("aabbc", 2));
        c.hypre("abcd",3);

    }
}
