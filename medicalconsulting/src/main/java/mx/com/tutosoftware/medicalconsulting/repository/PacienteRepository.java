package mx.com.tutosoftware.medicalconsulting.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.com.tutosoftware.medicalconsulting.domain.Paciente;

public interface PacienteRepository extends PagingAndSortingRepository<Paciente,String> {
	
	List<Paciente> findByMail(String mail);
    public void agregarPaciente(Paciente p);
    List<Paciente> mostrarPacientes();
    public void actualizarPaciente(Paciente p);
    public void eliminarPaciente(Paciente p);

}
