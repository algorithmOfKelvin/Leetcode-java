package vip.kelvin.jvm.chap2._4_1Java堆溢出;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码清单2-3 Java堆内存溢出异常测试
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *  1. 引用路径
 *  2. 哪些GC Roots相关联
 *  3. 泄漏对象的类型
 *  4. GCRoots引用链
 * @author Kelvin范显
 * @date 2020/7/22 上午6:35
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
