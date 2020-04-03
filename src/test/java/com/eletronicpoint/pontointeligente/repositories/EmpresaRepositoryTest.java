package com.eletronicpoint.pontointeligente.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eletronicpoint.pontointeligente.api.EletronicPointApplication;
import com.eletronicpoint.pontointeligente.api.EletronicPointApplicationTests;
import com.eletronicpoint.pontointeligente.api.entities.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EletronicPointApplication.class)
public class EmpresaRepositoryTest 
{
	@Autowired
	private EmpresaRepository empresaRepository;
	
	Empresa empresa = new Empresa();
	
	@Before
	public void setUp() throws Exception 
	{
		System.out.println("aaaaaaaaaaaaaaaaaaa");
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj("1");
		this.empresaRepository.saveAndFlush(empresa);
	}
	
	@After
	public final void tearDown()
	{
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testFindByCnpj()
	{
		Empresa empresa = this.empresaRepository.findByCnpj("1");
	}
	
	
	
}
