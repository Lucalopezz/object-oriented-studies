# Prova Simulada 2 - Try1

Implementacao em Java do sistema de simulacao de IRPF solicitado no enunciado.

## O que foi implementado

- Template Method em `DeclaracaoIR` com variacoes em `DeclaracaoSimplificada` e `DeclaracaoCompleta`.
- Entidades com encapsulamento, `toString()`, `equals()` e `hashCode()`.
- Composicao `Contribuinte` -> `List<DespesaDedutivel>` com metodos de adicao/remocao.
- Persistencia em memoria com `Map` usando `GenericDAO<K, T extends Entidade<K>>`.
- Interface de console com operacoes de cadastrar, editar, remover, listar e simular imposto.
- Tratamento de erros com excecoes da linguagem e excecao customizada (`RegraNegocioException`).
- Testes unitarios com JUnit 5.

## Executar testes

```bash
mvn test
```

## Rodar aplicacao

```bash
mvn -q exec:java -Dexec.mainClass=Try1.Main
```

Se o plugin `exec` nao estiver configurado, rode via classes compiladas:

```bash
mvn -q package
java -cp target/classes Try1.Main
```

