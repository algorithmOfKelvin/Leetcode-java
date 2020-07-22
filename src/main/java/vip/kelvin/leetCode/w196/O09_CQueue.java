package vip.kelvin.leetCode.w196;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Kelvin范显
 * @date 2020/6/30 下午9:09
 */
public class O09_CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public O09_CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }
}
