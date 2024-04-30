public class Garagem {
    public static void main(String[] args) {
        FilaGenereica<Carro> f = new FilaGenereica<>();
        int i = 2010;
        while(!f.estaCheia()){
            f.enfileira(new Carro(i, "ABC" + i++));
            System.out.println(f);
        }
    }
}
