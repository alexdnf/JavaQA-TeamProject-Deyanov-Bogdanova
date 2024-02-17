package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void NegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(-1000, 5000, 10000, 5);
        });
    }

    @Test
    public void NegativeMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(1000, -1000, 10000, 5);
        });
    }

    @Test
    public void NegativeMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(6000, 5000, -10000, 5);
        });
    }

    @Test
    public void NegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(6000, 5000, 10000, -5);
        });
    }

    @Test
    public void InitialBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(1000, 5000, 10000, 5);
        });
    }

    @Test
    public void MinBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(16000, 15000, 10000, 5);
        });
    }


    @Test
    public void shouldNotPayMoreThanBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertFalse(account.pay(12000));
    }

    @Test
    public void shouldPay() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertTrue(account.pay(1000));
    }

    @Test
    public void shouldNotPayNegativeAmount() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertFalse(account.pay(-1000));
    }

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }


    @Test
    public void shouldNotAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertFalse(account.add(15000));
    }

    @Test
    public void shouldNotAddNegativeAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertFalse(account.add(-1000));
    }
}
