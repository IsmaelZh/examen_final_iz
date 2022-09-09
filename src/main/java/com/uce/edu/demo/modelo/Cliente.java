package com.uce.edu.demo.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_id_seq")
	@SequenceGenerator(name = "clie_id_seq", sequenceName = "clie_id_seq", allocationSize = 1)
	@Column(name = "clie_id")
	private Integer id;

	@Column(name = "clie_nombre")
	private String nombre;
	
	@Column(name = "clie_cedula")
	private String cedula;

	@OneToMany(mappedBy = "cliente")
	private List<CompraPasaje> comprasPasaje;
	
	

}