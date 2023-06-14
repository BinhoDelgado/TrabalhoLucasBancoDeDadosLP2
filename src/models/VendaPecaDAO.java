package models;

import java.util.List;

public interface VendaPecaDAO {
    void cadastrar(VendaPeca vendaPeca);
    void atualizar(VendaPeca vendaPeca);
    void excluir(int vendaPecaId);
    VendaPeca buscar(int vendaPecaId);
    List<VendaPeca> listar();
}
