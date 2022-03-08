package com.ke.springsharks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ke.springsharks.entity.Shark;
import com.ke.springsharks.repo.SharkRepo;

@Service
public class SharkService implements ServiceMethods<Shark>{

	private SharkRepo repo;

	public SharkService(SharkRepo repo) {
		this.repo = repo;
	}

	@Override
	public Shark create(Shark Shark) {
		return this.repo.save(Shark);
	}

	@Override
	public List<Shark> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Shark readById(long id) {
		Optional<Shark> getShark = this.repo.findById(id);
		if(getShark.isPresent()) {
			return getShark.get();
		}
		return null;
	}

	@Override
	public Shark update(long id, Shark Shark) {
		Optional<Shark> existingShark = this.repo.findById(id);
		if(existingShark.isPresent()) {
			Shark exists = existingShark.get();
			exists.setAge(Shark.getAge());
			exists.setGender(Shark.getGender());
			exists.setHabitat(Shark.getHabitat());
			exists.setName(Shark.getName());
			
			return this.repo.saveAndFlush(exists);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}