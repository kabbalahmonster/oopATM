import java.awt.event.*;

public class Controller {
	
	// declare variables
	private View atmView;
	private Model atmModel;
	
	public Controller(View myView, Model myModel) {
		// initialize variables
		atmView = myView;
		atmModel = myModel;
		
		// atmView.setVisible(true);
		assignButtons();
		populateTypes();
		

		atmView.setVisible(true);
		
	}
	
	
	
	
	
	//----------------------------- methods
	
	private void populateTypes(){
	}
	
	// assigns functions to all buttons
	private void assignButtons() {
		
		// ------- main menu buttons
		atmView.addMainSelectListener((ActionEvent e) -> {
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
			atmView.changeView("Delete");
		});

		atmView.addMainTransactionsListener((ActionEvent e) -> {
			atmView.changeView("Transactions");
		});

		atmView.addMainDepositListener((ActionEvent e) -> {
			atmView.changeView("Deposit");
		});

		atmView.addMainQuitListener((ActionEvent e) -> {
			atmView.changeView("Menu");
		});
		
		// -------- select menu buttons

		atmView.addSelectAcceptListener((ActionEvent e) -> {
			atmModel.setSelectedAccount(0);
			System.out.println(atmModel.getSelectedAccount().getDescription());
			
			atmView.changeView("Menu");
		});

		atmView.addSelectCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
		});
		
		// -------- deposit menu buttons

		atmView.addDepositAcceptListener((ActionEvent e) -> {
			atmView.changeView("Menu");
		});

		atmView.addDepositCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
		});
		
		// -------- withdraw menu buttons

		atmView.addWithdrawAcceptListener((ActionEvent e) -> {
			atmView.changeView("Menu");
		});

		atmView.addWithdrawCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
		});
		
		// -------- create menu buttons

		atmView.addCreateAcceptListener((ActionEvent e) -> {
			try {atmModel.createAccount(atmView.getCreateDescription(), atmView.getCreateBalance(), atmView.getCreateType());
				System.out.println(atmView.getCreateDescription());
				System.out.println(atmView.getCreateBalance());
				System.out.println(atmModel.getAccounts().get(0).getBalance());
				System.out.println(atmModel.getAccounts());
				System.out.println(atmView.getCreateType());
				
				
				atmView.changeView("Menu");
			} catch (Exception x) {
				atmView.setCreateFeedback("Please fill out both fields appropriately");
			}
			
		});

		atmView.addCreateCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
		});
		
		// -------- delete menu buttons

		atmView.addDeleteAcceptListener((ActionEvent e) -> {
			atmView.changeView("Menu");
		});

		atmView.addDeleteCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
		});
		
		// -------- transactions menu buttons

		atmView.addTransactionCancelListener((ActionEvent e) -> {
			atmView.changeView("Menu");
		});
	}
	
	

}
