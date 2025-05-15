package com.curso.resources;

import com.curso.domains.Technician;
import com.curso.domains.dtos.TechnicianDTO;
import com.curso.services.TechnicianService;
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
@RequestMapping(value = "/technician")
@Tag(name = "Grupo de Tecnicos", description = "API para Gerenciamento de Tecnicos")
public class TechnicianResource {

    @Autowired
    private TechnicianService techService;

    @GetMapping
    @Operation(summary = "Listar todos os tecnicos",
            description = "Retorna uma lista com todos os tecnicos cadastrados")
    public ResponseEntity<List<TechnicianDTO>> findAll(){
        return ResponseEntity.ok().body(techService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um tecnico por id",
            description = "Realiza a busca de um tecnico cadastrado por id")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Long id){
        Technician obj = this.techService.findbyId(id);
        return ResponseEntity.ok().body(new TechnicianDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    @Operation(summary = "Busca um tecnico por CPF",
            description = "Realiza a busca de um tecnico cadastrado pelo CPF")
    public ResponseEntity<TechnicianDTO> findByCpf(@PathVariable String cpf){
        Technician obj = this.techService.findbyCpf(cpf);
        return ResponseEntity.ok().body(new TechnicianDTO(obj));
    }

    @GetMapping(value = "/email/{email}")
    @Operation(summary = "Busca um tecnico pelo email",
            description = "Realiza a busca de um tecnico cadastrado pelo email")
    public ResponseEntity<TechnicianDTO> findByEmail(@PathVariable String email){
        Technician obj = this.techService.findbyEmail(email);
        return ResponseEntity.ok().body(new TechnicianDTO(obj));
    }

    @PostMapping
    @Operation(summary = "Criar um novo tecnico",
            description = "Cria um novo tecnico com base nos dados fornecidos")
    public ResponseEntity<TechnicianDTO> create(@Valid @RequestBody TechnicianDTO objDto){
        Technician newObj = techService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
      return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um tecnico",
            description = "Altera um tecnico existente")
    public ResponseEntity<TechnicianDTO> update(@PathVariable Long id, @Valid @RequestBody TechnicianDTO objDto){
        Technician Obj = techService.update(id, objDto);
        return ResponseEntity.ok().body(new TechnicianDTO(Obj));
    }

    @DeleteMapping
    @Operation(summary = "Deletar um tecnico",
            description = "Remove um tecnico a partir de seu id")
    public ResponseEntity<TechnicianDTO> delete(@PathVariable Long id){
        techService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
