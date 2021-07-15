package design_patterns.active_model.COR.handler;

/**
 * @author
 * @date 2021年07月13日 22:52
 * @description
 */
public class Sales2 extends PriceHandler{




    @Override
    public void processDisCount(float discount) {
        if (discount <= 0.1) {
            System.out.format("%.2f%n,具体实现类%s", discount, this.getClass().getName());
        } else {
            successor.processDisCount(discount);
        }
    }
}
