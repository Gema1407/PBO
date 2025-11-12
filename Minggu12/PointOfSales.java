package Minggu12;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PointOfSales extends JFrame {

    private DefaultTableModel productTableModel;
    private DefaultTableModel cartTableModel;

    private JTable productTable;
    private JLabel selectedProductLabel;
    private JTextField qtyField;
    private JButton addToCartButton;
    private JLabel totalValueLabel;
    private JLabel pointsValueLabel;
    private JButton checkoutButton;
    private JButton printButton;
    private JTextArea receiptArea;

    private double currentTotal = 0.0;
    private int currentPoints = 0;
    private NumberFormat currencyFormat = new DecimalFormat("Rp#,##0.00");
    private NumberFormat numberFormat = new DecimalFormat("#,##0");
    private static final String RECEIPT_SEPARATOR = "========================================";
    private static final String RECEIPT_DIVIDER = "----------------------------------------";

    public PointOfSales() {
        setTitle("POIN Off-Sales - Java Swing");
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2, 10, 10));

        setupMenuBar();

        JPanel leftPanel = setupLeftPanel();

        add(leftPanel);

        JPanel rightPanel = setupRightPanel();
        add(rightPanel);

        loadInitialProducts();

        setupEventListeners();
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    private JPanel setupLeftPanel() {
        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        String[] productColumns = { "ID", "Nama Produk", "Harga (Rp)" };
        productTableModel = new DefaultTableModel(productColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        productTable = new JTable(productTableModel);
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane productScrollPane = new JScrollPane(productTable);
        productScrollPane.setBorder(new TitledBorder("Produk"));
        leftPanel.add(productScrollPane, BorderLayout.CENTER);

        JPanel addToCartPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        selectedProductLabel = new JLabel("Pilih produk dari tabel di atas");
        addToCartPanel.add(selectedProductLabel);

        JLabel qtyLabel = new JLabel("Qty:");
        addToCartPanel.add(qtyLabel);

        qtyField = new JTextField("1", 3);
        addToCartPanel.add(qtyField);

        addToCartButton = new JButton("Add to Cart");
        addToCartPanel.add(addToCartButton);

        leftPanel.add(addToCartPanel, BorderLayout.SOUTH);

        return leftPanel;
    }

    private JPanel setupRightPanel() {
        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));
        rightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        String[] cartColumns = { "ID", "Nama Produk", "Qty", "Harga", "Subtotal" };
        cartTableModel = new DefaultTableModel(cartColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable cartTable = new JTable(cartTableModel);

        JScrollPane cartScrollPane = new JScrollPane(cartTable);
        cartScrollPane.setBorder(new TitledBorder("Keranjang"));
        rightPanel.add(cartScrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));

        JPanel summaryPanel = new JPanel(new GridBagLayout());
        summaryPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        summaryPanel.add(new JLabel("Total:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        totalValueLabel = new JLabel(currencyFormat.format(0));
        totalValueLabel.setFont(totalValueLabel.getFont().deriveFont(Font.BOLD, 16f));
        summaryPanel.add(totalValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        summaryPanel.add(new JLabel("Points:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        pointsValueLabel = new JLabel("0");
        pointsValueLabel.setFont(pointsValueLabel.getFont().deriveFont(Font.BOLD, 14f));
        summaryPanel.add(pointsValueLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        checkoutButton = new JButton("Checkout");
        checkoutButton.setPreferredSize(new Dimension(100, 50));
        summaryPanel.add(checkoutButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        printButton = new JButton("Cetak");
        printButton.setPreferredSize(new Dimension(100, 50));
        summaryPanel.add(printButton, gbc);

        bottomPanel.add(summaryPanel, BorderLayout.NORTH);

        receiptArea = new JTextArea(15, 30);
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane receiptScrollPane = new JScrollPane(receiptArea);
        receiptScrollPane.setBorder(new TitledBorder("Struk"));

        bottomPanel.add(receiptScrollPane, BorderLayout.CENTER);

        rightPanel.add(bottomPanel, BorderLayout.SOUTH);
        return rightPanel;
    }

    private void loadInitialProducts() {
        productTableModel.addRow(new Object[] { "P001", "Air Mineral 600ml", 3000.0 });
        productTableModel.addRow(new Object[] { "P002", "Kopi Sachet", 5000.0 });
        productTableModel.addRow(new Object[] { "P003", "Roti Isi", 8000.0 });
        productTableModel.addRow(new Object[] { "P004", "Snack Keripik", 6000.0 });
        productTableModel.addRow(new Object[] { "P005", "Minuman Botol", 12000.0 });
    }

    private void setupEventListeners() {
        productTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && productTable.getSelectedRow() != -1) {
                int selectedRow = productTable.getSelectedRow();
                String id = productTableModel.getValueAt(selectedRow, 0).toString();
                String name = productTableModel.getValueAt(selectedRow, 1).toString();
                double price = (Double) productTableModel.getValueAt(selectedRow, 2);

                selectedProductLabel.setText(String.format(
                        "Dipilih: %s - %s (%s)",
                        id, name, currencyFormat.format(price)));
            }
        });

        addToCartButton.addActionListener(e -> actionAddToCart());

        checkoutButton.addActionListener(e -> actionCheckout());

        printButton.addActionListener(e -> actionPrintReceipt());
    }

    private void actionAddToCart() {
        int selectedRow = productTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Silakan pilih produk terlebih dahulu.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int qty;
        try {
            qty = Integer.parseInt(qtyField.getText());
            if (qty <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Kuantitas (Qty) tidak valid. Harap masukkan angka lebih dari 0.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            qtyField.setText("1");
            return;
        }

        String id = productTableModel.getValueAt(selectedRow, 0).toString();
        String name = productTableModel.getValueAt(selectedRow, 1).toString();
        double price = (Double) productTableModel.getValueAt(selectedRow, 2);
        double subtotal = price * qty;

        boolean itemExists = false;
        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            if (cartTableModel.getValueAt(i, 0).equals(id)) {
                int existingQty = (Integer) cartTableModel.getValueAt(i, 2);
                double existingSubtotal = (Double) cartTableModel.getValueAt(i, 4);

                int newQty = existingQty + qty;
                double newSubtotal = existingSubtotal + subtotal;

                cartTableModel.setValueAt(newQty, i, 2);
                cartTableModel.setValueAt(newSubtotal, i, 4);
                itemExists = true;
                break;
            }
        }

        if (!itemExists) {
            cartTableModel.addRow(new Object[] { id, name, qty, price, subtotal });
        }

        updateTotal();

        productTable.clearSelection();
        selectedProductLabel.setText("Pilih produk dari tabel di atas");
        qtyField.setText("1");
    }

    private void actionCheckout() {
        if (cartTableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Keranjang belanja masih kosong.",
                    "Checkout Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder receiptBuilder = new StringBuilder();
        String nl = System.lineSeparator();
        receiptBuilder.append(RECEIPT_SEPARATOR).append(nl);
        receiptBuilder.append("          POIN OFF-SALES").append(nl);
        receiptBuilder.append(RECEIPT_SEPARATOR).append(nl).append(nl);

        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            String name = cartTableModel.getValueAt(i, 1).toString();
            int qty = (Integer) cartTableModel.getValueAt(i, 2);
            double price = (Double) cartTableModel.getValueAt(i, 3);
            double subtotal = (Double) cartTableModel.getValueAt(i, 4);

            receiptBuilder.append(String.format("%s%n", name));
            receiptBuilder.append(String.format("  %d x %s = %s%n",
                    qty, numberFormat.format(price), numberFormat.format(subtotal)));
        }

        receiptBuilder.append(RECEIPT_DIVIDER).append(nl);
        receiptBuilder.append(String.format("TOTAL: %s%n", currencyFormat.format(currentTotal)));
        receiptBuilder.append(String.format("POINTS DIDAPAT: %d%n", currentPoints));
        receiptBuilder.append(String.format("(1 point per Rp 1000)%n"));
        receiptBuilder.append(RECEIPT_DIVIDER).append(nl);
        receiptBuilder.append("   Terima kasih! Silakan kunjungi kembali.").append(nl);
        receiptBuilder.append(RECEIPT_SEPARATOR).append(nl);

        receiptArea.setText(receiptBuilder.toString());

        cartTableModel.setRowCount(0);

        updateTotal();
    }

    private void actionPrintReceipt() {
        if (receiptArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Struk masih kosong. Silakan Checkout terlebih dahulu.",
                    "Cetak Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            boolean complete = receiptArea.print();
            if (complete) {
                JOptionPane.showMessageDialog(this,
                        "Struk berhasil dikirim ke printer.",
                        "Cetak Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Proses cetak dibatalkan.",
                        "Cetak Dibatalkan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal mencetak struk: " + ex.getMessage(),
                    "Error Cetak", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTotal() {
        currentTotal = 0.0;

        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            currentTotal += (Double) cartTableModel.getValueAt(i, 4);
        }

        currentPoints = (int) (currentTotal / 1000);

        totalValueLabel.setText(currencyFormat.format(currentTotal));
        pointsValueLabel.setText(String.valueOf(currentPoints));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PointOfSales().setVisible(true));
    }
}