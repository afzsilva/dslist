package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.repository.GameListReporitory;
import com.devsuperior.dslist.service.GameListService;
import com.devsuperior.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lists")
public class ListsController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;

    @GetMapping()
    public ResponseEntity<List<GameListDTO>> findAll(){
        return ResponseEntity.ok(gameListService.findaAll());
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId){
        return ResponseEntity.ok(gameService.findByList(listId));
    }

    @PostMapping("/{listId}/replacement")
    public ResponseEntity<?> move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
        return ResponseEntity.noContent().build();
    }
}
