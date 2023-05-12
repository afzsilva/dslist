package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.GameListReporitory;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListReporitory gameListReporitory;

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findaAll(){
        return gameListReporitory.findAll().stream().map(gameEntity->new GameListDTO(gameEntity)).toList();
    }

    @Transactional(readOnly = false)
    public void move(Long listId, int sourceIndex,int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex? sourceIndex:destinationIndex;
        int max = sourceIndex < destinationIndex? destinationIndex:sourceIndex;

        for (int i = min; i < max; i++) {
            gameListReporitory.updateBelongingPosition(listId,list.get(i).getId(),i);
        }
    }

}
