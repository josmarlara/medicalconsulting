package mx.com.tutosoftware.medicalconsulting.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.com.tutosoftware.medicalconsulting.domain.Turno;



public interface TurnoRepository extends PagingAndSortingRepository<Turno,String> {
	
	public void agregarTurno(Turno t);
	List<Turno> mostrarTurnos(String dni);
	public List<Turno> mostrarTurnoFechaMayorHoyDni (String dni);

}
