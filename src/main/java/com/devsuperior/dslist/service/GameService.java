package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream().map(gameEntity -> new GameMinDTO(gameEntity)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        return gameRepository.findById(id).map(gameEntity-> new GameDTO(gameEntity)).orElseThrow(()->new RuntimeException("Game Não existe na Base"));
    }
}
