package uloge;

public class User {

	private String username;
	private String password;
	private String role;

	public User() {
	}

	public User(String user, String pass, String role) {
		this.username = user;
		this.password = pass;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String user) {
		this.username = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
