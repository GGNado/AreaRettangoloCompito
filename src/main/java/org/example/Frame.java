package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    public Frame(){
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calcolo Area");

        JPanel panel = new JPanel(null);

        //Label
        JLabel baseLabel = new JLabel("Lunghezza Base");
        JLabel altezzaLabel = new JLabel("Lunghezza Altezza");
        JLabel areaLabel = new JLabel("Area");
        areaLabel.setBounds(0, 150, areaLabel.getPreferredSize().width, areaLabel.getPreferredSize().height);
        panel.add(areaLabel);

        //TextFiled
        JTextField base = new JTextField("10");
        JTextField altezza = new JTextField("7");
        JTextField area = new JTextField("70");

        base.setBounds(50, 50, 200, 35);
        panel.add(base);

        altezza.setBounds(50, 100, 200, 35);
        panel.add(altezza);

        area.setBounds(50, 150, 200, 35);
        panel.add(area);
        area.setEditable(false);

        //Bottoni
        JButton cancella = new JButton("Cancella");
        cancella.setBounds(50, 500, cancella.getPreferredSize().width, cancella.getPreferredSize().height);
        cancella.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.setText("");
                altezza.setText("");
                area.setText("");
            }
        });
        panel.add(cancella);
        JButton calcola = new JButton("Calcola Area");
        calcola.setBounds(cancella.getX() + 150, cancella.getY(), calcola.getPreferredSize().width, calcola.getPreferredSize().height);
        calcola.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (base.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Non presenti numeri per la base");
                    return;
                }

                if (altezza.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Non presenti numeri per laltezza");
                    return;
                }
                try {
                    Integer.parseInt(base.getText());
                    Integer.parseInt(altezza.getText());
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Errore, presenti Lettere");
                    return;
                }

                int nBase = Integer.parseInt(base.getText());
                int nAltezza = Integer.parseInt(altezza.getText());

                if (nBase < 0){
                    System.out.println("Errore, numero negativo");
                    JOptionPane.showMessageDialog(null, "Errore, numero negativo", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (nAltezza < 0){
                    System.out.println("Errore, numero negativo");
                    JOptionPane.showMessageDialog(null, "Errore, numero negativo", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                nBase *= nAltezza;

                area.setText("" + nBase);

            }
        });
        panel.add(calcola);

        add(panel);
        setVisible(true);
    }

}
