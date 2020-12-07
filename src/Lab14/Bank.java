package Lab14;

import java.util.HashMap;
import java.util.Random;

public class Bank {
    private HashMap<String, Account> accounts;
    private final Random random = new Random();

    public Bank(){
        accounts = new HashMap<>();
        for (int i = 100_000; i < 1_000_000; i++){
            accounts.put("" + i, new Account(random.nextInt(1_000_000), "" + i));
        }
    }

    public long allMoney(){
        long sum = 0;
        for (String key : accounts.keySet())
            sum += accounts.get(key).getMoney();
        return sum;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (amount > 50_000){
            boolean safe = isFraud(fromAccountNum, toAccountNum, amount);
            accounts.get(fromAccountNum).setBlocked(safe);
            accounts.get(toAccountNum).setBlocked(safe);
            if (safe)
                System.out.println(fromAccountNum + " и " + toAccountNum + " заблокированы");
        }
        if (!accounts.get(fromAccountNum).isBlocked() && !accounts.get(toAccountNum).isBlocked()
                && getBalance(fromAccountNum) >= amount){
            System.out.println("до: " + accounts.get(fromAccountNum).getMoney() + "->"
                    + accounts.get(toAccountNum).getMoney());
            //synchronized ();
            accounts.get(fromAccountNum).addMoney(-amount);
            accounts.get(toAccountNum).addMoney(+amount);
            System.out.println("после: "+ accounts.get(fromAccountNum).getMoney() + "->"
                    + accounts.get(toAccountNum).getMoney());
        }
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }
}

