package com.fstg.mediatechs.controllers;

import com.fstg.mediatechs.dto.ClientRequestDto;
import com.fstg.mediatechs.dto.ClientResponseDto;
import com.fstg.mediatechs.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    @Qualifier("impl1")
    private ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

     @GetMapping("")
    public ResponseEntity<List<ClientResponseDto>> getClient(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody() ClientRequestDto clientRequestDto){
        ClientResponseDto clientResponseDto=clientService.save(clientRequestDto);
         return  new ResponseEntity<>(clientResponseDto,HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable("id") Integer id) {
        ClientResponseDto clientResponseDto= clientService.findById(id);
        return ResponseEntity.ok(clientResponseDto);
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ClientResponseDto> findByNom(@PathVariable("nom") String nom) {
        ClientResponseDto clientResponseDto = clientService.findByNom(nom);
        return ResponseEntity.ok(clientResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> update(@RequestBody() ClientRequestDto clientRequestDto,@PathVariable() Integer id) {
        ClientResponseDto clientResponseDto = clientService.update(clientRequestDto, id);
        return ResponseEntity.accepted().body(clientResponseDto);
    }
}
