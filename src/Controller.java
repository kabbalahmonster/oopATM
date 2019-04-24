import java.awt.event.*;
import java.util.*;

public class Controller {
	
	// declare variables
	private View atmView;
	private Model atmModel;
	//private TextFieldValidator dollarTFV;
	//private TextFieldValidator stringTFV;
	
	public Controller(View myView, Model myModel) {
		// initialize variables
		atmView = myView;
		atmModel = myModel;
		//dollarTFV.setRegExp("^\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$");
		
		// atmView.setVisible(true);
		assignButtons();
		populateTypes();
		
		// load saved accounts if available
		atmModel.loadAccounts();
		if (atmModel.getAccounts().size()==0) {
			atmView.enableAccountButtons(false);
		} else {
			atmModel.setSelectedAccount(0);
		}
		
		// start gui
		atmView.setVisible(true);
		
	}		
	
	
	//----------------------------- methods
	
	private void populateTypes(){
	}
	
	// assigns functions to all buttons
	private void assignButtons() {
		
		// ------- main menu buttons
		atmView.addMainSelectListener((ActionEvent e) -> {
			atmView.setSelectAccount(atmModel.getAccounts());
			atmView.changeView("Select");
		});

		atmView.addMainDepositListener((ActionEvent e) -> {
			atmView.changeView("Deposit");
		});

		atmView.addMainWithdrawListener((ActionEvent e) -> {
			atmView.changeView("Withdraw");
		});

		atmView.addMainCreateListener((ActionEvent e) -> {
			
			atmView.changeView("Create");
		});

		atmView.addMainDeleteListener((ActionEvent e) -> {
			atmView.setDeleteAccount(atmModel.getAccounts());
			atmView.changeView("Delete");
		});
		// construct report
		atmView.addMainTransactionsListener((ActionEvent e) -> {
		
			atmView.setTransactionHistory(atmModel.generateReport());
			atmView.changeView("Transactions");
		});

		atmView.addMainDepositListener((ActionEvent e) -> {
			atmView.changeView("Deposit");
		});

		atmView.addMainQuitListener((ActionEvent e) -> {
			atmModel.saveAccounts();
			atmView.changeView("Menu");
			atmView.resetForms();
			atmView.quitATM();
		});
		
		// -------- select menu buttons
		// adds action listener for accept select
		atmView.addSelectAcceptListener((ActionEvent e) -> {
			atmModel.setSelectedAccount(atmView.getSelectAccount());
			System.out.println(atmModel.getSelectedAccount().getDescription());
			
			atmView.changeView("Menu");
			atmView.resetForms();
			atmModel.saveAccounts();
		});
		// adds action listener for cancel select
		atmView.addSelectCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
			atmView.resetForms();
			atmModel.saveAccounts();
		});
		
		// -------- deposit menu buttons

		atmView.addDepositAcceptListener((ActionEvent e) -> {
			try {
				atmModel.makeDeposit(atmView.getDepositDescription(), atmView.getDepositAmount());
				atmView.changeView("Menu");
				atmView.resetForms();
				atmModel.saveAccounts();
			} catch (Exception x) {
				atmView.setDepositFeedback("Please fill out all fields appropriately");
				x.printStackTrace();
			}
		});

		atmView.addDepositCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
			atmView.resetForms();
			atmModel.saveAccounts();
		});
		
		// -------- withdraw menu buttons

		atmView.addWithdrawAcceptListener((ActionEvent e) -> {
			try {
					if(atmModel.makeWithdrawal(atmView.getWithdrawalDescription(), atmView.getWithdrawalAmount())) {
					atmView.changeView("Menu");
					atmView.resetForms();
				} else {
					atmView.setWithdrawFeedback("Insufficient funds in account");
				}
			} catch (Exception x) {
				atmView.setWithdrawFeedback("Please fill out all fields appropriately");				
			}	
		});

		atmView.addWithdrawCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
			atmView.resetForms();
			atmModel.saveAccounts();
		});
		
		// -------- create menu buttons

		atmView.addCreateAcceptListener((ActionEvent e) -> {
			try {atmModel.createAccount(atmView.getCreateDescription(), atmView.getCreateBalance(), atmView.getCreateType());
				//System.out.println(atmView.getCreateDescription());
				//System.out.println(atmView.getCreateBalance());
				//System.out.println(atmModel.getAccounts());
				//System.out.println(atmView.getCreateType());

				if (atmModel.getAccounts().size()>0) {
					atmView.enableAccountButtons(true);
				}		
				
				atmModel.setSelectedAccount(0);				
				
				atmView.changeView("Menu");
				atmView.resetForms();
				atmModel.saveAccounts();
			} catch (Exception x) {
				atmView.setCreateFeedback("Please fill out all fields appropriately");
			}
			
		});

		atmView.addCreateCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
			atmView.resetForms();
			atmModel.saveAccounts();
		});
		
		// -------- delete menu buttons

		atmView.addDeleteAcceptListener((ActionEvent e) -> {
			atmModel.deleteAccount(atmView.getDeleteAccount());
			if (atmModel.getAccounts().size()==0) {
				atmView.enableAccountButtons(false);
			} else {
				atmModel.setSelectedAccount(0);
			}
			atmView.changeView("Menu");
			atmView.resetForms();
			atmModel.saveAccounts();
		});

		atmView.addDeleteCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
			atmView.resetForms();
			atmModel.saveAccounts();
		});
		
		// -------- transactions menu buttons

		atmView.addTransactionCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
			atmView.resetForms();
			atmModel.saveAccounts();
		});
	}
	
	

}
