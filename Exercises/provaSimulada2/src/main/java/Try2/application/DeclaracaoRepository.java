package Try2.application;

import Try2.domain.Declaracao;
import Try2.domain.EntityAlreadyExists;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface DeclaracaoRepository {
     void salvar(Declaracao declaracao);


     void atualizar(Declaracao declaracao);

     void remover(Declaracao declaracao);

     void remover(long id);

     Optional<Declaracao> buscarPorId(long id);
}
