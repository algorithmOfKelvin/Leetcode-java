package vip.kelvin.jvm.chap2._4_3方法区和运行时常量池溢出;

/**
 * 代码清单2-8 String.intern()返回引用的测试 「JDK7，自永久代中的方法区-->堆中的元数据区」
 * @author Kelvin范显
 * @date 2020/7/22 下午5:16
 */
public class RuntimeConstantPoolOOM2 {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
