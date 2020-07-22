package vip.kelvin.jvm.chap2._4_2虚拟机栈和本地方法栈溢出;

/**
 * 代码清单2-6 创建线程导致内存溢出异常
 * VM Args: -Xss2M
 * @author Kelvin范显
 * @date 2020/7/22 下午12:06
 * 如果是建立过多线程导致的内存溢出，
 * 在不能减少线程数量或者更换64位虚拟机的情况下，
 * 就只能通过减少最大堆和减少栈容量来换取更多的线程。
 */
public class JavaVMStackOOM {

    private void downStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    downStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
