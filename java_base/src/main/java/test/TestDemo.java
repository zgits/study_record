package test;

/**
 * @author
 * @date 2021年09月12日 16:19
 * @description
 */
public class TestDemo {



    public static void simpleTryCatch() {
        try {
            System.out.println("1111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String arch = System.getProperty("sun.arch.data.model");
        System.out.println(arch+"-bit");
    }
}
