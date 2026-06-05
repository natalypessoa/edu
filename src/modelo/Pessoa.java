package modelo;

public class Pessoa {

    private static int contador = 0;

    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private  String Email;
    private  int telefone;
    
    // Construtor padrão
    public Pessoa() {
        this.id = ++contador;
    }

    // Construtor completo (sem id)
    public Pessoa(String nome, String cpf, int idade, string Email, int telefone) {
        this.id = ++contador;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.Email= Email;
        this.telefone = telefone 
    }

    // Construtor só com id (para pesquisa)
    public Pessoa(int id) {
        this.id = id;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
     public string getEmail() {
         return Emial;
     }
     public void setEmail() {
         this.Email=Email;
     }
    public int gettelefone() {
        return telefone;
    }
    public void settelefone(int telefone) {
        this.telefone= telefone;
    }

 
    @Override
    public String toString() {
        return "id=" + id +
               ", nome='" + nome + '\'' +
               ", cpf='" + cpf + '\'' +
               ", idade=" + idade + '\'' +
               ", Email=" + Email + '\'' +
               ", telefone=" + telefone ;
    }
}

    
