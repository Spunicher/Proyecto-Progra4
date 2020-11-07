package com.alquiler.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nick;
	String clave;
	private String correo;
	private String apellido;
	private String dui;
	private String licencia;
	private String direcion;
	
	@JsonIgnore 
	@OneToMany(mappedBy = "fkCliente", cascade = CascadeType.ALL)
	public List<alquiler> fkCliente;
	
	//************************************************************
	
		@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	    @JoinTable( 
	        name = "usuarios_roles", 
	        joinColumns = @JoinColumn(
	          name = "idUsuario", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "idRol", referencedColumnName = "id")) 
	    private List<Rol> roles= new ArrayList<>();
		
		
		//************************************************************
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getDirecion() {
		return direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public List<alquiler> getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(List<alquiler> fkCliente) {
		this.fkCliente = fkCliente;
	}

	public Usuario(int id, String nick, String clave, String correo, String apellido, String dui, String licencia,
			String direcion) {
		this.id = id;
		this.nick = nick;
		this.clave = clave;
		this.correo = correo;
		this.apellido = apellido;
		this.dui = dui;
		this.licencia = licencia;
		this.direcion = direcion;
	}

	
	public Usuario(String nick, String clave, String correo, String apellido, String dui, String licencia,
			String direcion) {
		this.nick = nick;
		this.clave = clave;
		this.correo = correo;
		this.apellido = apellido;
		this.dui = dui;
		this.licencia = licencia;
		this.direcion = direcion;
	}

	public Usuario() {
	}
	
	
}
