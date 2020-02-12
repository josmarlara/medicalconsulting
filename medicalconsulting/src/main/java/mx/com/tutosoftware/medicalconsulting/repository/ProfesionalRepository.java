package mx.com.tutosoftware.medicalconsulting.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.com.tutosoftware.medicalconsulting.domain.Profesional;

public interface ProfesionalRepository extends PagingAndSortingRepository<Profesional,String> {
	
	List<Profesional> findByMail(String mail);
    public void agregarProfesional(Profesional p);
    List<Profesional> mostrarProfesionales();
    public void actualizarProfesional(Profesional p);
    public void eliminarProfesional(Profesional p);

}
