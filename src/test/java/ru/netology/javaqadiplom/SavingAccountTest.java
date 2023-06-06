package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SavingAccountTest {


    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());//должно приходить 5
    }

    @Test
    public void shouldAddOverThanMaxBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(30_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddAmountLessThanZero() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);

        account.add(-1_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddAmountBoolean() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        Assertions.assertTrue(account.add(3_000));
        Assertions.assertFalse(account.add(30_000));
        Assertions.assertFalse(account.add(-1_000));
    }

    @Test
    public void shouldPayLessThenMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void shouldPayOverThenMinBalance() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.pay(5_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountLessZero() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        account.pay(-5_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayTrueOrFalse() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        Assertions.assertFalse(account.pay(-5_000));
        Assertions.assertTrue(account.pay(500));
        Assertions.assertFalse(account.pay(5_000));
    }

    @Test
    public void shouldYearChange() {
        SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, 5);
        int actual = account.yearChange();
        int expected = 2_000 / 100 * 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldToThrowWhenRateLessZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 1_000, 10_000, -5);
        }); // Выбрасывание при @rate меньше 0
    }

    @Test
    public void shouldToThrowWhenMinBalanceLessZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, -1_000, 10_000, 5);
        }); // Выбрасывание при @minBalance меньше 0
    }

    @Test
    public void shouldToThrowWhenInitialBalanceOverMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(12_000, 1_000, 10_000, 5);
        }); // Выбрасывание при initialBalance больше maxBalance
    }

    @Test
    public void shouldToThrowWhenInitialBalanceLessMinxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(500, 1_000, 10_000, 5);
        }); // Выбрасывание при initialBalance больше minBalance
    }

    @Test
    public void shouldToThrowWhenRateAndMinBalanceLessZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, -1_000, 10_000, -5);
        }); // Выбрасывание при @rate меньше 0, при @minBalance меньше 0
    }
}
