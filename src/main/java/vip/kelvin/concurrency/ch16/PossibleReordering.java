package vip.kelvin.concurrency.ch16;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;

/**
 * 图 16-1 PossibleReordering中存在重排序的交替执行
 * @author Kelvin范显
 * @date 2020/7/21 下午5:59
 */
public class PossibleReordering {
    static int x=0, y =0;
    static int a=0, b =0;

    public String run() throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 1;
                x = b;
            }
        });
        Thread other = new Thread(new Runnable() {
            @Override
            public void run() {
                b = 1;
                y = a;
            }
        });

        one.start(); other.start();
        one.join(); other.join();
        return String.format("(%d, %d)", x,y);
    }

    public static void main(String[] args) throws InterruptedException {
        HashSet<String> res = new HashSet<>();
        while (res.size() < 2) {
            PossibleReordering possibleReordering = new PossibleReordering();
            res.add(possibleReordering.run());
        }
        System.out.println(JSONObject.toJSON(res));
    }
}
