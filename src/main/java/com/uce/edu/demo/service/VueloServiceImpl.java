package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Vuelo;
import com.uce.edu.demo.modelo.VueloSencillo;
import com.uce.edu.demo.repository.IVueloRepository;

@Service
public class VueloServiceImpl implements IVueloService {

	@Autowired
	private IVueloRepository iVueloRepository;

	@Override
	public void ingresar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.iVueloRepository.ingresar(vuelo);
	}

	@Override
	public List<VueloSencillo> buscarVuelos(String origen, String destino, LocalDateTime fechaVuelo) {
		// TODO Auto-generated method stub

		List<VueloSencillo> lista = this.iVueloRepository.buscarVuelos(origen, destino, fechaVuelo);

		return lista;

	}

	@Override
	public Vuelo buscaVueloDisponibles(String numero) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscaVueloDisponibles(numero);

	}

}
