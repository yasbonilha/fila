public class Fila{
    // a remoçao é logica, nao fisica
    // o primeiro que entra é o primeiro que sai - o ponteiro de primeiro nao muda nas inserções, só o ultio. o primeiro so muda na hra de remover (já que é ele que é o vetor removido)
    // o vetor de uma fila é circular - quando a ultima posicao fica cheia, temos que ver se a primeira posição está livre para podermos verificar se o vetor está cheio. da mesma forma que, quando excluimos o primeiro da fila, deixamos o espaço livre
    // para conseguirmos achar o ultimo e colocar como próximo: (num + 1) % tamanho do vetor circular (para todas as posições do vetor)
    // perdemos a lógica do primeiro é menor do que o ultimo, já que o vetor é circular - se usarmos prim != ult, podemos perder uma fila de uma pessoa só

}