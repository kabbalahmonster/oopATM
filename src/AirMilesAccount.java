
public class AirMilesAccount extends BankAccount {
	
	private int airMilesBalance;
	private final Double WITHDRAWAL_FEE = 0.75;
	
	public AirMilesAccount(String myDescription, Double myBalance, int myAirMiles) {
		super(myDescription, myBalance);
		airMilesBalance = myAirMiles;		
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
}
