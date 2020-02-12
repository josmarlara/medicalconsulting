package mx.com.tutosoftware.medicalconsulting.repository.impl;


import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import mx.com.tutosoftware.medicalconsulting.domain.Turno;
import mx.com.tutosoftware.medicalconsulting.repository.TurnoRepository;




public class TurnoRepositoryImpl implements TurnoRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Iterable<Turno> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Turno> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Turno> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Turno> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Turno> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Turno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Turno> findAllById(Iterable<String> ids) {
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
	public void delete(Turno entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Turno> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarTurno(Turno t) {
		// TODO Auto-generated method stub
		
		mongoTemplate.save(t,"turno");

	}
	
	public List<Turno> mostrarTurnos(String dni){
		
		 Query query = new Query();
			
			Criteria c = Criteria.where("dni").is(dni);
			query.addCriteria(c);
			
			return mongoTemplate.find(query,Turno.class);
		
		
		
	}
	@Override
	public List<Turno> mostrarTurnoFechaMayorHoyDni(String dni){
		Date fechaHoy = new Date();
		
		
		System.out.println("La Fecha de hoy es:"+fechaHoy);
		
		final Query query=new Query();
		
		query.addCriteria(Criteria.where("horarioInicio").gt(fechaHoy).and("dni").is(dni));
	
		return mongoTemplate.find(query,Turno.class);
	}

}
