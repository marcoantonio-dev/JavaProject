package br.com.fatecads.fatecads.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.fatecads.fatecads.entity.Usuario;
import br.com.fatecads.fatecads.repository.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
 
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLoginUsuario(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));
 
        return (UserDetails) new UserDetailsImpl(usuario);
    }

}
