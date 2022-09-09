package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.CompraPasaje;

public interface ICompraPasajeService {

	public CompraPasaje buscarNumero(String numero);
	public void actualizar(CompraPasaje compraPasaje);
}
