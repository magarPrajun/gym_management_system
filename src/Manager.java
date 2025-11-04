import java.util.List; 
import java.util.LinkedList;

public class Manager{

	// members managed by the manager
	private static List<Member> memberRecord; 
	
	// constructor for initializing member record
	public Manager() {
		memberRecord = new LinkedList<>();
	}
	
	// register member in the gym 
	public void registerMembership(Member member) {
		memberRecord.add(member);
		System.out.println("Membership registered successfully!");
	}
	
	//de-register member from the gym 
	public void terminateMembership(Member member) {
			}
	
	// member's details view
	public void viewMemberDetail(Object searchKey) {		
			for(Member m:memberRecord) {
				// searching member according to member's ID provided.
				if(searchKey instanceof Integer) {
					if(m.getMemberID() == (int)searchKey) {
						System.out.println(m.toString());
						return;
				}
				
				// searching member according to member's name.
				if(searchKey instanceof String) {
					if(m.getMemberName().equals(searchKey)) {
						System.out.println(m.toString());
						return;
					}
				}
				
				// searching member according to member's name.
				if(searchKey instanceof Float) {
					if(m.getMemberName().equals(searchKey)) {
						System.out.println(m.toString());
						return;
					}
				}
			}
		}	
	}
	
	

}