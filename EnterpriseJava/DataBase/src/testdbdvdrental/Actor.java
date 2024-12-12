package testdbdvdrental;

public class Actor {
	
	private int actorId;
	private String firstName;
	private String lastName;
	
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", getActorId()="
				+ getActorId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + "]";
	}
	
	

	
}
