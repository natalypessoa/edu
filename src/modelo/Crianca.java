
package modelo;
 
public class Crianca extends Pessoa {
 
    private String turma;
    private String turno;
    private String curso;
    
 
    public Crianca() {
        super();
    }

    public Crianca(String nome, String cpf, int idade,
                   String turma, String turno, String curso) {
        super(nome, cpf, idade);
        this.turma = turma;
        this.turno = turno;
        this.curso = curso;

    }
 
    public Crianca(int id) {
        super(id);
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + " | Turma: " + turma
                + " | Turno: " + turno
                + "| Curso: " + curso;
    }
}
