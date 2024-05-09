package com.br.fatecrl.conta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fatecrl.conta.model.PessoaFisica;
import com.br.fatecrl.conta.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService implements IService<PessoaFisica> {
	@Autowired
	private PessoaFisicaRepository repository;

	public PessoaFisicaService() {
	}

	@Override
	public PessoaFisica findById(Long id) {
		Optional<PessoaFisica> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<PessoaFisica> findAll() {
		return repository.findAll();
	}

	@Override
	public PessoaFisica create(PessoaFisica pf) {
		repository.save(pf);
		return pf;
	}

	@Override
	public boolean update(PessoaFisica pf) {
		if (repository.existsById(pf.getId())) {
			repository.save(pf);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
