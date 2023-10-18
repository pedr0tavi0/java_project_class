import java.sql.Connection;

import dao.factories.ConexaoFactory;
import dao.factories.ContatoMySqlDAO;
import dao.factories.IContatoDAO;
import domain.ContatoVO;
import repositories.ContatoMySqlRepository;
import repositories.IContatoRepository;
import services.ContatoService;
import services.IContadoService;

public class App {
    public static void main(String[] args) throws Exception {

        /*
         * Este conjunto de instruções inicializaram as dependencias 
         * para o uso do serviço de contatos utilizando o repositório
         * com o SGBD MySQL.
         */
        Connection conexao = ConexaoFactory.getConexao();
        IContatoDAO dao = new ContatoMySqlDAO(conexao);
        IContatoRepository repository = new ContatoMySqlRepository(dao);

        IContadoService service = new ContatoService(repository);

        // Criar objeto ContatoVO e realizar chamada do metodo salvar do service
        ContatoVO c1 = new ContatoVO(
                null,
                "João Pedro Ferreira",
                "jpferreira@gmail.com",
                "19999997878",
                "jpferreira_li");

        // Chamada do metodo de persistencia
        // TODO: Descomente o trecho abaixo para persisitir em baco de dados e consulte o banco de dados
        //service.salvar(c1);

        //TODO: Criar mais 2 contatos.

        //TODO: Exibir os contatos cadastrados

        // TODO: Remover o primeiro contatto criado.

        // TODO: Buscar e exibir o segundo contato criado com base no e-mail

        // TODO: Exibir os contatos cadastrados

        // TODO: Altere o repositório MySQL pelo repositório em memória


    }
}
