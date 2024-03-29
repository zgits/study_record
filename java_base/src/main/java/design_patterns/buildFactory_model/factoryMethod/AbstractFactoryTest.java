package design_patterns.buildFactory_model.factoryMethod;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        Product a;
        AbstractFactory abstractFactory;
        abstractFactory = (AbstractFactory) ReadXML1.getObject();
        a = abstractFactory.newProduct();
        a.show();
    }
}


interface Product {
    void show();
}


class ConcreteProduct1 implements Product {

    @Override
    public void show() {
        System.out.println("1");
    }
}


class ConcreteProduct2 implements Product {

    @Override
    public void show() {
        System.out.println("2");
    }
}


interface AbstractFactory {
    Product newProduct();
}


class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("生成"+ConcreteProduct1.class);
        return new ConcreteProduct1();
    }
}


class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("生成" + ConcreteProduct2.class);
        return new ConcreteProduct2();
    }
}


class ReadXML1 {
    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
    public static Object getObject() {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            System.out.println(ReadXML1.class.getResource("/").getPath());
            System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
            doc = builder.parse(new File("java_base/src/main/java/design_patterns/buildFactory_model/factoryMethod/config1.xml"));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName =  classNode.getNodeValue();
            System.out.println("新类名："+cName);
            //通过类名生成实例对象并将其返回
            Class<?> c = Class.forName(AbstractFactoryTest.class.getPackage().getName() + "." + cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}


