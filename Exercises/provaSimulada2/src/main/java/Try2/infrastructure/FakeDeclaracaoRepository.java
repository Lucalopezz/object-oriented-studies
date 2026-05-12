package Try2.infrastructure;

import Try2.application.DeclaracaoRepository;
import Try2.domain.Declaracao;
import Try2.domain.EntityAlreadyExists;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class FakeDeclaracaoRepository implements DeclaracaoRepository {
    private static final Map<Long, Declaracao> db = new LinkedHashMap<>();

    @Override
    public void salvar(Declaracao declaracao) {
        long id = declaracao.getId();

        if (db.containsKey(id))
            throw new EntityAlreadyExists("Já existe uma declaração com o id " + id);
        db.put(id, declaracao);
    }

    @Override
    public void atualizar(Declaracao declaracao) {
        long id = declaracao.getId();

        if (!db.containsKey(id))
            throw new NoSuchElementException("Não existe uma declaração com o id " + id);
        db.put(declaracao.getId(), declaracao);
    }

    @Override
    public void remover(Declaracao declaracao) {
        long id = declaracao.getId();

        if (!db.containsKey(id))
            throw new NoSuchElementException("Não existe uma declaração com o id " + id);
        db.remove(id);
    }

    @Override
    public void remover(long id) {
        remover(id);
    }

    @Override
    public Optional<Declaracao> buscarPorId(long id) {
        return Optional.ofNullable(db.get(id));
    }


}
