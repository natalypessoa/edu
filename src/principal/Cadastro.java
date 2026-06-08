package principal;

import estruturaArray.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.*;

public class Cadastro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        Array bancoDados = new Array();

        // Dados de teste iniciais
        Responsavel respTeste = new Responsavel("Jane Cristina da Silva", "321.321.234-12", 19, "jan@gmail.com", "1112345");
        bancoDados.inserirResponsavel(respTeste);
        Crianca criancaTeste = new Crianca("Pedro Silva", "123.123.123-12", 12, "pedr@gmail.com", "3B", "Manha", "Ciencias", respTeste);
        bancoDados.inserirCrianca(criancaTeste);

        while (true) {
            try {
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
                        String nomeresponsavel = lerNomeCompleto(scanner, "Nome completo do responsável: ");

                        int idaderesponsavel;
                        do {
                            System.out.print("Idade do responsável: ");
                            idaderesponsavel = scanner.nextInt();
                            scanner.nextLine();
                            if (idaderesponsavel < 18) {
                                System.out.println("Responsável deve ter 18 anos ou mais.");
                            }
                        } while (idaderesponsavel < 18);

                        System.out.println("------------------------------------------------------------------------------");

                        String cpfresponsavel = lerCpfCompleto(scanner, "CPF do responsável (formato XXX.XXX.XXX-XX): ");

                        System.out.println("------------------------------------------------------------------------------");

                        System.out.print("Digite o gmail: ");
                        String gmail = scanner.nextLine().trim();

                        System.out.println("------------------------------------------------------------------------------");

                        System.out.print("Digite o telefone: ");
                        String telefone = scanner.nextLine().trim();

                        System.out.println("==============================================================================");

                        // --- DADOS DA CRIANÇA ---
                        String nomecrianca = lerNomeCompleto(scanner, "Nome completo da criança: ");

                        int idadecrianca;
                        do {
                            System.out.print("Idade da criança: ");
                            idadecrianca = scanner.nextInt();
                            scanner.nextLine();
                            if (idadecrianca < 0 || idadecrianca > 17) {
                                System.out.println("Idade inválida! Digite entre 0 e 17.");
                            }
                        } while (idadecrianca < 0 || idadecrianca > 17);

                        String cpfcrianca = lerCpfCompleto(scanner, "CPF da criança (formato XXX.XXX.XXX-XX): ");

                        System.out.println("------------------------------------------------------------------------------");

                        // --- CURSO (escolha por menu) ---
                        String curso = escolherCurso(scanner);

                        System.out.println("------------------------------------------------------------------------------");

                        // --- TURNO (escolha por menu) ---
                        String turno = escolherTurno(scanner);

                        System.out.println("------------------------------------------------------------------------------");

                        // --- TURMA (gerada a partir do curso e turno) ---
                        String turma = escolherTurma(scanner, turno, curso);

                        System.out.println("------------------------------------------------------------------------------");

                        System.out.print("Digite o gmail do aluno: ");
                        String gmail2 = scanner.nextLine().trim();

                        System.out.println("==============================================================================");

                        // --- INSTANCIAÇÃO E SALVAMENTO ---
                        Responsavel novoResp = new Responsavel(nomeresponsavel, cpfresponsavel, idaderesponsavel, gmail, telefone);
                        bancoDados.inserirResponsavel(novoResp);

                        Crianca novaCrianca = new Crianca(nomecrianca, cpfcrianca, idadecrianca, gmail2, turma, turno, curso, novoResp);
                        bancoDados.inserirCrianca(novaCrianca);

                        System.out.println("Nome do Aluno: " + novaCrianca);
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println("Nome do Responsável: " + novoResp);
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
                        System.out.println("1) Atualizar responsavel");
                        System.out.println("2) Atualizar aluno");
                        System.out.print("Escolha: ");

                        int opcao3 = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao3) {
                            case 1:
                                System.out.println("==============================================================================");
                                System.out.println("                        ----- Atualizar responsavel -----");
                                System.out.print("Digite a matricula do aluno vinculado ao responsavel: ");
                                int idaluno = scanner.nextInt();
                                scanner.nextLine();

                                String nomeResp = lerNomeCompleto(scanner, "Novo nome completo do responsável: ");
                                String cpfRs = lerCpfCompleto(scanner, "Novo CPF do responsável (formato XXX.XXX.XXX-XX): ");

                                int idade;
                                do {
                                    System.out.print("Nova idade do responsável: ");
                                    idade = scanner.nextInt();
                                    scanner.nextLine();
                                    if (idade < 18) {
                                        System.out.println("Responsável deve ter 18 anos ou mais.");
                                    }
                                } while (idade < 18);

                                System.out.print("Novo Gmail: ");
                                String novogmail = scanner.nextLine();

                                System.out.print("Novo telefone: ");
                                String novotelefone = scanner.nextLine();

                                boolean atualizado = bancoDados.atualizarResponsavel(
                                        idaluno, nomeResp, cpfRs, idade, novogmail, novotelefone);

                                if (atualizado) {
                                    System.out.println("Responsável atualizado com sucesso!");
                                } else {
                                    System.out.println("Aluno não encontrado ou sem responsável vinculado.");
                                }
                                break;

                            case 2:
                                System.out.println("==============================================================================");
                                System.out.println("                        ----- Atualizar aluno -----");
                                System.out.print("Digite a matricula do aluno: ");
                                int matriBusca2 = scanner.nextInt();
                                scanner.nextLine();

                                String nomeAl = lerNomeCompleto(scanner, "Novo nome completo do aluno: ");
                                String cpfAl = lerCpfCompleto(scanner, "Novo CPF do aluno (formato XXX.XXX.XXX-XX): ");

                                int idade2;
                                do {
                                    System.out.print("Nova idade do aluno: ");
                                    idade2 = scanner.nextInt();
                                    scanner.nextLine();
                                    if (idade2 < 0 || idade2 > 17) {
                                        System.out.println("Idade inválida! Digite entre 0 e 17.");
                                    }
                                } while (idade2 < 0 || idade2 > 17);

                                System.out.print("Novo Gmail: ");
                                String novogmail2 = scanner.nextLine();

                                String novocurso = escolherCurso(scanner);
                                String novoturno = escolherTurno(scanner);
                                String novoturma = escolherTurma(scanner, novoturno, novocurso);

                                boolean atualizado2 = bancoDados.atualizarAluno(
                                        matriBusca2, nomeAl, cpfAl, idade2, novogmail2, novoturma, novoturno, novocurso);

                                if (atualizado2) {
                                    System.out.println("Aluno atualizado com sucesso!");
                                } else {
                                    System.out.println("Aluno não encontrado.");
                                }
                                break;

                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        break;

                    case 5:
                        System.out.println("==============================================================================");
                        System.out.println("                        ----- PROCURAR ALUNOS -----");
                        System.out.println("1) PROCURAR ALUNOS por CPF");
                        System.out.println("2) PROCURAR ALUNOS por matricula");
                        System.out.print("Escolha: ");

                        int opcao2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao2) {
                            case 1:
                                System.out.println("==============================================================================");
                                System.out.println("                        ----- PROCURAR ALUNOS por CPF -----");
                                System.out.print("Digite o CPF do aluno (formato XXX.XXX.XXX-XX): ");
                                String cpfBusca = scanner.nextLine();
                                System.out.println("------------------------------------------------------------------------------");
                                bancoDados.buscarAlunoPorCpf(cpfBusca);
                                break;
                            case 2:
                                System.out.println("==============================================================================");
                                System.out.println("                        ----- PROCURAR ALUNOS por id -----");
                                System.out.print("Digite a matricula do aluno para busca: ");
                                int matriBusca = scanner.nextInt();
                                System.out.println("------------------------------------------------------------------------------");
                                bancoDados.buscarAlunoPorid(matriBusca);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        break;

                    case 6:
                        System.out.println("==============================================================================");
                        System.out.println("                        ----- Deletar -----");
                        System.out.println("1) Excluir (essa opção irá excluir tudo relacionado a um cadastro, sem retorno)");
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println("2) Sair");
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.print("Escolha: ");

                        int opcaodeletar = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaodeletar) {
                            case 1:
                                System.out.print("Digite a matricula do aluno que deseja excluir: ");
                                int matri = scanner.nextInt();
                                if (bancoDados.excluirAluno(matri)) {
                                    System.out.println("Aluno e responsável excluídos com sucesso!");
                                } else {
                                    System.out.println("Aluno não encontrado.");
                                }
                                break;
                            case 2:
                                break;
                        }
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (InputMismatchException erro) {
                System.out.println("Opção inválida!");
                scanner.next();//limpa buffer
            }
        }

    }

    // --- MÉTODOS AUXILIARES ---
    // Nome completo em campo único
    public static String lerNomeCompleto(Scanner sc, String msg) {
        String nome;
        do {
            System.out.print(msg);
            nome = sc.nextLine().trim();

            if (nome.isBlank()) {
                System.out.println("Nome vazio! Por favor, digite o nome completo.");
                continue;
            }
            if (!nomeValido(nome)) {
                System.out.println("Nome inválido! Não pode conter números ou caracteres especiais.");
            }
        } while (nome.isBlank() || !nomeValido(nome));
        return nome;
    }

    // CPF completo em campo único com validação de formato
    public static String lerCpfCompleto(Scanner sc, String msg) {
        String cpf;
        do {
            System.out.print(msg);
            cpf = sc.nextLine().trim();
            if (!cpfFormatoValido(cpf)) {
                System.out.println("CPF inválido! Use o formato XXX.XXX.XXX-XX (apenas números e pontuação correta).");
            }
        } while (!cpfFormatoValido(cpf));
        return cpf;
    }

    // Valida formato XXX.XXX.XXX-XX
    public static boolean cpfFormatoValido(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    // Escolha de curso por menu
    public static String escolherCurso(Scanner sc) {
        int opcao;
        do {
            System.out.println("Escolha o curso:");
            System.out.println("  1) Lógica de Programação: Criando Meu Primeiro Jogo");
            System.out.println("  2) Robótica Educativa: Programando no Mundo Real");
            System.out.println("  3) Criatividade Digital com Minecraft: Criar e Explorar");
            System.out.println("  4) Segurança em Redes: Usar a Internet com Segurança");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            if (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida! Escolha entre 1 e 4.");
            }
        } while (opcao < 1 || opcao > 4);

        switch (opcao) {
            case 1:
                return "Lógica de Programação: Criando Meu Primeiro Jogo";
            case 2:
                return "Robótica Educativa: Programando no Mundo Real";
            case 3:
                return "Criatividade Digital com Minecraft: Criar e Explorar";
            case 4:
                return "Segurança em Redes: Usar a Internet com Segurança";
            default:
                return "";
        }
    }

    // Turmas disponíveis por turno e curso — exibe a turma atribuída ao final
    public static String escolherTurma(Scanner sc, String turno, String curso) {
        // Prefixo do turno
        String prefixoTurno;
        switch (turno) {
            case "Matutino":
                prefixoTurno = "M";
                break;
            case "Vespertino":
                prefixoTurno = "V";
                break;
            case "Noturno":
                prefixoTurno = "N";
                break;
            default:
                prefixoTurno = "X";
        }

        // Prefixo do curso
        String prefixoCurso;
        if (curso.startsWith("Lógica")) {
            prefixoCurso = "LP";
        } else if (curso.startsWith("Robótica")) {
            prefixoCurso = "RE";
        } else if (curso.startsWith("Criatividade")) {
            prefixoCurso = "MC";
        } else if (curso.startsWith("Segurança")) {
            prefixoCurso = "SR";
        } else {
            prefixoCurso = "XX";
        }

        // Gera turmas: ex. M-LP-1, M-LP-2
        String[] turmas = {
            prefixoTurno + "-" + prefixoCurso + "-1",
            prefixoTurno + "-" + prefixoCurso + "-2",
            prefixoTurno + "-" + prefixoCurso + "-3"
        };

        int opcao;
        do {
            System.out.println("Escolha a turma (" + turno + " | " + curso + "):");
            for (int i = 0; i < turmas.length; i++) {
                System.out.println("  " + (i + 1) + ") " + turmas[i]);
            }
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            if (opcao < 1 || opcao > turmas.length) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao < 1 || opcao > turmas.length);

        String turmaSelecionada = turmas[opcao - 1];
        System.out.println("Turma atribuída: " + turmaSelecionada);
        return turmaSelecionada;
    }

    // Escolha de turno por menu
    public static String escolherTurno(Scanner sc) {
        int opcao;
        do {
            System.out.println("Escolha o turno:");
            System.out.println("  1) Matutino");
            System.out.println("  2) Vespertino");
            System.out.println("  3) Noturno");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            if (opcao < 1 || opcao > 3) {
                System.out.println("Opção inválida! Escolha entre 1 e 3.");
            }
        } while (opcao < 1 || opcao > 3);

        switch (opcao) {
            case 1:
                return "Matutino";
            case 2:
                return "Vespertino";
            case 3:
                return "Noturno";
            default:
                return "";
        }
    }

    public static boolean nomeValido(String nome) {
        return nome.matches("[a-zA-ZÀ-ÿ\\s]+");
    }

    // Mantidos para compatibilidade caso usados em outro lugar
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

    public static String montarCpf(String p1, String p2, String p3, String p4) {
        return p1 + "." + p2 + "." + p3 + "-" + p4;
    }

    public static String montarnome(String p1, String p2, String p3) {
        return p1 + " " + p2 + " " + p3;
    }
}
