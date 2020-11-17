package com.alquiler.controlador;
import java.security.Principal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alquiler.entidades.alquiler;
import com.alquiler.entidades.vehiculo;
import com.alquiler.proyecto.interfaces.IAlquiler;
import com.alquiler.proyecto.interfaces.IVehiculo;
import com.alquiler.proyecto.interfaces.UsuarioRepo;
import com.sun.el.parser.ParseException;
@Controller
public class controladorAlquiler {
	@Autowired
	IAlquiler repoA;
	@Autowired
	IVehiculo repoV;
	@Autowired
	UsuarioRepo repoU;
	
  @GetMapping("/Vista")
  public String vista(Model modelo, Principal principal) {
	modelo.addAttribute("inner", repoA.findAll());
	modelo.addAttribute("user", repoU.findByNick(principal.getName()).getId());
	return "vista";  
  }
  
 @RequestMapping(value = "/CrearAlquiler", method = RequestMethod.POST)
	   public String crearvehiculo(
			   @RequestParam(value = "marca")String marca,
			   @RequestParam(value = "modelo")String modelo,
			   @RequestParam(value = "matri")String matri,
			   @RequestParam(value = "cost")String cost,
			   @RequestParam(value = "ano")String ano,
			   @RequestParam(value = "img")String img,
			   
			   @RequestParam(value = "color")String color,
			   @RequestParam(value = "fechaE")String fechaE,
			   @RequestParam(value = "fechaC")String fechaC,
			   @RequestParam(value = "galones")int galones,
			   @RequestParam(value = "dias")int dias,
			   @RequestParam(value = "telefono")int telefono,
			   @RequestParam(value = "total")int total,
			   @RequestParam(value = "fkcl")int fkcl,
			   @RequestParam(value = "fkV")int fkV)throws ParseException  {
	alquiler a = new alquiler();
	Date date = new Date();
	a.setColor(color);
	a.setEstado(1); 
	a.setFecha_entrega(fechaE);
	a.setFecha_recibido(fechaC);
	a.setFechaDCompra(date);
	a.setFkCliente(repoU.findById(fkcl).get());
	a.setFkVehiculo(repoV.findById(fkV).get());
	a.setGalonesInicio(galones);
	a.setNumero_dias(dias);
	a.setTelefono(telefono);
	a.setTotal(total);
    repoA.save(a);
		  
		  vehiculo h = new vehiculo();
		  h.setId_vehiculo(fkV);
			h.setEstado(2);
			   h.setMarca(marca);
			   h.setModelo(modelo);
			   h.setMatricula(matri);
			   h.setCostoDiario(Double.parseDouble(cost));
			   h.setAno(ano);
			   h.setImagen(img);
			   repoV.save(h);
			   return "redirect:/menu";
		}
	   
}
