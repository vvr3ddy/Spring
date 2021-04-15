package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IDomainDao;
import com.cg.entity.Domain;

@Service
public class DomainServiceImpl implements IDomainService {

	@Autowired
	IDomainDao domainDao;
	
	@Override
	public Domain addDomain(Domain domain) {
		return domainDao.save(domain);
	}

}
