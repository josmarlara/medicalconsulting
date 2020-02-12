package mx.com.tutosoftware.medicalconsulting.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.com.tutosoftware.medicalconsulting.domain.Cita;



public interface CitaRepository extends PagingAndSortingRepository<Cita,String> {
	
	
	public void agregarCita(Cita c);
	public List<Cita> busquedaCitaHorarioDni(Date horarioInicio,Date horarioFinal,String dni);
	public void actualizarCita(Cita c);
	public List<Cita> mostrarCitasAgendadas(String dni,String nombrePaciente);
	public List<Cita> mostrarCitasAgendadas(String nombrePaciente);
	public List<Cita> busquedaCitas(Date horarioInicio,Date horarioFinal,String dni);
}
