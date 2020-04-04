package com.eletronicpoint.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eletronicpoint.pontointeligente.api.entities.Empresa;
import com.eletronicpoint.pontointeligente.api.entities.Funcionario;
import com.eletronicpoint.pontointeligente.api.entities.Lancamento;
import com.eletronicpoint.pontointeligente.api.enums.PerfilEnum;
import com.eletronicpoint.pontointeligente.api.enums.TipoEnum;
import com.eletronicpoint.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LancamentoRepositoryTest 
{
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private Long funcionarioId;

	@Before
	public void setUp() throws Exception 
	{
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		
		this.funcionarioId = funcionario.getId();
		this.lancamentoRepository.save(obterDadosLancamento(funcionario));
		this.lancamentoRepository.save(obterDadosLancamento(funcionario));
	}
	
	@After
	public final void tearDown()
	{
		this.empresaRepository.deleteAll();
	}
	
	private Lancamento obterDadosLancamento(Funcionario funcionario)
	{
		Lancamento lancamento = new Lancamento();
		lancamento.setData(new Date());
		lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
		lancamento.setFuncionario(funcionario);
		return lancamento;
	}
	
	@Test
	public void testBuscarLancamentosPorFuncionarioId()
	{
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
		
		assertEquals(2,lancamentos.size());
	}
	
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException 
	{
		Funcionario funcionario = new Funcionario();
		funcionario.setName("Sr. Sdrubbles");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.generateBCrypt("123456"));
		funcionario.setCpf("1234566775");
		funcionario.setEmail("email@email.com");
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
