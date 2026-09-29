package form;

//import java.awt.*;
//import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




import modelDominio.Te220ite;
import tableModel.TE220iteTableModel;
import util.Configuracao;
import view.ChamarDeposito;

public class FormEsto extends JPanel {

    private TE220iteTableModel Te220iteModel;
    private JTable Table;
    private TableRowSorter<TableModel> sorter;

    private JComboBox<String> cbDeposito;
    private JTextField txtProduto;
    private JButton btnLimparProduto;
    private JButton btnExportar;

    public static String datainv;
    Configuracao arquivo = new Configuracao();

    public FormEsto() {
        setLayout(new BorderLayout());
        setOpaque(false);

        Table = new JTable();
        JScrollPane scroll = new JScrollPane(Table);

        JPanel panelFiltros = criarPainelFiltros();

        add(panelFiltros, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        atualizaTabela();
    }

    // ================== PAINEL DE FILTROS ==================
    private JPanel criarPainelFiltros() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Filtros"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;

        // Deposito
        gbc.gridx = 0;
        panel.add(new JLabel("Deposito:"), gbc);

        gbc.gridx = 1;
        cbDeposito = new JComboBox<>();
        cbDeposito.addItem("Todos");
        cbDeposito.addActionListener(e -> aplicarFiltros());
        panel.add(cbDeposito, gbc);

        // Produto
        gbc.gridx = 2;
        panel.add(new JLabel("Produto:"), gbc);

        gbc.gridx = 3;
        gbc.weightx = 1;
        txtProduto = new JTextField(20);
        txtProduto.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { aplicarFiltros(); }
            @Override public void removeUpdate(DocumentEvent e) { aplicarFiltros(); }
            @Override public void changedUpdate(DocumentEvent e) { aplicarFiltros(); }
        });
        panel.add(txtProduto, gbc);

        gbc.gridx = 4;
        gbc.weightx = 0;
        btnLimparProduto = new JButton("❌");
        btnLimparProduto.addActionListener(e -> txtProduto.setText(""));
        panel.add(btnLimparProduto, gbc);

        // Exportar
        gbc.gridx = 5;
        btnExportar = new JButton("Exportar Excel");
        btnExportar.addActionListener(e -> exportarParaExcel());
        panel.add(btnExportar, gbc);

        return panel;
    }

    // ================== TABELA ==================
    private void atualizaTabela() {
        try {
            datainv = arquivo.GetProp("datainv", "N");

            ArrayList<Te220ite> lista =
                    ChamarDeposito.ccont.ListaTe220ite(datainv, "todos");

            Te220iteModel = new TE220iteTableModel(lista);
            Table.setModel(Te220iteModel);

            sorter = new TableRowSorter<>(Te220iteModel);
            Table.setRowSorter(sorter);

            ajustarLarguraColunas();
            atualizarListaDepositos(lista);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar dados: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void aplicarFiltros() {
        if (sorter == null) return;

        List<RowFilter<Object, Object>> filtros = new ArrayList<>();

        String deposito = (String) cbDeposito.getSelectedItem();
        if (deposito != null && !"Todos".equals(deposito)) {
            filtros.add(RowFilter.regexFilter("(?i)" + deposito, 1));
        }

        String produto = txtProduto.getText().trim();
        if (!produto.isEmpty()) {
            filtros.add(RowFilter.regexFilter("(?i)" + produto, 2));
        }

        sorter.setRowFilter(
                filtros.isEmpty() ? null : RowFilter.andFilter(filtros)
        );
    }

    private void atualizarListaDepositos(ArrayList<Te220ite> lista) {
        Set<String> set = new TreeSet<>();
        for (Te220ite t : lista) {
            if (t.getCoddep() != null && !t.getCoddep().isEmpty()) {
                set.add(t.getCoddep());
            }
        }

        cbDeposito.removeAllItems();
        cbDeposito.addItem("Todos");
        set.forEach(cbDeposito::addItem);
    }

    private void ajustarLarguraColunas() {
        TableColumnModel cm = Table.getColumnModel();
        for (int i = 0; i < cm.getColumnCount(); i++) {
            int width = 80;
            for (int r = 0; r < Table.getRowCount(); r++) {
                Component c = Table.prepareRenderer(
                        Table.getCellRenderer(r, i), r, i);
                width = Math.max(width, c.getPreferredSize().width + 10);
            }
            cm.getColumn(i).setPreferredWidth(width);
        }
    }

    // ================== EXPORTAÇÃO EXCEL ==================
    private void exportarParaExcel() {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("estoque.xlsx"));

        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Estoque");
            TableModel model = Table.getModel();

            // Cabeçalho
            Row header = sheet.createRow(0);
            for (int c = 0; c < model.getColumnCount(); c++) {
                header.createCell(c).setCellValue(model.getColumnName(c));
            }

            // Dados visíveis
            int rowIdx = 1;
            for (int r = 0; r < Table.getRowCount(); r++) {
                Row row = sheet.createRow(rowIdx++);
                for (int c = 0; c < model.getColumnCount(); c++) {
                    Object val = Table.getValueAt(r, c);
                    row.createCell(c).setCellValue(val == null ? "" : val.toString());
                }
            }

            for (int c = 0; c < model.getColumnCount(); c++) {
                sheet.autoSizeColumn(c);
            }

            try (FileOutputStream fos =
                         new FileOutputStream(chooser.getSelectedFile())) {
                wb.write(fos);
            }

            JOptionPane.showMessageDialog(this,
                    "Exportado com sucesso!",
                    "Excel",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao exportar: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ================== MAIN ==================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Estoque");
            f.setSize(900, 500);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setContentPane(new FormEsto());
            f.setVisible(true);
        });
    }
}
