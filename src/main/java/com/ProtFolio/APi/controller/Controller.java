
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


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

    
   @Autowired
   private IUsuarioService userService;
   
   @PostMapping("/nueva/descripcion")
   public ResponseEntity<?> actualizarDescripcion(@RequestBody Usuario user) {
     try {
       Usuario usuarioExistente = userService.encontrarPorId(user.getId());
       usuarioExistente.setDescripcion(user.getDescripcion());
       userService.guardar(usuarioExistente);
       return ResponseEntity.ok().build();
     } catch (Exception e) {
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
   }
   
   @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Usuario user = userService.authenticate(usuario.getEmail(), usuario.getPassword());
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
