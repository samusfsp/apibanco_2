package br.com.projetofinalturmaiv.apibanco.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinalturmaiv.apibanco.model.Conta;
import br.com.projetofinalturmaiv.apibanco.service.IContaService;

@RestController
public class ContaController {
	
	@Autowired
	private IContaService service;

	@GetMapping("/conta")
	public ArrayList<Conta> recuperarTodos() {

		return service.recuperarTodas();
	}
	@GetMapping("/conta/{id}")
	public ResponseEntity<Conta> recuperarPeloId(@PathVariable int id) {
		Conta cnt = service.recuperarPeloId(id);
		if (cnt != null) {
			return ResponseEntity.ok(cnt);
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping("/conta")
	public ResponseEntity<?> cadastrarNova(@RequestBody Conta conta) {
		Conta res = service.cadastrarNova(conta);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}


	
	
	
	
	}
	
		
	
	
	
	
	

