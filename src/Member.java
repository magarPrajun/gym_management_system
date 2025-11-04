import java.math.BigDecimal;
import java.util.List;
import java.util.LinkedList;

/*
 * Encapsulating common attributes for members
 * Static method -> common method for members

 */
public abstract class Member{
	public int memberId;
	private String memberName;
	private String memberContact;
	private String memberEmail;
	private List<Performance> performanceRecord; 
	static private BigDecimal baseRate; // base rate applies to all types of members
	
	public Member(String name, String contact, String email) {
		this.memberName = name;
		this.memberContact = contact;
		this.memberEmail = email;
		this.performanceRecord = new LinkedList<>(); 
	}
	
	
	// method to access member's ID
	public int getMemberID() {
		return this.memberId;
	}
	
	// method to access member's name
	public String getMemberName() {
		return this.memberName;
	}
	
	// method to set base rate for membership
	public static void setBaseRate(BigDecimal rate) {
		baseRate = rate;
	}
	
	// method to get base rate for membership
	public static BigDecimal getBaseRate() {
		return baseRate;
	} 
	
	/* method to compute monthly fee for membership and other services.
	* implementation of this method is different according to the sub classes.
	*/
	public abstract void computeMonthlyFee();
	
	public void recordMonthlyPerformance() {
		performanceRecord.add(new Performance());
	}
	
	/*
	 * toString() method override.
	 * returns member's overall details. 
	 */
	@Override
	public String toString() {
		return "Member ID:"+this.memberId+"\nName:"+this.memberName+"\nContact:"+this.memberContact+"\nEmail:"+this.memberEmail;
	}
}