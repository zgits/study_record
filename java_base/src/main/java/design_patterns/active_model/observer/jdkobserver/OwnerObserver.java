package design_patterns.active_model.observer.jdkobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * @author
 * @date 2021年07月31日 11:23
 * @description
 */
public class OwnerObserver implements Observer {


    private String observerName;


    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(Observable o, Object arg) {


        System.out.println(observerName + ":" + arg);


        System.out.println(observerName + ":" + o.getClass().getName());


    }
}
