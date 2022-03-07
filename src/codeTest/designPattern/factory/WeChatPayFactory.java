package codeTest.designPattern.factory;

/**
 * Factory： 具体产品的工厂
 */
public class WeChatPayFactory implements PayFactory{
    @Override
    public Pay getPay() {
        return new WeChatPay();
    }
}
