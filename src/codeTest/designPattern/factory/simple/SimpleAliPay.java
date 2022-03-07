package codeTest.designPattern.factory.simple;

public class SimpleAliPay implements SimplePay{
    @Override
    public void unifiedOrder() {
        System.out.println("Ali pay");
    }
}
