package br.com.api.viacep.repository;

import br.com.api.viacep.dto.EnderecoDto;
import br.com.api.viacep.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<EnderecoDto> findAllBy();
}
