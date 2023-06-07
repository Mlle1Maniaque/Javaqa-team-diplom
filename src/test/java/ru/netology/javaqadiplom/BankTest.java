package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqadiplom.Bank;
import ru.netology.javaqadiplom.CreditAccount;
import ru.netology.javaqadiplom.SavingAccount;

public class BankTest {
    @Test
    public void transferPositiveAmountToSavingAccount() {
        CreditAccount creditAccount = new CreditAccount(
                4000,
                5000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                1000,
                500,
                10000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, 1000);

        Assertions.assertEquals(3000, creditAccount.getBalance());
        Assertions.assertEquals(2000, savingAccount.getBalance());
    }

    @Test
    public void shouldTransferNegativeAmountToSavingAccount() {
        CreditAccount creditAccount = new CreditAccount(
                4000,
                5000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                1000,
                500,
                10000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, -2000);

        Assertions.assertEquals(4000, creditAccount.getBalance());
        Assertions.assertEquals(1000, savingAccount.getBalance());
    }

    @Test
    public void shouldTransferToSavingAccountOverCreditLimit() {
        CreditAccount creditAccount = new CreditAccount(
                2000,
                5000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                3000,
                500,
                10000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, 7000);

        Assertions.assertEquals(5000, creditAccount.getCreditLimit());
        Assertions.assertEquals(10000, savingAccount.getBalance());
    }

    @Test
    public void shouldTransferToSavingAccountMaxCreditLimit() {
        CreditAccount creditAccount = new CreditAccount(
                2000,
                5000,
                15
        );
        SavingAccount savingAccount = new SavingAccount(
                3000,
                500,
                10000,
                10
        );
        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, 5000);

        Assertions.assertEquals(5000, creditAccount.getCreditLimit());
        Assertions.assertEquals(8000, savingAccount.getBalance());

    }

    @Test
    public void shouldTransferPositiveAmountToCreditAccount() {
        SavingAccount savingAccount = new SavingAccount(
                5000,
                500,
                15000,
                15
        );
        CreditAccount creditAccount = new CreditAccount(
                1000,
                5000,
                15
        );
        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 1000);

        Assertions.assertEquals(2000, creditAccount.getBalance());
        Assertions.assertEquals(4000, savingAccount.getBalance());
    }

    @Test
    public void shouldTransferNegativeAmountToCreditAccount() {
        SavingAccount savingAccount = new SavingAccount(
                5000,
                500,
                15000,
                15
        );
        CreditAccount creditAccount = new CreditAccount(
                1000,
                5000,
                15
        );
        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, -1000);

        Assertions.assertEquals(1000, creditAccount.getBalance());
        Assertions.assertEquals(5000, savingAccount.getBalance());
    }

    @Test
    public void shouldTransferAmountOverMinBalance() {
        SavingAccount savingAccount = new SavingAccount(
                5000,
                500,
                15000,
                15
        );
        CreditAccount creditAccount = new CreditAccount(
                1000,
                5000,
                15
        );
        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 5200);

        Assertions.assertEquals(1000, creditAccount.getBalance());
        Assertions.assertEquals(5000, savingAccount.getBalance());
    }

    @Test
    public void shouldTransferAmountMinBalance() {
        SavingAccount savingAccount = new SavingAccount(
                5000,
                500,
                15000,
                15
        );
        CreditAccount creditAccount = new CreditAccount(
                1000,
                5000,
                15
        );
        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 4500);

        Assertions.assertEquals(5500, creditAccount.getBalance());
        Assertions.assertEquals(500, savingAccount.getBalance());
    }
}


