package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;

public class TelaCliente extends JFrame {

    private static final long serialVersionUID = 1L;
	private JLabel lblId;
    private JLabel lblNome;
    private JLabel lblSobrenome;
    private JLabel lblNomemae;
    private JLabel lblNomepai;
    private JLabel lblCpf;
    private JLabel lblDatanascimento;
    private JLabel lblEndereco;
    private JLabel lblCep;

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtNomemae;
    private JTextField txtNomepai;
    private JTextField txtCpf;
    private JTextField txtDatanascimento;
    private JTextField txtEndereco;
    private JTextField txtCep;

    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnLimpar;

    private JTable tabelaClientes;
    private DefaultTableModel modeloTabela;

    private ClienteController controller;

    public TelaCliente() {
        setTitle("Cadastro de Clientes - Java SE 7 + Swing + MySQL");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        criarComponentes();

        controller = new ClienteController(this);
        configurarEventos();
        controller.carregarTabela();
    }

    private void criarComponentes() {
        JPanel painelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Cliente"));

        lblId = new JLabel("Id:");
        txtId = new JTextField();
        txtId.setEditable(false);

        lblNome = new JLabel("Nome:");
        txtNome = new JTextField();

        lblSobrenome = new JLabel("Sobrenome:");
        txtSobrenome = new JTextField();

        painelFormulario.add(lblId);
        painelFormulario.add(txtId);
        painelFormulario.add(lblNome);
        painelFormulario.add(txtNome);
        painelFormulario.add(lblSobrenome);
        painelFormulario.add(txtSobrenome);
        painelFormulario.add(lblNomemae);
        painelFormulario.add(txtNomemae);
        painelFormulario.add(lblNomepai);
        painelFormulario.add(txtNomepai);
        painelFormulario.add(lblCpf);
        painelFormulario.add(txtCpf);
        painelFormulario.add(lblDatanascimento);
        painelFormulario.add(txtDatanascimento);
        painelFormulario.add(lblEndereco);
        painelFormulario.add(txtEndereco);
        painelFormulario.add(lblCep);
        painelFormulario.add(txtCep);

        add(painelFormulario, BorderLayout.NORTH);

        modeloTabela = new DefaultTableModel(new Object[] { "Id", "Nome", "Sobrenome", "Nomemae", "Nomepai", "Cpf", "Datanascimento", "Endereco", "Cep"}, 0) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaClientes = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaClientes);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
        add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnNovo = new JButton("Novo");
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnLimpar);

        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void configurarEventos() {
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.limpar();
            }
        });

        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.salvar();
            }
        });

        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.excluir();
            }
        });

        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                controller.limpar();
            }
        });

        tabelaClientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                controller.preencherFormulario();
            }
        });
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtSobrenome() {
        return txtSobrenome;
    }

    public JTextField getTxtNomemae() {
        return txtNomemae;
    }

    public JTextField getTxtNomepai() {
        return txtNomepai;
    }

    public JTextField getTxtCpf() {
        return txtCpf;
    }

    public JTextField getTxtDatanascimento() {
        return txtDatanascimento;
    }

    public JTextField getTxtEndereco() {
        return txtEndereco;
    }

    public JTextField getTxtCep() {
        return txtCep;
    }

    public JTable getTabelaClientes() {
        return tabelaClientes;
    }
}