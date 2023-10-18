package services;

import java.util.List;
import java.util.Objects;

import domain.ContatoVO;
import repositories.IContatoRepository;

public class ContatoService implements IContadoService {

    private final IContatoRepository repository;

    public ContatoService(IContatoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(ContatoVO contato) {
        // Validar objeto conforme a entidade contatos
        if (Objects.isNull(contato.getNome()) || contato.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório!");
        }

        if (Objects.isNull(contato.getEmail()) || contato.getEmail().isEmpty()) {
            throw new RuntimeException("É-mail é obrigatório!");
        }

        repository.salvar(contato);
    }

    @Override
    public void alterar(ContatoVO contato) {
        // TODO: Validar objeto conforme a entidade contatos
        // TODO: Consultar e recuperar contato
        // TODO: Alterar contato
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        // TODO: Validar e-mail
        // TODO: Localizar contato e retornar contato
        return null;
    }

    @Override
    public void excluir(Integer id) {
        // TODO: Validar id
        // TODO: Localizar contato e excluir contato
    }

    @Override
    public List<ContatoVO> buscarTodos() {
        // TODO: Consultar e retornar todos os contatos cadastrados
        return repository.buscarTodos();
    }

}
