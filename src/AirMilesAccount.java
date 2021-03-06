import java.util.Date;

public class AirMilesAccount extends BankAccount {
	// declare variables
	private int airMilesBalance;
	private final Double WITHDRAWAL_FEE = 0.75;
	
	public AirMilesAccount(String myDescription, Double myBalance, int myAirMiles) {
		super(myDescription, myBalance);
		airMilesBalance = myAirMiles;
		airMilesBalance += (int) (myBalance / 30);
		withdrawalFee = WITHDRAWAL_FEE;
	}
	public AirMilesAccount(String myDescription, Double myBalance) {
		this(myDescription, myBalance, 10);	
	}
	public AirMilesAccount(String myDescription, int myAirMiles) {
		this(myDescription, 0.00, myAirMiles);
	}
	public AirMilesAccount(String myDescription) {
		this(myDescription, 0.00, 10);
	}
	
	// ------------------------------gets
	public int getAirMiles() {
		return airMilesBalance;
	}
	
	//------------------------------- methods
	public void addAirMiles(int myMiles) {
		airMilesBalance += myMiles;
	}
	public void deposit(String myDescription, Double myDeposit) {
		balance += myDeposit;
		airMilesBalance += (int) (myDeposit / 30);
		recordtransaction(new Transaction(new Date(), myDescription, myDeposit));
		//System.out.println(airMilesBalance);
	}
}
