package com.pmxxx.account;

/**
 * This exception is triggered whenever a withdrawal is required on a customer account
 * and this withdrawal does not comply to the balance verification rules
 */
public class IllegalBalanceException extends Exception {

    private static final long serialVersionUID = -9204191749972551939L;

    private double balance;

    public IllegalBalanceException(double illegalBalance) {
        balance = illegalBalance;
    }

    public String toString() {
        return "Illegal account balance: " + balance;
    }
}
