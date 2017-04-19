package com.company;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.border.LineBorder;

public class Frame extends JFrame {

    public JPanel contentPane;
    public JTextField textField;
    public JTextField textField_1;
    public JTextField textField_2;
    public JTextField textField_3;
    public JTable table;
    int count;
    int choiceOfAlgo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Frame frame = new Frame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1020, 610);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnDonnes = new JMenu("Donn\u00E9es");
        menuBar.add(mnDonnes);

        JMenuItem mntmDonnesAlatoires = new JMenuItem("Donn\u00E9es Al\u00E9atoires");
        mnDonnes.add(mntmDonnesAlatoires);

        JMenuItem mntmNewMenuItem = new JMenuItem("Donn\u00E9es a partir de fichier");
        mnDonnes.add(mntmNewMenuItem);

        JMenuItem mntmDonnesDirectes = new JMenuItem("Donn\u00E9es directes");
        mnDonnes.add(mntmDonnesDirectes);

        JMenuItem mntmRnitialiserLesDonnes = new JMenuItem("R\u00E9nitialiser les Donn\u00E9es");
        mnDonnes.add(mntmRnitialiserLesDonnes);

        JMenuItem mntmQuitter = new JMenuItem("Quitter");
        mnDonnes.add(mntmQuitter);

        JMenu mnOptions = new JMenu("Options");
        menuBar.add(mnOptions);

        JMenu mnAlgorithmes = new JMenu("Algorithmes");
        mnOptions.add(mnAlgorithmes);

        JMenuItem mntmFirstComeFirst = new JMenuItem("First Come First Served");
        mntmFirstComeFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                choiceOfAlgo = 0;
            }
        });
        mnAlgorithmes.add(mntmFirstComeFirst);

        JMenuItem mntmShortestJobFirst = new JMenuItem("Shortest Job First");
        mntmShortestJobFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                choiceOfAlgo = 1;
            }
        });
        mnAlgorithmes.add(mntmShortestJobFirst);

        JMenuItem mntmRoundRobin = new JMenuItem("Round Robin");
        mntmRoundRobin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                choiceOfAlgo = 2;
            }
        });
        mnAlgorithmes.add(mntmRoundRobin);

        JMenuItem mntmPriority = new JMenuItem("Priority");
        mntmPriority.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                choiceOfAlgo = 3;
            }
        });
        mnAlgorithmes.add(mntmPriority);

        JCheckBoxMenuItem chckbxmntmAvecPriority = new JCheckBoxMenuItem("Avec priority");
        mnOptions.add(chckbxmntmAvecPriority);

        JCheckBoxMenuItem chckbxmntmPreemptivit = new JCheckBoxMenuItem("Preemptivit\u00E9");
        mnOptions.add(chckbxmntmPreemptivit);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblCoreSimulator = new JLabel("Core Simulator");
        lblCoreSimulator.setFont(new Font("Rockwell", Font.BOLD, 34));
        lblCoreSimulator.setBounds(371, 13, 298, 46);
        panel.add(lblCoreSimulator);

        JLabel lblProcessus = new JLabel("Processus: ");
        lblProcessus.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblProcessus.setBounds(40, 135, 87, 25);
        panel.add(lblProcessus);

        JLabel lblTempsDarriv = new JLabel("Temps d'arriv\u00E9");
        lblTempsDarriv.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblTempsDarriv.setBounds(136, 95, 105, 25);
        panel.add(lblTempsDarriv);

        JLabel lblTempsCpu = new JLabel("Temps CPU");
        lblTempsCpu.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblTempsCpu.setBounds(271, 95, 84, 25);
        panel.add(lblTempsCpu);

        JLabel lblPriorit = new JLabel("Priorit\u00E9");
        lblPriorit.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblPriorit.setBounds(382, 95, 76, 25);
        panel.add(lblPriorit);

        textField = new JTextField();
        textField.setBounds(139, 136, 89, 22);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(271, 137, 76, 22);
        panel.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(370, 136, 76, 22);
        panel.add(textField_2);

        JButton btnNewButton = new JButton("Ajouter a la liste");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                ++count;
                String[] a = {String.valueOf(count), textField.getText(), textField_1.getText(), textField_2.getText()};

                model.addRow(a);

                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
            }
        });
        btnNewButton.setBounds(180, 186, 175, 25);
        panel.add(btnNewButton);

        JLabel lblQuantum = new JLabel("Quantum");
        lblQuantum.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblQuantum.setBounds(40, 360, 87, 25);
        panel.add(lblQuantum);

        textField_3 = new JTextField();
        textField_3.setBounds(205, 362, 116, 22);
        panel.add(textField_3);
        textField_3.setColumns(10);

        table = new JTable();
        table.setBackground(SystemColor.inactiveCaptionBorder);
        table.setBorder(new LineBorder(new Color(51, 153, 255), 2, true));
        table.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "N processus", "Temps d'arriv\u00E9", "Temps CPU", "Priority"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(93);
        table.getColumnModel().getColumn(1).setPreferredWidth(98);
        table.getColumnModel().getColumn(2).setPreferredWidth(95);
        table.getColumnModel().getColumn(3).setPreferredWidth(92);
        table.setFont(new Font("Ravie", Font.PLAIN, 15));
        table.setBounds(522, 101, 421, 175);
        panel.add(table);

        JButton btnCommencez = new JButton("Commencez !");

        btnCommencez.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ArrayList<Processus> file = new ArrayList<>();
                Random r = new Random();

                for (int i = 0; i < table.getRowCount(); i++) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    Processus p = new Processus(i + 1, Integer.valueOf((String) model.getValueAt(i, 0)), Integer.valueOf((String) model.getValueAt(i, 1)), Integer.valueOf((String) model.getValueAt(i, 2)), false);

                    //Processus p = new Processus(i + 1, r.nextInt(4), r.nextInt(5) + 1, r.nextInt(3), false);
                    System.out.println("Processus " + p.getName() + " arrival time " + p.getArriveTime() + " cpu " + p.getCpuTime() + " Priority " + p.getPriority());
                    file.add(p);
                }
                System.out.println();

                Algorithmes algorithmes = new Algorithmes(file);
                switch (choiceOfAlgo) {
                    case 0:
                        System.out.println("first to come");
                        algorithmes.firstComeFirstServe(algorithmes.file);
                        break;
                    case 1:
                        System.out.println("shortest job");
                        algorithmes.shortJobFirst(algorithmes.file);
                        break;
                    case 2:
                        System.out.println("round robin");
                        algorithmes.roundRobinNonPreemptif(algorithmes.file, Integer.parseInt(textField_3.getText()));
                        break;
                    case 3:
                        System.out.println("priority");
                        algorithmes.priorityNonPremptif(algorithmes.file);
                        break;
                    default:
                        System.out.println("default");
                        algorithmes.firstComeFirstServe(algorithmes.file);
                        break;
                }


            }
        });

        btnCommencez.setBounds(666, 361, 175, 25);
        panel.add(btnCommencez);

    }


}