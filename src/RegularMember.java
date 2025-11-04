public class RegularMember extends Member{
	
	public RegularMember(String name, String contact, String email) {
		super(name, contact, email);
		
	}
	
	@Override
	public void computeMonthlyFee() {
		RegularMember.getBaseRate();
	}
	
}