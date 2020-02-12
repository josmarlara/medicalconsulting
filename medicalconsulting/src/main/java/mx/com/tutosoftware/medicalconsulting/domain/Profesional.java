package mx.com.tutosoftware.medicalconsulting.domain;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="profesional")
public class Profesional {
	
	
	//Esta clave depende del pais donde sea implmentada
		//La aplicación
		private String dni;
		private String nombre;
		private String apellidoPaterno;
		private String apellidoMaterno;
		//el correo va hacer el usuario para loguearse
		private String mail;
		private String telefono;
		private String password;
		private Domicilio domicilio;
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
		public Domicilio getDomicilio() {
			return domicilio;
		}
		public void setDomicilio(Domicilio domicilio) {
			this.domicilio = domicilio;
		}

}
