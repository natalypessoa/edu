package principal;
import estruturaArray.*;
import java.util.Scanner;
import modelo.*;
public class Cadastro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        Array bancoDados = new Array();
        
        // Dados de teste iniciais
        Responsavel respTeste = new Responsavel("Jane Cristina da Silva", "321.321.234-12",19,"jan@gmail.com","1112345");
        bancoDados.inserirResponsavel(respTeste);            
        Crianca criancaTeste = new Crianca("Pedro","123.123.123-12",12,"pedr@gmail.com","3B", "Manha","Ciencias",respTeste);
        bancoDados.inserirCrianca(criancaTeste); 
                   
        while (true) {
            System.out.println("==============================================================================");
            System.out.println("                                ----- SISTEMA -----");
            System.out.println("1) Cadastrar");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("2) ver responsaveis por aluno");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("3) ver alunos");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("4) atualizar");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("5) procurar aluno");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("6) excluir");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("0) sair");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("  Escolha: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 0:
                    System.out.println("Encerrando sistema...");
                    scanner.close();
                    return;

                case 1:
                    System.out.println("==============================================================================");
                    
                    // --- DADOS DO RESPONSÁVEL ---
                    String nome1responsavel = lerNome(scanner, "Primeiro nome do responsável: ");
                    String nome2responsavel = lerNome(scanner, "Segundo nome do responsável: ");
                    String nome3responsavel = lerNome(scanner, "Terceiro nome do responsável: ");
                    String nomeresponsavel = montarnome(nome1responsavel, nome2responsavel, nome3responsavel);

                    int idaderesponsavel;
                    do {
                        System.out.print("Idade do responsável: ");
                        idaderesponsavel = scanner.nextInt();
                        scanner.nextLine(); // Limpa buffer

                        if (idaderesponsavel < 18) {
                            System.out.println("Responsável deve ter 18 anos ou mais.");
                        }
                    } while (idaderesponsavel < 18);

                    System.out.println("------------------------------------------------------------------------------");

                    System.out.print("Digite o CPF do responsável:");
                    String cpf1responsavel = lerCpf(scanner, 3, "3 primeiros dígitos: ");
                    String cpf2responsavel = lerCpf(scanner, 3, "3 dígitos do meio: ");
                    String cpf3responsavel = lerCpf(scanner, 3, "3 dígitos finais: ");
                    String cpf4responsavel = lerCpf(scanner, 2, "2 últimos dígitos: ");
                    String cpfresponsavel = montarCpf(cpf1responsavel, cpf2responsavel, cpf3responsavel, cpf4responsavel);
                    
                    System.out.println("------------------------------------------------------------------------------");

                    System.out.print("Digite o gmail:");
                    String gmail;
                    gmail= scanner.next();
                    
                    System.out.println("------------------------------------------------------------------------------");
                    
                   System.out.print("Digite o telefone:");
                   String telefone;
                   telefone = scanner.next();
                   scanner.nextLine();
                  
                   
                    System.out.println("==============================================================================");
                    
                    // --- DADOS DA CRIANÇA ---
                    String nome1crianca = lerNome(scanner, "Primeiro nome da criança: ");
                    String nome2crianca = lerNome(scanner, "Segundo nome da criança: ");
                    String nome3crianca = lerNome(scanner, "Terceiro nome da criança: ");
                    String nomecrianca = montarnome(nome1crianca, nome2crianca, nome3crianca);

                    int idadecrianca;
                    do {
                        System.out.print("Idade da criança: ");
                        idadecrianca = scanner.nextInt();
                        scanner.nextLine(); // Limpa buffer

                        if (idadecrianca < 0 || idadecrianca > 17) {
                            System.out.println("Idade inválida! Digite entre 0 e 17.");
                        }
                    } while (idadecrianca < 0 || idadecrianca > 17);

                    System.out.print("Digite o CPF da criança:");
                    String cpf1crianca = lerCpf(scanner, 3, "3 primeiros dígitos: ");
                    String cpf2crianca = lerCpf(scanner, 3, "3 dígitos do meio: ");
                    String cpf3crianca = lerCpf(scanner, 3, "3 dígitos finais: ");
                    String cpf4crianca = lerCpf(scanner, 2, "2 últimos dígitos: ");
                    String cpfcrianca = montarCpf(cpf1crianca, cpf2crianca, cpf3crianca, cpf4crianca);
                    
                    System.out.println("------------------------------------------------------------------------------");

                    System.out.print("Digite a turma:");
                    String turma;
                    turma= scanner.next();
                    
                    System.out.println("------------------------------------------------------------------------------");

                    System.out.print("Digite o turno:");
                    String turno;
                    turno= scanner.next();
                    
                    System.out.println("------------------------------------------------------------------------------");
                    
                    System.out.print("Digite o curso:");
                    String curso;
                    curso = scanner.next();
                    
                    System.out.println("==============================================================================");
                    System.out.print("Digite o gmail do aluno:");
                    String gmail2;
                    gmail2= scanner.next();
                    
                    System.out.println("------------------------------------------------------------------------------");
                    

                    // --- INSTANCIAÇÃO E SALVAMENTO ---
                    Responsavel novoResp = new Responsavel(nomeresponsavel, cpfresponsavel, idaderesponsavel,gmail,telefone);
                    bancoDados.inserirResponsavel(novoResp);
                    
                    Crianca novaCrianca = new Crianca(nomecrianca, cpfcrianca,idadecrianca,gmail2,turma,turno,curso, novoResp);
                    bancoDados.inserirCrianca(novaCrianca);

                    System.out.println("Nome do Aluno: " +novaCrianca);
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("Nome do Responsável: " +novoResp);                    
                    System.out.println("==============================================================================");
                    System.out.println("\nAluno e Responsável cadastrados com sucesso!");
                    break;
                    
                case 2:
                    System.out.println("==============================================================================");
                    System.out.println("                ----- RESPONSÁVEIS POR ALUNO CADASTRADOS -----");
                    bancoDados.exibirResponsaveisPorAluno(); 
                    break;

                case 3:
                    System.out.println("==============================================================================");
                    System.out.println("                        ----- ALUNOS CADASTRADOS -----");
                    bancoDados.exibirCriancas();
                    break;

                case 4:
                    System.out.println("==============================================================================");
                    System.out.println("                        -----ATUALIZAR-----");
                    System.out.println("1)Atualizar responsavel: ");
                    System.out.println("2)Atualizar aluno: ");
                    
                    System.out.print("Escolha: ");
                    
                    int opcao3 = scanner.nextInt();
                    scanner.nextLine();


                    switch (opcao3) {
                        case 1:System.out.println("==============================================================================");
                        System.out.println("                        ----- Atualizar responsavel-----");
                        System.out.print("Digite a matricula do aluno vinculado ao responsavel");
                        int idaluno = scanner.nextInt();
                        scanner.nextLine();
                        String nome;
                        do {System.out.print("Digite o  Novo nome do responsavel: ");
                           nome = scanner.nextLine();
                           
                        if (!nomeValido(nome)) {System.out.println("Nome inválido! Tente novamente.");}
                        } while (!nomeValido(nome));


                         System.out.print("Digite o CPF do responsável:");
                         String cpfRs1 = lerCpf(scanner, 3, "3 primeiros dígitos: ");
                         String cpfRs2 = lerCpf(scanner, 3, "3 dígitos do meio: ");
                         String cpfRs3 = lerCpf(scanner, 3, "3 dígitos finais: ");
                         String cpfRs4 = lerCpf(scanner, 2, "2 últimos dígitos: ");
                         String cpfRs = montarCpf(cpfRs1, cpfRs2, cpfRs3, cpfRs4);


                        int idade;
                    do {
                        System.out.print("Nova Idade do responsável: ");
                        idade = scanner.nextInt();
                        scanner.nextLine(); // Limpa buffer

                        if (idade< 18) {
                            System.out.println("Responsável deve ter 18 anos ou mais.");
                        }
                    } while (idade < 18);
                        
                        
                        

                        System.out.print("Novo Gmail: ");
                        String novogmail = scanner.nextLine();

                        System.out.print("Novo telefone: ");
                        String novotelefone = scanner.nextLine();

                        boolean atualizado = bancoDados.atualizarResponsavel(
                        idaluno, nome, cpfRs, idade, novogmail, novotelefone);

                        if (atualizado) {
                        System.out.print("Responsável atualizado com sucesso!");
                        } else {System.out.print ("Aluno não encontrado ou sem responsável vinculado.");}
                            break;
                            
                            
                        case 2:System.out.println("==============================================================================");
                    System.out.println("                        -----Atualizar aluno-----");
                        System.out.print("Digite a matricula do aluno: ");
                        String nome2;
                        int idaluno2 = scanner.nextInt();
                        scanner.nextLine(); 
                                                
                       do {System.out.print("Digite o  Novo nome do aluno: ");
                           nome2 = scanner.nextLine();
                           
                        if (!nomeValido(nome2)) {System.out.println("Nome inválido! Tente novamente.");}
                        } while (!nomeValido(nome2));
                       
                        System.out.print("Digite o CPF do Aluno: ");
                    String cpf1 = lerCpf(scanner, 3, "3 primeiros dígitos: ");
                    String cpf2 = lerCpf(scanner, 3, "3 dígitos do meio: ");
                    String cpf3 = lerCpf(scanner, 3, "3 dígitos finais: ");
                    String cpf4 = lerCpf(scanner, 2, "2 últimos dígitos: ");
                    String cpfAl = montarCpf(cpf1, cpf2, cpf3, cpf4);

                        int idade2;
                        do {
                        System.out.print("Digite o nova idade do Aluno: ");
                        idade2 = scanner.nextInt();
                        scanner.nextLine(); // Limpa buffer

                        if (idade2 < 0 || idade2 > 17) {
                            System.out.println("Idade inválida! Digite entre 0 e 17.");
                        }
                    } while (idade2 < 0 || idade2 > 17);

                        System.out.print("Novo Gmail: ");
                        String novogmail2 = scanner.nextLine();

                        
                        System.out.print("Novo turma: ");
                        String novoturma = scanner.nextLine();
                        
                        System.out.print("Novo turno: ");
                        String novoturno = scanner.nextLine();
                        
                        System.out.print("Novo curso: ");
                        String novocurso = scanner.nextLine();


                        boolean atualizado2 = bancoDados.atualizarAluno(
                        idaluno2, nome2, cpfAl, idade2, novogmail2, novoturma,novoturno,novocurso);

                        if (atualizado2) {
                        System.out.println("Aluno atualizado com sucesso!");
                        } else {System.out.println("Aluno não encontrado.");}
                            break;
                            
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                     break;
                                        default:
                    System.out.println("Opção inválida!");
                    break;                            
                        
                                        
                case 5:
                    System.out.println("==============================================================================");
                    System.out.println("                        ----- PROCURAR ALUNOS-----");
                    System.out.println("1) PROCURAR ALUNOS por CPF");
                    System.out.println("2) PROCURAR ALUNOS por matricula");
                    System.out.print("Escolha: ");
                    
                    int opcao2 = scanner.nextInt();
                    scanner.nextLine();


                    switch (opcao2) {
                        case 1:System.out.println("==============================================================================");
                        System.out.println("                        ----- PROCURAR ALUNOS por CPF-----");
                        System.out.print("Digite o CPF do aluno para busca (completo no formato XXX.XXX.XXX-XX): ");
                        String cpfBusca = scanner.nextLine();
                        System.out.println("------------------------------------------------------------------------------");
                        bancoDados.buscarAlunoPorCpf(cpfBusca);
                            break;
                        case 2:System.out.println("==============================================================================");
                    System.out.println("                        ----- PROCURAR ALUNOS por id-----");
                        System.out.print("Digite a matricula do aluno para busca: ");
                        int idBusca = scanner.nextInt();
                        System.out.println("------------------------------------------------------------------------------");
                        bancoDados.buscarAlunoPorid(idBusca);
                        break;
                                            
                        default:
                            System.out.println("Opção inválida!");
                            break;}
                    break;
                    
                case 6:  
                    System.out.println("==============================================================================");
                    System.out.println("                        ----- Deletar-----");
                    System.out.println("1) Excluir (essa opcao ira excluir tudo quelacionado a um cadstro nao tendo retorno) ");
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("2) Sair");
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.print("Escolha: ");

                    int opcaodeletar = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (opcaodeletar){
                        case 1:System.out.print("Digite a matricula do aluno que deseja excluir: ");
                        int id = scanner.nextInt();

                        if (bancoDados.excluirAluno(id)) {
                        System.out.println("Aluno e responsável excluídos com sucesso!");}
                    else {System.out.println("Aluno não encontrado.");}
                        break;
                    case 2: break;
}
            
            }
        } 
    } 

    // --- MÉTODOS AUXILIARES --- scanner.close();}

    public static boolean blocoValido(String parte, int tamanho) {
        return parte.matches("\\d{" + tamanho + "}");
    }

    public static String lerCpf(Scanner sc, int tamanho, String msg) {
        String cpf;
        do {
            System.out.print(msg);
            cpf = sc.nextLine().trim();

            if (!blocoValido(cpf, tamanho)) {
                System.out.println("CPF inválido! Digite somente números com a quantidade correta de dígitos.");
            }
        } while (!blocoValido(cpf, tamanho));
        return cpf;
    }

    public static boolean nomeValido(String nome) {
        return nome.matches("[a-zA-ZÀ-ÿ\\s]+");
    }

    public static String lerNome(Scanner sc, String msg) {
        String nome;
        do {
            System.out.print(msg);
            nome = sc.nextLine().trim();

            if (nome.isBlank()) {
                System.out.println("Nome vazio! Por favor, digite um nome.");
                continue;
            }

            if (!nomeValido(nome)) {
                System.out.println("Nome inválido! Não pode conter números ou caracteres especiais.");
            }

        } while (nome.isBlank() || !nomeValido(nome));

        return nome;
    }

    public static String montarCpf(String p1, String p2, String p3, String p4) {
        return p1 + "." + p2 + "." + p3 + "-" + p4;
    }

    public static String montarnome(String p1, String p2, String p3) {
        return p1 + " " + p2 + " " + p3;}
    
    
}
