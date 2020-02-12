package mx.com.tutosoftware.medicalconsulting.bean;

import java.io.Serializable;
import java.util.List;

//import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import mx.com.tutosoftware.medicalconsulting.domain.Paciente;
import mx.com.tutosoftware.medicalconsulting.domain.Profesional;
import mx.com.tutosoftware.medicalconsulting.service.PacienteService;
import mx.com.tutosoftware.medicalconsulting.service.ProfesionalService;
import mx.com.tutosoftware.medicalconsulting.util.SessionUtils;





@ManagedBean
@SessionScoped
public class Login implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuarioMedico;
	private String passwordMedico;
	private String usuarioPaciente;
	private String passwordPaciente;
	private List<Profesional> medico;
	private List<Paciente> pacientes;
	private Profesional profesional;
	private Paciente paciente;
	private String user;
	private String userPaciente;
	
	
	@ManagedProperty(value = "#{profesionalService}")
	ProfesionalService profesionalServicio;
	
	@ManagedProperty(value = "#{pacienteService}")
	PacienteService pacienteServicio;
	
	
	
	public String getUsuarioMedico() {
		return usuarioMedico;
	}
	public void setUsuarioMedico(String usuarioMedico) {
		this.usuarioMedico = usuarioMedico;
	}
	public String getPasswordMedico() {
		return passwordMedico;
	}
	public void setPasswordMedico(String passwordMedico) {
		this.passwordMedico = passwordMedico;
	}
	public String getUsuarioPaciente() {
		return usuarioPaciente;
	}
	public void setUsuarioPaciente(String usuarioPaciente) {
		this.usuarioPaciente = usuarioPaciente;
	}
	public String getPasswordPaciente() {
		return passwordPaciente;
	}
	public void setPasswordPaciente(String passwordPaciente) {
		this.passwordPaciente = passwordPaciente;
	}
	
	
	public ProfesionalService getProfesionalServicio() {
		return profesionalServicio;
	}
	public void setProfesionalServicio(ProfesionalService profesionalServicio) {
		this.profesionalServicio = profesionalServicio;
	}
	
	
	public List<Profesional> getMedico() {
		return medico;
	}
	public void setMedico(List<Profesional> medico) {
		this.medico = medico;
	}
	public Profesional getProfesional() {
		return profesional;
	}
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public PacienteService getPacienteServicio() {
		return pacienteServicio;
	}
	public void setPacienteServicio(PacienteService pacienteServicio) {
		this.pacienteServicio = pacienteServicio;
	}
	public String getUserPaciente() {
		return userPaciente;
	}
	public void setUserPaciente(String userPaciente) {
		this.userPaciente = userPaciente;
	}
	public String loginMedico() {
		
		System.out.println("Este es el valor de Medico: "+usuarioMedico);
		
		medico = profesionalServicio.obtenerProfesional(usuarioMedico);
		
		if(medico == null) {
			FacesMessage msg = new FacesMessage("Password o usuario incorrecto",null);  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			return "index";
		}
		if(medico.get(0).getPassword().equals(passwordMedico)) {
			
			profesional = medico.get(0);
			HttpSession session = SessionUtils.getSession();
			user=medico.get(0).getNombre()+" "+medico.get(0).getApellidoPaterno()+" "+medico.get(0).getApellidoMaterno();
			session.setAttribute("username",user);
			
			return "adminMedico";
		}else {
			FacesMessage msg = new FacesMessage("Password o usuario incorrecto",null);  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
			return "index";
			
		}
		
	}
	
	
	public String loginPaciente() {
		
    pacientes = pacienteServicio.obtenerPaciente(usuarioPaciente);
		
		if(pacientes == null) {
			FacesMessage msg2 = new FacesMessage("Password o usuario incorrecto",null);  
	        FacesContext.getCurrentInstance().addMessage(null, msg2);  
			
			return "index";
		}
		if(pacientes.get(0).getPassword().equals(passwordPaciente)) {
			
			paciente = pacientes.get(0);
			HttpSession session = SessionUtils.getSession();
			userPaciente=pacientes.get(0).getNombre()+" "+pacientes.get(0).getApellidoPaterno()+" "+pacientes.get(0).getApellidoMaterno();
			session.setAttribute("username",userPaciente);
			
			return "adminPaciente";
		}else {
			FacesMessage msg2 = new FacesMessage("Password o usuario incorrecto",null);  
	        FacesContext.getCurrentInstance().addMessage(null, msg2);  
			return "index";
			
			
		}
		
		
		
		
		
		
	}
	
	//logout event, invalidate session
		public String logout() {
			HttpSession session = SessionUtils.getSession();
			session.invalidate();
			return "index";
		}
}
