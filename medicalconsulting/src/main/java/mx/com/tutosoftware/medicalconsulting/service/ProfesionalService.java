package mx.com.tutosoftware.medicalconsulting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.tutosoftware.medicalconsulting.domain.Profesional;
import mx.com.tutosoftware.medicalconsulting.repository.ProfesionalRepository;



@Service
public class ProfesionalService {
	
	@Autowired
	ProfesionalRepository  profesionalRepository;
	
	
	public List<Profesional> obtenerProfesional(String mail) {
		
		
		
		return profesionalRepository.findByMail(mail);
		
	}
	
	
	public void agregarProfesional(Profesional p) {
		System.out.println("Este es servicio save");
		
		profesionalRepository.agregarProfesional(p);
		
	}
	
	
	public List<Profesional> mostrarProfesionales(){
		return profesionalRepository.mostrarProfesionales();
	}
	
	
	public void actualizarProfesional(Profesional p) {
		profesionalRepository.actualizarProfesional(p);
	}
	
	public void eliminarProfesional(Profesional p) {
		profesionalRepository.eliminarProfesional(p);
	}

}
