package com.api.pessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.pessoa.repository.UsuarioRepository;
import com.api.pessoa.usuario.RespostaModels;
import com.api.pessoa.usuario.UsuarioModels; 

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
	public @ResponseBody List<UsuarioModels> Listar() {
		return usuarioRepository.findAll();
	}

	@RequestMapping(value = "/pessoa/{codigo}", method = RequestMethod.GET)
	public @ResponseBody UsuarioModels filtrar(@PathVariable Integer codigo) {
		return usuarioRepository.findBycodigo(codigo);
	}

	@RequestMapping(value = "/pessoa", method = RequestMethod.POST)
	public @ResponseBody UsuarioModels Cadastrar(@RequestBody UsuarioModels pessoa) {
		return usuarioRepository.save(pessoa);
	}

	@RequestMapping(value = "/pessoa", method = RequestMethod.PUT)
	public @ResponseBody UsuarioModels Atualizar(@RequestBody UsuarioModels pessoa) {
		return usuarioRepository.save(pessoa);
	}

	@RequestMapping(value = "/pessoa/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModels Remover(@PathVariable Integer codigo) {

		RespostaModels resposta = new RespostaModels();

		try { 
			UsuarioModels pessoa = filtrar(codigo);
			this.usuarioRepository.delete(pessoa);
			resposta.setMensagem("Pessoa removida com sucesso.");
		} catch (Exception erro) {
			resposta.setMensagem("Falha ao remover:" + erro.getMessage());
		}
		  return resposta;
	}

}
