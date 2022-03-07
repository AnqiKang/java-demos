package codeTest.designPattern.factory;
/**
 * Product B
 */
public class AliPay implements Pay {
    @Override
    public void unifiedPay() {
        System.out.println("Ali pay");
    }
}
