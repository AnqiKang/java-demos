package codeTest.designPattern.factory;

/**
 * 工厂方法模式： 对简单工厂模式的进一步抽象，不用改动旧代码，而实现添加新的功能。满足open-close principle。用的最多
 * 通过工厂父类负责创建产品的公共接口，通过子类来确定所需要创建的类型
 *  将类实例化（具体的产品创建）延迟到工厂类的子类（具体的工厂）中完成。 即由子类来决定应该实例化哪一个类
 *
 *  核心组成
 *  Product Interface： 抽象产品类，简单工厂模式所创建的所有对象的父类， 描述所有实例所共有的公共接口
 *  Product： 具体产品， 实现Product Interface的接口， 工厂类创建对象，如有多个需要定义多个
 *
 *  Factory Interface： 抽象工厂类， 描述具体的工厂的公共接口
 *  Factory： 具体工厂类，实现创建产品类对象，实现Factory Interface， 如有多个需要定义多个
 *
 *  如果想要增加一个新的支付方法，所有的旧代码都不需要改动，
 *  但是要增加一个具体的产品c，也需要增加对应的工厂类。
 *  想要去掉某个产品，直接删除即可
 *
 */
public class FactoryTest {
    public static void main(String[] args) {
       Pay weChatPay = new WeChatPayFactory().getPay();
       weChatPay.unifiedPay();

       Pay aliPay = new AliPayFactory().getPay();
       aliPay.unifiedPay();




    }


}
