# Desafio Stone

Esta é minha implementação para o desafio Stone.
A linguagem de programação selecionada para a realização do desafio foi Java.
A aplicação está preparada para receber novos objetos do tipo Item e Email, que atendem ao requisito da entrada de dados.

Para alimentar as Listas, novos itens devem ser adicionados as suas respectivas listas.
No caso de Itens, a lista (itemList) é alimentada da seguinte forma (Linha 16 do código arquivo fonte DesafioStone.java):
```
itemList.add(new Item(description, quantity, unitaryValue));
```
onde:
    * description é a descrição do item (String)
    * quantity é a quantidade (Inteiro)
    * unitary é o valor unitário (Inteiro) - onde o centavo representa 1 (seguindo a recomendação do enunciado)

No caso de Emails, a lista (emailList) é alimentada da seguinte forma (Linha 26 do código arquivo fonte DesafioStone.java):
```
 emailList.add(new (Email(mailAddress));
```
onde:
    * mailAddress é o endereço de email da pessoa (String)

No código fonte estão 3 Itens, e 3 Emails.

Na linha 34, o último parâmetro para o método calculate, é chamado de showDetails. Como padrão, ele está setado para true, e desta forma, os detalhes do cálculo são exibidos no console. 
```
        Map<String, Integer> results = calculate(itemList,emailList, true);
```
Para exibir somente o resultado final, este parâmetros pode ser setado para false
```
        Map<String, Integer> results = calculate(itemList,emailList, false);
```

Executando a aplicação:

Abrir um console, selecionar a pasta onde o arquivos arquivos foram saldos.
Executar os seguintes comandos (Java deve estar instalado, e o path deve estar configurado no windows).

```
javac DesafioStone.java
java DesafioStone

```

Com os dados iniciais carregados nos vetores de Itens e de Emails, e com a flag que exibe os detalhes de Log no console ativos (showDetailsLog), o resultado é o seguinte:

```
Aplicacao Iniciada
---------------------------------------------- Itens da Lista --------------------------------------------------------
Produto: Produto 1  | Quantidade: 20  | Unitario: R$ 16,00  | Subtotal: R$ 320,00
Produto: Produto 2  | Quantidade: 7  | Unitario: R$ 3,00  | Subtotal: R$ 21,00
Produto: Produto 3  | Quantidade: 1  | Unitario: R$ 1,00  | Subtotal: R$ 1,00
Valor Total da Lista => R$ 342,00
---------------------------- Rateio dos valores --------------------------------------
z_user1@provider  |  Valor do Rateio: R$ 114,00
a_user2@provider  |  Valor do Rateio: R$ 114,00
user3@provider  |  Valor do Rateio: R$ 114,00
{user3@provider=11400, z_user1@provider=11400, a_user2@provider=11400}
Aplicacao Finalizada
```
Setando a variável showDetailsLog para false, o resultado apresentado é o seguinte:
```
Aplicacao Iniciada
{user3@provider=11400, z_user1@provider=11400, a_user2@provider=11400}
Aplicacao Finalizada
```

As classes Email, Item, e uma classe criada para reutilização de métodos para manipulação de variáveis estão inclusos no arquivo DesafioStone.java