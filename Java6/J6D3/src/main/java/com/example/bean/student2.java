package com.example.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student2 {
	@NotBlank(message = "Khoong dc de trong ?")
	@Email(message = "Khoong dung dinh dang email")
	String email;
	@NotBlank(message = "Khoong dc de trong ?")
	String fullname;
	@NotNull(message = "Khong de trong diem")
	@Max(value = 10 ,message = "diem phai nho hon hoac bang 10")
	@PositiveOrZero(message = "diem phai lon hon hoac bang 0")
	Double marks;
	@NotNull(message = "Chon gioi tinh")
	Boolean gender;
	@NotBlank(message = "chon quoc tich ?")
	String country;
}
