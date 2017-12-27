package object;

/**
 * Created by dell on 2017-12-05.
 */
public class Son extends Father {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Son() {
        System.out.println("我是儿子构造器");
    }

    static {
        System.out.println("我是儿子静态块");
    }

    {
        System.out.println("我是儿子初始化块");
    }


    public static void main(String[] args) {
        new Son();


    }

    //重写父类方法
    @Override
    public void study() {
        //调用父类方法
        System.out.println("儿子在学习");
    }


}
