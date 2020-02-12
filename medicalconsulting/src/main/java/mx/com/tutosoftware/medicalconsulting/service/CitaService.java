package mx.com.tutosoftware.medicalconsulting.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tutosoftware.medicalconsulting.domain.Cita;
import mx.com.tutosoftware.medicalconsulting.repository.CitaRepository;


@Service
public class CitaService {
	
	@Autowired
    CitaRepository citaRepository;
	
	
	public void agregarCita(Cita c) {
		
		citaRepository.agregarCita(c);
		
	}
	
	
	public List<Cita> busquedaCitaHorarioDni(Date horarioInicio,Date horarioFinal,String dni){
		return citaRepository.busquedaCitaHorarioDni(horarioInicio, horarioFinal, dni);
	}
	
	
	public void actualizarCita(Cita c) {
		citaRepository.actualizarCita(c);
	}
	
	
	public List<Cita> mostrarCitasAgendadas(String dni,String nombrePaciente){
		return citaRepository.mostrarCitasAgendadas(dni,nombrePaciente);
	}
	
	public List<Cita> mostrarCitasAgendadas(String nombrePaciente){
		return citaRepository.mostrarCitasAgendadas(nombrePaciente);
	}
	
	public List<Cita> busquedaCitas(Date horarioInicio,Date horarioFinal,String dni){
		
		return citaRepository.busquedaCitas(horarioInicio, horarioFinal, dni);
		
	}
	
	
}
