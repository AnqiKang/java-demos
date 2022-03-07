package codeTest.designPattern.factory.simple;

public class SimplePayFactory {

    // 根据参数返回对应的支付对象
    public static SimplePay createPay(String payType) {
        if (payType == null) {
            return null;
        } else if (payType.equalsIgnoreCase("WECHAT")) {
            return new SimpleWeChatPay();
        } else if (payType.equalsIgnoreCase("ALI")) {
            return new SimpleAliPay();
        }
        // 想拓展，继续编辑

        return null;
    }
}
