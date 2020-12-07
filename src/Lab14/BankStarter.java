package Lab14;

import java.util.Random;

public class BankStarter implements Runnable {
    Bank bank;
    Random random;

    public BankStarter(Bank bank){
        this.bank = bank;
        random = new Random();
    }
    @Override
    public void run() {
        for (int i = 1; i < 21; i++){
            long amount = random.nextInt(50_000);
            if (i % 5 == 0)
                amount += 50_000;
            String fromAccount = random.nextInt(90_000) + 100_000 + "";
            String toAccount = random.nextInt(90_000) + 100_000 + "";
            try {
                bank.transfer(fromAccount, toAccount, amount);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        System.out.println("Всего на счетах " + bank.allMoney());
    }
}
