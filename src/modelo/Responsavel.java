package modelo;

public class Responsavel extends Pessoa {
private String telefone;
    public Responsavel(String nome, String cpf, int idade,String gmail,String telefone) {
        super(nome, cpf, idade,gmail);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {return  "RESPONSAVEL: "+super.toString()+" telefone:" + telefone;
    }
}

