package com.fstg.mediatechs.service;

import com.fstg.mediatechs.dto.ClientRequestDto;
import com.fstg.mediatechs.dto.ClientResponseDto;

import java.util.List;
import java.util.stream.Stream;

public interface ClientService {
    ClientResponseDto save(ClientRequestDto clientRequestDto);
    ClientResponseDto findById(Integer id);
    ClientResponseDto findByNom(String nom);
    void delete(Integer id);
    ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) ;
    List<ClientResponseDto>findAll();

}
