import java.io.*;
import java.util.*;

public class BankAccount implements Serializable{
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
	public void deposit(String myDescription, Double myDeposit) {
		balance += myDeposit;
		recordtransaction(new Transaction(new Date(), myDescription, myDeposit));
	}
	public boolean withdraw(String myDescription, Double myWithdrawal) {
		if(myWithdrawal <= balance){
			balance -= myWithdrawal + withdrawalFee;
			recordtransaction(new Transaction(new Date(), myDescription, -myWithdrawal));
			return true;
		} else {
			return false;
		}
	}
	public void recordtransaction(Transaction myTransaction) {
		transactions.add(myTransaction);
		System.out.println(myTransaction.getDescription());

		System.out.println(myTransaction);
		
	}
	
	
}
