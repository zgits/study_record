package design_patterns.active_model.COR.handler;

/**
 * @author
 * @date 2021年07月13日 22:49
 * @description
 */
public abstract class PriceHandler {


    protected PriceHandler successor;

    public static PriceHandler createHandler() {

        PriceHandler sales = new Sales();
        PriceHandler sales2 = new Sales2();
        PriceHandler saleslast = new SalesLast();

        sales.setSuccessor(sales2);
        sales2.setSuccessor(saleslast);
        return sales;
    }


    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }


    public abstract void processDisCount(float discount);
}
