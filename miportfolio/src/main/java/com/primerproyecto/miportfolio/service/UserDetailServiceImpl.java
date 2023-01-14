package com.primerproyecto.miportfolio.service;




import com.primerproyecto.miportfolio.model.entities.Usuario;
import com.primerproyecto.miportfolio.repository.UsuarioRepository;
import com.primerproyecto.miportfolio.security.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

     Usuario user =   userRepository.findOneByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        return new UserDetailImpl(user);
    }
}
