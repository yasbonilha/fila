public class FilaGenereica <T> { //fila sobre vetor generica
    //podemos colocar o que quisermos dentro do diamante, mas há uma convenção - E para elementos de uma coleção, T para tipos
    private int primeiro;
    private int ultimo;
    private T[] dados;
    private int tamanho; //nao temos como saber se o vetor circular esta cheio ou nao, por isso temos que acrescentar um marcador
    public static final int CAPACIDADE_MINIMA = 10;
    // delcaração de constantes - nao pode ser modificado (variavel final nao pode ser modificada, metodo final nao pode ser sobrescrito e classe final nao pode ser herdada). quando nao parametrizamos um valor, chamamos ele de "numero magico" pq surgiu do nada
    
    @SuppressWarnings("unchecked")
    public FilaGenereica(int capacidade) {
        dados = (T[]) new Object[capacidade]; //nao podemos criar um vetor do tipo generico, pois ele nao sabe o tamanho da memoria que sera necessaria para alocar aqueles elementos. podemos fazer o casting de um vetor de Objects. Ele dá como unsafe operation pois dependendo de como operamos a hierarquia de classes, podemos acabar com algum erro.
        ultimo = dados.length -1;
        primeiro = 0;
        tamanho = 0;

    }

    public FilaGenereica () {
        // dados = new int[CAPACIDADE_MINIMA];
        // ultimo = CAPACIDADE_MINIMA - 1;
        // primeiro = 0;
        
        // podemos otimizar codigo
        this(CAPACIDADE_MINIMA); // estamos chamando o metodo construtor fila e passando como parametro a constante capacidade minima
    }

    public boolean estaCheia(){
        return tamanho == dados.length; //colocamos dados length pois o marcador começa no um e vai acrescentando.
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    int proxima (int pos) { //acesso default da classe - coração da fila circular assim como o coração do quick é o partition e o coração do merge é o ... (nao peguei)
        return (pos + 1) % dados.length;
    }

    public boolean enfileira(T i){
        //enfileiramos quando a fila nao esta cheia, desenfileiramos quando a lista nao esta vazia

        if(estaCheia()) return false;
        ultimo = proxima(ultimo); //atualizamos a posição do ultimo primeiro antes de mandala para o primeiro.
        dados[ultimo] = i;
        tamanho++;
        return true;
    }

    public T desenfileira() {
        T info = null;
        if(!estaVazia()){
        info = dados[primeiro];
        primeiro = proxima(primeiro);
        tamanho--;
        }
        return info;
    }

    @Override
    public String toString(){
        if (estaVazia()) return "fila vazia";

        String s = ""; //string vazia é diferente de string nula

        int i = primeiro;
        do{
            s += dados[i] + "\n";
            i = proxima(i);
        }while (i != proxima(ultimo));
        return s;
    }
}
