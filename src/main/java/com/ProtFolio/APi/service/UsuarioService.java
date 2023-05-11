
package com.ProtFolio.APi.service;

import com.ProtFolio.APi.model.Usuario;
import com.ProtFolio.APi.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;







@Service
public class UsuarioService implements IUsuarioService{

   

    
   
    @Autowired
    public UsuarioRepository userRepo;
    
    
    @Override
  public Usuario encontrarPorId(Long id) {
    Optional<Usuario> usuarioOptional = userRepo.findById(id);
    return usuarioOptional.orElse(null);
  }

  @Override
  public void guardar(Usuario usuario) {
    userRepo.save(usuario);
  }


    @Override
     public Usuario authenticate(String email, String password) {
        Usuario user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
    
    
    @Override
    public void agregarUsuario(Usuario user) {
        userRepo.save(user);
    }
    
    @Override
    public List<Usuario> verUsuarios() {
        return userRepo.findAll();
    }

    @Override
    public void borrarUsuario(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    
}
