package com.trainings.platform.Models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", 
discriminatorType =DiscriminatorType.INTEGER)
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
	private String lastName;
	
	@Column
	@Email
	private String email;
	
	@NotBlank
	private String username;
	
	@Column
	private String phone;
	
	
	@Enumerated(EnumType.STRING)
    @Column(length = 60)
    private ERole role;
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(	name = "user_roles", 
//				joinColumns = @JoinColumn(name = "user_id"), 
//				inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles = new HashSet<>();
	
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_role",referencedColumnName = "id")
//	private Role role;
	
	
	public String getUsername() {
		return username;
	}
	
	public User(String firstName, String lastName, @Email String email, @NotBlank String username, String phone,
		String strRole, String password) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.username = username;
	this.phone = phone;
	this.password = password;
	switch (strRole) {
	case "ROLE_ADMIN":
		this.setRole(ERole.ROLE_ADMIN);
		break;
	case "ROLE_FORMATEUR":
		this.setRole(ERole.ROLE_FORMATEUR);
		break;
	case "ROLE_BENEFICIARE":
		this.setRole(ERole.ROLE_BENEFICIARE);
		break;
	default: 
		this.setRole(ERole.ROLE_BENEFICIARE);
}
}

	public User( @NotBlank String username,@Email String email, String password,String strRole) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		switch (strRole) {
		case "ROLE_ADMIN":
			this.setRole(ERole.ROLE_ADMIN);
			break;
		case "ROLE_FORMATEUR":
			this.setRole(ERole.ROLE_FORMATEUR);
			break;
		case "ROLE_BENEFICIARE":
			this.setRole(ERole.ROLE_BENEFICIARE);
			break;
		default: 
			this.setRole(ERole.ROLE_BENEFICIARE);
	}
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

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
	
}
