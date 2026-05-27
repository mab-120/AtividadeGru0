package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import util.Conexao;

public class ClienteDAO {

    public void salvar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "insert into cliente (id, nome, sobrenome, nomemae, nomepai, cpf, datanascimento, endereco, cep) values (?,?,?,?,?,?,?,?,?)";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getNomemae());
            stmt.setString(4, cliente.getNomepai());
            stmt.setString(5, cliente.getCpf());
            stmt.setDate(6, java.sql.Date.valueOf(cliente.getDatanascimento()));
            stmt.setString(7, cliente.getEndereco());
            stmt.setString(8, cliente.getCep());
            stmt.executeUpdate();
        } 
        
        catch (Exception e) {
            throw new RuntimeException("Houve um erro ao salvar cliente: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        
    }
        public void excluir(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "DELETE FROM cliente where id = ?";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } 
        
        catch (Exception e) {
            throw new RuntimeException("Houve um erro ao excluir cliente: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (Exception e) {
                    e.printStackTrace();
            }
            }
        
    }

    public void atualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE cliente SET nome = ?, sobrenome = ?, nomemae = ?, nomepai = ?, cpf = ?, datanascimento = ?, endereco = ?, cep = ? WHERE id = ?";

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getNomemae());
            stmt.setString(4, cliente.getNomepai());
            stmt.setString(5, cliente.getCpf());
            stmt.setDate(6, java.sql.Date.valueOf(cliente.getDatanascimento()));
            stmt.setString(7, cliente.getEndereco());
            stmt.setString(8, cliente.getCep());
            stmt.setInt(9, cliente.getId());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage());
        } finally {
            
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT id, nome, sobrenome, nomemae, nomepai, cpf, datanascimento, endereco, cep FROM cliente order by id DESC";


        try {

            conn = Conexao.conectar();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            
            while (rs.next() ) {

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setNomemae(rs.getString("nomemae"));
                cliente.setNomepai(rs.getString("nomepai"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDatanascimento(rs.getDate("datanascimento").toLocalDate());
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCep(rs.getString("cep"));

                lista.add(cliente);

            }

        } catch (Exception e) {
            throw new RuntimeException("Houve um erro ao listar clientes: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                    e.printStackTrace();
            }
            
        }
        return lista;
    }
    
}

