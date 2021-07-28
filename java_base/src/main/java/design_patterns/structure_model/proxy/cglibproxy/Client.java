package design_patterns.structure_model.proxy.cglibproxy;

/**
 * @author
 * @date 2021年07月28日 20:28
 * @description
 */
public class Client {


    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Train train = (Train) cglibProxy.getProxy(Train.class);
        train.move();

    }
}
