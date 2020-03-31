package com.trainings.platform.Models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users",
		uniqueConstraints = { 
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "username") 
	}) 
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String Lastname;
	
	@Column
	@Email
	private String email;
	
	@NotBlank
	private String username;
	
	@Column
	private String phone;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_role",referencedColumnName = "id")
//	private Role role;
	
	
	public String getUsername() {
		return username;
	}

	public User( @NotBlank String username,@Email String email, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public User( ) {

	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
