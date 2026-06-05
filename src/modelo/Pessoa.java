package modelo;

public class Pessoa {

    private static int contador = 0;

    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private  String email;
    private  int telefone;
    
    // Construtor padrão
    public Pessoa() {
        this.id = ++contador;
    }

    // Construtor completo (sem id)
    public Pessoa(String nome, String cpf, int idade, String email, int telefone) {
        this.id = ++contador;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone; 
    }

    // Construtor só com id (para pesquisa)
    public Pessoa(int id) {
        this.id = id;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
     public String getEmail() {
         return email;
     }
     public void setEmail( String email) {
         this.email= email;
     }
    public int gettelefone() {
        return telefone;
    }
    public void settelefone(int telefone) {
        this.telefone= telefone;
    }

 
    @Override
    public String toString() {
        return "| Id: " + id +
               "| Nome: '" + nome + '\'' +
               "| Cpf: " + cpf + '\'' +
               "| Idade: " + idade + '\'' +
               "| Email: " + email + '\'' +
               "| Telefone: " + telefone ;
    }
}
    
