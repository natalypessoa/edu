package estruturaArray;

import modelo.*;

public class Array {

    // Crianças
    private Crianca[] criancas = new Crianca[10];
    private int contCriancas = 0;

    // Responsáveis
    private Responsavel[] responsaveis = new Responsavel[10];
    private int contResponsaveis = 0;

    // ==================== CRIANÇAS ====================

    public void inserirCrianca(Crianca crianca) {
        if (contCriancas == criancas.length) {
            criancas = novoArrayCriancas();
        }
        criancas[contCriancas++] = crianca;
    }

    private Crianca[] novoArrayCriancas() {
        Crianca[] novo = new Crianca[criancas.length + (criancas.length/2)];
        System.arraycopy(criancas, 0, novo, 0, criancas.length);
        return novo;
    }

    public void exibirCriancas() {
        if (contCriancas == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (int i = 0; i < contCriancas; i++) {
            System.out.println(criancas[i]);
        }
    }
    
    public boolean atualizarAluno(int matricula,String nome, String cpf, int idade,String gmail,String turma, String turno, String curso) {
    for (int i = 0; i < contCriancas; i++) {
        if (criancas[i].getMatricula() == matricula) {
            criancas[i].setNome(nome);
            criancas[i].setCpf(cpf);
            criancas[i].setIdade(idade);            
            criancas[i].setGmail(gmail);
            criancas[i].setTurma(turma);
            criancas[i].setTurno(turno);
            criancas[i].setCurso(curso);
           
            return true;
        }
    }
    
    
    return false;
}
    
    public boolean excluirAluno(int matriculaAluno) {

    for (int i = 0; i < contCriancas; i++) {

        if (criancas[i].getMatricula() == matriculaAluno) {

            Responsavel resp = criancas[i].getResponsavel();

            // Remove o responsável do array de responsáveis
            if (resp != null) {

                for (int j = 0; j < contResponsaveis; j++) {

                    if (responsaveis[j] == resp) {

                        for (int k = j; k < contResponsaveis - 1; k++) {
                            responsaveis[k] = responsaveis[k + 1];
                        }

                        responsaveis[contResponsaveis - 1] = null;
                        contResponsaveis--;
                        break;
                    }
                }
            }

            // Remove o aluno do array de crianças
            for (int j = i; j < contCriancas - 1; j++) {
                criancas[j] = criancas[j + 1];
            }

            criancas[contCriancas - 1] = null;
            contCriancas--;

            return true;
        }
    }

    return false;
}

    // ==================== RESPONSÁVEIS ====================

    public void inserirResponsavel(Responsavel responsavel) {
        if (contResponsaveis == responsaveis.length) {
            responsaveis = novoArrayResponsaveis();
        }
        responsaveis[contResponsaveis++] = responsavel;
    }

    private Responsavel[] novoArrayResponsaveis() {
        Responsavel[] novo = new Responsavel[responsaveis.length + (responsaveis.length/2)];
        System.arraycopy(responsaveis, 0, novo, 0, responsaveis.length);
        return novo;
    }

    public void exibirResponsaveis() {
        for (int i = 0; i < contResponsaveis; i++) {
            System.out.println(responsaveis[i]);
        }
    }
    
    public void exibirResponsaveisPorAluno() {
        if (contCriancas == 0) {
            System.out.println("Nenhum aluno cadastrado até o momento.");
            return;
        }
        
        for (int i = 0; i < contCriancas; i++) {
            System.out.println(" " + criancas[i]);
            if (criancas[i].getResponsavel() != null) {
                System.out.println(" " + criancas[i].getResponsavel());
            } else {
                System.out.println("Responsável: Não vinculado.");
            }
            System.out.println("------------------------------------------------------------------------------");
        }
    }
    
public boolean atualizarResponsavel(int matriculaAluno, String nome, String cpf,
                                    int idade, String gmail, String telefone) {

    for (int i = 0; i < contCriancas; i++) {

        if (criancas[i].getMatricula() == matriculaAluno) {

            Responsavel resp = criancas[i].getResponsavel();

            if (resp == null) {return false;}

            resp.setNome(nome);
            resp.setCpf(cpf);
            resp.setIdade(idade);
            resp.setGmail(gmail);
            resp.setTelefone(telefone);

            return true;
        }
    }

    return false;
}
    
    // ==================== MÉTODOS DE BUSCA (CASE 4) ====================



    public void buscarAlunoPorCpf(String cpfBusca) {
        for (int i = 0; i < contCriancas; i++) {
            if (criancas[i].getCpf().equals(cpfBusca)) {
                System.out.println("\n[Aluno Encontrado!]");
                System.out.println("Dados: " + criancas[i]);
                
                if (criancas[i].getResponsavel() != null) {
                    System.out.println("Responsável: " + criancas[i].getResponsavel());
                }
               
                return; // Para o método imediatamente ao encontrar
            }
        }
        // Se o for terminar e não der o return, significa que não achou:
        System.out.println("Aluno com o CPF " + cpfBusca + " não foi encontrado.");
    }
        public void buscarAlunoPorid(int MatriculaBusca) {
        for (int i = 0; i < contCriancas; i++) {
            if (criancas[i].getMatricula() == MatriculaBusca){
                System.out.println("\n[Aluno Encontrado!]");
                System.out.println("Dados: " + criancas[i]);
                
                if (criancas[i].getResponsavel() != null) {
                    System.out.println( criancas[i].getResponsavel());
                }
               
                return; // Para o método imediatamente ao encontrar
            }
        }
        // Se o for terminar e não der o return, significa que não achou:
        System.out.println("Aluno com a Matricula " + MatriculaBusca + " não foi encontrado.");
    }
}
