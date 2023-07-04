package models;

public class VendaPeca {
    private String nomePeca;
    private double valor;
    private int quantidade;
    private int id;

    public VendaPeca(String nomePeca, double valor, int quantidade) {
        this.nomePeca = nomePeca;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
