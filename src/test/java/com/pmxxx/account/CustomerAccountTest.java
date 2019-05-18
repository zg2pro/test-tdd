package com.pmxxx.account;

import com.pmxxx.account.implementation.CustomerAccount;
import com.pmxxx.account.implementation.CustomerAccountRule;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, then develop the code that makes it pass. Then
 * focus on the second test, and so on.
 *
 * We want to see how you "think code", and how you organize and structure a
 * simple application.
 *
 * When you are done, please zip the whole project (incl. source-code) and send
 * it to recrutement-dev@pmxxx.com
 *
 */
public class CustomerAccountTest {

    private Account customerAccount;

    @Before
    public void setUp() {
        customerAccount = new CustomerAccount();
    }

    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertNotNull(customerAccount.getBalance());
    }

    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        customerAccount.add(1.0);
        assertEquals(1.0, customerAccount.getBalance(), 0.0);
        try {
            customerAccount.add(-2.0);
            fail("This is a cash-in method only and we should have failed adding a negative");
        } catch (IllegalArgumentException iae) {
        } catch (Throwable t) {
            fail("The exception raised here was unexpected");
        }
        //testing null as a parameter is no longer required since we use primitives instead of wrapper class
    }

    /**
     * Tests that an illegal withdrawal throws the expected exception. Use the
     * logic contained in CustomerAccountRule; feel free to refactor the
     * existing code.
     * @throws com.pmxxx.account.IllegalBalanceException
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
        AccountRule rule = new CustomerAccountRule();
        customerAccount.add(1.0);
        customerAccount.withdrawAndReportBalance(1.0, rule);
        assertEquals(0.0, customerAccount.getBalance(), 0.0);
        try {
            customerAccount.withdrawAndReportBalance(1.0, rule);
            fail("This is a cash-in method only and we should have failed adding a negative");
        } catch (IllegalBalanceException rte) {
            assertEquals(true, rte.toString().contains("Illegal account balance"));
        } catch (Throwable e) {
            fail("The exception raised here was unexpected");
        }
        //testing null as a parameter is no longer required since we use primitives instead of wrapper class
        customerAccount.withdrawAndReportBalance(1.0, null);
        assertEquals(-1.0, customerAccount.getBalance(), 0.0);
    }

    // no further tests, see codecov in target/site/jacoco, also see codeclimate if you can access the gitlab repo
}
