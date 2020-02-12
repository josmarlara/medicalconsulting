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
import mx.com.tutosoftware.medicalconsulting.domain.Profesional;
import mx.com.tutosoftware.medicalconsulting.service.ProfesionalService;



@ManagedBean
@SessionScoped
@ViewScoped
public class ProfesionalBean implements Serializable{
	
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
	private List<Profesional> medicos;
	
	
	@ManagedProperty(value = "#{profesionalService}")
	ProfesionalService profesionalServicio;

	
	
	
	@PostConstruct
	public void init() {
		medicos=profesionalServicio.mostrarProfesionales();
	}
	
	
	
	
	public ProfesionalService getProfesionalServicio() {
		return profesionalServicio;
	}
	public void setProfesionalServicio(ProfesionalService profesionalServicio) {
		this.profesionalServicio = profesionalServicio;
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
	



	public List<Profesional> getMedicos() {
		return medicos;
	}




	public void setMedicos(List<Profesional> medicos) {
		this.medicos = medicos;
	}




	public void guardarProfesional() {
		Profesional profesional = new Profesional();
		profesional.setDni(dni);
		profesional.setNombre(nombre);
		profesional.setApellidoPaterno(apellidoPaterno);
		profesional.setApellidoMaterno(apellidoMaterno);
		profesional.setMail(mail);
		profesional.setTelefono(telefono);
		profesional.setPassword(password);
		Domicilio domicilio=new Domicilio();
		domicilio.setCalle(calle);
		domicilio.setColonia(colonia);
		domicilio.setMunicipio(municipio);
		domicilio.setNumero(numero);
		domicilio.setEstado(estado);
		domicilio.setCodigoPostal(codigoPostal);
		profesional.setDomicilio(domicilio);
		
		System.out.println(dni);
		
		
		
		profesionalServicio.agregarProfesional(profesional);
		medicos=profesionalServicio.mostrarProfesionales();
		limpiarFormulario();
		
		
		
		
		
	}
	
	
	public void onEdit(RowEditEvent event) {  
		

		
		
		profesionalServicio.actualizarProfesional((Profesional)event.getObject());
		
		FacesMessage msg = new FacesMessage("Profesional Actualizado",((Profesional) event.getObject()).getDni());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
		
		
		
	}
	
	
	
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Profesional Eliminado",((Profesional) event.getObject()).getDni());  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
		profesionalServicio.eliminarProfesional((Profesional)event.getObject());
		medicos=profesionalServicio.mostrarProfesionales();
		 
		
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
