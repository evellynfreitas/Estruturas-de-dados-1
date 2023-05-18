Exercícios Extras de Lista Encadeada:

1) Para a classe Lista vista em sala de aula, implemente um método de seguinte assinatura:

public int max();

que retorna o maior inteiro contido por um elo da lista encadeada. Caso a lista seja vazia, o método deve retornar 0. Esse método deve percorrer a lista encadeada de
forma iterativa.


2) Implemente um método de mesmo propósito que o método acima, porém usando recursão.


3) Para a classe Lista vista em sala de aula, que implementa uma lista encadeada simples, desenvolva um método que receba como parâmetro um valor inteiro n e divida a lista para o qual o método
foi chamado em duas, de modo que a segunda lista comece no primeiro elo logo após a primeira ocorrência de n na lista original.

Desenho: l1 = 3 -> 17 -> 5 -> 12 -> 1

l1 = 3 -> 17 -> 5  e  l2 = 12 -> 1

Esse método deve obedecer ao seguinte protótipo e deve ter como retorno a segunda lista obtida através dessa separação.

public Lista separa(int n);


4) Para a classe Lista vista em sala de aula, implemente um método estático que recebe duas listas encadeadas l1 e l2, concatena a lista l2 no final da lista l1 e retorna
o resultado, conforme figura abaixo:

l1 = 2 -> 4 -> 1
l2 = 7 -> 10

resultado = 2 -> 4 -> 1 -> 7 -> 10

Esse método deve possuir o seguinte protótipo:

public static Lista concatena(Lista l1, Lista l2);

Observe que l1 e/ou l2 podem ser vazias.


5) Para a classe Lista vista em sala de aula, implemente um método que receba um vetor de inteiros com n elementos e construa uma lista encadeada armazenando os elementos do
vetor nos elos da lista. Assim, se for recebido o vetor v[5] = {1, 9, 6, 8, 5}, o método deve retornar uma nova lista cujo primeiro elo tem o dado 1, o segundo tem o dado 9
e assim por diante. Se o vetor possuir zero elemento, o método deve retornar uma lista vazia.

O protótipo do método é dado por:

public static Lista constroi(int[] v, int n);


6) Refaça as questões anteriores considerando uma Lista Circular Duplamente Encadeada.
