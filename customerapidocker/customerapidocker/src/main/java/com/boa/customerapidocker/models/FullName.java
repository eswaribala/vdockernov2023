package com.boa.customerapidocker.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullName {
	@Column(name="First_Name",nullable = false,length = 100)
	private String firstName;
	@Column(name="Last_Name",nullable = false,length = 100)
	private String lastName;
	@Column(name="Middle_Name",nullable = true,length = 100)
	private String middleName;

}
