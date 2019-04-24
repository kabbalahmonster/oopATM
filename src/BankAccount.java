import java.util.*;

public class BankAccount {
	// declare variables
	private int id;
	protected Double balance;
	private String description;
	private ArrayList<Transaction> transactions;
	protected Double withdrawalFee;
	
	protected BankAccount(String myDescription, Double myBalance) {
		description = myDescription;
		balance = myBalance;
		transactions = new ArrayList<Transaction>(0);
	}
	
	protected BankAccount(String myDescription) {
		this(myDescription, 0.00);
	}
	
	
	//------------------------------ sets
	protected void setId(int myId) {
		id = myId;
	}
	
	protected void setWithdrawalFee(Double myFee) {
		withdrawalFee = myFee;
	}
	
	public void setDescription(String myDescription) {
		description = myDescription;
	}
	
	//-----------------------------gets
	public int getId() {
		return id;
	}
	public Double getBalance() {
		return balance;
	}
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public String getDescription() {
		return description;
	}
	
	//----------------------------- public methods
	public void deposit(Double myDeposit) {
		balance += myDeposit;
	}
	public void withdraw(Double myWithdrawal) {
		balance -= myWithdrawal;
	}
	public void recordtransaction(Transaction myTransaction) {
		transactions.add(myTransaction);
		System.out.println(myTransaction.getDescription());

		System.out.println(myTransaction);
		
	}
	
	
}
