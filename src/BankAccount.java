
public class BankAccount {
	
	private int id;
	private Double balance;
	private String description;
	private Transaction[] transactions;
	protected Double withdrawalFee;
	
	protected BankAccount(String myDescription, Double myBalance) {
		description = myDescription;
		balance = myBalance;
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
	public Transaction[] getTransactions() {
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
		
	}
	
	
}
