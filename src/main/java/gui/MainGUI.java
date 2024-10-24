package gui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import common.Competitor;
import decathlon.*;
import excel.ExcelPrinter;
import heptathlon.*;



public class MainGUI {

    private JTextField nameField;
    private JTextField resultField;
    private JComboBox<String> disciplineBox;
    private JTextArea outputArea;

    private ArrayList<Competitor> competitors = new ArrayList<>();
    public static void main(String[] args) {
        new MainGUI().createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Track and Field Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(6, 1));

        // Input for competitor's name
        nameField = new JTextField(20);
        panel.add(new JLabel("Enter Competitor's Name:"));
        panel.add(nameField);

        // Dropdown for selecting discipline
        String[] disciplines = {
                "Deca 100m", "Deca 400m", "Deca 1500m", "Deca 110m Hurdles",
                "Deca Long Jump", "Deca High Jump", "Deca Pole Vault",
                "Deca Discus Throw", "Deca Javelin Throw", "Deca Shot Put",
                "Hep 200m", "Hep 800m", "Hep 100m Hurdles",
                "Hep High Jump", "Hep Long Jump", "Hep Shot Put",
                "Hep Javelin Throw"
        };
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

        // Output area
        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String discipline = (String) disciplineBox.getSelectedItem();
            String resultText = resultField.getText();

            try {
                double result = Double.parseDouble(resultText);

                int score = 0;
                switch (discipline) {
                    case "Deca 100m":
                        Deca100M deca100M = new Deca100M();
                        score = deca100M.calculateResult(result);
                        break;
                    case "Deca 400m":
                        Deca400M deca400M = new Deca400M();
                        score = deca400M.calculateResult(result);
                        break;
                    case "Deca 1500m":
                        Deca1500M deca1500M = new Deca1500M();
                        score = deca1500M.calculateResult(result);
                        break;
                    case "Deca 110m Hurdles":
                        Deca110MHurdles deca110MHurdles = new Deca110MHurdles();
                        score = deca110MHurdles.calculateResult(result);
                        break;
                    case "Deca Long Jump":
                        DecaLongJump decaLongJump = new DecaLongJump();
                        score = decaLongJump.calculateResult(result);
                        break;
                    case "Deca High Jump":
                        DecaHighJump decaHighJump = new DecaHighJump();
                        score = decaHighJump.calculateResult(result);
                        break;
                    case "Deca Pole Vault":
                        DecaPoleVault decaPoleVault = new DecaPoleVault();
                        score = decaPoleVault.calculateResult(result);
                        break;
                    case "Deca Discus Throw":
                        DecaDiscusThrow decaDiscusThrow = new DecaDiscusThrow();
                        score = decaDiscusThrow.calculateResult(result);
                        break;
                    case "Deca Javelin Throw":
                        DecaJavelinThrow decaJavelinThrow = new DecaJavelinThrow();
                        score = decaJavelinThrow.calculateResult(result);
                        break;
                    case "Deca Shot Put":
                        DecaShotPut decaShotPut = new DecaShotPut();
                        score = decaShotPut.calculateResult(result);
                        break;
                    case "Hep 200m":
                        Hep200M hep200m = new Hep200M();
                        score = hep200m.calculateResult(result);
                        break;
                    case "Hep 800m":
                        Hep800M hep800m = new Hep800M();
                        score = hep800m.calculateResult(result);
                        break;
                    case "Hep 100m Hurdles":
                        Hep100MHurdles hep100MHurdles = new Hep100MHurdles();
                        score = hep100MHurdles.calculateResult(result);
                        break;
                    case "Hep High Jump":
                        HeptHighJump hepHighJump = new HeptHighJump();
                        score = hepHighJump.calculateResult(result);
                        break;
                    case "Hep Long Jump":
                        HeptLongJump heptLongJump = new HeptLongJump();
                        score = heptLongJump.calculateResult(result);
                        break;
                    case "Hep Shot Put":
                        HeptShotPut hepShotPut = new HeptShotPut();
                        score = hepShotPut.calculateResult(result);
                        break;
                    case "Hep Javelin Throw":
                        HeptJavelinThrow heptJavelinThrow = new HeptJavelinThrow();
                        score = heptJavelinThrow.calculateResult(result);
                        break;
                }

                Competitor competitor = new Competitor(name);  // Create a new competitor
                competitors.add(competitor);        // Add to the list


                // Update the competitor's score for the selected discipline
                competitor.setScore(discipline, score);

                outputArea.append("Competitor: " + name + "\n");
                outputArea.append("Discipline: " + discipline + "\n");
                outputArea.append("Result: " + result + "\n");
                outputArea.append("Score: " + score + "\n\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for the result.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidResultException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Result", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ExportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                exportToExcel();
                JOptionPane.showMessageDialog(null, "Results exported successfully!", "Export Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Failed to export results to Excel.", "Export Error", JOptionPane.ERROR_MESSAGE);
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
}
