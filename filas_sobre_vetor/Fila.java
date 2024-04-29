package filas_sobre_vetor;

public class Fila {
    private int primeiro;
    private int ultimo;
    private int[] dados;

    public static final int CAPACIDADE_MINIMA = 10;
    // delcaração de constantes - nao pode ser modificado (variavel final nao pode ser modificada, metodo final nao pode ser sobrescrito e classe final nao pode ser herdada). quando nao parametrizamos um valor, chamamos ele de "numero magico" pq surgiu do nada
    
    public Fila(int capacidade) {
        dados = new int[capacidade];
        ultimo = dados.length -1;
        primeiro = ultimo;
    }

    public Fila() {
        // dados = new int[CAPACIDADE_MINIMA];
        // ultimo = CAPACIDADE_MINIMA - 1;
        // primeiro = 0;
        
        // podemos otimizar codigo
        this(CAPACIDADE_MINIMA); // estamos chamando o metodo construtor fila e passando como parametro a constante capacidade minima
    }

    public boolean estaCheia(){
        
    }

    public boolean estaVazia() {

    }

    public boolean enfileira(int i){
        //enfileiramos quando a fila nao esta cheia, desenfileiramos quando a lista nao esta vazia

    }
}
