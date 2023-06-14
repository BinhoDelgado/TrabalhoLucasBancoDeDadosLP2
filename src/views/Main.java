package views;
import java.util.List;
import java.util.Scanner;

import models.VendaDAO;
import models.VendaDAOMySQL;
import models.VendaPecaDAO;
import models.VendaPecaDAOMySQL;

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
        } while (opcao != 
