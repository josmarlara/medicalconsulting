package mx.com.tutosoftware.medicalconsulting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tutosoftware.medicalconsulting.domain.Paciente;
import mx.com.tutosoftware.medicalconsulting.repository.PacienteRepository;



@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	
	public List<Paciente> obtenerPaciente(String email){
		
		return pacienteRepository.findByMail(email);
	}
	
	
	public void agregarPaciente(Paciente p) {
		
		pacienteRepository.agregarPaciente(p);
	}
	
	public List<Paciente> mostrarPacientes(){
		return pacienteRepository.mostrarPacientes();
	}
	
	
	public void actualizarPaciente(Paciente p) {
		pacienteRepository.actualizarPaciente(p);
	}
	
	
	public void eliminarPaciente(Paciente p) {
		pacienteRepository.eliminarPaciente(p);
	}

}
