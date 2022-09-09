package com.uce.edu.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.modelo.Vuelo;
import com.uce.edu.demo.modelo.VueloSencillo;
import com.uce.edu.demo.service.IVueloService;

@Controller
@RequestMapping("/aerolinea")
public class AerolineaController {

	@Autowired
	private IVueloService iVueloService;

	@GetMapping("/ListaVuelos/{origen}/{destino}/{fechaVuelo}")
	public String VuelosLista(@PathVariable("origen") String origen, @PathVariable("destino") String destino,
			@PathVariable("fechaVuelo") String fechaVuelo, Model modelo) {
		LocalDateTime fecha = LocalDateTime.parse(fechaVuelo);
		List<VueloSencillo> listaVuelos = this.iVueloService.buscarVuelos(origen, destino, fecha);
		modelo.addAttribute("vuelos", listaVuelos);
		return "vistaListaVuelos";
	}

	@GetMapping("/buscarVuelo")
	public String PaginaBuscarVuelos(Vuelo vuelo) {
		return "vistaBuscarVuelos";
	}

//	@PostMapping("/vuelo")
//	public String buscarVueloDisponible( persona) {
//		this.personaService.guardar(persona);
//		return "redirect:/personas/buscar";
//	}

}
