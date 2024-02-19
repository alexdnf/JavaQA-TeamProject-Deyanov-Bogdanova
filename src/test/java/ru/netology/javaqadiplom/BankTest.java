package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    SavingAccount account1 = new SavingAccount(6_000, 1_000, 10_000, 15);
    SavingAccount account2 = new SavingAccount(2_000, 1_000, 15_000, 15);
    SavingAccount account3 = new SavingAccount(1_000, 1_000, 3_000, 15);


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
    @Test
    public void shouldNotTransferTestIfAmountIsFalse2() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account1, account2, -1));
    }
    @Test
    public void shouldTransferBalanceTest() {
        Bank bank = new Bank();

        bank.transfer(account1,account2, 5_000);

        Assertions.assertEquals(1_000, account1.getBalance());
        Assertions.assertEquals(7_000, account2.getBalance());
    }
    @Test
    public void shouldTransferBalanceTest1() {
        Bank bank = new Bank();

        bank.transfer(account2,account1, 500);

        Assertions.assertEquals(6_500, account1.getBalance());
        Assertions.assertEquals(1_500, account2.getBalance());
    }
    @Test
    public void shouldNotTransferIfAmountMoreThanBalance() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account2,account1,3_000));
    }
    @Test
    public void shouldNotTransferIfAddIsFalse() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account1,account3, 3_000));
    }
}
