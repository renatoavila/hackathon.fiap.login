package com.hackathon.lep.login.modelo;

 
import javax.persistence.*;
 
 
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
  
@Getter
@Setter
@ToString(callSuper=true, includeFieldNames=true)
@Table(name = "usuario"  )
@Entity 
public class Usuario extends Entidade<Integer> {
	 

	private String email;	

	private String senha;

	private Boolean ativo = true;	
	
	private Boolean atendente = false;
   
}
