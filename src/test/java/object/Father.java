package object;

/**
 * Created by dell on 2017-12-05.
 */
public class Father {

    public Father(){
        System.out.println("我是父类构造器");
    }

    static {
        System.out.println("我是父类静态块");
    }

    {
        System.out.println("我是父类初始化块");
    }


    private void work() {
        System.out.println("我在工作");
    }

    public void study() {
        System.out.println("我在学习");
    }
}
