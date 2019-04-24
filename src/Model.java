import java.util.*;

public class Model {
	
	private ArrayList<BankAccount> accounts;
	private BankAccount selectedAccount;
	
	public Model() {		
		accounts = new ArrayList<BankAccount>(0);
		
	}
	
	//---------------------------------------------gets
	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}
	
	public BankAccount getSelectedAccount() {
		return selectedAccount;
	}
	
	
	//---------------------------------------------sets
	public void setSelectedAccount(int mySelection) {
		selectedAccount = accounts.get(mySelection);
	}
	
	
	
	//---------------------------------------------methods
	// load saved accounts
	public void loadAccounts() {
		
	}
	
	// save accounts
	public void saveAccounts() {
		
	}
	
	// create new account
	public void createAccount(String myDescription, Double myBalance, int myType) {
		BankAccount myAccount;
		if (myType == 0) {
			 myAccount = new SavingsAccount(myDescription, myBalance);
		} else {
			 myAccount = new AirMilesAccount(myDescription, myBalance);
		}
		selectedAccount = myAccount;
		accounts.add(myAccount);
		
	}
	
	// delete an account
	public void deleteAccount() {
		
	}
	
	// retrieve transactions
	public void viewTransactions() {
		
	}
	
	public void makeDeposit(String myDescription, Double myDeposit) {
		selectedAccount.deposit(myDeposit);
		selectedAccount.recordtransaction(new Transaction(new Date(), myDescription, myDeposit));
		
	}
}
