public class RegularMember extends Member{
	
	public RegularMember(String name, String contact, String email) {
		super(name, contact, email);
		
	}
	
	@Override
	void computeMonthlyFee() {
		RegularMember.getBaseRate();
	}
	
}