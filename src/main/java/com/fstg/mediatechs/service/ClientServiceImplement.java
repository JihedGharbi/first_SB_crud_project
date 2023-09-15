package com.fstg.mediatechs.service;

import com.fstg.mediatechs.dao.ClientDao;
import com.fstg.mediatechs.dto.ClientRequestDto;
import com.fstg.mediatechs.dto.ClientResponseDto;
import com.fstg.mediatechs.exceptions.EntityNotFoundException;
import com.fstg.mediatechs.models.EntityClient;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream:

@Service("impl1")

public class ClientServiceImplement implements ClientService{
    private ClientDao clientDao;
    private ModelMapper modelMapper;
    public ClientServiceImplement(ClientDao clientDao, ModelMapper modelMapper){
        this.clientDao=clientDao;
        this.modelMapper=modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        EntityClient entityClient=modelMapper.map(clientRequestDto, EntityClient.class);
        EntityClient saved = clientDao.save(entityClient);
        return modelMapper.map(saved,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        EntityClient entityClient = clientDao.findById(id).orElseThrow(()-> new EntityNotFoundException("Client Not Found"));
        return modelMapper.map(entityClient,ClientResponseDto.class);


    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        EntityClient entityClient=clientDao.findByNom(nom);
        return modelMapper.map(entityClient,ClientResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        clientDao.deleteById(id);
        EntityClient entityClient=clientDao.findById(id).get();
        clientDao.delete(entityClient);
}

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id)  {
        Optional<EntityClient> entityClientOptional = clientDao.findById(id);
        if(entityClientOptional.isPresent()) {
            EntityClient entityClient = modelMapper.map(clientRequestDto, EntityClient.class);
              entityClient.setId(id);
            EntityClient updated = clientDao.save(entityClient);
            return modelMapper.map(updated, ClientResponseDto.class);
        }else{
            throw new EntityNotFoundException("Client Not Found");
        }
    }

    @Override
    public List<ClientResponseDto>findAll() {
        return clientDao.findAll()
                .stream().map(el->modelMapper.map(el,ClientResponseDto.class))
                .collect(Collectors.toList());
    }
}
