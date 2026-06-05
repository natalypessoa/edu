package modelo;

public class Responsavel extends Pessoa {

    // Construtor padrão
    public Responsavel() {
        super();
    }

    // Construtor completo (sem id)
    public Responsavel(String nome, String cpf, int idade) {
        super(nome, cpf, idade);
    }

    // Construtor só com id (para pesquisa)
    public Responsavel(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Responsavel{" + super.toString() + '}';
    }
}
