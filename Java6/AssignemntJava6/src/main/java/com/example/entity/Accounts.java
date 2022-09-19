package com.example.entity;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import lombok.Data;

@SuppressWarnings("serial") //: đây là warning khi bạn cố tình thực hiện thao tác với một object cần serialize trong khi object đó lại 
@Data
@Entity 
@Table(name = "Accounts")
public class Accounts  implements Serializable{
	@Id
	String username;
	String password;
	String fullname;
	String email;
	String photo;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Orders> orders;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authorities> authorities;
}
