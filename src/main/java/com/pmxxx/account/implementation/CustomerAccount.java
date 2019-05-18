package com.pmxxx.account.implementation;

import com.pmxxx.account.AccountRule;
import com.pmxxx.account.IllegalBalanceException;
import com.pmxxx.account.Account;

/**
 * Account dedicated to end-customers
 */
public class CustomerAccount implements Account {

    private double balance = 0.0;

    public void add(double addedAmount) {
        if (addedAmount < 0) {
            throw new IllegalArgumentException("any withdrawal from the account must be checked using withdrawAndReportBalance()");
        }
        balance += addedAmount;
    }

    public double getBalance() {
        return balance;
    }

    public double withdrawAndReportBalance(double withdrawnAmount, AccountRule rule) throws IllegalBalanceException {
        double anticipatedBalance = getBalance() - withdrawnAmount;
        if (rule != null && !rule.withdrawPermitted(anticipatedBalance)) {
            throw new IllegalBalanceException(anticipatedBalance);
        }
        balance = anticipatedBalance;
        return getBalance();
    }

}
