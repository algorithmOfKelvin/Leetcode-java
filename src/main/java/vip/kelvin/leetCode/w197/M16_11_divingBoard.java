package vip.kelvin.leetCode.w197;

/**
 * @author Kelvin范显
 * @date 2020/7/8 上午8:36
 */
public class M16_11_divingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{shorter * k};

        int[] ans = new int[k + 1];
        for (int i = 0; i <= k; i++)
            ans[i] = shorter * (k - i) + longer * i;
        return ans;
    }
}
