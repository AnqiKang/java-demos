package codeTest.designPattern.factory;

/**
 * Factory： 具体产品的工厂
 */
public class AliPayFactory implements PayFactory {
    @Override
    public Pay getPay() {
        return new AliPay();
    }
}
