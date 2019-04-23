import java.util.*;

public class Transaction {
	
	private Date dateTime;
	private String description;
	private Double amount;
	
	public Transaction(Date myDateTime, String myDescription, Double myAmount) {
		dateTime = myDateTime;
		description = myDescription;
		amount = myAmount;
	}
	
	
	//------------------------------------ Gets
	
	public Date getDateTime() {
		return dateTime;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	//----------------------------------- Sets
	
	public void setDateTime(Date myDateTime) {
		dateTime = myDateTime;
	}
	
	public void setDescription(String myDescription) {
		description = myDescription;
	}
	
	public void setAmount(Double myAmount) {
		amount = myAmount;
	}
}
