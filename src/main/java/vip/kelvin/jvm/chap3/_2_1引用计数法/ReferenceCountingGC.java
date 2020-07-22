package vip.kelvin.jvm.chap3._2_1引用计数法;

/**
 * 无法重现作者
 *
 * 代码清单3-1 引用计数算法的缺陷
 * 「循环引用」
 * testGC()方法执行后，objA和objB会不会被GC呢？
 * @author Kelvin范显
 * @date 2020/7/22 上午6:24
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这行发生GC， objA和objB是否能被回收？
        System.gc();
    }
}
