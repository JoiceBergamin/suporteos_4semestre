package com.curso.resources;

import com.curso.domains.Technician;
import com.curso.domains.User;
import com.curso.domains.dtos.TechnicianDTO;
import com.curso.domains.dtos.UserDTO;
import com.curso.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Tag(name = "Grupo de Usuários", description = "API para Gerenciamento de Usuários")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "Listar todos os usuarios",
            description = "Retorna uma lista com todos os usuarios cadastrados")
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um usuario por id",
            description = "Realiza a busca de um usuario cadastrado por id")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        User obj = this.userService.findbyId(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    @Operation(summary = "Busca um usuario por CPF",
            description = "Realiza a busca de um usuario cadastrado pelo CPF")
    public ResponseEntity<UserDTO> findByCpf(@PathVariable String cpf){
        User obj = this.userService.findbyCpf(cpf);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @GetMapping(value = "/email/{email}")
    @Operation(summary = "Busca um usuario pelo email",
            description = "Realiza a busca de um usuario cadastrado pelo email")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email){
        User obj = this.userService.findbyEmail(email);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }


    @PostMapping
    @Operation(summary = "Criar um novo usuario",
            description = "Cria um novo usuario com base nos dados fornecidos")
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO objDto){
        User newObj = userService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um usuario",
            description = "Altera um usuario existente")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserDTO objDto){
        User Obj = userService.update(id, objDto);
        return ResponseEntity.ok().body(new UserDTO(Obj));
    }

    @DeleteMapping
    @Operation(summary = "Deletar um usuario",
            description = "Remove um usuario a partir de seu id")
    public ResponseEntity<UserDTO> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
