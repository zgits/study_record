package design_patterns.structure_model.bridge;

/**
 * @author
 * @date 2021年07月14日 21:05
 * @description
 */
public class BridgeTest {

    public static void main(String[] args) {
        Implementor imple = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(imple);
        abs.Operation();
    }
}


// 实现化角色
interface Implementor {
    void OperationImpl();
}


//具体实现化角色
class ConcreteImplementorA implements Implementor {

    @Override
    public void OperationImpl() {
        System.out.println("具体实现化角色被访问"+this.getClass().getSimpleName());
    }
}



// 抽象化角色
abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }


    public abstract void Operation();
}


// 扩展抽象化角色
class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void Operation() {
        System.out.println("扩展抽象化角色被访问" + this.getClass().getName());
        implementor.OperationImpl();
    }
}



