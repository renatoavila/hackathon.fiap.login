package com.hackathon.lep.login.modelo;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathon.lep.login.componentes.Data;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString 
@EqualsAndHashCode(onlyExplicitlyIncluded = true) 
@MappedSuperclass   
public abstract class Entidade<ID> {

	 
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id ;
 
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column( nullable = false, columnDefinition = "VARCHAR(36)", unique = true)
    @Type(type = "uuid-char") 	  
	private UUID chave;
	 

	@Column(nullable = false)
	private LocalDateTime DataCadastro;

	@Column(nullable = false)
	private LocalDateTime DataAtualizacao;
  
	@PrePersist
	void preInsert() {
		this.chave = UUID.randomUUID();
		this.DataCadastro = Data.Agora();			
		this.DataAtualizacao = this.DataCadastro;
	}
	
	@PreUpdate
	void preUpdate() {
		 this.DataAtualizacao = Data.Agora();
	}
	
}
