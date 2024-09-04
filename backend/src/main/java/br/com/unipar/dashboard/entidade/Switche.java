package br.com.unipar.dashboard.entidade;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABLE_INV_SWITCHES")
public class Switche {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registro;
	private LocalDate data;
	private String hora;
	private String hostname;
	private String ipAddress;
	private String macAddress;
	private String marca;
	private String modelo;
	private String numSerie;
	private String versao;
	private String imobilizado;
	
	public Switche() {
		super();
	}

	public Switche(Long registro, LocalDate data, String hora, String hostname, String ipAddress, String macAddress,
			String marca, String modelo, String numSerie, String versao, String imobilizado) {
		super();
		this.registro = registro;
		this.data = data;
		this.hora = hora;
		this.hostname = hostname;
		this.ipAddress = ipAddress;
		this.macAddress = macAddress;
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.versao = versao;
		this.imobilizado = imobilizado;
	}

	public Long getRegistro() {
		return registro;
	}

	public void setRegistro(Long registro) {
		this.registro = registro;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getImobilizado() {
		return imobilizado;
	}

	public void setImobilizado(String imobilizado) {
		this.imobilizado = imobilizado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(registro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Switche other = (Switche) obj;
		return Objects.equals(registro, other.registro);
	}
}
