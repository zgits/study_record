package design_patterns.active_model.COR;

import design_patterns.active_model.COR.handler.PriceHandler;

import java.util.Random;

/**
 * @author
 * @date 2021年07月13日 22:57
 * @description
 */
public class Client {


    private PriceHandler priceHandler;


    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void requestDicCount(float disCount) {
        priceHandler.processDisCount(disCount);

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.setPriceHandler(PriceHandler.createHandler());

        Random random = new Random();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i+":");
            client.requestDicCount(random.nextFloat());
        }
    }
}
