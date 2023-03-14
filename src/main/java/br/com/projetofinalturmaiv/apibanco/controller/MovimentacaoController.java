package br.com.projetofinalturmaiv.apibanco.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinalturmaiv.apibanco.model.Movimentacao;
import br.com.projetofinalturmaiv.apibanco.service.IMovimentacaoService;

@RestController
public class MovimentacaoController {

	@Autowired
	private IMovimentacaoService service;
	
	@GetMapping("/movimentacao")
	public ArrayList<Movimentacao> recuperarTodas() {

		return service.recuperarTodas();
	}
	
	@PostMapping("/movimentacao")
	public ResponseEntity<?> cadastrarNova(@RequestBody Movimentacao novo) {
		Movimentacao res = service.cadastrarNova(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
}