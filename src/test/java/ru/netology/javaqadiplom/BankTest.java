package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    SavingAccount account1 = new SavingAccount(6_000, 1_000, 10_000, 15);
    SavingAccount account2 = new SavingAccount(2_000, 1_000, 15_000, 15);


    @Test
    public void shouldTransferTest() {

        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(account1, account2, 5_000));

    }

    @Test
    public void shouldNotTransferTest() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account1, account2, 10_000));
    }

    @Test
    public void shouldNotTransferTestIfAmountIsFalse() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account1, account2, 0));
    }
}
