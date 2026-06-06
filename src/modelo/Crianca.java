
package modelo;
public class Crianca extends Pessoa {
 
    
    private static int contador = 0;
    private int matricula;
    private String turma;
    private String turno;
    private String curso;
    private Responsavel responsavel;
    

    public Crianca(String nome, String cpf, int idade,String gmail,String turma, String turno, String curso,Responsavel responsavel) {
        super(nome, cpf, idade,gmail);
        this.matricula = ++contador;
        this.turma = turma;
        this.turno = turno;
        this.curso = curso;
        this.responsavel= responsavel;

    }
    
    

    public int getMatricula() {
        return matricula;
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
     public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

  
    
    @Override
    public String toString() {return "ALUNO: "+super.toString()+ " Turma: " + turma+ " Turno: " + turno+ " Curso: " + curso+" Matricula: "+matricula; }
}

