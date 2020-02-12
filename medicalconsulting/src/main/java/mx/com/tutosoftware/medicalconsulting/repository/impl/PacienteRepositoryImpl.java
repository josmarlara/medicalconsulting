package mx.com.tutosoftware.medicalconsulting.repository.impl;

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

import mx.com.tutosoftware.medicalconsulting.domain.Paciente;
import mx.com.tutosoftware.medicalconsulting.repository.PacienteRepository;

public class PacienteRepositoryImpl implements PacienteRepository {
	
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	@Override
	public Iterable<Paciente> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Paciente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Paciente> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Paciente> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Paciente> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Paciente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Paciente> findAllById(Iterable<String> ids) {
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
	public void delete(Paciente entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Paciente> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Paciente> findByMail(String mail) {
		// TODO Auto-generated method stub
		 Query query = new Query();
		 Criteria c = Criteria.where("mail").is(mail);
		 query.addCriteria(c);
			
		return mongoTemplate.find(query, Paciente.class);
		
	}

	@Override
	public void agregarPaciente(Paciente p) {
		// TODO Auto-generated method stub
		mongoTemplate.save(p,"paciente");

	}

	@Override
	public List<Paciente> mostrarPacientes() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Paciente.class);
	}

	@Override
	public void actualizarPaciente(Paciente p) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("dni").is(p.getDni()));
		Document doc = new Document();
		mongoTemplate.getConverter().write(p,doc);
		Update update = Update.fromDocument(doc);
		mongoTemplate.upsert(query, update, "paciente");

	}

	@Override
	public void eliminarPaciente(Paciente p) {
		// TODO Auto-generated method stub
        Query query = new Query();
		query.addCriteria(Criteria.where("dni").is(p.getDni()));
		mongoTemplate.remove(query,"paciente");

	}

}
