package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1000,
                5000,
                15
        );

        account.add(4000);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.add(-2000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldCalculateYearChangeIfBalancePositive() {
        CreditAccount account = new CreditAccount(
                1500,
                5000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculateYearChangeIfBalanceNegative() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );
        account.add(1500);

        Assertions.assertEquals(0, account.yearChange());

    }

    @Test
    public void shouldNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1500, 5000, -15);
        });

    }

    @Test
    public void shouldNegativeInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1500, 5000, 15);
        });
    }

    @Test
    public void shouldNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1500, -5000, 15);
        });
    }

    @Test
    public void shouldPayPositiveAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.pay(1500);

        Assertions.assertEquals(-1500, account.getBalance());
    }

    @Test
    public void shouldPayAmountUnderLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5000,
                15
        );

        account.pay(7500);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldGetCreditLimit() {
        CreditAccount account = new CreditAccount(1500, 5000, 15);

        int expected = 5000;
        int actual = account.getCreditLimit();

        Assertions.assertEquals(expected, actual);
    }
}
