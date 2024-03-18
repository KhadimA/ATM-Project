//-------------------------------Developed By Khadim Ali--------------------------------------
import java.util.ArrayList;
import java.util.List;

public class ATM {
    private String bankName;
    private int branchCode;
    private String city;
    private int availableCash;
    private int cashLimit;

    private List<String> transactionList;

    public ATM(String bankName, int branchCode, String city, int cashLimit) {
        this.bankName = bankName;
        this.branchCode = branchCode;
        this.city = city;
        this.availableCash = 0;
        this.cashLimit = cashLimit;
        this.transactionList = new ArrayList<>();
    }
  // Khadim Ali
    public void depositCash(int amount) {
        this.availableCash += amount;
        transactionList.add("Deposited: " + amount + " PKR");
    }

    public boolean withdrawMoney(int amount) {
        if (amount <= availableCash) {
            availableCash -= amount;
            transactionList.add("Withdrawal : " + amount + " PKR");
            return true;
        } else {
            return false;
        }
    }

    public int getAvailableCash() {
        return availableCash;
    }

    public boolean isAboveLimit(int amount) {
        return amount > cashLimit;
    }

    public List<String> getTransactionList() {
        return transactionList;
    }
}
  // Khadim Ali