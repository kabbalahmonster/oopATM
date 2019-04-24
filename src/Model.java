import java.util.*;
import java.io.*;

public class Model {
	
	private ArrayList<BankAccount> accounts;
	private BankAccount selectedAccount;	
	private File file;
	private File directory;
	
	public Model() {		
		accounts = new ArrayList<BankAccount>(0);
		// initialize save file and folder
		file = new File("accountRecord.txt");
		directory = new File(System.getProperty("user.home"));
		String filenames[] = directory.list();
		System.out.println("Directory: " + directory.getName());
		System.out.println("Full path to file: " + file.getAbsolutePath());
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
		 try
	        {
	            FileInputStream fis = new FileInputStream("employeeData");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	 
	            accounts = (ArrayList<BankAccount>) ois.readObject();
	 
	            ois.close();
	            fis.close();
	        }
	        catch (IOException ioe)
	        {
	            ioe.printStackTrace();
	            return;
	        }
	        catch (ClassNotFoundException c)
	        {
	            System.out.println("Class not found");
	            c.printStackTrace();
	            return;
	        }
	         
	        //Verify list data
	        for (BankAccount account : accounts) {
	            System.out.println(account);
	        }
		
	}
	
	// save accounts
	public void saveAccounts() {
		 try
	        {
	            FileOutputStream fos = new FileOutputStream("employeeData");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(accounts);
	            oos.close();
	            fos.close();
	        }
	        catch (IOException ioe)
	        {
	            ioe.printStackTrace();
	        }
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
