package com.eletronicpoint.pontointeligente.api.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.eletronicpoint.pontointeligente.api.EletronicPointApplication;
import com.eletronicpoint.pontointeligente.api.entities.Empresa;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmpresaRepositoryTest 
{
	@Autowired
	private EmpresaRepository empresaRepository;
	
	Empresa empresa = new Empresa();
	
	@Before
	public void setUp() throws Exception 
	{
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj("1");
		this.empresaRepository.saveAndFlush(empresa);
		empresa = new Empresa();
		empresa.setCnpj("2");
		empresa.setRazaoSocial("Empresa de exemplo 2");
		this.empresaRepository.saveAndFlush(empresa);
	}
	
	@After
	public final void tearDown()
	{
		this.empresaRepository.deleteAll();
		System.out.println(this.empresaRepository.findAll());
	}
	
	@Test
	public void testFindByCnpj()
	{
		System.out.println(empresaRepository.findByCnpj("2"));
	}
	
	
	
}
