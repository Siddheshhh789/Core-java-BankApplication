package Final;

public class Transaction {
	private String type;
    private double amount;
	private double Balance;
    
    public Transaction(String type, double amount,double Balance) {
        this.type = type;
        this.amount = amount;
        this.Balance=Balance;
    }
    
    @Override
    public String toString() {
        return type + ": " + amount;
    }
}
