package elk.context;

public class Account implements Comparable<Object>{
	
	private String accountNumber;
	private int balance;
	private String firstname;
	private String lastname;
	private int age;
	private String gender;
	private String address;
	private String employer;
	private String email;
	private String city;
	private String state;

	public Account(String accountNumber, Integer balance, String firstname,
			String lastname, Integer age, String gender, String address,
			String employer, String email, String city, String state) {
	
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.employer = employer;
		this.email = email;
		this.city = city;
		this.state = state;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int compareTo(Object o) {
		if (o instanceof Account) {
			Account obj = (Account) o;
			if(this.accountNumber.equals(obj.accountNumber) && this.address.equals(obj.address) && this.city.equals(obj.city) && this.age == obj.age && 
					this.balance == obj.balance && this.email.equals(obj.email) && this.employer.equals(obj.employer) && this.firstname.equals(obj.firstname) &&
					this.gender.equals(obj.gender) && this.lastname.equals(obj.lastname) && this.state.equals(obj.state))
				return 1;
			else
				return 0;
		}
		return 0;
	}

}
