package com.ghost.csbstoreapi.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.ghost.csbstoreapi.dto.CategoryDTO;
import com.ghost.csbstoreapi.dto.ClientDTO;
import com.ghost.csbstoreapi.dto.ClientNewDTO;
import com.ghost.csbstoreapi.models.Category;
import com.ghost.csbstoreapi.models.enums.ClientType;
import com.ghost.csbstoreapi.models.enums.Profile;
import com.ghost.csbstoreapi.models.location.City;
import com.ghost.csbstoreapi.models.user.Address;
import com.ghost.csbstoreapi.repositories.AddressRepository;
import com.ghost.csbstoreapi.security.UserSS;
import com.ghost.csbstoreapi.services.exceptions.AuthorizationException;
import com.ghost.csbstoreapi.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ghost.csbstoreapi.models.user.Client;
import com.ghost.csbstoreapi.repositories.ClientRepository;
import com.ghost.csbstoreapi.services.exceptions.ObjectNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@Service
public class ClientService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ClientRepository repo;

	@Autowired
	private AddressRepository addressRepository;



	public Client find(Integer id) {
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasHole(Profile.ADMIN) && !id.equals(user.getId())){
			throw new AuthorizationException("Access denied");
		}


		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto not found! Id: " + id + ", Type: " + Client.class.getName()));
	}

	@Transactional
	public Client insert(Client obj) {
		obj.setId(null);
		obj = repo.save(obj);
		addressRepository.saveAll(obj.getAddress());
		return obj;
	}


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
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null, null);
	}
	public Client fromDTO(ClientNewDTO objDto) {
		Client cli = new Client(null, objDto.getName(), objDto.getEmail(), objDto.getCpfOrCnpj(), ClientType.toEnum(objDto.getType()), bCryptPasswordEncoder.encode(objDto.getPassword()));
		City cit = new City(objDto.getCityId(), null, null);
		Address adr = new Address(null, objDto.getStreet(), objDto.getNumber(), objDto.getComplement(), objDto.getDistrict(), objDto.getCep(), cli, cit);
		cli.getAddress().add(adr);
		cli.getPhones().add(objDto.getPhone1());
		if (objDto.getPhone2() != null){
			cli.getPhones().add(objDto.getPhone2());
		}
		if (objDto.getPhone3() != null){
			cli.getPhones().add(objDto.getPhone3());
		}
		return cli;

	}

	private void updateData(Client newObj, Client obj){
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}
