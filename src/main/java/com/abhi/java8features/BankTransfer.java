package com.abhi.java8features;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BankTransfer {
    public static void main(String[] args) {
        BankAccountFactory bankAccountFactory = (id,balance,accountName) -> new BankAccount(id,balance,accountName);
        BankAccount studentAcc = bankAccountFactory.createBankAccount(1, 50000, "studentA");
        BankAccount universityAcc = bankAccountFactory.createBankAccount(2, 100000, "university");

        BiPredicate<Double, Double> p1 = (balance, amount) -> balance > amount;
        BiConsumer<String, Double> printer = (x,y) -> System.out.println(x + y);
        BiConsumer<BankAccount, BankAccount> printer2 = (student, university) -> {
            System.out.println("Ending balance of student account: " + student.getBalance() +
                    " Ending balance of university: " + university.getBalance());
        };

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " says :: executing transfer");
            double amount = 1000;

            if(!p1.test(studentAcc.getBalance(), amount)) {
                printer.accept(Thread.currentThread().getName() + " says :: insufficient balance", amount);
                return;
            }

            try {
                while (!studentAcc.transfer(universityAcc, amount)) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printer.accept(Thread.currentThread().getName() + " says :: transfer is successful, balance in university account: ", universityAcc.getBalance());
        });

        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 20; i++) {
            service.submit(t1);
        }
        service.shutdown();
        try {
            while(!service.awaitTermination(24, TimeUnit.HOURS)) {
                System.out.println("Not yet still waiting for termination");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printer2.accept(studentAcc, universityAcc);
    }
}

class BankAccount {
    private int id;
    private double balance;
    private String accountName;
    final Lock lock = new ReentrantLock();

    BiFunction<Double, Double, Double> addFunction = (a,b) -> a+b;
    BiFunction<Double, Double, Double> subtractFunction = (a,b) -> a-b;

    public BankAccount(int id, double balance, String accountName) {
        this.id = id;
        this.balance = balance;
        this.accountName = accountName;
    }

    public boolean withdraw(double amount) throws InterruptedException {
        if (this.lock.tryLock()) {
            Thread.sleep(100);
          this.balance = subtractFunction.apply(this.balance, amount);
          this.lock.unlock();
          return true;
        }
        return false;
    }

    public boolean deposit(double amount) throws InterruptedException {
        if (this.lock.tryLock()) {
            Thread.sleep(100);
            this.balance = addFunction.apply(this.balance, amount);
            this.lock.unlock();
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount to, double amount) throws InterruptedException {
        if(this.withdraw(amount)) {
            System.out.println("Withdrawing amount " + amount + " from account " + this.getAccountName());
            if(to.deposit(amount)) {
                System.out.println("Depositing amount " + amount + " to account " + to.getAccountName());
                return true;
            } else {
                System.out.println("Transfer failed, refunding amount " + amount + "to account " + this.getAccountName());
                while (!to.deposit(amount)) {
                    continue;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountName='" + accountName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}


@FunctionalInterface
interface BankAccountFactory {
    public BankAccount createBankAccount(int id, double balance, String accountName);
}
