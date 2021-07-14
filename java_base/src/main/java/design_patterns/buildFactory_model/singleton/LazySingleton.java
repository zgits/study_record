package design_patterns.buildFactory_model.singleton;


/**
 * 惰性加载单例模式
 */
public class LazySingleton {


    private static volatile LazySingleton singleton = null;

    private LazySingleton() {

    }

    public static synchronized LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
