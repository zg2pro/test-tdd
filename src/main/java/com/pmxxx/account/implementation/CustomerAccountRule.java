package com.pmxxx.account.implementation;

import com.pmxxx.account.AccountRule;

/**
 * rules dedicated to customer accounts check
 */
public class CustomerAccountRule implements AccountRule {

    /* (non-Javadoc)
     * @see com.pmxxx.account.AccountRule#withdrawPermitted(java.lang.Double)
     */
    public boolean withdrawPermitted(double resultingAccountBalance) {
        return resultingAccountBalance >= 0;
    }

}
