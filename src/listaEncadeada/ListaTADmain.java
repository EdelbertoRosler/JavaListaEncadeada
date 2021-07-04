package listaEncadeada;
/**
 * Estrutura de dados sequenciais dinâmicas - lista encadeada
 * Baseado na aula do prof. Felipe Sampaio - IFRS
 * @author edelberto Hermann Rösler
 */
public class ListaTADmain {

    public static void main(String[] args) {
        ListaTAD lista = new ListaTAD();
        lista.insereFinal(10);
        lista.insereFinal(20);
        lista.insereFinal(20);
        lista.insereFinal(20);
        lista.insereFinal(30);
        lista.insereFinal(8);
        lista.insereFinal(40);lista.imprime();//insereFinal, imprime
        lista.insereInicio(125);//insereInicio
        lista.insereInicio(118);lista.imprime();
        lista.imprimeReverso();//imprimeReverso
        lista.insere(4, 99);lista.imprime();//insere
        lista.removeFinal();lista.imprime();  //removeFinal
        lista.removeInicio();lista.imprime();//removeInicio
        lista.remove(2);lista.imprime();//remove
        System.out.println(lista.acessa(4));//acessa
        System.out.println(lista.tamanho());//tamanho
        System.out.println(lista.toString());//toString
        System.out.println(lista.ehVazia());//ehVazia
        System.out.println(lista.pesquisa(125));//pesquisa
        lista.altera(3, 777);lista.imprime();//altera
        System.out.println(lista.tamanho());
        lista.imprimeReversoLinha();lista.imprime();
        lista.removeValor(125);lista.imprime();
        System.out.println(lista.tamanho());
        lista.limpa();lista.imprime();//limpa
        System.out.println(lista.tamanho());
    }

}
