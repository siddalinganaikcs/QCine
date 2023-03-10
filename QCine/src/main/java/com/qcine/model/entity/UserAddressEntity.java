package com.qcine.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserAddressEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int addId;
    private String city;
    private String street;
    private String houseNo;
    private String state;
    private String country;
    private int zipCode;
    
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="intId")
    private UserIntrestedEntity intrested;
    
}
