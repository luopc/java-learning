package com.luopc.override;

public class MyOuter {

    private int x = 100;

    private static int a = 100;

    // 创建内部类
    class MyInner {
        private String y = "Hello!";

        public void innerMethod() {
            System.out.println("内部类中 String y = " + y);
            System.out.println("外部类中的int x = " + x);// 直接访问外部类中的实例变量x
            outerMethod();
            System.out.println("x = " + MyOuter.this.x);
        }
    }

    public void outerMethod() {
        x++;
    }

    public void makeInner() {
        // 在外部类方法中创建内部类实例
        MyInner in = new MyInner();
        in.innerMethod();
    }

    /**
     * 静态内部类
     * 
     * @author luopc
     *
     */
    static class MyStaticInner {
        private String y = "Hello!";

        public void innerMethod() {
            System.out.println("a=" + a);// 可以访问外部的静态变量
            System.out.println("y=" + y);
        }
    }

    private int size = 5, y = 7;

    /**
     * 局部内部类
     */
    public Object makeInner(int localVar) {
        final int finalLocalVar = localVar;
        // 创建内部类，该类只在makeInner（）方法有效，就像局部变量一样。在方法体外部不能创建MyInner类的对象
        class MyInner {
            int y = 4;

            public String toString() {
                return "OuterSize:" + size + "\nfinalLocalVar=" + finalLocalVar + "，this.y=" + this.y + ",localVar="+localVar;

            }
        }
        return new MyInner();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        MyOuter mo = new MyOuter();
        // 使用外部类构造方法创建mo对象
        MyOuter.MyInner inner = mo.new MyInner();// 常规内部类需要通过外部类的实例才能创建对象，与实例变量需要通过对象来访问相似
        // 创建inner对象
        inner.innerMethod();
        System.out.println("--------------------------------");
        MyStaticInner si = new MyOuter.MyStaticInner();
        si.innerMethod();
        System.out.println("--------------------------------");
        Object obj = new MyOuter().makeInner(47);// 创建MyOuter对象obj，并调用它的makeInner（）方法，该方法返回一个
        // 该方法返回一个MyInner类型的的对象obj，然后调用其同toString方法。
        System.out.println(obj.toString());

    }

}