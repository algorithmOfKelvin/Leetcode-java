package vip.kelvin.leetCode;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Kelvin范显
 * @date 2020/6/11 上午4:51
 */
public class C739_dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int t = T[i];
            while (!stack.isEmpty() && t > T[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        C739_dailyTemperatures s = new C739_dailyTemperatures();
        int[] r = s.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(JSONObject.toJSON(r));
    }
}
