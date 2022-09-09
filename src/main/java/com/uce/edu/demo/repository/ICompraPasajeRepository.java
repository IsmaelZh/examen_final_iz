package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.CompraPasaje;

public interface ICompraPasajeRepository {

	public CompraPasaje buscarNumero(String numero);
	public void actualizarCheckIn(CompraPasaje compraPasaje);
	
}
