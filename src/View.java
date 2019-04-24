import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class View extends JFrame {
	private JTextField txtCreateBalance;
	private JTextField txtCreateDescription;
	private JTextField txtDepositAmount;
	private JTextField txtDepositDescription;
	private JTextField txtWithdrawAmount;
	private JTextField txtWithdrawDescription;
	
	private Model atmModel;
	private JButton btnMenuCreate;
	private JButton btnMenuSelect;
	private JButton btnMenuDeposit;
	private JButton btnMenuWithdraw;
	private JButton btnMenuDelete;
	private JButton btnMenuTransactions;
	private JButton btnMenuQuit;
	
	private CardLayout cardLayout;
	private Button btnSelectAccept;
	private Button btnSelectCancel;
	private Button btnCreateAccept;
	private Button btnCreateCancel;
	private Button btnDepositAccept;
	private Button btnDepositCancel;
	private Button btnWithdrawCancel;
	private Button btnWithdrawAccept;
	private Button btnDeleteAccept;
	private Button btnDeleteCancel;
	private Button btnTransactionCancel;
	private JLabel lblCreateFeedback;
	private JComboBox<String> comboCreateType;
	private JComboBox<String> comboSelectAccount;
	private JLabel lblDepositFeedback;
	private JLabel lblWithdrawFeedback;
	private JTextArea txtTransactionHistory;
	private JComboBox<String> comboDeleteAccount;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View(atmModel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public View(Model myModel) {
		// initialize variables
		atmModel = myModel;
		
		String[] accountTypes = new String[] {"Savings", "Air Miles"};
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 524);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		cardLayout = (CardLayout) getContentPane().getLayout();
		
		JPanel panelMenu = new JPanel();
		getContentPane().add(panelMenu, "Menu");
		
		btnMenuCreate = new JButton("Create Account");
		btnMenuCreate.setBounds(31, 229, 151, 23);
		btnMenuCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelMenu.setLayout(null);
		panelMenu.add(btnMenuCreate);
		
		// create "main" panel
		btnMenuSelect = new JButton("Select Account");
		btnMenuSelect.setBounds(31, 40, 151, 23);
		panelMenu.add(btnMenuSelect);
		
		JLabel lblMenu = new JLabel("ATM Menu");
		lblMenu.setBounds(243, 11, 97, 14);
		panelMenu.add(lblMenu);
		
		btnMenuDeposit = new JButton("Deposit");
		btnMenuDeposit.setBounds(31, 103, 151, 23);
		panelMenu.add(btnMenuDeposit);
		
		btnMenuWithdraw = new JButton("Withdraw");
		btnMenuWithdraw.setBounds(31, 166, 151, 23);
		panelMenu.add(btnMenuWithdraw);
		
		btnMenuDelete = new JButton("Delete Account");
		btnMenuDelete.setBounds(31, 292, 151, 23);
		panelMenu.add(btnMenuDelete);
		
		btnMenuTransactions = new JButton("View Transactions");
		btnMenuTransactions.setBounds(31, 355, 151, 23);
		panelMenu.add(btnMenuTransactions);
		
		btnMenuQuit = new JButton("Save & Quit");
		btnMenuQuit.setBounds(31, 418, 151, 23);
		panelMenu.add(btnMenuQuit);
		
		
		// create "select" panel
		JPanel panelSelect = new JPanel();
		panelSelect.setLayout(null);
		getContentPane().add(panelSelect, "Select");
		
		JLabel lblSelectPanel = new JLabel("Select Panel");
		lblSelectPanel.setBounds(238, 11, 107, 14);
		panelSelect.add(lblSelectPanel);
		
		comboSelectAccount = new JComboBox();
		comboSelectAccount.setBounds(145, 92, 200, 20);
		panelSelect.add(comboSelectAccount);
		
		JLabel lblNewLabel = new JLabel("Select Account :");
		lblNewLabel.setBounds(34, 95, 101, 14);
		panelSelect.add(lblNewLabel);
		
		btnSelectAccept = new Button("Accept");
		btnSelectAccept.setBounds(65, 323, 70, 22);
		panelSelect.add(btnSelectAccept);
		
		btnSelectCancel = new Button("Cancel");
		btnSelectCancel.setBounds(184, 323, 70, 22);
		panelSelect.add(btnSelectCancel);
		
		
		// create "create" panel
		JPanel panelCreate = new JPanel();
		panelCreate.setLayout(null);
		getContentPane().add(panelCreate, "Create");
		
		JLabel lblCreatePanel = new JLabel("Create Panel");
		lblCreatePanel.setBounds(238, 11, 107, 14);
		panelCreate.add(lblCreatePanel);
		
		comboCreateType = new JComboBox(accountTypes);
		comboCreateType.setBounds(145, 95, 200, 22);
		panelCreate.add(comboCreateType);
		
		JLabel lblCreateType = new JLabel("Account Type : ");
		lblCreateType.setBounds(34, 95, 101, 14);
		panelCreate.add(lblCreateType);
		
		btnCreateAccept = new Button("Create");
		btnCreateAccept.setBounds(34, 350, 70, 22);
		panelCreate.add(btnCreateAccept);
		
		btnCreateCancel = new Button("Cancel");
		btnCreateCancel.setBounds(145, 350, 70, 22);
		panelCreate.add(btnCreateCancel);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(34, 187, 87, 14);
		panelCreate.add(lblDescription);
		
		JLabel lblCreateBalance = new JLabel("Starting Balance ($) :");
		lblCreateBalance.setBounds(34, 249, 129, 14);
		panelCreate.add(lblCreateBalance);
		
		txtCreateBalance = new JTextField();
		txtCreateBalance.setBounds(163, 249, 86, 20);
		panelCreate.add(txtCreateBalance);
		txtCreateBalance.setColumns(10);
		
		txtCreateDescription = new JTextField();
		txtCreateDescription.setBounds(163, 187, 369, 20);
		panelCreate.add(txtCreateDescription);
		txtCreateDescription.setColumns(10);
		
		lblCreateFeedback = new JLabel("");
		lblCreateFeedback.setForeground(Color.RED);
		lblCreateFeedback.setBounds(145, 301, 369, 14);
		panelCreate.add(lblCreateFeedback);
		
		
		// create "deposit" panel
		JPanel panelDeposit = new JPanel();
		panelDeposit.setLayout(null);
		getContentPane().add(panelDeposit, "Deposit");
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setBounds(238, 11, 107, 14);
		panelDeposit.add(lblDeposit);
		
		btnDepositAccept = new Button("Deposit");
		btnDepositAccept.setBounds(34, 350, 70, 22);
		panelDeposit.add(btnDepositAccept);
		
		btnDepositCancel = new Button("Cancel");
		btnDepositCancel.setBounds(145, 350, 70, 22);
		panelDeposit.add(btnDepositCancel);
		
		JLabel lblDepositDescription = new JLabel("Description :");
		lblDepositDescription.setBounds(34, 99, 87, 14);
		panelDeposit.add(lblDepositDescription);
		
		JLabel lblDepositAmount = new JLabel("Deposit Amount ($) :");
		lblDepositAmount.setBounds(34, 171, 116, 14);
		panelDeposit.add(lblDepositAmount);
		
		txtDepositAmount = new JTextField();
		txtDepositAmount.setColumns(10);
		txtDepositAmount.setBounds(160, 171, 86, 20);
		panelDeposit.add(txtDepositAmount);
		
		txtDepositDescription = new JTextField();
		txtDepositDescription.setColumns(10);
		txtDepositDescription.setBounds(160, 99, 369, 20);
		panelDeposit.add(txtDepositDescription);
		
		lblDepositFeedback = new JLabel("");
		lblDepositFeedback.setForeground(Color.RED);
		lblDepositFeedback.setBounds(145, 301, 369, 14);
		panelDeposit.add(lblDepositFeedback);
		
		
		// create "withdraw" panel
		JPanel panelWithdraw = new JPanel();
		panelWithdraw.setLayout(null);
		getContentPane().add(panelWithdraw, "Withdraw");
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setBounds(238, 11, 107, 14);
		panelWithdraw.add(lblWithdraw);
		
		btnWithdrawAccept = new Button("Withdraw");
		btnWithdrawAccept.setBounds(34, 350, 70, 22);
		panelWithdraw.add(btnWithdrawAccept);
		
		btnWithdrawCancel = new Button("Cancel");
		btnWithdrawCancel.setBounds(145, 350, 70, 22);
		panelWithdraw.add(btnWithdrawCancel);
		
		JLabel lblWithdrawDescription = new JLabel("Description :");
		lblWithdrawDescription.setBounds(34, 99, 87, 14);
		panelWithdraw.add(lblWithdrawDescription);
		
		JLabel lblWithdrawAmount = new JLabel("Withdraw Amount ($) :");
		lblWithdrawAmount.setBounds(34, 171, 137, 14);
		panelWithdraw.add(lblWithdrawAmount);
		
		txtWithdrawAmount = new JTextField();
		txtWithdrawAmount.setColumns(10);
		txtWithdrawAmount.setBounds(170, 171, 86, 20);
		panelWithdraw.add(txtWithdrawAmount);
		
		txtWithdrawDescription = new JTextField();
		txtWithdrawDescription.setColumns(10);
		txtWithdrawDescription.setBounds(170, 99, 369, 20);
		panelWithdraw.add(txtWithdrawDescription);
		
		lblWithdrawFeedback = new JLabel("");
		lblWithdrawFeedback.setForeground(Color.RED);
		lblWithdrawFeedback.setBounds(145, 301, 369, 14);
		panelWithdraw.add(lblWithdrawFeedback);
		
		
		// create "delete" panel
		JPanel panelDelete = new JPanel();
		panelDelete.setLayout(null);
		getContentPane().add(panelDelete, "Delete");
		
		JLabel lblDelete = new JLabel("Delete Account");
		lblDelete.setBounds(238, 11, 107, 14);
		panelDelete.add(lblDelete);
		
		comboDeleteAccount = new JComboBox();
		comboDeleteAccount.setBounds(145, 92, 200, 20);
		panelDelete.add(comboDeleteAccount);
		
		JLabel lblDeleteAccount = new JLabel("Select Account :");
		lblDeleteAccount.setBounds(34, 95, 101, 14);
		panelDelete.add(lblDeleteAccount);
		
		btnDeleteAccept = new Button("Delete");
		btnDeleteAccept.setBounds(65, 323, 70, 22);
		panelDelete.add(btnDeleteAccept);
		
		btnDeleteCancel = new Button("Cancel");
		btnDeleteCancel.setBounds(184, 323, 70, 22);
		panelDelete.add(btnDeleteCancel);
		
		JPanel panelTransactions = new JPanel();
		getContentPane().add(panelTransactions, "Transactions");
		panelTransactions.setLayout(null);
		
		JLabel lblAccountTransactions = new JLabel("Account Transactions");
		lblAccountTransactions.setBounds(238, 11, 139, 14);
		panelTransactions.add(lblAccountTransactions);
		
		JLabel lblTransactionHistory = new JLabel("Transaction History : ");
		lblTransactionHistory.setBounds(34, 95, 131, 14);
		panelTransactions.add(lblTransactionHistory);
		
		btnTransactionCancel = new Button("Return");
		btnTransactionCancel.setBounds(62, 431, 70, 22);
		panelTransactions.add(btnTransactionCancel);
		
		txtTransactionHistory = new JTextArea();
		txtTransactionHistory.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtTransactionHistory.setEditable(false);
		txtTransactionHistory.setBounds(34, 121, 518, 298);
		panelTransactions.add(txtTransactionHistory);
	}
	
	// ------------------------------------------gets
	
	// ----------------text fields
	// create
	public String getCreateDescription() {
		return txtCreateDescription.getText();
	}
	public Double getCreateBalance() {
		return  Double.parseDouble(txtCreateBalance.getText());
	}
	public int getCreateType() {
		return comboCreateType.getSelectedIndex();
	}
	// deposit
	public String getDepositDescription() {
		return txtDepositDescription.getText();
	}
	public Double getDepositAmount() {
		return Double.parseDouble(txtDepositAmount.getText());
	}

	// withdraw
	public String getWithdrawalDescription() {
		return txtWithdrawDescription.getText();
	}
	public Double getWithdrawalAmount() {
		return Double.parseDouble(txtWithdrawAmount.getText());
	}
	// select
	public int getSelectAccount() {
		return comboSelectAccount.getSelectedIndex();
	}
	// delete
	public int getDeleteAccount() {
		return comboDeleteAccount.getSelectedIndex();
	}
	
	
	// ---------------------------------------- sets
	// -------------------combo boxes
	// select
	public void setSelectAccount(ArrayList<BankAccount> myAccounts) {
		comboSelectAccount.removeAllItems();
		for (int i = 0; i < myAccounts.size(); i++) {
			comboSelectAccount.addItem(myAccounts.get(i).getDescription());
		}	
	}
	// delete
	public void setDeleteAccount(ArrayList<BankAccount> myAccounts) {
		comboDeleteAccount.removeAllItems();
		for (int i = 0; i < myAccounts.size(); i++) {
			comboDeleteAccount.addItem(myAccounts.get(i).getDescription());
		}	
	}
	// -------------------feedback labels
	// create
	public void setDepositFeedback(String myFeedback) {
		lblDepositFeedback.setText(myFeedback);
	}
	// create
	public void setCreateFeedback(String myFeedback) {
		lblCreateFeedback.setText(myFeedback);
	}
	// transaction
	public void setTransactionHistory(String myHistory) {
		txtTransactionHistory.setText(myHistory);
	}
	// withdraw
	public void setWithdrawFeedback(String myFeedback) {
		lblWithdrawFeedback.setText(myFeedback);
	}
	

	
	//----------------------------------------action listeners
	//--------main menu buttons
	public void addMainSelectListener(ActionListener mainSelectActionListener) {
		btnMenuSelect.addActionListener(mainSelectActionListener);
	}
	public void addMainDepositListener(ActionListener mainDepositActionListener) {
		btnMenuDeposit.addActionListener(mainDepositActionListener);
	}
	public void addMainWithdrawListener(ActionListener mainWithdrawActionListener) {
		btnMenuWithdraw.addActionListener(mainWithdrawActionListener);
	}
	public void addMainCreateListener(ActionListener mainCreateActionListener) {
		btnMenuCreate.addActionListener(mainCreateActionListener);
	}
	public void addMainDeleteListener(ActionListener mainDeleteActionListener) {
		btnMenuDelete.addActionListener(mainDeleteActionListener);
	}
	public void addMainTransactionsListener(ActionListener mainTransactionsActionListener) {
		btnMenuTransactions.addActionListener(mainTransactionsActionListener);
	}
	public void addMainQuitListener(ActionListener mainQuitActionListener) {
		btnMenuQuit.addActionListener(mainQuitActionListener);
	}
	
	//--------select panel buttons
	public void addSelectAcceptListener(ActionListener selectAcceptActionListener) {
		btnSelectAccept.addActionListener(selectAcceptActionListener);
	}
	public void addSelectCancelListener(ActionListener selectCancelActionListener) {
		btnSelectCancel.addActionListener(selectCancelActionListener);
	}

	
	//--------deposit panel buttons
	public void addDepositAcceptListener(ActionListener depositAcceptActionListener) {
		btnDepositAccept.addActionListener(depositAcceptActionListener);
	}
	public void addDepositCancelListener(ActionListener depositCancelActionListener) {
		btnDepositCancel.addActionListener(depositCancelActionListener);
	}

	
	//--------withdraw panel buttons
	public void addWithdrawAcceptListener(ActionListener withdrawAcceptActionListener) {
		btnWithdrawAccept.addActionListener(withdrawAcceptActionListener);
	}
	public void addWithdrawCancelListener(ActionListener withdrawCancelActionListener) {
		btnWithdrawCancel.addActionListener(withdrawCancelActionListener);
	}

	
	//--------create panel buttons
	public void addCreateAcceptListener(ActionListener createAcceptActionListener) {
		btnCreateAccept.addActionListener(createAcceptActionListener);
	}
	public void addCreateCancelListener(ActionListener createCancelActionListener) {
		btnCreateCancel.addActionListener(createCancelActionListener);
	}

	
	//--------delete panel buttons
	public void addDeleteAcceptListener(ActionListener deleteAcceptActionListener) {
		btnDeleteAccept.addActionListener(deleteAcceptActionListener);
	}
	public void addDeleteCancelListener(ActionListener deleteCancelActionListener) {
		btnDeleteCancel.addActionListener(deleteCancelActionListener);
	}

	
	//--------transaction panel buttons
	
	public void addTransactionCancelListener(ActionListener transactionCancelActionListener) {
		btnTransactionCancel.addActionListener(transactionCancelActionListener);
	}
	
	
	
	
	//--------------------------------------methods
	public void changeView(String myView) {
		cardLayout.show(getContentPane(), myView);
	}
	
	// reset all forms
	public void resetForms() {
		txtDepositDescription.setText("");
		txtDepositAmount.setText("");
		txtWithdrawDescription.setText("");
		txtWithdrawAmount.setText("");
		txtTransactionHistory.setText("");
		txtCreateDescription.setText("");
		txtCreateBalance.setText("");
		lblDepositFeedback.setText("");
		lblWithdrawFeedback.setText("");
		lblCreateFeedback.setText("");
		
	}
	// disable most menu buttons if no accounts
	public void enableAccountButtons(Boolean state) {
		btnMenuSelect.setEnabled(state);
		btnMenuDelete.setEnabled(state);
		btnMenuDeposit.setEnabled(state);
		btnMenuWithdraw.setEnabled(state);
		btnMenuTransactions.setEnabled(state);
	}
	
	public void quitATM() {
		this.dispose();
	}
	
}
