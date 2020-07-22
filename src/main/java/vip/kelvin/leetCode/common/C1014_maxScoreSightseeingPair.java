package vip.kelvin.leetCode.common;

/**
 * @author Kelvin范显
 * @date 2020/6/17 上午7:51
 */
public class C1014_maxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int pre_max = A[0] + 0;
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, pre_max + A[i] - i);
            pre_max = Math.max(pre_max, A[i] + i);
        }
        return res;
    }

}
