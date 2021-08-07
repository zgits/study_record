package design_patterns.active_model.observer.jdkobserver;

import java.util.Observable;

/**
 * @author
 * @date 2021年07月31日 11:20
 * @description
 */
public class ownersubject extends Observable {


    private String content;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;


        //需要调用setChange
        this.setChanged();

        // 推方式
        this.notifyObservers(content);


        //拉方式
//        this.notifyObservers();
    }
}
