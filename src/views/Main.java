package views;

import models.Venda;
import models.VendaDAO;
import models.VendaDAOMySQL;
import models.VendaPeca;
import models.VendaPecaDAO;
import models.VendaPecaDAOMySQL;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static VendaDAO vendaDAO = new VendaDAOMySQL();
    private static VendaPecaDAO vendaPecaDAO = new VendaPecaDAOMySQL();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarVenda();
                    break;
                case 2:
                    atualizarVenda();
                    break;
                case 3:
                    excluirVenda();
                    break;
                case 4:
                    buscarVenda();
                    break;
                case 5:
                    listarVendas();
                    break;
                case 6:
                    cadastrarVendaPeca();
                    break;
                case 7:
                    atualizarVendaPeca();
                    break;
                case 8:
                    excluirVendaPeca();
                    break;
                case 9:
                    buscarVendaPeca();
                    break;
                case 10:
                    listarVendaPecas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("==== Menu ====");
        System.out.println("1. Cadastrar Venda");
        System.out.println("2. Atualizar Venda");
        System.out.println("3. Excluir Venda");
        System.out.println("4. Buscar Venda");
        System.out.println("5. Listar Vendas");
        System.out.println("6. Cadastrar Venda de Peça");
        System.out.println("7. Atualizar Venda de Peça");
        System.out.println("8. Excluir Venda de Peça");
        System.out.println("9. Buscar Venda de Peça");
        System.out.println("10. Listar Vendas de Peças");
        System.out.println("0. Sair");
        System.out.println("==============");
        System.out.print("Digite a opcao desejada: ");
    }

    private static int lerOpcao() {
        return scanner.nextInt();
    }

    private static void cadastrarVenda() {
        System.out.print("Digite o ID da venda: ");
        int vendaId = scanner.nextInt();
        Venda venda = new Venda(vendaId);
        vendaDAO.cadastrar(venda);
    }

    private static void atualizarVenda() {
        System.out.print("Digite o ID da venda a ser atualizada: ");
        int vendaId = scanner.nextInt();
        Venda venda = vendaDAO.buscar(vendaId);
        if (venda != null) {
            System.out.print("Digite o novo ID da venda: ");
            int novoId = scanner.nextInt();
            venda.setId(novoId);
            vendaDAO.atualizar(venda);
        } else {
            System.out.println("Venda não encontrada.");
        }
    }

    private static void excluirVenda() {
        System.out.print("Digite o ID da venda a ser excluída: ");
        int vendaId = scanner.nextInt();
        vendaDAO.excluir(vendaId);
    }

    private static void buscarVenda() {
        System.out.print("Digite o ID da venda a ser buscada: ");
        int vendaId = scanner.nextInt();
        Venda venda = vendaDAO.buscar(vendaId);
        if (venda != null) {
            System.out.println("Venda encontrada:");
            System.out.println("ID: " + venda.getId());
        } else {
            System.out.println("Venda não encontrada.");
        }
    }

    private static void listarVendas() {
        List<Venda> vendas = vendaDAO.listar();
        if (!vendas.isEmpty()) {
            System.out.println("Lista de vendas:");
            for (Venda venda : vendas) {
                System.out.println("ID: " + venda.getId());
            }
        } else {
            System.out.println("Não há vendas cadastradas.");
        }
    }

    private static void cadastrarVendaPeca() {
        System.out.print("Digite o nome da peça: ");
        String nomePeca = scanner.next();
        System.out.print("Digite o valor da peça: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite a quantidade da peça: ");
        int quantidade = scanner.nextInt();
        VendaPeca vendaPeca = new VendaPeca(nomePeca, valor, quantidade);
        vendaPecaDAO.cadastrar(vendaPeca);
    }

    private static void atualizarVendaPeca() {
        System.out.print("Digite o ID da venda de peça a ser atualizada: ");
        int vendaPecaId = scanner.nextInt();
        VendaPeca vendaPeca = vendaPecaDAO.buscar(vendaPecaId);
        if (vendaPeca != null) {
            System.out.print("Digite o novo nome da peça: ");
            String nomePeca = scanner.next();
            System.out.print("Digite o novo valor da peça: ");
            double valor = scanner.nextDouble();
            System.out.print("Digite a nova quantidade da peça: ");
            int quantidade = scanner.nextInt();
            vendaPeca.setNomePeca(nomePeca);
            vendaPeca.setValor(valor);
            vendaPeca.setQuantidade(quantidade);
            vendaPecaDAO.atualizar(vendaPeca);
        } else {
            System.out.println("Venda de peça não encontrada.");
        }
    }

    private static void excluirVendaPeca() {
        System.out.print("Digite o ID da venda de peça a ser excluída: ");
        int vendaPecaId = scanner.nextInt();
        vendaPecaDAO.excluir(vendaPecaId);
    }

    private static void buscarVendaPeca() {
        System.out.print("Digite o ID da venda de peça a ser buscada: ");
        int vendaPecaId = scanner.nextInt();
        VendaPeca vendaPeca = vendaPecaDAO.buscar(vendaPecaId);
        if (vendaPeca != null) {
            System.out.println("Venda de peça encontrada:");
            System.out.println("ID: " + vendaPeca.getId());
            System.out.println("Nome da peça: " + vendaPeca.getNomePeca());
            System.out.println("Valor: " + vendaPeca.getValor());
            System.out.println("Quantidade: " + vendaPeca.getQuantidade());
        } else {
            System.out.println("Venda de peça não encontrada.");
        }
    }

    private static void listarVendaPecas() {
        List<VendaPeca> vendaPecas = vendaPecaDAO.listar();
        if (!vendaPecas.isEmpty()) {
            System.out.println("Lista de vendas de peças:");
            for (VendaPeca vendaPeca : vendaPecas) {
                System.out.println("ID: " + vendaPeca.getId());
                System.out.println("Nome da peça: " + vendaPeca.getNomePeca());
                System.out.println("Valor: " + vendaPeca.getValor());
                System.out.println("Quantidade: " + vendaPeca.getQuantidade());
            }
        } else {
            System.out.println("Não há vendas de peças cadastradas.");
        }
    }
}
