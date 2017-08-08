package org.terrytsao.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.terrytsao.model.Pet;

@Service
@Transactional
public class PetServiceImpl extends MyServiceImpl<Pet>
		implements PetService {

}
