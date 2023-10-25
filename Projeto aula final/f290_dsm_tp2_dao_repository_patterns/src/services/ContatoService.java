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
        ContatoVO contatoVo1 = new ContatoVO();
        // TODO: Validar objeto conforme a entidade contatos
       if (Objects.isNull(contato.getId())) {
            throw new RuntimeException("Contato não encontrado!");
        }else{                                                           //TODO Consultar e recuperar contato              
             contatoVo1 = repository.buscarPorEmail(contato.getEmail()); // tentei puxar do DAO da pasta factories e salvar na variavel

            if(Objects.isNull(contatoVo1)){
                    throw new RuntimeException("Contato não encontrado!");
            }else{
                repository.atualizar(contatoVo1);    // TODO: Alterar contato

            }


        }


        
       
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        // TODO: Validar e-mail
         ContatoVO contatoVo2 = new ContatoVO();
            if (Objects.isNull(email) || email.isEmpty()) {
                 throw new RuntimeException("Email não encontrado!");
        }else{                                              // TODO: Localizar contato e retornar contato

             contatoVo2 = repository.buscarPorEmail(email);
        }


        

        return contatoVo2;
    }

    @Override
    public void excluir(Integer id) {
        // TODO: Validar id
        ContatoVO contatoVo3 = new ContatoVO();
         if (Objects.isNull(id)) {
                 throw new RuntimeException("contato não encontrado!");

        // TODO: Localizar contato e excluir contato
    }else{

        repository.excluir(id);
    }
    }

    @Override
    public List<ContatoVO> buscarTodos() {
        // TODO: Consultar e retornar todos os contatos cadastrados
        return repository.buscarTodos();
    }

}
