package vip.kelvin.jvm;


import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 10.3 Java语法糖对味道
 * @1 Java与C#的泛型
 * @2 泛型的历史背景
 * @3 类型擦除
 * @4 值类型（ValueType）与未来的泛型
 */
public class _10_3 {

    /**
     *  code 10-2 Java中不支持对泛型用法
     * @param <E>
     */
    public class TypeErasureGenerics<E> {
        public void soSomething(Object item) {
//            if (item instanceof E) { // 不合法， 无法对泛型进行实例判断
//                //..
//            }
//            E newItem = new E(); // 不合法，无法使用泛型创建对象
//            E[] itemArray = new E[10]; // 不合法，无法使用泛型创建数组
        }
    }

    /**
     * 支持协变（Covariant）
     * List里面本身是允许不同类型的
     */
    @Test
    public void code3() {

        Object[] array = new String[10];
//        array[0] = 10; // compile good, run error--> java.lang.ArrayStoreException: java.lang.Integer

        ArrayList things = new ArrayList();
        things.add(Integer.valueOf(10)); // compile and run good
        things.add("hello world");
        things.forEach(System.out::println);
    }

    /**
     *  裸类型（Raw Type）————> Super Type
     */
    @Test
    public void code4() {
        ArrayList<Integer> ilist = new ArrayList<>();
        ArrayList<String> slist = new ArrayList<>();
        ArrayList list; // 裸类型
        list = ilist;
        list = slist;
    }

    /**
     * 泛型擦除前
     */
    @Test
    public void code5() {
        Map<String, String> map = new HashMap<>();
        map.put("hello","你好");
        map.put("how are you?","吃了没？");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }
    /**
     * 泛型擦除后
     */
    @Test
    public void code6() {
        Map map = new HashMap();
        map.put("hello","你好");
        map.put("how are you?","吃了没？");
        System.out.println((String)map.get("hello"));
        System.out.println((String)map.get("how are you?"));
    }

    /**
     * 实现原始类型的泛型很麻烦。。
     */
    @Test
    public void code7() {
//        ArrayList<int> ilist = new ArrayList<int>();
//        ArrayList<long> llist = new ArrayList<long>();
//        ArrayList list;
//        list = ilist;
//        list = llist;
    }

    /**
     * 不得不从一个额外参数中再传入一个数组的组件类型进去，实属无奈。
     * 因为泛型T运行时被擦除了……
     *
     * @param list
     * @param componentType
     * @param <T>
     * @return
     */
    @Test
    public static <T> T[] code8_convert(List<T> list, Class<T> componentType){
        T[] array = (T[]) Array.newInstance(componentType, list.size());
        return array;
    }

    /**
     * 自动装箱、拆箱与遍历循环
     */
    @Test
    public void code11() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
    }
    /**
     * 自动装箱、拆箱与遍历循环编译之后
     */
    @Test
    public void code12() {
        List list = Arrays.asList(new Integer[]{
                Integer.valueOf(1),
                Integer.valueOf(2),
                Integer.valueOf(3),
                Integer.valueOf(4)
        });

        int sum = 0;
        for (Iterator localIterator = list.iterator(); localIterator.hasNext();) {
            int i = ((Integer)localIterator.next()).intValue();
            sum += i;
        }
        System.out.println(sum);
    }

    @Test
    public void code13() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); // true
        System.out.println(e == f); // false
        System.out.println(c == (a + b)); // true
        System.out.println(c.equals(a + b)); // true
        System.out.println(g == (a + b)); // true
        System.out.println(g.equals(a + b)); //false
    }
}
