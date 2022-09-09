package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.Vuelo;
import com.uce.edu.demo.modelo.VueloSencillo;

public interface IVueloRepository {

	public void ingresar (Vuelo vuelo);
	public List<VueloSencillo> buscarVuelos(String origen, String destino, LocalDateTime fechaVuelo);
	public Vuelo buscaVueloDisponibles(String numero);
}
