package modelo;

public abstract class Pessoa {

    private String gmail;
    private String nome;
    private String cpf;
    private int idade;
   
    
    // Construtor padrão
    public Pessoa(String nome, String cpf, int idade,String gmail) {
    this.nome = nome;
    this.gmail = gmail;
    this.cpf = cpf;
    this.idade = idade;
    }
    
    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
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

 
    
@Override
    public String toString() {return nome + " CPF: " + cpf +" IDADE: " + idade+" GMAIL: "+gmail;}
}

    

    
