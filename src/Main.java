import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[][] tabuleiro = new String[3][3];
        int linhaJogador;
        int colunaJogador;
        String jogadorAtual = "(X)";

        Scanner sc = new Scanner(System.in);

        montarTabuleiro(tabuleiro);

        do {
            imprimirTabuleiro(tabuleiro);
            System.out.println("Jogador " + (jogadorAtual.equals("(X)") ? "1" : "2"));

            System.out.println("Insira o numero da linha.");
            linhaJogador = sc.nextInt();
            System.out.println("Insira o numero da coluna.");
            colunaJogador = sc.nextInt();

            if (selecionarLocal(tabuleiro, linhaJogador, colunaJogador, jogadorAtual)) {
                String nomeJogador = "Jogador 1";
                if (verificarVencedor(tabuleiro, jogadorAtual)) {
                    if (!jogadorAtual.equals("(X)")) {
                        nomeJogador = "Jogador 2";
                    }
                    System.out.printf("*** O vencedor é: %s  ***", nomeJogador);
                    return;
                }
                if (verificarEmpate(tabuleiro)) {
                    System.out.println("*** EMPATE! NINGUEM VENCER. ***");
                    return;
                }

                if (jogadorAtual.equals("(X)")) {
                    jogadorAtual = "(O)";
                } else {
                    jogadorAtual = "(X)";
                }
            }

        } while (true);
    }


    static boolean selecionarLocal(String[][] tabela, int linha, int coluna, String simbolo) {
        try {
            if (tabela[linha][coluna].equals("( )")) {
                tabela[linha][coluna] = simbolo;
                return true;
            } else {
                System.out.println("Local já preenchido!");
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("*** Indice de linha ou coluna invalidos: " + e.getMessage() + " ***");
            return false;
        }
    }

    static void montarTabuleiro(String[][] tabuleiro) {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = "( )";
            }
        }
    }

    static void imprimirTabuleiro(String[][] tabuleiro) {
        System.out.println("  0  1  2");
        for (int linha = 0; linha < 3; linha++) {
            System.out.print(linha);
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(tabuleiro[linha][coluna]);
            }
            System.out.println();
        }
    }

    static boolean verificarVencedor(String[][] tabuleiro, String simbolo) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0].equals(simbolo) && tabuleiro[i][1].equals(simbolo)
                    && tabuleiro[i][2].equals(simbolo)) return true;
            if (tabuleiro[0][i].equals(simbolo) && tabuleiro[1][i].equals(simbolo)
                    && tabuleiro[2][i].equals(simbolo)) return true;
            if (tabuleiro[0][0].equals(simbolo) && tabuleiro[1][1].equals(simbolo)
                    && tabuleiro[2][2].equals(simbolo)) return true;
            if (tabuleiro[2][0].equals(simbolo) && tabuleiro[1][1].equals(simbolo)
                    && tabuleiro[0][2].equals(simbolo)) return true;
        }
        return false;
    }

    static boolean verificarEmpate(String[][] tabuleiro) {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna].equals("( )")) {
                    return false;
                }
            }
        }
        return true;
    }


}