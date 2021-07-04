package listaEncadeada;

/**
 * Estrutura de dados sequenciais dinâmicas - lista encadeada
 * Baseado na aula do prof. Felipe Sampaio - IFRS
 * @author edelberto Hermann Rösler
 */
public class ListaTAD {
    private Nodo inicio, fim;
    private int num;


    public ListaTAD() {
        this.inicio = null;
        this.fim = null;
        this.num = 0;
    }

    public int tamanho(){
        return num;
    }//retorna a quantidade de elementos que a lista tem

    public boolean ehVazia() {
        return this.inicio == null;
    }//verifica se a lista está vazia

    public void imprime() {
        Nodo aux = this.inicio;

        while(aux != null) {
            System.out.print(aux.elem + " ");
            aux = aux.prox;
        }
        System.out.println("");
    }//imprime a lista com os elementos um ao lado do outro

    public void imprimeReverso() {
        Nodo aux = this.fim;

        while(aux != null) {
            System.out.print(aux.elem + " ");
            aux = aux.ant;
        }
        System.out.println("");
    }//percorre a lista no reverso e imprime os elementos um ao lado do outro

    public void imprimeReversoLinha(){
        Nodo aux = this.fim;
        while(aux != null){
            System.out.println(aux.elem);
            aux = aux.ant;
        }
    }//percorre a lista no reverso e imprime os elemento um em cada linha

    @Override
    public String toString() {
        Nodo aux = this.inicio;
        String result = "";
        for (int i = 0; i < num; i ++){
            result += aux.elem + " ";
            aux = aux.prox;
        }
        return (result);
    }//Converte a lista para String

    public int acessa(int pos){
        Nodo aux = this.inicio;
        if (true == ehVazia()){
            System.out.println("Lista vazia, esta posição é inválida: ");
        }
        else{
            for (int i = 0 ; i < pos; i++){
                aux = aux.prox;
            }
            return aux.elem;
        }
        return pos;
    }//acessa o elemento da lista de uma determinada posição (passada no parâmetro)

    public void insereFinal(int valor) {
        Nodo novo = new Nodo();  //cria um nodo na memória
        novo.elem = valor;

        if(this.ehVazia()) {
            novo.ant = null;
            novo.prox = null;
            this.inicio = novo;
            this.fim = novo;
        }
        else {
            novo.prox = null;
            novo.ant = this.fim;
            this.fim.prox = novo;
            this.fim = novo;
        }
        this.num += 1;
    }//insere um novo elemento no final da lista

    public void insereInicio(int valor){
        Nodo novo = new Nodo();  //cria um nodo na memória
        novo.elem = valor;

        if(this.ehVazia()) {
            novo.ant = null;
            novo.prox = null;
            this.inicio = novo;
            this.fim = novo;
        }
        else{
            novo.ant = null;
            novo.prox = this.inicio;
            this.inicio.ant = novo;
            this.inicio = novo;
        }
        this.num += 1;
    }//inssere um novo elemento no início da lista

    public void insere(int pos, int valor){
        Nodo novo = new Nodo();  //cria um nodo na memória
        novo.elem = valor;

        if(this.ehVazia()) {//verifica se a lista está vazia
            novo.ant = null;
            novo.prox = null;
            this.inicio = novo;
            this.fim = novo;
        }
        else if (pos == 0){//se desejar inserir na posição 0, chama a função insereInicio
            this.insereInicio(valor);
        }
        else if (pos == num-1){//se ele desejar inserir na última posição, chama a função insereFinal
            this.insereFinal(valor);
        }
        else{
            Nodo aux = this.inicio;//criar o aux
            for(int i = 0; i < pos; i ++){//percorrer até o elemento
                aux = aux.prox;
            }
            //System.out.println(aux.ant.elem); //verificar se é o elemento correto
            novo.ant = aux.ant;
            novo.prox = aux;
            //System.out.println(novo.prox.elem);//testa o elemento
            aux.ant.prox = novo;
            aux.ant = novo;

            this.num += 1;
        }
    }//insere um novo elemento passando a posição e o valor por parâmetros

    public void removeFinal() {
        if (false == ehVazia()){//verifica se a lista está vazia
            if (this.num == 1) {
                this.inicio = null;
                this.fim = null;
            }
            else {
                this.fim = this.fim.ant;
                this.fim.prox = null;
            }
            this.num -= 1;
        }
        else{
            System.out.println("A lista está vazia!");
        }
    }//remove o último elemento da lista

    public void removeInicio() {
        if (false == ehVazia()){//verifica se a lista está vazia
            if (this.num == 1) {
                this.inicio = null;
                this.fim = null;
            }
            else {
                this.inicio = this.inicio.prox;
                this.inicio.ant = null;
            }
            this.num -= 1;
        }
        else{
            System.out.println("A lista está vazia!");
        }
    }//remove o primeiro elemento da lista

    public void remove(int pos) {
        if (false == ehVazia()){//verifica se a lista está vazia
            if (pos == 0) {
                removeInicio();
            }
            else if (pos == num - 1){
                removeFinal();
            }
            else{
                Nodo aux = this.inicio;//criar o aux
                for(int i = 0; i < pos; i ++){//percorrer até o elemento
                    aux = aux.prox;
                }
                //System.out.println(aux.elem);
                aux = aux.ant;
                aux.prox = aux.prox.prox;
                this.num -= 1;
            }
        }
        else{
            System.out.println("A lista está vazia!");
        }
    }//remove o elemento de uma determinada posição passada por parâmetro

    public void removeValor(int valor){
        if (false == ehVazia()){//verifica se a lista está vazia
            if (this.num == 1) {
                this.inicio = null;
                this.fim = null;
            }
            else {
                if (pesquisa(valor) == true){//com a função pesquisa, verifica se o valor existe na lista
                    int pos = 0;
                    Nodo aux = this.inicio;//criar o aux
                    while (aux.elem != valor){//percorrer até o elemento
                        aux = aux.prox;
                        pos += 1;
                    }
                    remove(pos);
                }
                else {
                    System.out.println("Valor inexistente na lista!");
                }
            }
        }
    }//remove o elemento de um valor especificado por parâmetro

    public boolean pesquisa(int valor) {
        Nodo aux = this.inicio;
        for (int i = 0 ; i < num; i++){
            if(valor == aux.elem){
                return true;
            }
            aux = aux.prox;
        }
        return false;
    }//pesquisa se um determinado valor existe na lista - retorna Boolean

    public void altera(int pos, int valor) {
        Nodo aux = this.inicio;//criar o aux
        if (pos >= 0 && pos < num){
            for(int i = 0; i < pos; i ++){//percorrer até o elemento
                aux = aux.prox;
            }
            aux.elem = valor;
        }
        else{
            System.out.println("Posiçao inexistente!");
        }
    }//altera o valor de uma determinada posição passado por parâmetro

    public void limpa() {
        Nodo aux = this.inicio;//criar o aux
        int cont = num;
        for(int i = 0; i < cont; i ++){
            this.inicio = aux.prox;
            aux.ant = null;
            aux = aux.prox;
            this.num -= 1;
        }
    }

}//limpa a lista



