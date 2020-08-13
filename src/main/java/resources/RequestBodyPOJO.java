package resources;

public class RequestBodyPOJO {

	public String firstName;
	public String lastName;
	public String middleName;
	public String gender;
	public String employmentStatus;
	public String maritalStatus;
	public String suffix;
	public String title;
	public String birthDate;
	public String languagePref;

	public RequestBodyPOJO(String firstName, String lastName, String middleName, String gender, String employmentStatus,
			String maritalStatus, String suffix, String title, String birthDate, String languagePref) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.gender = gender;
		this.employmentStatus = employmentStatus;
		this.maritalStatus = maritalStatus;
		this.suffix = suffix;
		this.title = title;
		this.birthDate = birthDate;
		this.languagePref = languagePref;

	}

}
