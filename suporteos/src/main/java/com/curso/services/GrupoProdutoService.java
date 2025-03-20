package com.curso.services;

import com.curso.domains.GrupoProduto;
import com.curso.domains.dtos.GrupoProdutoDTO;
import com.curso.repositories.GrupoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GrupoProdutoService {

    @Autowired
    private GrupoProdutoRepository grupoProdutoRepo;

    public List<GrupoProdutoDTO> findAll(){
        //retorna uma lista de ProdutoDTO
        return grupoProdutoRepo.findAll().stream().map
                (obj -> new GrupoProdutoDTO(obj)).collect(Collectors.toList());
    }
    public GrupoProduto findbyId (int id){
        Optional<GrupoProduto> obj = grupoProdutoRepo.findById(id);
        return obj.orElse(null);
    }

    public GrupoProduto create(GrupoProdutoDTO dto){
        dto.setId(null);
        GrupoProduto obj = new GrupoProduto(dto);
        return grupoProdutoRepo.save(obj);
    }
    public GrupoProduto update(Integer id, GrupoProdutoDTO objDto){
        objDto.setId(id);
        GrupoProduto oldObj = findbyId(id);
        oldObj = new GrupoProduto(objDto);
        return grupoProdutoRepo.save(oldObj);
    }

    }

