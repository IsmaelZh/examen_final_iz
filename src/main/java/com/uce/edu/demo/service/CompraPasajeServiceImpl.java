package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.CompraPasaje;
import com.uce.edu.demo.repository.ICompraPasajeRepository;

@Service
public class CompraPasajeServiceImpl implements ICompraPasajeService{

	@Autowired
	private ICompraPasajeRepository compraPasajeRepository;
	
	
	@Override
	public CompraPasaje buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.compraPasajeRepository.buscarNumero(numero);
	}

	@Override
	public void actualizar(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		CompraPasaje cp = buscarNumero(compraPasaje.getNumero());
		cp.setEstado("I");
		this.compraPasajeRepository.actualizarCheckIn(cp);
	}

}
