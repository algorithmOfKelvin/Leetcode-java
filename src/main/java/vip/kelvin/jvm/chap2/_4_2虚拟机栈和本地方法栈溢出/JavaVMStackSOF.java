package vip.kelvin.jvm.chap2._4_2虚拟机栈和本地方法栈溢出;

/**
 * 代码清单2-4 虚拟机栈和本地方法栈测试（作为第1点测试程序） 「虚拟机栈容量太小」
 * VM Args: -Xss128k
 * @author Kelvin范显
 * @date 2020/7/22 上午11:29
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println(String.format("stack length: %s", oom.stackLength));
            throw e;
        }
    }
}
