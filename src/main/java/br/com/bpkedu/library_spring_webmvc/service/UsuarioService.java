package br.com.bpkedu.library_spring_webmvc.service;

import br.com.bpkedu.library_spring_webmvc.domain.Usuario;
import br.com.bpkedu.library_spring_webmvc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private static UsuarioRepository usuarioRepository;



    public static List<Usuario> listarTodos(){
       return usuarioRepository.findAll();
    }

    public static Object buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public static Usuario salvar(Usuario usuario) {
        return null;
    }

    public static void deletar(Long id) {
    }
}
