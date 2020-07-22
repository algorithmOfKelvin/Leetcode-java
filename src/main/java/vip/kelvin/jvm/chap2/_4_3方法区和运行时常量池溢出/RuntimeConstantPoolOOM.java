package vip.kelvin.jvm.chap2._4_3方法区和运行时常量池溢出;

import java.util.HashSet;

/**
 * 代码清单2-7 运行时常量池导致的内存溢出异常
 * VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M
 * @author Kelvin范显
 * @date 2020/7/22 下午12:30
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        HashSet<String> set = new HashSet<String>();
        // 在Short范围内，足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
