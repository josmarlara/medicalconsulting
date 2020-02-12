package mx.com.tutosoftware.medicalconsulting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tutosoftware.medicalconsulting.domain.Turno;
import mx.com.tutosoftware.medicalconsulting.repository.TurnoRepository;



@Service
public class TurnoService {
	
	@Autowired
	TurnoRepository turnoRepository;
	
	
	public void agregarTurno(Turno t) {
		
		turnoRepository.agregarTurno(t);
		
	}
	
	public List<Turno> mostrarTurno(String dni){
		
		return turnoRepository.mostrarTurnos(dni);
	}
	
	public List<Turno> mostrarTurnoFechaMayorHoyDni(String dni){
		return turnoRepository.mostrarTurnoFechaMayorHoyDni(dni);
	}

}
