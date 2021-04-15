package com.cg.service;

import org.springframework.stereotype.Service;

import com.cg.entity.Domain;

@Service
public interface IDomainService {
	
	public Domain addDomain(Domain domain);

}
