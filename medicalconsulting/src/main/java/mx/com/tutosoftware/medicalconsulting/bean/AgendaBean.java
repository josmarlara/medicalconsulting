package mx.com.tutosoftware.medicalconsulting.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import mx.com.tutosoftware.medicalconsulting.domain.Cita;
import mx.com.tutosoftware.medicalconsulting.domain.Profesional;
import mx.com.tutosoftware.medicalconsulting.domain.Turno;
import mx.com.tutosoftware.medicalconsulting.service.CitaService;
import mx.com.tutosoftware.medicalconsulting.service.ProfesionalService;
import mx.com.tutosoftware.medicalconsulting.service.TurnoService;



@ManagedBean
@SessionScoped
@ViewScoped
public class AgendaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private List<Profesional> medicos;
    private List<Turno> turnos;
    private List<Cita> horarios;
    private List<Cita> citasAgendadas;
    
    
    
	
     @ManagedProperty(value = "#{profesionalService}")
	ProfesionalService profesionalServicio;
     
     @ManagedProperty(value = "#{turnoService}")
 	TurnoService turnoService; 
     
     @ManagedProperty(value = "#{citaService}")
 	CitaService citaService;
     
    
     
     private String dni;
     private String nombrePaciente;
     private Turno horario;
     private Date horarioInicio;
     private boolean medicoDiseable = false;
     
     @PostConstruct
 	public void init() {
 		medicos=profesionalServicio.mostrarProfesionales();
 	}
     
     
     
     

	public List<Profesional> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Profesional> medicos) {
		this.medicos = medicos;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}





	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}





	public List<Cita> getHorarios() {
		return horarios;
	}





	public void setHorarios(List<Cita> horarios) {
		this.horarios = horarios;
	}





	public List<Cita> getCitasAgendadas() {
		return citasAgendadas;
	}





	public void setCitasAgendadas(List<Cita> citasAgendadas) {
		this.citasAgendadas = citasAgendadas;
	}





	public ProfesionalService getProfesionalServicio() {
		return profesionalServicio;
	}

	public void setProfesionalServicio(ProfesionalService profesionalServicio) {
		this.profesionalServicio = profesionalServicio;
	}





	public TurnoService getTurnoService() {
		return turnoService;
	}





	public void setTurnoService(TurnoService turnoService) {
		this.turnoService = turnoService;
	}





	public CitaService getCitaService() {
		return citaService;
	}





	public void setCitaService(CitaService citaService) {
		this.citaService = citaService;
	}













	public String getDni() {
		return dni;
	}





	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	



	 public String getNombrePaciente() {
		
		return nombrePaciente;
	}





	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}





	public Turno getHorario() {
		return horario;
	}





	public void setHorario(Turno horario) {
		this.horario = horario;
	}





	public Date getHorarioInicio() {
		return horarioInicio;
	}





	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}





	
	public boolean isMedicoDiseable() {
		return medicoDiseable;
	}





	public void setMedicoDiseable(boolean medicoDiseable) {
		this.medicoDiseable = medicoDiseable;
	}





	public void mostrarFechasDisponibles() {
		System.out.println("DNI:"+dni);
		turnos = turnoService.mostrarTurnoFechaMayorHoyDni(dni);
		horarios=null;
		
	}
	
	public void mostrarHorario(Turno t) {
		
		horarios=citaService.busquedaCitaHorarioDni(t.getHorarioInicio(),t.getHorarioFinal(),t.getDni());
		
	}
	
	
	public void agendarCita(Cita c) {
		System.out.println("nombrePaciente:"+nombrePaciente);
		c.setNombrePaciente(nombrePaciente);
		c.setStatus("Ocupado");
		citaService.actualizarCita(c);
		horarios=citaService.busquedaCitaHorarioDni(horario.getHorarioInicio(),horario.getHorarioFinal(),horario.getDni());
		citasAgendadas=citaService.mostrarCitasAgendadas(horario.getDni(), nombrePaciente);
		
	}
	
	
	public void mostrarCitas() {
		citasAgendadas=citaService.mostrarCitasAgendadas(nombrePaciente);
		horarios=null;
	}
	
	public void cancelarCita(Cita c) {
		c.setNombrePaciente("");
		c.setStatus("Disponible");
		citaService.actualizarCita(c);
		citasAgendadas=citaService.mostrarCitasAgendadas(nombrePaciente);
		horarios=null;
		
	}
	

}
