package controller;

import java.util.List;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import java.time.LocalDate;

import dao.ClienteDAO;
import model.Cliente;
import view.TelaCliente;

public class ClienteController {
    
    private TelaCliente tela;
    private ClienteDAO clienteDAO;

    public ClienteController(TelaCliente tela) {
        this.tela = tela;
        this.clienteDAO = new ClienteDAO();
    }

    public void salvar() {
        String nome = tela.getTxtNome().getText().trim();
        String sobrenome = tela.getTxtSobrenome().getText().trim();
        String nomemae = tela.getTxtNomemae().getText().trim();
        String nomepai = tela.getTxtNomepai().getText().trim();
        String cpf = tela.getTxtCpf().getText().trim();
        String dataTexto = tela.getTxtDatanascimento().getText().trim();
        String endereco = tela.getTxtEndereco().getText().trim();
        String cep = tela.getTxtCep().getText().trim();

        LocalDate datanascimento = LocalDate.parse(dataTexto);

        if (nome.isEmpty() || sobrenome.isEmpty() || nomemae.isEmpty() || cpf.isEmpty() || dataTexto.isEmpty()|| endereco.isEmpty() || cep.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Preencha todos os campos (exceto pai)", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
        }

        try {
            String idTexto = tela.getTxtId().getText().trim();

            if (idTexto.isEmpty()) {
                Cliente cliente = new Cliente(nome, sobrenome, nomemae, nomepai, cpf,  datanascimento, endereco, cep);

                clienteDAO.salvar(cliente);
                JOptionPane.showMessageDialog(tela, "Cliente salvo com sucesso");

            } else {
                Cliente cliente = new Cliente(Integer.parseInt(idTexto), nome, sobrenome, nomemae, nomepai, cpf, datanascimento, endereco, cep);
                clienteDAO.atualizar(cliente);

                JOptionPane.showMessageDialog(tela, "Cliente atualizado com sucesso.");
            }

            limpar();
            carregarTabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Erro ao salvar." + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE );

        }
    }

    public void excluir() {
        int linha = tela.getTabelaClientes().getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione um cliente para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(tela, "Deseja realmente excluir o cliente selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
        if (confirmacao != JOptionPane.YES_NO_OPTION) {
            return;
        }

        try {
            int id = Integer.parseInt(tela.getTxtId().getText());
            clienteDAO.excluir(id);
            JOptionPane.showMessageDialog(tela, "Cliente excluído!");
            limpar();
            carregarTabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Erro ao excluir." + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE );
        }
    }

   

     public void limpar() {
        tela.getTxtId().setText("");
        tela.getTxtNome().setText("");
        tela.getTxtSobrenome().setText("");
        tela.getTxtNomemae().setText("");
        tela.getTxtNomepai().setText("");
        tela.getTxtCpf().setText("");
        tela.getTxtDatanascimento().setText("");
        tela.getTxtEndereco().setText("");
        tela.getTxtCep().setText("");
        tela.getTxtNome().requestFocus();
        tela.getTabelaClientes().clearSelection();
    }
     public void carregarTabela() {
         DefaultTableModel modelo = (DefaultTableModel) tela.getTabelaClientes().getModel();
         modelo.setRowCount(0);

         try {
            List<Cliente> clientes = clienteDAO.listar();
            int i;
            for (i = 0; i < clientes.size(); i++) {
                Cliente c = clientes.get (i);
                modelo.addRow(new Object[] {
                    c.getId(),
                    c.getNome(),
                    c.getSobrenome(),
                    c.getNomemae(),
                    c.getNomepai(),
                    c.getCpf(),
                    c.getDatanascimento(),
                    c.getEndereco(),
                    c.getCep()
                });
            }
         } catch (Exception e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro ao carregar tabela: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
         }
    }
    
    public void preencherFormulario() {
        int linha = tela.getTabelaClientes().getSelectedRow();

        if (linha != -1) {
            tela.getTxtId().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getTxtNome().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getTxtSobrenome().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getTxtNomemae().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getTxtNomepai().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getTxtCpf().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getTxtDatanascimento().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getTxtEndereco().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
            tela.getTxtCep().setText(tela.getTabelaClientes().getValueAt(linha, 0).toString());
        }
    }
}
