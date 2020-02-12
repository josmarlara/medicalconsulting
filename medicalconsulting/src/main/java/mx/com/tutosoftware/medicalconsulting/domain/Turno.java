package mx.com.tutosoftware.medicalconsulting.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection="turno")
public class Turno {
	
	private String dni;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@CreatedDate
	private Date horarioInicio;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@CreatedDate
	private Date horarioFinal;
	private int duracionConsulta;
	
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getHorarioInicio() {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.setTime(horarioInicio);
		return calendar.getTime();
	}
	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public Date getHorarioFinal() {
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.setTime(horarioFinal);
		return calendar.getTime();
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
	
	

}
