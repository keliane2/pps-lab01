<<<<<<< HEAD:basic-refactoring-exercise/src/test/java/it/unibo/pps/model/SimpleBankAccountTest.java
package it.unibo.pps.model;
=======
import example.model.BankAccount;
import example.model.AccountHolder;
import example.model.SimpleBankAccount;
>>>>>>> a8d7ad6 (Lab01 completato):basic-refactoring-exercise/src/test/java/SimpleBankAccountTest.java

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder);
    }

    @Test
    void testInitialBalance() {
        assertEquals(SimpleBankAccount.INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), 100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.id(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.id(), 100);
        bankAccount.withdraw(accountHolder.id(), 70);
        assertEquals(30, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.id(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100, bankAccount.getBalance());
    }
}
