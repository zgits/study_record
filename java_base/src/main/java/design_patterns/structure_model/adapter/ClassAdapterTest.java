package design_patterns.structure_model.adapter;

/**
 * @author
 * @date 2021年07月14日 20:43
 * @description
 */
public class ClassAdapterTest {


    public static void main(String[] args) {
        System.out.println("类适配器模式测试");


        Target target = new ClassAdapter();
        target.request();


        System.out.println("对象适配器模式测试");

        Adaptee adaptee = new Adaptee();
        Target target1 = new ObjectAdapter(adaptee);
        target1.request();


    }

}


// 目标接口
interface Target{
    void request();
}



//适配者接口
class Adaptee{
    public void SpecailRequest(){
        System.out.println("适配者中的业务代码被调用");
    }
}

// 类适配器类
class ClassAdapter extends Adaptee implements Target {

    @Override
    public void request() {
        SpecailRequest();
    }
}


//对象适配器
class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.SpecailRequest();
    }
}



