package com.senai.rafaella.PrjGame.servicies;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.rafaella.PrjGame.entities.Jogo;
import com.senai.rafaella.PrjGame.repositories.JogoRepositorio;


import java.util.Optional;
@Service
public class JogoService {
	private final JogoRepositorio jogoRepository;
	
	public JogoService(JogoRepositorio jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	public List<Jogo> getAllJogos(){
		return jogoRepository.findAll();
	}
	public Jogo saveJogo (Jogo jogo) {
        return jogoRepository.save(jogo);
    }
    
    public void deleteJogo (Long id) {
        jogoRepository.deleteById(id);
    }
	
 // fazendo o update do jogo com o optional
 	public Jogo updateJogo(Long id, Jogo novoJogo) {
         Optional<Jogo> jogoOptional = jogoRepository.findById(id);
         if (jogoOptional.isPresent()) {
         	Jogo jogoExistente = jogoOptional.get();
            	jogoExistente.setName(novoJogo.getName());
         	jogoExistente.setPlataform(novoJogo.getPlataform());          
             return jogoRepository.save(jogoExistente); 
         } else {
             return null; 
         }
     }
}
