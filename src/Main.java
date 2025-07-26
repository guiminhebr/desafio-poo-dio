import br.com.dio.desafio.dominio.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Bootcamp bootcamp = new Bootcamp();
    static Dev dev = new Dev();

    public static void main(String[] args) {
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Aprenda Java do básico ao avançado!");
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("1 - Cadastrar Curso");
            System.out.println("2 - Cadastrar Mentoria");
            System.out.println("3 - Consultar Conteúdos do Bootcamp");
            System.out.println("4 - Cadastrar Dev");
            System.out.println("5 - Inscrever Dev no Bootcamp");
            System.out.println("6 - Progredir Dev");
            System.out.println("7 - Ver XP do Dev");
            System.out.println("8 - Ver Conteúdos Inscritos e Concluídos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(input.nextLine());

                switch (opcao) {
                    case 1 -> cadastrarCurso();
                    case 2 -> cadastrarMentoria();
                    case 3 -> listarConteudos();
                    case 4 -> cadastrarDev();
                    case 5 -> dev.inscreverBootcamp(bootcamp);
                    case 6 -> dev.progredir();
                    case 7 -> System.out.println("XP Total: " + dev.calcularTotalXp());
                    case 8 -> mostrarConteudosDev();
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida.");
            }
        }
    }

    public static void cadastrarCurso() {
        Curso curso = new Curso();
        System.out.print("Título do curso: ");
        curso.setTitulo(input.nextLine());
        System.out.print("Descrição: ");
        curso.setDescricao(input.nextLine());
        System.out.print("Carga horária: ");
        curso.setCargaHorario(Integer.parseInt(input.nextLine()));

        bootcamp.getConteudos().add(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    public static void cadastrarMentoria() {
        Mentoria mentoria = new Mentoria();
        System.out.print("Título da mentoria: ");
        mentoria.setTitulo(input.nextLine());
        System.out.print("Descrição: ");
        mentoria.setDescricao(input.nextLine());
        mentoria.setData(LocalDate.now());

        bootcamp.getConteudos().add(mentoria);
        System.out.println("mentoria cadastrada com sucesso!");
    }

    public static void listarConteudos() {
        System.out.println("Conteúdos do Bootcamp:");
        for (Conteudo c : bootcamp.getConteudos()) {
            System.out.println("- " + c);
        }
    }

    public static void cadastrarDev() {
        System.out.print("Nome do Dev: ");
        dev.setNome(input.nextLine());
        System.out.println("Dev cadastrado!");
    }

    public static void mostrarConteudosDev() {
        System.out.println("Conteúdos Inscritos:");
        dev.getConteudoInscritos().forEach(c -> System.out.println("- " + c.getTitulo()));
        System.out.println("Conteúdos Concluídos:");
        dev.getConteudoConcluidos().forEach(c -> System.out.println("- " + c.getTitulo()));
    }
}
