
package modelo;

public class Crianca {

    private static int contadorId = 0;

    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private String genero;
    private String responsavel;

    // Construtor padrao
    public Crianca() {
        this.id = ++contadorId;
    }

    // Construtor com todos os atributos exceto id
    public Crianca(String nome, String cpf, int idade, String responsavel) {
        this.id = ++contadorId;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.responsavel = responsavel;
    }

    // Construtor apenas com id (para pesquisa)
    public Crianca(int id) {
        this.id = id;
    }

    public int getId()               { return id; }
    public void setId(int id)        { this.id = id; }

    public String getNome()          { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf()           { return cpf; }
    public void setCpf(String cpf)   { this.cpf = cpf; }


    public int getIdade()            { return idade; }
    public void setIdade(int idade)  { this.idade = idade; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    
    public String getResponsavel()               { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    @Override
    public String toString() {
        return "|ID: " + id
             + " | Nome: " + nome
             + " | CPF: " + cpf
             + " | Idade: " + idade
             + " | Genero: " + genero
             + " | Responsavel: " + responsavel;
    }
}  
