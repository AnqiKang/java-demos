package codeTest.designPattern.factory.simple;

/**
 * 简单工厂设计模式： 静态工厂方法
 * 可以根据参数的不同返回不同类的实例
 * 专门定义一个类来负责创建其他类的实例， 被创建的实例通常都具有共同的父类
 *
 * 静态方法， 可通过类名直接调用，只需要传入简单的参数
 *
 * 组成
 *  Factory ： 工厂类，负责实现创建实例的内部逻辑
 *  Product Interface： 抽象产品类，简单工厂模式所创建的所有对象的父类， 描述所有实例所共有的公共接口
 *  Product： 具体产品， 创建目标
 *
 * 步骤
 *  创建抽象产品类： 里面有产品的抽象方法，
 *  创建具体的产品类（多个实现类）： 继承抽象类，并根据各自的业务特点， 实现具体方法
 *  创建工厂类： 提供一个静态方法 createXXX用来生产产品，定义一个参数，来输入你想生产的对应产品
 *  调用的时候， 只需要传入对应参数，
 *
 *  缺点：
 *      违反了open-close principle
 *      工厂类的指责过重，每次新增加一个对应的实现方法，都需要修改创建工厂类的代码
 *      加入新增一个apple pay。除了需要增加一个apple pay实现类，还要在Pay Factory里面添加代码，
 *      如果这个代码出现错误，可能导致整个factory 无法使用
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimplePay weChatPay = SimplePayFactory.createPay("wechat");
        weChatPay.unifiedOrder();

        SimplePay aliPay = SimplePayFactory.createPay("ali");
        aliPay.unifiedOrder();

    }
}
