package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream().map(gameEntity -> new GameMinDTO(gameEntity)).toList();
    }
}
