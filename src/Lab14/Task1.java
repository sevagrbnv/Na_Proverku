package Lab14;

public class Task1 {

    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println("Всего на счетах " + bank.allMoney());

        for (int i = 0; i < 5; i++)
            new Thread(new BankStarter(bank)).start();
    }
}
