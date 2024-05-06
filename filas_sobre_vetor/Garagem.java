public class Garagem {
    public static void main(String[] args) {
        FilaGenereica<Carro> f = new FilaGenereica<>();
        int i = 2010;
        while(!f.estaCheia()){
            f.enfileira(new Carro(i, "ABC" + i++)); //primeiro o i é atribuido à placa e depois ele é incrementado
            System.out.println(f);
        }
        while (!f.estaVazia()){
            System.out.println(f.desenfileira() + " foi embora\n");
            System.out.println(f);
        }
    }
}
