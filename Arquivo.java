import java.util.Scanner;

public class SistemaRPG {

    static String nomeJogador;
    static int vida = 100;
    static int moedas = 50;
    static int ataque = 20;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("      ⚔️  SISTEMA RPG JAVA ⚔️");
        System.out.println("===================================");

        System.out.print("Digite o nome do herói: ");
        nomeJogador = sc.nextLine();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Ver status");
            System.out.println("2 - Explorar floresta");
            System.out.println("3 - Loja");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    mostrarStatus();
                    break;

                case 2:
                    explorar();
                    break;

                case 3:
                    loja(sc);
                    break;

                case 4:
                    System.out.println("\nSaindo do jogo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        sc.close();
    }

    public static void mostrarStatus() {

        System.out.println("\n===== STATUS =====");
        System.out.println("Herói: " + nomeJogador);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Moedas: " + moedas);
    }

    public static void explorar() {

        System.out.println("\n🌲 Você entrou na floresta...");

        int inimigoVida = 40;

        while (inimigoVida > 0 && vida > 0) {

            System.out.println("\n⚔️ Você atacou o monstro!");
            inimigoVida -= ataque;

            System.out.println("Vida do monstro: " + inimigoVida);

            if (inimigoVida > 0) {
                System.out.println("👹 O monstro te atacou!");
                vida -= 10;
                System.out.println("Sua vida: " + vida);
            }
        }

        if (vida > 0) {
            System.out.println("\n🏆 Você venceu o monstro!");
            moedas += 30;
            System.out.println("Você ganhou 30 moedas!");
        } else {
            System.out.println("\n☠️ Você foi derrotado...");
        }
    }

    public static void loja(Scanner sc) {

        System.out.println("\n🛒 LOJA");
        System.out.println("1 - Comprar espada (+10 ataque) = 40 moedas");
        System.out.println("2 - Comprar poção (+30 vida) = 20 moedas");
        System.out.print("Escolha: ");

        int escolha = sc.nextInt();

        switch (escolha) {

            case 1:

                if (moedas >= 40) {
                    moedas -= 40;
                    ataque += 10;
                    System.out.println("⚔️ Espada comprada!");
                } else {
                    System.out.println("Moedas insuficientes!");
                }

                break;

            case 2:

                if (moedas >= 20) {
                    moedas -= 20;
                    vida += 30;
                    System.out.println("🧪 Poção comprada!");
                } else {
                    System.out.println("Moedas insuficientes!");
                }

                break;

            default:
                System.out.println("Item inválido!");
        }
    }
}