package design_patterns.buildFactory_model.singleton;

public class Test {

    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        System.out.println(lazySingleton == lazySingleton1);
    }
}
