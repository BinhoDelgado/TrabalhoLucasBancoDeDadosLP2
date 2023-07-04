package models;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaPecaDAOMySQL implements VendaPecaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/trabalholucasfinal";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    @Override
    public void cadastrar(VendaPeca vendaPeca) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO venda_peca (nome_peca, valor, quantidade) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, vendaPeca.getNomePeca());
            statement.setDouble(2, vendaPeca.getValor());
            statement.setInt(3, vendaPeca.getQuantidade());
            statement.executeUpdate();
            statement.close();
            System.out.println("Venda de peca cadastrada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar venda de peca: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(VendaPeca vendaPeca) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE venda_peca SET nome_peca = ?, valor = ?, quantidade = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, vendaPeca.getNomePeca());
            statement.setDouble(2, vendaPeca.getValor());
            statement.setInt(3, vendaPeca.getQuantidade());
            statement.setInt(4, vendaPeca.getId());
            statement.executeUpdate();
            statement.close();
            System.out.println("Venda de peca atualizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar venda de peca: " + e.getMessage());
        }
    }

    @Override
    public void excluir(int vendaPecaId) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM venda_peca WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, vendaPecaId);
            statement.executeUpdate();
            statement.close();
            System.out.println("Venda de peca exclui�da com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir venda de peça: " + e.getMessage());
        }
    }

    @Override
    public VendaPeca buscar(int vendaPecaId) {
        VendaPeca vendaPeca = null;
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM venda_peca WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, vendaPecaId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                vendaPeca = new VendaPeca(
                    resultSet.getString("nome_peca"),
                    resultSet.getDouble("valor"),
                    resultSet.getInt("quantidade")
                );
                vendaPeca.setId(resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar venda de peca: " + e.getMessage());
        }
        return vendaPeca;
    }

    @Override
    public List<VendaPeca> listar() {
        List<VendaPeca> vendaPecas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM venda_peca";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                VendaPeca vendaPeca = new VendaPeca(
                    resultSet.getString("nome_peca"),
                    resultSet.getDouble("valor"),
                    resultSet.getInt("quantidade")
                );
                vendaPeca.setId(resultSet.getInt("id"));
                vendaPecas.add(vendaPeca);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar vendas de pecas: " + e.getMessage());
        }
        return vendaPecas;
    }
}
