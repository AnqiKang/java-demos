package codeTest.designPattern.factory;

/**
 * Product A
 */

public class WeChatPay implements Pay {
    @Override
    public void unifiedPay() {
        System.out.println("Wechat pay");
    }
}
