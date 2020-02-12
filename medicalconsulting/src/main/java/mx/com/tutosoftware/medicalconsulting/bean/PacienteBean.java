package mx.com.tutosoftware.medicalconsulting.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import mx.com.tutosoftware.medicalconsulting.domain.Domicilio;
import mx.com.tutosoftware.medicalconsulting.domain.Paciente;
import mx.com.tutosoftware.medicalconsulting.service.PacienteService;




@ManagedBean
@SessionScoped
@ViewScoped
public class PacienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String mail;
	private String telefono;
	private String password;
	private String calle;
	private String numero;
	private String colonia;
	private String municipio;
	private String estado;
	private String codigoPostal;
	private List<Paciente> pacientes;
	
	@ManagedProperty(value = "#{pacienteService}")
	PacienteService pacienteServicio;
	
	
	@PostConstruct
	public void init() {
		pacientes=pacienteServicio.mostrarPacientes();
	}
	
	
	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public PacienteService getPacienteServicio() {
		return pacienteServicio;
	}

	public void setPacienteServicio(PacienteService pacienteServicio) {
		this.pacienteServicio = pacienteServicio;
	}
	
	
	
	public void guardarPaciente() {
		Paciente paciente = new Paciente();
		paciente.setDni(dni);
		paciente.setNombre(nombre);
		paciente.setApellidoPaterno(apellidoPaterno);
		paciente.setApellidoMaterno(apellidoMaterno);
		paciente.setMail(mail);
		paciente.setTelefono(telefono);
		paciente.setPassword(password);
		Domicilio domicilio=new Domicilio();
		domicilio.setCalle(calle);
		domicilio.setColonia(colonia);
		domicilio.setMunicipio(municipio);
		domicilio.setNumero(numero);
		domicilio.setEstado(estado);
		domicilio.setCodigoPostal(codigoPostal);
		paciente.setDomicilio(domicilio);
		
		System.out.println(dni);
		
		
		
		pacienteServicio.agregarPaciente(paciente);
		pacientes=pacienteServicio.mostrarPacientes();
		limpiarFormulario();
		
		
		
		
		
	}
	
	
public void onEdit(RowEditEvent event) {  
		

		
		
		pacienteServicio.actualizarPaciente((Paciente)event.getObject());
		
		FacesMessage msg = new FacesMessage("Paciente Actualizado",((Paciente) event.getObject()).getDni());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
		
		
		
	}
	
	
	
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Paciente Eliminado",((Paciente) event.getObject()).getDni());  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
		pacienteServicio.eliminarPaciente((Paciente)event.getObject());
		pacientes=pacienteServicio.mostrarPacientes();
		 
		
	}
	
	
	
      public void limpiarFormulario() {
    	
    	dni=" ";
        nombre=" ";
    	apellidoPaterno=" ";
    	apellidoMaterno=" ";
    	mail=" ";
    	telefono=" ";
    	password=" ";
    	calle=" ";
    	numero=" ";
    	colonia=" ";
    	municipio=" ";
    	estado=" ";
        codigoPostal=" ";
    	
    }

}
