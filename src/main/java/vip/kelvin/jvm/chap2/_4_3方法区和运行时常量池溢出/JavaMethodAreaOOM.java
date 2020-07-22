package vip.kelvin.jvm.chap2._4_3方法区和运行时常量池溢出;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代码清单2-9 借助CGLib使得方法区出现内存溢出异常
 * VM Args: -XX:permSize=10M -XX:MaxPermSize=10M
 * @author Kelvin范显
 * @date 2020/7/22 下午6:00
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }

    }

    static class OOMObject{}
}
