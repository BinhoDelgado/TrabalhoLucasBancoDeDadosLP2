package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAOMySQL implements VendaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/trabalholucasfinal";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    @Override
    public void cadastrar(Venda venda) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO venda (id) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, venda.getId());
            statement.executeUpdate();
            statement.close();
            System.out.println("Venda cadastrada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar venda: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Venda venda) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "UPDATE venda SET id = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, venda.getId());
            statement.setInt(2, venda.getId());
            statement.executeUpdate();
            statement.close();
            System.out.println("Venda atualizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar venda: " + e.getMessage());
        }
    }

    @Override
    public void excluir(int vendaId) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "DELETE FROM venda WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, vendaId);
            statement.executeUpdate();
            statement.close();
            System.out.println("Venda exclui�da com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir venda: " + e.getMessage());
        }
    }

    @Override
    public Venda buscar(int vendaId) {
        Venda venda = null;
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM venda WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, vendaId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                venda = new Venda(resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar venda: " + e.getMessage());
        }
        return venda;
    }

    @Override
    public List<Venda> listar() {
        List<Venda> vendas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT * FROM venda";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Venda venda = new Venda(resultSet.getInt("id"));
                vendas.add(venda);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar vendas: " + e.getMessage());
        }
        return vendas;
    }
}
