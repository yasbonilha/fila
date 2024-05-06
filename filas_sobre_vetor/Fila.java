public class Fila {
    private int primeiro;
    private int ultimo;
    private int[] dados;
    private int tamanho; //nao temos como saber se o vetor circular esta cheio ou nao, por isso temos que acrescentar um marcador
    public static final int CAPACIDADE_MINIMA = 10;
    // delcaração de constantes - nao pode ser modificado (variavel final nao pode ser modificada, metodo final nao pode ser sobrescrito e classe final nao pode ser herdada). quando nao parametrizamos um valor, chamamos ele de "numero magico" pq surgiu do nada
    
    public Fila(int capacidade) {
        dados = new int[capacidade];
        ultimo = dados.length -1;
        primeiro = 0;
        tamanho = 0;

    }

    public Fila() {
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

    public boolean enfileira(int i){
        //enfileiramos quando a fila nao esta cheia, desenfileiramos quando a lista nao esta vazia

        if(estaCheia()) return false;
        ultimo = proxima(ultimo); //atualizamos a posição do ultimo primeiro antes de mandala para o primeiro.
        dados[ultimo] = i;
        tamanho++;
        return true;
    }

    public int desenfileira() {
        if(estaVazia()) return -1;
        int temp = dados [primeiro];
        primeiro = proxima(primeiro);
        tamanho--;
        return temp;
    }

    @Override
    public String toString(){ //nao podemos fazer um for com !proxima(ultimo) porque vai dar erro no caso de o ultimo acabar encostando com o primeiro - ele nao vi printar nada
        if (estaVazia()) return "fila vazia";

        String s = ""; //string vazia é diferente de string nula

        int i = primeiro;
        do{
            s += dados[i] + " "; //essa linha é de processamento - aqui estamos abstraindo ao varrermos a nossa estrutura - podemos ver que essa é uma dica de como nós percorremos a nossa estrutura
            i = proxima(i);
        }while (i != proxima(ultimo));
        return s;
    }

    public String stringDoVetor() { //esta falando sobre o vetor, nao sobre a fila. logo, pode haver lixo no vetor que nao é mostrado na fila devido as exclusoes sla
        if (estaVazia()) return ("_ _ _ _ _ _ _ _ _ _"); //estamos no prórpio modelo. os métodos de uma classe estão se referindo aos atributos da propria classe. na prática, estamos deixando o this. implícito, mas ele poderia ser explícito. mas geralmente usamos o this só quando há ambiguidade
        String s = "";
        
        int i =0;
        if( primeiro <= ultimo) {
            for (i = 0; i < primeiro; i ++){
                s += "_ ";
            }
            for (i = primeiro; i <=ultimo; i++){
                s += dados[i] + " ";
            }
            for (i=ultimo + 1; i <dados.length; i++){
                s+= "_ ";
            }

        } else {
            for (i=0; i <=ultimo; i++){
                s += dados[i] + " ";
            }
            for( i= ultimo + 1; i<primeiro; i++){
                s += "_ ";
            }
            for (i = primeiro; i <dados.length; i++){
                s+= dados[i] + " ";
            }
        }
        return s;
    }
}
