package object;

/**
 * Created by dell on 2017-12-06.
 */
public class InnerClass {

    public static void main(String[] args) {
        //调用非内部静态类
        InnerClass.InnerNotStaticClass innerNotStaticClass = new InnerClass().new InnerNotStaticClass();
        innerNotStaticClass.getName();

        //调用内部静态类
        InnerClass.InnerStaticClass innerStaticClass = new InnerClass.InnerStaticClass();
        innerStaticClass.get();

        //调用内部类的内部类
        new InnerClass().new InnerNotStaticClass().new hh().tt();

    }

    public class InnerNotStaticClass {

        /**
         * 非静态内部类，不能拥有静态块，静态变量，静态方法, 下面声明会报如下错误：
         * Inner classs cannot have declarations
         */
        /*
        static {

        }

        public static String gender = "women";

        public static void get() {

        }
        */

        {
            System.out.println("非静态内部类非静态块");
        }

        private String name = "jing";

        public void getName() {
            System.out.println("获取名字");
        }


        /**
         * 内部类里面可以再套内部类
         */
        public class hh {
            public void tt() {
                System.out.println("我是内部类的内部类");
            }
        }
    }

    public static class InnerStaticClass {
        static {
            System.out.println("静态类静态块");
        }

        {
            System.out.println("");
        }

        public static String gender = "women";

        public String addr = "西安";

        public void get() {
            System.out.println(addr);
        }
    }
}
