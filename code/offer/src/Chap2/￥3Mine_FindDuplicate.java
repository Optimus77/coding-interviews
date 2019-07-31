package Chap2;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2或者3。
 */
public class ￥3Mine_FindDuplicate {
/*
* 我的思路：
* 不需要修改原数组。
* 数组长度为n，数字的取值范围也是n，只有当数组中的数字与取值范围内的数字一一对应才没有重复的。
* 所以，在某个取值范围的子集内，数组的数字在这个子集中的个数已一定大于子集的区间长度。
*  选择二分法找到这个最小的子集即可：
*  [0,(n-1)/2]的范围内应该有(n-1)/2+1个数字; ((n-1)/2,(n-1)]的范围内应该有(n-1)/2个数字;
 *
* */
        static int[] arr ={2,3,1,0,2,5,3};

        public static int FindDuplicate (int [] arr) {
            return 1;
        }

    public static void main(String[] args) {
        FindDuplicate(arr);
    }

}
