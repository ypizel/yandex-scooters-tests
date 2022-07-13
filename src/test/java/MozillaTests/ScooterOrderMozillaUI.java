package MozillaTests;

import PageObject.OrderFields;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ScooterOrderMozillaUI extends BaseMozillaUITest {

    @Test
    public void checkMakeOrderWithTopButton() {
        boolean isOrderStatusDisplayed = new OrderFields(driver)
                .open()
                .clickTopOrderButton()
                .setAllOrderFields()
                .getOrderStatus();
        assertTrue("Заказ не оформлен", isOrderStatusDisplayed);
    }
    @Test
    public void checkMakeOrderWithBottomButton() {
        boolean isOrderStatusDisplayed = new OrderFields(driver)
                .open()
                .clickBottomOrderButton()
                .setAllOrderFields()
                .getOrderStatus();
        assertTrue("Заказ не оформлен", isOrderStatusDisplayed);
    }
}

