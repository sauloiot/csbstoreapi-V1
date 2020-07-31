package com.ghost.csbstoreapi.services;

import java.util.List;
import java.util.Optional;

import com.ghost.csbstoreapi.dto.ClientDTO;
import com.ghost.csbstoreapi.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ghost.csbstoreapi.models.user.Client;
import com.ghost.csbstoreapi.repositories.ClientRepository;
import com.ghost.csbstoreapi.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto not found! Id: " + id + ", Type: " + Client.class.getName()));
	}
	///////////////
	//INSERT METHOD HERE
	///////////////

	public Client update(Client obj){
		Client newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id){
		find(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("You cannot delete client with associated entities");
		}
	}

	public List<Client> findAll(){
		return repo.findAll();
	}

	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
				orderBy);
		return repo.findAll(pageRequest);
	}

	public Client fromDTO(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
	}

	private void updateData(Client newObj, Client obj){
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}
