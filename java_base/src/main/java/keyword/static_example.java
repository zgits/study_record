package keyword;

/**
 * @author
 * @date 2021年08月08日 10:15
 * @description static关键字示例
 *
 *
 *
 *
 * <p>
 *
 * 1. 静态变量 静态变量: 又称为类变量，也就是说这个变量属于类的，类所有的实例都共享静态变量，可以直接通过类名来访问它；静态变量在内存中只存在一份。
 *    实例变量: 每创建一个实例就会产生一个实例变量，它与该实例同生共死。
 *
 *
 * 2. 静态方法
 * 静态方法在类加载的时候就存在了，它不依赖于任何实例。所以静态方法必须有实现，也就是说它不能是抽象方法(abstract)。
 * 只能访问所属类的静态字段和静态方法，方法中不能有 this 和 super 关键字。
 *
 *
 *
 * 3. 静态语句块
 *
 * 静态语句块在类初始化时运行一次。
 *
 *
 *
 * 4. 静态内部类
 *
 * 非静态内部类依赖于外部类的实例，而静态内部类不需要。
 *
 * 静态内部类不能访问外部类的非静态的变量和方法。
 *
 * 5. 静态导包
 *
 * 在使用静态变量和方法时不用再指明 ClassName，从而简化代码，但可读性大大降低。
 *
 *
 * 6. 初始化顺序
 *
 * 静态变量和静态语句块优先于实例变量和普通语句块，静态变量和静态语句块的初始化顺序取决于它们在代码中的顺序。最后才是构造函数的初始化。
 *
 **********************************************
 * public static String staticField = "静态变量";
 *
 *
 * static {
 *     System.out.println("静态语句块");
 * }
 *
 * public String field = "实例变量";
 *
 *
 * {
 *     System.out.println("普通语句块");
 * }
 *
 *
 * public InitialOrderTest() {
 *     System.out.println("构造函数");
 * }
 ***********************************************
 * 存在继承的情况下，初始化顺序为:
 * 父类(静态变量、静态语句块)
 * 子类(静态变量、静态语句块)
 * 父类(实例变量、普通语句块)
 * 父类(构造函数)
 * 子类(实例变量、普通语句块)
 * 子类(构造函数)
 * </p>
 */
public class static_example {

    private static int x;
    private int y;

    static {
        System.out.println("123");
    }


    public static void func1(){
        int a = x;
        // int b = y;  // Non-static field 'y' cannot be referenced from a static context
        // int b = this.y;     // 'A.this' cannot be referenced from a static context
    }


    public static void main(String[] args) {
        static_example a = new static_example();
        static_example b = new static_example();
    }

}
