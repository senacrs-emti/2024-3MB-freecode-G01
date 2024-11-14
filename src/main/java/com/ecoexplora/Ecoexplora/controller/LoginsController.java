package com.ecoexplora.Ecoexplora.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecoexplora.Ecoexplora.model.Logins;
import com.ecoexplora.Ecoexplora.repository.EcoexploraRepository;

@RestController
public class LoginsController {

	@Autowired
	EcoexploraRepository ecoexploraRepository;
	
	@GetMapping("/getAllUsers")
	public List<Logins> getAllUsers(){
		return ecoexploraRepository.findAll();
	}
	
    @DeleteMapping("/remove/{identity}")
    public boolean deleteRow(@PathVariable("identity") Integer id){
        if(!ecoexploraRepository.findById(id).equals(Optional.empty())){
        	ecoexploraRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    @PutMapping("/update/{identity}")
    public Logins updateAddress(@PathVariable("identity") Integer id,
                                 @RequestBody Map<String, String> body){

        Logins current = ecoexploraRepository.findById(id).get();
        current.setUser(body.get("user"));
        current.setPassword(body.get("password"));
        ecoexploraRepository.save(current);
        return current;
    }
    
    @PostMapping("/add")
    public Logins create(@RequestBody Map<String, String> body){

        String user = body.get("user");
        String password = body.get("password");
        Logins newLogins = new Logins(user, password);

        return ecoexploraRepository.save(newLogins);
    }
    
}

