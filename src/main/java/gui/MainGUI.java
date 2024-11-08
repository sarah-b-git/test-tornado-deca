package gui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import common.Competitor;
import decathlon.*;
import excel.ExcelPrinter;
import heptathlon.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class MainGUI {

    private JTextField nameField;
    private JTextField resultField;
    private JComboBox<String> disciplineBox;
    private JTextArea outputArea;

    private JTable competitorTable;
    private DefaultTableModel tableModel;
    private ArrayList<Competitor> competitors = new ArrayList<>();

    public static void main(String[] args) {
        new MainGUI().createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Track and Field Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(6, 1));

        // Input for competitor's name
        nameField = new JTextField(20);
        panel.add(new JLabel("Enter Competitor's Name (max 40 competitors):"));
        panel.add(nameField);

        // Dropdown for selecting discipline
        String[] disciplines = {"Deca 100m", "Deca 400m", "Deca 1500m", "Deca 110m Hurdles", "Deca Long Jump", "Deca High Jump", "Deca Pole Vault", "Deca Discus Throw", "Deca Javelin Throw", "Deca Shot Put", "Hep 200m", "Hep 800m", "Hep 100m Hurdles", "Hep High Jump", "Hep Long Jump", "Hep Shot Put", "Hep Javelin Throw"};
        disciplineBox = new JComboBox<>(disciplines);
        panel.add(new JLabel("Select Discipline:"));
        panel.add(disciplineBox);

        // Input for result
        resultField = new JTextField(10);
        panel.add(new JLabel("Enter Result:"));
        panel.add(resultField);

        // Button to calculate and display result
        JButton calculateButton = new JButton("Calculate Score");
        calculateButton.addActionListener(new CalculateButtonListener());
        panel.add(calculateButton);

        JButton exportButton = new JButton("Export to Excel");
        exportButton.addActionListener(new ExportButtonListener());  // New export button listener
        panel.add(exportButton);  // Add export button to the panel

        // Tooltips for input fields and buttons
        nameField.setToolTipText("Enter a valid name for the competitor");
        resultField.setToolTipText("Enter a valid result in numbers for the selected discipline");


        // Output area
        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane);

        String[] columnNames = {"Name", "100m", "400m", "1500m", "110m Hurdles",
                "Long Jump", "High Jump", "Pole Vault",
                "Discus Throw", "Javelin Throw", "Shot Put",
                "Hep 100M Hurdles", "Hep 200M", "Hep 800M", "Hep High Jump",
                "Hep Javelin Throw", "Hep Long Jump", "Hep Shot Put", "Total Score"};

        tableModel = new DefaultTableModel(columnNames, 0);
        competitorTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(competitorTable);
        tableScrollPane.setPreferredSize(new Dimension(750, 200));

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);  // Top panel with inputs
        frame.add(tableScrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String name = nameField.getText();
            Competitor competitor = findCompetitorByName(name);
            if (competitor == null) {
                competitor = new Competitor(name);  // Create a new competitor
                competitors.add(competitor);
            }
            int score;
            double result;
            if (competitors.size() < 40) {

                String discipline = (String) disciplineBox.getSelectedItem();
                String resultText = resultField.getText();

                try {
                    result = Double.parseDouble(resultText);
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid name for the competitor", "Invalid Name", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the method if name is empty or doesn't start with an uppercase letter
                    }
                    score = switch (discipline) {
                        case "Deca 100m" -> {
                            Deca100M deca100M = new Deca100M();
                            yield deca100M.calculateResult(result);
                        }
                        case "Deca 400m" -> {
                            Deca400M deca400M = new Deca400M();
                            yield deca400M.calculateResult(result);
                        }
                        case "Deca 1500m" -> {
                            Deca1500M deca1500M = new Deca1500M();
                            yield deca1500M.calculateResult(result);
                        }
                        case "Deca 110m Hurdles" -> {
                            Deca110MHurdles deca110MHurdles = new Deca110MHurdles();
                            yield deca110MHurdles.calculateResult(result);
                        }
                        case "Deca Long Jump" -> {
                            DecaLongJump decaLongJump = new DecaLongJump();
                            yield decaLongJump.calculateResult(result);
                        }
                        case "Deca High Jump" -> {
                            DecaHighJump decaHighJump = new DecaHighJump();
                            yield decaHighJump.calculateResult(result);
                        }
                        case "Deca Pole Vault" -> {
                            DecaPoleVault decaPoleVault = new DecaPoleVault();
                            yield decaPoleVault.calculateResult(result);
                        }
                        case "Deca Discus Throw" -> {
                            DecaDiscusThrow decaDiscusThrow = new DecaDiscusThrow();
                            yield decaDiscusThrow.calculateResult(result);
                        }
                        case "Deca Javelin Throw" -> {
                            DecaJavelinThrow decaJavelinThrow = new DecaJavelinThrow();
                            yield decaJavelinThrow.calculateResult(result);
                        }
                        case "Deca Shot Put" -> {
                            DecaShotPut decaShotPut = new DecaShotPut();
                            yield decaShotPut.calculateResult(result);
                        }
                        case "Hep 200m" -> {
                            Hep200M hep200m = new Hep200M();
                            yield hep200m.calculateResult(result);
                        }
                        case "Hep 800m" -> {
                            Hep800M hep800m = new Hep800M();
                            yield hep800m.calculateResult(result);
                        }
                        case "Hep 100m Hurdles" -> {
                            Hep100MHurdles hep100MHurdles = new Hep100MHurdles();
                            yield hep100MHurdles.calculateResult(result);
                        }
                        case "Hep High Jump" -> {
                            HeptHighJump hepHighJump = new HeptHighJump();
                            yield hepHighJump.calculateResult(result);
                        }
                        case "Hep Long Jump" -> {
                            HeptLongJump heptLongJump = new HeptLongJump();
                            yield heptLongJump.calculateResult(result);
                        }
                        case "Hep Shot Put" -> {
                            HeptShotPut hepShotPut = new HeptShotPut();
                            yield hepShotPut.calculateResult(result);
                        }
                        case "Hep Javelin Throw" -> {
                            HeptJavelinThrow heptJavelinThrow = new HeptJavelinThrow();
                            yield heptJavelinThrow.calculateResult(result);
                        }
                        default -> 0;
                    };


                    // Update the competitor's score for the selected discipline
                    competitor.setScore(discipline, score);

                    outputArea.append("Competitor: " + name + "\n");
                    outputArea.append("Discipline: " + discipline + "\n");
                    outputArea.append("Result: " + result + "\n");
                    outputArea.append("Score: " + score + "\n\n");
                    tableModel.addRow(competitor.getRowData());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for the result.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } catch (InvalidResultException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Result", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                showMessageDialog(null, "Limit reached: You can only add up to 40 competitors.");
            }// Add to the list
        }
    }

    private class ExportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                exportToExcel();
                showMessageDialog(null, "Results exported successfully!", "Export Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                showMessageDialog(null, "Failed to export results to Excel.", "Export Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void exportToExcel() throws IOException {
        String[][] data = new String[competitors.size()][];
        int i = 0;
        for (Competitor competitor : competitors) {
            Object[] rowData = competitor.getRowData(); // Get the competitor's row data

            // Ensure the array size matches the number of columns in rowData
            data[i] = new String[rowData.length];

            // Safely copy rowData to data array
            for (int j = 0; j < rowData.length; j++) {
                data[i][j] = (rowData[j] != null) ? rowData[j].toString() : "";  // Handle null values
            }
            i++;
        }

        ExcelPrinter printer = new ExcelPrinter("TrackAndFieldResults");
        printer.add(data, "Results");
        printer.write();
    }

    private Competitor findCompetitorByName(String name) {
        for (Competitor competitor : competitors) {
            if (competitor.getName().equalsIgnoreCase(name)) {
                return competitor;
            }
        }
        return null;  // If not found, return null
    }

}
