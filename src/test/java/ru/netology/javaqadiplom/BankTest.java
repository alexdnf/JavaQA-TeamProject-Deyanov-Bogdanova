package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    SavingAccount account1 = new SavingAccount(6_000, 1_000, 10_000, 15);
    SavingAccount account2 = new SavingAccount(2_000, 1_000, 15_000, 15);
    SavingAccount account3 = new SavingAccount(1_500, 1_000, 3_000, 15);

    CreditAccount account4 = new CreditAccount(1_000, 5_000, 15);
    CreditAccount account5 = new CreditAccount(3_000, 10_000, 15);

    @Test
    public void shouldTransferBetweenCreditAccountsTest1() {
        Bank bank = new Bank();

        bank.transfer(account5,account4,5_000);

        Assertions.assertEquals(-2_000, account5.getBalance());
        Assertions.assertEquals(6_000, account4.getBalance());
    }
    @Test
    public void shouldTransferBetweenCreditAccountsTest2() {
        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(account5,account4,5_000));
    }
    @Test
    public void shouldNotTransferBetweenCreditAccountsOverLimitTest() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account5, account4, 15_000));
    }
    @Test
    public void shouldNotTransferBetweenCreditAccountsZeroAmountTest() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account5, account4, 0));
    }
    @Test
    public void shouldNotTransferBetweenCreditAccountsAmountIsNegativeTest() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account5, account4, -1_000));
    }
    @Test
    public void shouldTransferBetweenSavingAccountsTest1() {
        Bank bank = new Bank();

        bank.transfer(account1, account2, 4_000);

        Assertions.assertEquals(2_000, account1.getBalance());
        Assertions.assertEquals(6_000, account2.getBalance());
    }
    @Test
    public void shouldTransferBetweenSavingAccountsTest2() {
        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(account2, account1, 500));
    }

    @Test
    public void shouldNotTransferBetweenSavingAccountsZeroAmountTest() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account1, account2, 0));
    }

    @Test
    public void shouldNotTransferBetweenSavingAccountsNegativeAmountTest() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account1, account2, -1_000));
    }
    @Test
    public void shouldNotTransferBetweenSavingAccountsLessMinBalanceTest() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account1, account2, 6_000));
    }
    @Test
    public void shouldNotTransferBetweenSavingAccountsMoreMaxBalanceTest() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(account1, account3, 3_000));
    }
    @Test
    public void shouldTransferFromSavingToCreditAccountTest() {
        Bank bank = new Bank();

        bank.transfer(account1, account4, 3_000);

        Assertions.assertEquals(3_000, account1.getBalance());
        Assertions.assertEquals(4_000, account4.getBalance());
    }
    @Test
    public void shouldTransferFromCreditToSavingAccountTest() {
        Bank bank = new Bank();

        bank.transfer(account4, account1, 3_000);

        Assertions.assertEquals(-2_000, account4.getBalance());
        Assertions.assertEquals(9_000, account1.getBalance());
    }
}


