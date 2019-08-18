package Chap5;

/**
 * 在一个mxn的棋盘的每一格斗放油一个礼物，每个礼物都有一定的价值（大于0）
 * 从棋盘的左上角开始，每次可以往右边或者下边移动一格，知道到达棋盘的右下角。
 * 给定一个棋盘和上面的礼物，计算我们最多可以拿到多少价值的礼物
 */


public class MaxGiftValHY {
/**
 * 已知gift [i][j]，
 * 0 < i < gift [0].length ，
 * 0 < j < gift .length ，
 * f （i，j）=Max 【f（i-1，j）， f（i，j-1）】 + gift（i，j）；
 * */

    static int[][] gift = {
            {1,10,3,8},
            {12,2,9,6},
            {5,7,4,11},
            {3,7,16,5}
    } ;
    static int res ;

    int getMaxValueSolution (int i,int j){

        return Math.max(dynamicProgramming(res,i-1,j),dynamicProgramming(res,i,j-1))+gift[i][j];

    }

    int dynamicProgramming (int res ,int i,int j){

        if (i!=0 && j!=0) {
            return res+= Math.max(dynamicProgramming(res,i-1,j),dynamicProgramming(res,i,j-1))+gift[i][j];
        } else if (i!=0 && j==0) {
            return res+= dynamicProgramming(res,i-1,j)+gift[i][j];
        } else if (i==0 && j!=0) {
            try {
                return res+= dynamicProgramming(res,i,j-1)+gift[i][j];
            } catch (Exception e ) {
                System.out.println(i+" "+j);
                System.out.println(res);
                System.out.println(gift[i][j]);
            }

        } else {
            res+= gift[i][j];
        }

    }

    public static void main(String[] args) {
        MaxGiftValHY m =new MaxGiftValHY();
        System.out.println(m.getMaxValueSolution(4,4));
//        System.out.println(gift[0][1]);
    }

}
