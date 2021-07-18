package design_patterns.active_model.strategy;

public class StrategyPattern {

    public static void main(String[] args) {
        Context c = new Context();
        Strategy s = new ConcreteStrategyA();
        c.setStrategy(s);
        c.strategyMethod();
        System.out.println("-----------------");
        s = new ConcreteStrategyB();
        c.setStrategy(s);
        c.strategyMethod();
    }
}


interface Strategy {
    void StrategyMethod();// 策略方法
}

class ConcreteStrategyA implements Strategy {

    @Override
    public void StrategyMethod() {
        System.out.println("策略A方法访问到");
    }
}

class ConcreteStrategyB implements Strategy {

    @Override
    public void StrategyMethod() {
        System.out.println("策略B方法访问到");
    }
}

class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod(){
        strategy.StrategyMethod();
    }
}
