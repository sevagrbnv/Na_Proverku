package Lab14;

public class Account{
    private long money;
    private String accNumber;
    private boolean isBlocked;

    public Account(long money, String accNumber){
        this.money = money;
        this.accNumber = accNumber;
        this.isBlocked = false;
    }

    public long getMoney() {
        return money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void addMoney(long money){
        this.money += money;
    }
}