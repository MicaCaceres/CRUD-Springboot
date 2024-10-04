package com.example.CrudSpringboot.Rest;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudSpringboot.Model.Usuarios;
import com.example.CrudSpringboot.Repository.UsuarioRepository;
@RestController
public class UsuarioRest {
	@Autowired
	UsuarioRepository usuario;
	@GetMapping("/usuarios/mostrar")
	public ResponseEntity <List<Usuarios>> getAllUsuarios()
	{
		return ResponseEntity.ok(usuario.findAll());
	}

	 @PostMapping("/usuarios/agregar")
	    public ResponseEntity<Usuarios> saveUsuario(@RequestBody Usuarios user) {

	        try {
	            Usuarios usuarioNuevo = usuario.save(user);

	            return ResponseEntity.created(new URI("/usuarios/" + usuarioNuevo.getId())).body(usuarioNuevo);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }

	    }
	 @DeleteMapping("/usuarios/eliminar/{id}")
	    public ResponseEntity<Boolean> deletePersona(@PathVariable("id") Long id) {
	        usuario.deleteById(id);
	        return ResponseEntity.ok(!(usuario.findById(id) != null));

	    }
	 @PutMapping("/usuarios/editar/{id}")
	 public ResponseEntity<Usuarios> updateUsuario(@PathVariable Long id, @RequestBody Map<String, Object> fieldsToUpdate) {
	     Usuarios existingUsuario = usuario.findById(id).orElse(null);
	     if (existingUsuario == null) {
	         return ResponseEntity.notFound().build();
	     }	     
	     fieldsToUpdate.forEach((key, value) -> {
	         switch (key) {
	             case "nombre":
	                 existingUsuario.setNombre((String) value);
	                 break;
	             case "usuario":
	                 existingUsuario.setUsuario((String) value);
	                 break;
	             case "nacimiento":
	                 existingUsuario.setNacimiento((LocalDate) value);
	                 break;
	             case "contraseña":
	                 existingUsuario.setContraseña((String) value);
	                 break;
	             case "email":
	                 existingUsuario.setEmail((String) value);
	                 break;
	             case "dni":
	                 existingUsuario.setDni((Long) value);
	                 break;
	         }
	     });
	     Usuarios updatedUsuario = usuario.save(existingUsuario);
	     return ResponseEntity.ok(updatedUsuario);
	 }
}
