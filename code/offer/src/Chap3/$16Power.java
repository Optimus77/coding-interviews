package Chap3;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 不得使用库函数直接实现，无需考虑大数问题。
 */
public class $16Power {
    /**
     * 容易想到的蹩脚办法
     *
     * @param base     基数
     * @param exponent 次幂
     * @return base^exponent
     */
    public double power_2(double base, int exponent) {

        if (base == 0) {
            return 0;
        }

        double result = 1.0;
        int positiveExponent = Math.abs(exponent);
        for (int i = 0; i < positiveExponent; i++) {
            result *= base;
        }
        return exponent < 0 ? 1 /result : result;
    }

    /**
     * 非递归。推荐的做法，复杂度O(lg n)
     */
    public double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }

        double result = 1.0;
        int positiveExponent = Math.abs(exponent);

        while (positiveExponent != 0) {
            // positiveExponent & 1这句是判断奇数的
            if ((positiveExponent & 1) == 1) {
                result *= base;
            }

            base *= base;
            // 右移1位等于除以2
            positiveExponent = positiveExponent >> 1;
        }

        return exponent < 0 ? 1 / result : result;
    }

    /**
     * 和上面是同一个思路，递归版本。
     */
    private double powerUnsigned(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent == -1) {
            return 1.0/base;
        }
        double result = powerUnsigned(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

    public double power_1(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        int positiveExponent = Math.abs(exponent);
        double result = powerUnsigned(base, positiveExponent);
        return exponent < 0 ? 1 / result : result;
    }

    public static void main(String[] args) {
        $16Power a = new $16Power();
        System.out.println(a.powerUnsigned(2,-1));
    }
}
