package com.qcine.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    private String userName;
	private String userPassword;
    private String userEmail;
    private  int userAge;
    private String userGender;
    private long userPhoneNo;
    
    
    @OneToOne(fetch = FetchType.EAGER   ,cascade = CascadeType.ALL)
    @JoinColumn(name="addId")
    private UserAddressEntity address;
    
    
    
}
