package codeTest.designPattern.factory.simple;

public class SimpleWeChatPay implements SimplePay{
    @Override
    public void unifiedOrder() {
        System.out.println("Wechat pay");
    }
}
