package com.eletronicpoint.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eletronicpoint.pontointeligente.api.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long>
{
	Empresa findByCnpj(String cnpj);
}
