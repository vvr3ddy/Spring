package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Domain;
import com.cg.service.IDomainService;

import io.swagger.annotations.Api;

@Api("Domain API")
@RestController
@RequestMapping("/domain")
@CrossOrigin("*") // other servers can access these apis
public class DomainController {

	@Autowired
	IDomainService domainService;

	@PostMapping("/addNewDomain")
	public ResponseEntity<Object> addDomain(@RequestBody Domain domain) {

		// TODO add exception handling mechanism
		domainService.addDomain(domain);
		return new ResponseEntity<>("Added domain successfully", HttpStatus.OK);
	}
}
