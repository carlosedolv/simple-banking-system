package com.devteam.banco_agencias.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.devteam.banco_agencias.entities.enums.TipoInstituicao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bancos")
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cnpj;
	private String codigo;
	private String ispb;
	private LocalDate dataFundacao;
	private TipoInstituicao tipoIntituicao;
	private String presidente;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private String email;
	
	@OneToMany(mappedBy = "banco")
	private List<Agencia> agencias = new ArrayList<>();

	public Banco() {
	}

	public Banco(Long id, String nome, String cnpj, String codigo, String ispb, LocalDate dataFundacao,
			TipoInstituicao tipoIntituicao, String presidente, String endereco, String bairro, String cidade,
			String estado, String cep, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.codigo = codigo;
		this.ispb = ispb;
		this.dataFundacao = dataFundacao;
		this.tipoIntituicao = tipoIntituicao;
		this.presidente = presidente;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
	}
	
	public List<Agencia> getAgencias() {
		return agencias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIspb() {
		return ispb;
	}

	public void setIspb(String ispb) {
		this.ispb = ispb;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public TipoInstituicao getTipoIntituicao() {
		return tipoIntituicao;
	}

	public void setTipoIntituicao(TipoInstituicao tipoIntituicao) {
		this.tipoIntituicao = tipoIntituicao;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		return Objects.equals(id, other.id);
	}

}
