package mx.com.tutosoftware.medicalconsulting.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import mx.com.tutosoftware.medicalconsulting.domain.Cita;
import mx.com.tutosoftware.medicalconsulting.domain.Turno;
import mx.com.tutosoftware.medicalconsulting.service.CitaService;
import mx.com.tutosoftware.medicalconsulting.service.TurnoService;






@ManagedBean
@SessionScoped
@ViewScoped
public class TurnoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{login}")
	private Login login;
	@ManagedProperty(value = "#{turnoService}")
	TurnoService turnoService;
	@ManagedProperty(value = "#{citaService}")
	CitaService citaService;
	
	private Date horarioInicio;
	private Date horarioFinal;
	private int duracionConsulta;
	private List<Turno> turnos;
    private List<Cita> pacientes;
	private String dni;
	private Turno turnoDisponible;
	
	@PostConstruct
    public void init() {
		
		turnos=turnoService.mostrarTurno(getDni());
    	
    	
    	
    }
	
	

	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
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
		dni=login.getProfesional().getDni();
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
    
	
	



	public Turno getTurnoDisponible() {
		return turnoDisponible;
	}



	public void setTurnoDisponible(Turno turnoDisponible) {
		this.turnoDisponible = turnoDisponible;
	}



	public Date getHorarioInicio() {
		return horarioInicio;
	}



	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}



	public Date getHorarioFinal() {
		return horarioFinal;
	}



	public void setHorarioFinal(Date horarioFinal) {
		this.horarioFinal = horarioFinal;
	}



	public int getDuracionConsulta() {
		return duracionConsulta;
	}



	public void setDuracionConsulta(int duracionConsulta) {
		this.duracionConsulta = duracionConsulta;
	}



	public List<Turno> getTurnos() {
		return turnos;
	}



	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}



	public List<Cita> getPacientes() {
		return pacientes;
	}



	public void setPacientes(List<Cita> pacientes) {
		this.pacientes = pacientes;
	}



	public void guardarTurno() {
		Calendar calendario =Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		
		
		int hora1,hora2,dia,mes,year,dia2,mes2,year2;
		calendario.setTime(horarioInicio);
		hora1=calendario.get(Calendar.HOUR_OF_DAY);
		dia=calendario.get(Calendar.DATE);
		mes=calendario.get(Calendar.MONTH);
		year=calendario.get(Calendar.YEAR);
		
		
		
		System.out.println("Es mes es"+mes);
		
		calendario.setTime(horarioFinal);
		hora2=calendario.get(Calendar.HOUR_OF_DAY);
		dia2=calendario.get(Calendar.DATE);
		mes2=calendario.get(Calendar.MONTH);
		year2=calendario.get(Calendar.YEAR);
		
		
		
		if(dia != dia2  || mes != mes2   || year != year2){
			
			FacesMessage msg = new FacesMessage("Las fechas deben ser iguales",null);  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
			
		}
		
		
		
		else if(hora1>hora2 || hora1 == hora2) {
			FacesMessage msg = new FacesMessage("La hora1 es mayor que la hora2 o son iguales",null);  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
			
			
		}
		
		
		else {
		
		
		
		if(duracionConsulta == 15) {
		int duracion = (hora2-hora1)*4;
		int suma=0;
	
		System.out.println("La duracion es:"+duracion);
		for(int i=0;i<duracion;i++) {
			Cita cita = new Cita();
			cita.setDni(dni);
			
			
			cita.setHorario(sumaCita(horarioInicio,suma));
			cita.setNombrePaciente("");
			cita.setStatus("Disponible");
			citaService.agregarCita(cita);
			suma=suma+15;
		}
		
		}
		else if(duracionConsulta==30) {
			
			int duracion = (hora2-hora1)*2;
			int suma=0;
			
			System.out.println("La duracion es:"+duracion);
			for(int i=0;i<duracion;i++) {
				Cita cita = new Cita();
				cita.setDni(dni);
				
				
				cita.setHorario(sumaCita(horarioInicio,suma));
				cita.setNombrePaciente("");
				cita.setStatus("Disponible");
				citaService.agregarCita(cita);
				suma=suma+30;
				}
			
		}else {
			
			int duracion = hora2-hora1;
			int suma=0;
			
			System.out.println("La duracion es:"+duracion);
			for(int i=0;i<duracion;i++) {
				Cita cita = new Cita();
				cita.setDni(dni);
				
				
				cita.setHorario(sumaCita(horarioInicio,suma));
				cita.setNombrePaciente("");
				cita.setStatus("Disponible");
				citaService.agregarCita(cita);
				suma=suma+60;
				}
			
			
		}
		
		
		
		
		
		
		
		Turno turno = new Turno();
		turno.setDni(dni);
		turno.setHorarioInicio(conversorUTC(horarioInicio));
		turno.setHorarioFinal(conversorUTC(horarioFinal));
		turno.setDuracionConsulta(duracionConsulta);
		turnoService.agregarTurno(turno);
		turnos=turnoService.mostrarTurno(dni);
		limpiarFormulario();
		
		
		}
		
	}
	
	
	
	
	
	
	
	
	public Date conversorUTC(Date fecha) {
		//En Mexico es UTC-6 y mongodb guarda en UTC Hay que restar 6 horas
		Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	    calendar.setTime(fecha);
	    
	    return calendar.getTime();
		
		
		
		
	}
	
	public Date sumaCita(Date fecha,int duracion) {
		
		Calendar calendar=Calendar.getInstance();
	    calendar.setTime(fecha);
		calendar.add(Calendar.MINUTE,duracion);
		return calendar.getTime();
	}
	
	
	public void mostrarPacientes() {
		System.out.println("Estoy haciendo el evento");
		pacientes=citaService.busquedaCitas(turnoDisponible.getHorarioInicio(),turnoDisponible.getHorarioFinal(),turnoDisponible.getDni());
	}
	
	
	
	
	
	public void limpiarFormulario() {
		horarioInicio=null;
		horarioFinal=null;
	}
	
       
}
