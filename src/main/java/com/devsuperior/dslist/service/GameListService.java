package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repository.GameListReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListReporitory gameListReporitory;

    public List<GameListDTO> findaAll(){
        return gameListReporitory.findAll().stream().map(gameEntity->new GameListDTO(gameEntity)).toList();
    }

}
