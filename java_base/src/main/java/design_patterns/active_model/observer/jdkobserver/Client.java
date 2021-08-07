package design_patterns.active_model.observer.jdkobserver;

/**
 * @author
 * @date 2021年07月31日 11:25
 * @description
 */
public class Client {


    public static void main(String[] args) {

        ownersubject ownersubject = new ownersubject();


        OwnerObserver ownerObserver1 = new OwnerObserver();
        OwnerObserver ownerObserver2 = new OwnerObserver();



        ownerObserver1.setObserverName("1");
        ownerObserver2.setObserverName("2");

        ownersubject.addObserver(ownerObserver1);
        ownersubject.addObserver(ownerObserver2);

        ownersubject.setContent("update");


    }

}
