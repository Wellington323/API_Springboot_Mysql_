package com.api.pessoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.pessoa.usuario.UsuarioModels;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModels, Integer> {

	List<UsuarioModels> findAll();

	UsuarioModels findBycodigo(Integer codigo);

	void delete(UsuarioModels pessoa);

	<ProdMod extends UsuarioModels> ProdMod save(ProdMod pessoa);

}
