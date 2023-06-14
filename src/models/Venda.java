package models;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int id;
    private List<VendaPeca> vendaPecas;

    public Venda(int id) {
        this.id = id;
        this.vendaPecas = new ArrayList<>();
    }

    public Venda(int id, List<VendaPeca> vendaPecas) {
        this.id = id;
        this.vendaPecas = vendaPecas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<VendaPeca> getVendaPecas() {
        return vendaPecas;
    }

    public void setVendaPecas(List<VendaPeca> vendaPecas) {
        this.vendaPecas = vendaPecas;
    }
}
