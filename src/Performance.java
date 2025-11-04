public class Performance{
	private int daysAttended=0;
	private float weightRecord = 0.0f;
	private boolean achievedMonthlyGoal = false;
	private float performanceRating = 0.0f;
	
	
	// method to get member's monthly goal achievement.
	public boolean getMonthlyGoalStatus() {
		return this.achievedMonthlyGoal;
	}
	
	// method to set member's monthly goal achievement.
	public void setMonthlyGoalStatus() {
		this.achievedMonthlyGoal=!this.achievedMonthlyGoal;
	}
	
	
}

