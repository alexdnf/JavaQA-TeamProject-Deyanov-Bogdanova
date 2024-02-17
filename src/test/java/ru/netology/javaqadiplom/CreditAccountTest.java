package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -1000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayTest() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.pay(3000);

        Assertions.assertEquals(-2_000, account.getBalance());
    }

    @Test
    public void shouldNotPayTest() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        account.pay(10_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void yearChangeTestIfAccountIsPositive() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);


        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChangeTestIfAccountIsNegative() {
        CreditAccount account = new CreditAccount(-1_000, 5_000, 15);


        Assertions.assertEquals(-150, account.yearChange());
    }

    @Test
    public void creditAccountIfBalanceIsNegativeTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1_000, 5_000, 15);
        });
    }

    @Test
    public void creditAccountIfLimitIsNegativeTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, -5_000, 15);
        });
    }

    @Test
    public void creditAccountIfRateIsNegativeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000, 5_000, -15);
        });
    }

    @Test
    public void shouldNotPayIfFalseTest() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        Assertions.assertFalse(account.pay(-1_000));
    }

    @Test
    public void shouldNotAddIfFalseTest() {
        CreditAccount account = new CreditAccount(1_000, 5_000, 15);

        Assertions.assertFalse(account.add(-1_000));
    }
}
