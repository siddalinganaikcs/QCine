package com.qcine.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image 
{  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int image_Id;
	private String image_Name;
	private String image_Type;
	@Lob
	@Column(nullable = false ,columnDefinition = "blob")
	private byte[] image_Data;

}
