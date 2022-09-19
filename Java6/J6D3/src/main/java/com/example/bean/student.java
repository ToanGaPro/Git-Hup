package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {
	String email;
	String fullname;
	Double marks;
	Boolean gender;
	String country;
}
