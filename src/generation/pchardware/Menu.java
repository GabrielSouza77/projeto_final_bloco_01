package generation.pchardware;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import generation.pchardware.controller.ProdutoController;
import generation.pchardware.model.PlacaDeVideo;
import generation.pchardware.model.PlacaMae;
import generation.pchardware.model.Processador;
import generation.pchardware.model.Produto;

public class Menu {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        ProdutoController produtos = new ProdutoController();

        int opcao, id, tipo, nucleos, memoriaVRAM;
        double clock;
        String nome, marca, gpu, socket, chipset;
        float preco;

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
                    System.out.println("Escolha o tipo de produto: 1 - Processador  2 - Placa de Vídeo  3 - Placa-Mãe");
                    tipo = leia.nextInt();
                    leia.nextLine();

                    System.out.print("Nome: ");
                    nome = leia.nextLine();

                    System.out.print("Marca: ");
                    marca = leia.nextLine();

                    System.out.print("Preço: ");
                    preco = leia.nextFloat();

                    int novoId = produtos.gerarId();

                    switch (tipo) {
                        case 1 -> {
                            System.out.print("Núcleos: ");
                            nucleos = leia.nextInt();
                            System.out.print("Clock (GHz): ");
                            clock = leia.nextDouble();
                            produtos.cadastrar(new Processador(novoId, nome, marca, tipo, preco, nucleos, clock));
                        }
                        case 2 -> {
                            System.out.print("Memória VRAM (GB): ");
                            memoriaVRAM = leia.nextInt();
                            leia.nextLine();
                            System.out.print("GPU (chip gráfico): ");
                            gpu = leia.nextLine();
                            produtos.cadastrar(new PlacaDeVideo(novoId, nome, marca, tipo, preco, memoriaVRAM, gpu));
                        }
                        case 3 -> {
                            leia.nextLine();
                            System.out.print("Socket: ");
                            socket = leia.nextLine();
                            System.out.print("Chipset: ");
                            chipset = leia.nextLine();
                            produtos.cadastrar(new PlacaMae(novoId, nome, marca, tipo, preco, socket, chipset));
                        }
                        default -> System.out.println("Tipo inválido!");
                    }
                    keyPress();
                    break;

                case 2:
                    System.out.println("Listar todos os Produtos\n");
                    produtos.listarTodos();
                    keyPress();
                    break;

                case 3:
                    System.out.println("Consultar dados do Produto - por número\n");
                    System.out.print("Digite o ID do Produto: ");
                    id = leia.nextInt();
                    produtos.procurarPorId(id);
                    keyPress();
                    break;

                case 4:
                    System.out.println("Atualizar dados do Produto\n");
                    System.out.print("Digite o id do produto: ");
                    id = leia.nextInt();

                    Optional<Produto> produto = produtos.buscarNaCollection(id);

                    if (produto.isPresent()) {
                        leia.nextLine();
                        System.out.print("Nome: ");
                        nome = leia.nextLine();

                        System.out.print("Marca: ");
                        marca = leia.nextLine();

                        tipo = produto.get().getTipo();

                        System.out.print("Preço: ");
                        preco = leia.nextFloat();

                        switch (tipo) {
                            case 1 -> {
                                System.out.print("Núcleos: ");
                                nucleos = leia.nextInt();
                                System.out.print("Clock (GHz): ");
                                clock = leia.nextDouble();
                                produtos.atualizar(new Processador(id, nome, marca, tipo, preco, nucleos, clock));
                            }
                            case 2 -> {
                                System.out.print("Memória VRAM (GB): ");
                                memoriaVRAM = leia.nextInt();
                                leia.nextLine();
                                System.out.print("GPU (chip gráfico): ");
                                gpu = leia.nextLine();
                                produtos.atualizar(new PlacaDeVideo(id, nome, marca, tipo, preco, memoriaVRAM, gpu));
                            }
                            case 3 -> {
                                leia.nextLine();
                                System.out.print("Socket: ");
                                socket = leia.nextLine();
                                System.out.print("Chipset: ");
                                chipset = leia.nextLine();
                                produtos.atualizar(new PlacaMae(id, nome, marca, tipo, preco, socket, chipset));
                            }
                        }
                    } else {
                        System.out.printf("\nO Produto ID %d não existe!\n", id);
                    }
                    keyPress();
                    break;

                case 5:
                    System.out.println("Apagar o Produto\n");
                    System.out.print("Digite o ID do Produto: ");
                    id = leia.nextInt();
                    produtos.deletar(id);
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
