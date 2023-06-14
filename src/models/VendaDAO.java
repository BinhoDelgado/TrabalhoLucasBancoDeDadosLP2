package models;

import java.util.List;

public interface VendaDAO {
    void cadastrar(Venda venda);
    void atualizar(Venda venda);
    void excluir(int vendaId);
    Venda buscar(int vendaId);
    List<Venda> listar();
}
