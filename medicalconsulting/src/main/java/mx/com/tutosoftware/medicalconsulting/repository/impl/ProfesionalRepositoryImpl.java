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

import mx.com.tutosoftware.medicalconsulting.domain.Profesional;
import mx.com.tutosoftware.medicalconsulting.repository.ProfesionalRepository;

public class ProfesionalRepositoryImpl implements ProfesionalRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Iterable<Profesional> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Profesional> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Profesional> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Profesional> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Profesional> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Profesional> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Profesional> findAllById(Iterable<String> ids) {
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
	public void delete(Profesional entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Profesional> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Profesional> findByMail(String mail) {
		// TODO Auto-generated method stub
       Query query = new Query();
		
		Criteria c = Criteria.where("mail").is(mail);
		query.addCriteria(c);
		
		return mongoTemplate.find(query, Profesional.class);
	}

	@Override
	public void agregarProfesional(Profesional p) {
		// TODO Auto-generated method stub
		mongoTemplate.save(p,"profesional");

	}

	@Override
	public List<Profesional> mostrarProfesionales() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Profesional.class);
	}

	@Override
	public void actualizarProfesional(Profesional p) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("dni").is(p.getDni()));
		Document doc = new Document();
		mongoTemplate.getConverter().write(p,doc);
		Update update = Update.fromDocument(doc);
		mongoTemplate.upsert(query, update, "profesional");

	}

	@Override
	public void eliminarProfesional(Profesional p) {
		// TODO Auto-generated method stub
        Query query = new Query();
		query.addCriteria(Criteria.where("dni").is(p.getDni()));
		mongoTemplate.remove(query,"profesional");

	}

}
