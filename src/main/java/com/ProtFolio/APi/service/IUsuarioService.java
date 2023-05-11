
package com.ProtFolio.APi.service;

import com.ProtFolio.APi.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    
    public void agregarUsuario(Usuario user);
    public List<Usuario> verUsuarios();
    public void borrarUsuario(Long id);
    public Usuario buscarUsuario(Long id);
    
    public Usuario authenticate(String email, String password);
    Usuario encontrarPorId(Long id);
    void guardar(Usuario usuario);
    

 
}
