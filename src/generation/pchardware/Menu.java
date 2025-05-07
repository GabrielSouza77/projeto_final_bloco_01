package generation.pchardware;

import java.io.IOException;
import java.util.Scanner;

import generation.pchardware.model.PlacaDeVideo;
import generation.pchardware.model.PlacaMae;
import generation.pchardware.model.Processador;

public class Menu {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        
        /* Testes do modelo de dados */
		
		Processador cpu1 = new Processador(1, "Ryzen 5 5600X", "AMD", 1, 990.90f, 6, 4.90);
		cpu1.visualizar();
		
		PlacaDeVideo gpu1 = new PlacaDeVideo(2, "RX 6600XT", "AMD", 2, 1490.90f, 8, "Navi 23 XT");
		gpu1.visualizar();
		
		PlacaMae pm1 = new PlacaMae(3, "B450M", "Steel Legend", 3, 890.90f, "AM4", "AMD B450");
		pm1.visualizar();

        int opcao;

        while (true) {

            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                GENERATION PC HARDWARE               ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Produto                        ");
            System.out.println("            2 - Listar todos os Produtos             ");
            System.out.println("            3 - Buscar Produto por ID                ");
            System.out.println("            4 - Atualizar Dados do Produto           ");
            System.out.println("            5 - Apagar Produto                       ");
            System.out.println("            6 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.print("Entre com a opção desejada: ");

            opcao = leia.nextInt();

            if (opcao == 6) {
                System.out.println("\nGeneration PC Hardware - Os melhores hardwares do Brasil você encontra aqui!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Criar Produto\n");
                    keyPress();
                    break;
                case 2:
                    System.out.println("Listar todos os Produtos\n");
                    keyPress();
                    break;
                case 3:
                    System.out.println("Consultar dados do Produto - por número\n");
                    keyPress();
                    break;
                case 4:
                    System.out.println("Atualizar dados do Produto\n");
                    keyPress();
                    break;
                case 5:
                    System.out.println("Apagar o Produto\n");
                    keyPress();
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
                    keyPress();
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Gabriel dos Santos Souza");
        System.out.println("Generation Brasil - gabriels1@genstudents.org");
        System.out.println("https://github.com/GabrielSouza77/projeto_final_bloco_01");
        System.out.println("*********************************************************");
    }

    public static void keyPress() {
        try {
            System.out.println("\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.err.println("Erro de entrada/saída: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
        }
    }
}
