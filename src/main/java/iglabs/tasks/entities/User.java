package iglabs.tasks.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends IdentityEntity {
	@Column(name="name", nullable=false, length=50)
	private String name;
	
	@Column(name="password", nullable=false, length=50)
	private String password;
	
	@Column(name="email", nullable=false, length=50)
	private String email;
	
	@Column(name="is_admin", nullable=false)
	private boolean admin;

	
	public User() {
		admin = false;
	}
	
	public User(String name, String password, String email) {
		this();
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
