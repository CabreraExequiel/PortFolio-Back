
package com.ProtFolio.APi.controller;

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
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class Controller {

    @GetMapping("/health")
public ResponseEntity<?> checkHealth() {
  return ResponseEntity.ok().build();
}
   @Autowired
   private IUsuarioService userService;
   
   @PostMapping("/nueva/descripcion")
   @CrossOrigin(origins = "*", allowedHeaders = "*")
public ResponseEntity<?> actualizarDescripcion(@RequestBody Usuario usuario) {
  try {
    Usuario usuarioExistente = userService.encontrarPorId(usuario.getId());
    usuarioExistente.setDescripcion(usuario.getDescripcion());
    userService.guardar(usuarioExistente);
    return ResponseEntity.ok().build();
  } catch (Exception e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}

/*
@PostMapping("/perfil/foto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public ResponseEntity<?> actualizarFotoPerfil(@RequestParam("id") Long id, @RequestParam("foto") MultipartFile foto) {
  try {
    Usuario usuarioExistente = userService.encontrarPorId(id);
    // Guardar la nueva foto de perfil en el almacenamiento (por ejemplo, en el sistema de archivos o en Amazon S3)
    String nuevaRutaFoto = almacenarFotoPerfil(foto);
    // Actualizar la ruta de la foto de perfil en la base de datos
    usuarioExistente.setRutaFotoPerfil(nuevaRutaFoto);
    userService.guardar(usuarioExistente);
    return ResponseEntity.ok().build();
  } catch (Exception e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}
*/


  
@PostMapping("/login")
@CrossOrigin(origins = "https://portfolio-backend-exequiel.web.app")
public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
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
   public void agregarUsuario(@RequestBody Usuario user){
       userService.agregarUsuario(user);



   }
  @GetMapping("/ver/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ResponseBody
public List<Usuario> verUsuarios(){
    return userService.verUsuarios();
}
   
   


   
    @DeleteMapping("/borrarUsuario/{id}")
    public void borrarUsuario(@PathVariable Long id){
        userService.borrarUsuario(id);
    }


    @Autowired
    private IEducacionService eduService;
    
    @PostMapping("/nuevo/educacion")
    
    public void agregarEducacion(@RequestBody Educacion educ){
        eduService.agregarEducacion(educ);
    }
    @GetMapping("/ver/educacion")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ResponseBody
    
    public List<Educacion> verEducacion(){
        return eduService.verEducacion();
    }
    @DeleteMapping("/borrarEducacion/{id}")
    public void borrarEducacion(Long id){
        eduService.borrarEducacion(id);
    }
    
    
    
    @Autowired
    public IExperienciaService expService;
    
    @PostMapping("/nuevo/experiencia")
    public void agregarExperiencia(@RequestBody Experiencia exp){
        expService.agregarExperiencia(exp);
    }
    @GetMapping("/ver/experiencia")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ResponseBody
    
    public List<Experiencia> verExperiencia(){
        return expService.verExperiencia();
    }
    @DeleteMapping("/borrarExperiencia/{id}")
    public void borrarExperiencia(Long id){
        expService.borrarExperiencia(id);
    }
    
@Autowired
public IEmpleoService empService;

@PostMapping("/nuevo/empleo")
public void agregarEmpleo (@RequestBody Empleo emp){
    empService.agregarEmpleo(emp);
}
@GetMapping("/ver/empleo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ResponseBody

public List<Empleo> verEmpleo(){
    return empService.verEmpleo();
}
@DeleteMapping("/borrarEmpleo/{id}")
    public void borarEmpleo(@PathVariable Long id){
        empService.borrarEmpleo(id);
    }

    @Autowired
    public IProyectoService proService;
    
    @PostMapping("/nuevo/proyecto")
    public void agregarProyecto(@RequestBody Proyecto pro){
        proService.agregarProyecto(pro);
    }
    @GetMapping("/ver/proyecto")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ResponseBody
    public List<Proyecto> verProyecto(){
        return proService.verProyecto();
    }
    @DeleteMapping("/borrarProyecto/{id}")
    public void borarProyecto(@PathVariable Long id){
        proService.borrarProyecto(id);
    }
    @GetMapping("/buscarProyecto/{id} ")
    @ResponseBody
    public Proyecto buscarProyecto(@PathVariable Long id){
        return proService.buscarProyecto(id);
    }
    
   
          
}
