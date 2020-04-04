package com.eletronicpoint.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eletronicpoint.pontointeligente.api.entities.Empresa;
import com.eletronicpoint.pontointeligente.api.entities.Funcionario;
import com.eletronicpoint.pontointeligente.api.enums.PerfilEnum;
import com.eletronicpoint.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FuncionarioRepositoryTest 
{
	private static final String email = "email@email.com.br";
	private static final String cpf = "18174818174";
		
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	
	Funcionario funcionario = new Funcionario();
	
	@Before
	public void setUp() throws Exception 
	{
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		this.funcionarioRepository.save(obterDadosFuncionario(empresa));
	}
	
	@After
	public final void tearDown()
	{
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void findFuncionarioPorEmail()
	{
		Funcionario funcionario = this.funcionarioRepository.findByEmail(email);
		assertEquals(email,funcionario.getEmail());
	}
	
	@Test
	public void findFuncionarioPorCpf()
	{
		Funcionario funcionario = this.funcionarioRepository.findByCpf(cpf);
		assertEquals(cpf,funcionario.getCpf());
	}
	
	@Test
	public void findFuncionarioPorCpfOuEmail()
	{
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(cpf,email);
		assertNotNull(funcionario);
	}
	
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException 
	{
		Funcionario funcionario = new Funcionario();
		funcionario.setName("Sr. Sdrubbles");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.generateBCrypt("123456"));
		funcionario.setCpf(cpf);
		funcionario.setEmail(email);
		funcionario.setEmpresa(empresa);
		return funcionario;
	}
	
	private Empresa obterDadosEmpresa()
	{
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj("12345678987865");
		return empresa;
	}
}
