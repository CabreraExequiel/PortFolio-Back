
package com.ProtFolio.APi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ProtFolio.APi.model.Educacion;
import com.ProtFolio.APi.model.Empleo;
import com.ProtFolio.APi.model.Experiencia;
import com.ProtFolio.APi.model.Proyecto;
import com.ProtFolio.APi.model.Usuario;
import com.ProtFolio.APi.service.IEducacionService;
import com.ProtFolio.APi.service.IEmpleoService;
import com.ProtFolio.APi.service.IExperienciaService;
import com.ProtFolio.APi.service.IProyectoService;
import com.ProtFolio.APi.service.IUsuarioService;



@RestController
@CrossOrigin(origins = "https://portfolio-backend-exequiel.web.app/", allowedHeaders = "*")
public class Controller {

 
   @Autowired
   private IUsuarioService userService;
   @Autowired
    private IEducacionService eduService;
   @Autowired
    public IExperienciaService expService;
   @Autowired
    public IEmpleoService empService;
   @Autowired
    public IProyectoService proService;
   
   
@PostMapping("/nueva/descripcion")
  public ResponseEntity<Void> actualizarDescripcion(@RequestBody Usuario usuario) {
    try {
      Usuario usuarioExistente = userService.encontrarPorId(usuario.getId());
      usuarioExistente.setDescripcion(usuario.getDescripcion());
      userService.guardar(usuarioExistente);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

@PostMapping("/login")
  public ResponseEntity<Usuario> login(@RequestBody Map<String, String> credentials) {
    String email = credentials.get("email");
    String password = credentials.get("password");
    Usuario user = userService.authenticate(email, password);
    if (user != null) {
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

   @PostMapping("/nuevo/usuario")
  public ResponseEntity<Void> agregarUsuario(@RequestBody Usuario user) {
    userService.agregarUsuario(user);
    return ResponseEntity.ok().build();
  }
   
  @GetMapping("/ver/usuario")
  public List<Usuario> verUsuarios() {
    return userService.verUsuarios();
  }

  @PostMapping("/nuevo/educacion")
  public void agregarEducacion(@RequestBody Educacion educ) {
    eduService.agregarEducacion(educ);
  }

  @GetMapping("/ver/educacion")
  public List<Educacion> verEducacion() {
    return eduService.verEducacion();
  }

  @PostMapping("/nuevo/experiencia")
  public void agregarExperiencia(@RequestBody Experiencia exp) {
    expService.agregarExperiencia(exp);
  }

  @GetMapping("/ver/experiencia")
  public List<Experiencia> verExperiencia() {
    return expService.verExperiencia();
  }

  @PostMapping("/nuevo/empleo")
  public void agregarEmpleo(@RequestBody Empleo emp) {
    empService.agregarEmpleo(emp);
  }

  @GetMapping("/ver/empleo")
  public List<Empleo> verEmpleo() {
    return empService.verEmpleo();
  }

  @PostMapping("/nuevo/proyecto")
  public void agregarProyecto(@RequestBody Proyecto pro) {
    proService.agregarProyecto(pro);
  }

  @GetMapping("/ver/proyecto")
  public List<Proyecto> verProyecto() {
    return proService.verProyecto();
  }

}
