package modelo;

public class CriancaMatriculada extends Crianca{
    private String curso;
    private String turma;
    private String turno;
    
    public CriancaMatriculada() {
        super();
    }
    
    public CriancaMatriculada(String nome, String cpf, String turma,
                               int idade, String responsavel, String curso, String turno) {
        super(nome, cpf, idade, responsavel);
        this.curso = curso;
        this.turma = turma;
        this.turno = turno;
    }

    public CriancaMatriculada(int id) {
        super(id);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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
    
    @Override
    public String toString() {
        return super.toString() + " | Curso: " + curso
                + "| Turma: "+ turma
                + "| Turno:"+ turno;
    }
}
    
