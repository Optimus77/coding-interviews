package Chap2;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class $10_3JumpFloor2 {
    /**
     * 到达1级台阶只有1种可能，到达2级台阶有2种可能；可记为f(1) = 1,f(2) = 2
     * 要到达3级台阶，可以选择在1级台阶处起跳，也可以选择在2级台阶处起跳，也可直接跳到3级，所以只需到达1级台阶的可能情况 + 到达2级台阶的可能情况 + 1，即f(3) = f(2) +f(1) + 1
     * 同理到达n级台阶，可以在n-1级台阶起跳，可在n-2、n-1、n-3...级台阶起跳，f(n) = f(n-1)+f(n-2)+f(n-3)...+1,
     * 如果令f(n-n) = f(0) = 1,上式可表示为f(n) = f(n-1)+f(n-2)+f(n-3)...+f(n-n),
     *
     * ！！还有种更好理解的思路：前n-1级台阶，每级台阶都有两种选择——跳到此或不跳到此，对于最后一级n级，没得选择，必须跳到这里
     * 所以有2^(n-1)种跳法
     *
     * @param target 要到达的第n级台阶
     * @return 达n级台阶总共的跳法可能
     */
    public int jumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        return (int) Math.pow(2, target - 1);
    }
}
