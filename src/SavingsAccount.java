
public class SavingsAccount extends BankAccount{

	private final Double WITHDRAWAL_FEE = 0.50;

	protected SavingsAccount(String myDescription, Double myBalance) {
		super(myDescription, myBalance);
		withdrawalFee = WITHDRAWAL_FEE;
		// TODO Auto-generated constructor stub
	}
	protected SavingsAccount(String myDescription) {
		this(myDescription, 0.00);
	}

}
