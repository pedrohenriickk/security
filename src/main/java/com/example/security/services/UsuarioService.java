package com.example.security.services;

import com.example.security.DTO.UsuarioDTO;
import com.example.security.entities.Usuario;
import com.example.security.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final PasswordEncoder passwordEncoder;

    private final UsuarioRepository repo;

    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository repo) {
        this.passwordEncoder = passwordEncoder;
        this.repo = repo;
    }

    public Usuario saveUser(UsuarioDTO dto){

        Usuario u = new Usuario();

        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setSenha(passwordEncoder.encode(dto.getSenha()));
        u.setRole(dto.getRole());
        repo.save(u);

        return u;

    }
}
