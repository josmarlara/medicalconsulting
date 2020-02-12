package mx.com.tutosoftware.medicalconsulting.repository.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import mx.com.tutosoftware.medicalconsulting.domain.Cita;
import mx.com.tutosoftware.medicalconsulting.repository.CitaRepository;



public class CitaRepositoryImpl implements CitaRepository {
	
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Iterable<Cita> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Cita> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cita> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cita> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cita> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Cita> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Cita> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Cita entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Cita> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarCita(Cita c) {
		// TODO Auto-generated method stub
		
		mongoTemplate.save(c,"cita");

	}
	
	@Override
	public List<Cita> busquedaCitaHorarioDni(Date horarioInicio,Date horarioFinal,String dni){
		
		final Query query=new Query();
		
	
		query.addCriteria(Criteria.where("horario").gte(horarioInicio).lte(horarioFinal).and("dni").is(dni).and("status").is("Disponible"));
	
		return mongoTemplate.find(query,Cita.class);
		
		
		
	}
	
	@Override
	public void actualizarCita(Cita c) {
		
		
		Query query = new Query(Criteria.where("dni").is(c.getDni()).and("horario").is(c.getHorario()));
		Document doc = new Document();
		mongoTemplate.getConverter().write(c,doc);
		Update update = Update.fromDocument(doc);
		mongoTemplate.upsert(query, update, "cita");
		
	}
	
	public List<Cita> mostrarCitasAgendadas(String dni,String nombrePaciente){
       Date fechaHoy = new Date();
		
		
		System.out.println("La Fecha de hoy es:"+fechaHoy);
		
		final Query query=new Query();
		
		query.addCriteria(Criteria.where("horario").gt(fechaHoy).and("dni").is(dni).and("nombrePaciente").is(nombrePaciente));
	
		return mongoTemplate.find(query,Cita.class);
	}
	
	
	public List<Cita> mostrarCitasAgendadas(String nombrePaciente){
		
    Date fechaHoy = new Date();
		
		
		System.out.println("La Fecha de hoy es:"+fechaHoy);
		
		final Query query=new Query();
		
		query.addCriteria(Criteria.where("horario").gt(fechaHoy).and("nombrePaciente").is(nombrePaciente));
	
		return mongoTemplate.find(query,Cita.class);
		
	}
	
	public List<Cita> busquedaCitas(Date horarioInicio,Date horarioFinal,String dni){
		
		final Query query=new Query();
		
		
		query.addCriteria(Criteria.where("horario").gte(horarioInicio).lte(horarioFinal).and("dni").is(dni));
	
		return mongoTemplate.find(query,Cita.class);
		
	}
	

}
