package Chap3;

/**
 * 输入数字n，按顺序打印处1到最大的n位十进制数，比如输入3，则打印1~999之间的数
 */
public class $17PrintFrom1ToMaxOfNDigit {
    public void printFrom1ToMaxOfNDigit(int n) {
        if (n <= 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }

        while (stillIncrease(sb, n)) {
            print(sb);
        }

        System.out.println();
    }

    private boolean stillIncrease(StringBuilder sb, int len) {
        // 进位,应该要给下一位相加，所以设置在循环外
        int toTen = 0;
        // 从个位开始加，如果有进位就看十位...如果到最高位还有进位，说明溢出；
        for (int i = len - 1; i >= 0; i--) {
            // 加上进位toTen
            int sum = sb.charAt(i) - '0' + toTen;
            // 在个位上，先自增
            if (i == len - 1) {
                sum++;
            }

            if (sum == 10) {
                // 进位溢出
                if (i == 0) {
                    return false;
                    // 需要进位，当前位置为0，
                } else {
                    sb.setCharAt(i, '0');
                    // 进位了
                    toTen = 1;
                }
            } else {
                sb.setCharAt(i, (char) (sum + '0'));
                // 在某位上自增后不再进位，自增完成立即退出循环
                break;
            }
        }
        return true;
    }

    private void print(StringBuilder sb) {
        int start = sb.length();
        // 找到第一个不为0的索引
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                start = i;
                break;
            }
        }
        // 如果全是0，就不会打印
        if (start < sb.length()) {
            System.out.print(sb.substring(start) + " ");
        }
    }

    public void printFrom1ToMaxOfNDigitRecur(int n) {
        if (n <= 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }

        printRecur(sb, n, -1);
        System.out.println();
    }

    private void printRecur(StringBuilder sb, int len, int index) {
        if (index == len - 1) {
            print(sb);
            return;
        }

        for (int i = 0; i < 10; i++) {
            // 一定是先设置了字符，然后再递归
            sb.setCharAt(index + 1, (char) (i + '0'));
            printRecur(sb, len, index + 1);
        }
    }

    static int n =2;
    static char[] c = new char[n];
    static void print1 () {
        for (int i=0;i<n;i++) {
            c[i] = '0';
        }

        plus (c,n-1);
    }

    static void plus (char[] c ,int k) {
        if (c[k] != '9') {
            c[k] = (char) (c[k]+1);
            print2 ();
        } else  if (k-1>=0){
            c[k] = '0';
            plus (c,k-1);
        } else {
            return;
        }
    }

    static void print2 () {


    }



    static void useStringBuilder () {
        StringBuilder sb = new StringBuilder(n);
        for (int i=0;i<n;i++) {
            sb.append('0');
        }

        plusStringBuilder (sb,0) ;
    }

    static void plusStringBuilder (StringBuilder sb,int k) {
        for (int i =0; i<10;i++) {
            sb.setCharAt(k,(char)('0'+i));
            if (k<n-1 ) {
                plusStringBuilder(sb,k+1);
            } else {
                printStringBuilder(sb);
            }
        }
    }

    static void printStringBuilder(StringBuilder sb){
        int subStringStart = n;
        for (int i=0;i<n;i++) {
            if (sb.charAt(i)!='0') {
                subStringStart = i;
                break;
            }
        }

        if (subStringStart!=n)
        System.out.print(sb.substring(subStringStart)+" ");
    }


    public static void main(String[] args) {
        $17PrintFrom1ToMaxOfNDigit a = new $17PrintFrom1ToMaxOfNDigit();
//        a.printFrom1ToMaxOfNDigit(2);
        a.printFrom1ToMaxOfNDigitRecur(2);
        useStringBuilder();

    }
}
