import java.awt.event.*;

public class Controller {
	
	private View atmView;
	private Model atmModel;
	
	public Controller(View myView, Model myModel) {
		atmView = myView;
		atmModel = myModel;
		
		// atmView.setVisible(true);
		assignButtons();
		

		atmView.setVisible(true);
		
	}
	
	
	
	
	
	//----------------------------- methods
	
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
			atmView.changeView("Menu");
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
