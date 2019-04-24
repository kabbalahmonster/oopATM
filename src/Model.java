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
	public void deleteAccount(int myAccount) {
		accounts.remove(myAccount);
		
	}
	
	// retrieve transactions
	public void viewTransactions() {
		
	}
	// make a deposit
	public void makeDeposit(String myDescription, Double myDeposit) {
		selectedAccount.deposit(myDescription, myDeposit);
		
	}
	// make a withdrawal
	public boolean makeWithdrawal(String myDescription, Double myWithdrawal) {
		if(selectedAccount.withdraw(myDescription, myWithdrawal)) {
			return true;
		} else {
			return false;
		}
		
	}
}
