/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package datastructersproject;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ali Haydar
 */
public class Gui extends javax.swing.JFrame {

    DefaultListModel model = new DefaultListModel();
    ArrayList<String> wordsList = new ArrayList<>();//Text kelimelerinin listesi
    ArrayList<String> trueText = new ArrayList<>();//doğru kelimeler listesi
    BinarySearchTree wordTree = new BinarySearchTree();
    String newText = "";

    int index = 0;

    /**
     * Creates new form Guı
     */
    public Gui() {
        initComponents();
        keyList.setModel(model);

        String dosyaYolu = "C:\\Users\\Ali Haydar\\Documents\\NetBeansProjects\\dataStructersProject\\src\\datastructersproject\\metin.txt";
        String kelimeler = "";

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {

            String satir;
            while ((satir = br.readLine()) != null) {
                kelimeler += satir + " ";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String word = "";
        for (int i = 0; i < kelimeler.length(); i++) {
            if (kelimeler.charAt(i) != ' ') {
                word += kelimeler.charAt(i);
            } else {
                wordTree.insert(word);
                word = "";
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        keyList = new javax.swing.JList<>();
        btn_control = new javax.swing.JButton();
        btn_select = new javax.swing.JButton();
        btn_restart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jScrollPane2.setViewportView(keyList);

        btn_control.setText("Auto Control");
        btn_control.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_controlActionPerformed(evt);
            }
        });

        btn_select.setText("Select");
        btn_select.setEnabled(false);
        btn_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectActionPerformed(evt);
            }
        });

        btn_restart.setText("Restart");
        btn_restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_control, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(btn_restart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_select, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_control)
                        .addGap(18, 18, 18)
                        .addComponent(btn_select)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_restart)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });

    }

    private void btn_controlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_controlActionPerformed
        String[] words = textArea.getText().split(" ");

        for (int i = 0; i < words.length; i++) {
            if(!words[i].equals("")){
                wordsList.add(words[i]);
            }
            
        }

        btn_select.setEnabled(true);
        btn_control.setEnabled(false);
        textArea.setEditable(false);
        listing();

    }//GEN-LAST:event_btn_controlActionPerformed

    private void btn_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectActionPerformed
        if (index <= this.wordsList.size() - 1) {
            if (keyList.getSelectedValue() != null) {
                this.index++;
                trueText.add(keyList.getSelectedValue());
                this.wordTree.removeArrayList();
                model.removeAllElements();

                if (index == this.wordsList.size()) {
                    printTrueText();
                    btn_select.setEnabled(false);
                } else {
                    listing();
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Lütfen doğru kelimeyi seçin");
            }
        } else {
            printTrueText();
        }


    }//GEN-LAST:event_btn_selectActionPerformed

    
    //This method prints true text
    public void printTrueText() {
        for (int i = 0; i < trueText.size(); i++) {
            newText += trueText.get(i) + " ";
        }
        textArea.setText(newText);
    }

    
    //This method restarts the application.
    private void btn_restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restartActionPerformed
        textArea.setText("");
        btn_control.setEnabled(true);
        btn_select.setEnabled(false);
        textArea.setEditable(true);
        removeArrayList(wordsList);
        removeArrayList(trueText);
        wordTree.removeArrayList();
        model.removeAllElements();
        newText = "";
        index = 0;
    }//GEN-LAST:event_btn_restartActionPerformed

    
    //This method listing the possible true words.
    public void listing() {
        ArrayList<String> a = new ArrayList<>();
        if (!(wordTree.search(wordsList.get(this.index))) && wordsList.get(this.index) != ".") {
            
            
            for (int i = 0; i < wordTree.list.size(); i++) {
                a.add(wordTree.list.get(i));
            }
            

            for (int i = 0; i < a.size(); i++) {
                model.addElement(a.get(i));
            }
            
            
        } else {
            trueText.add(wordsList.get(this.index));
            if (index < this.wordsList.size() - 1) {
                index++;
                listing();
                System.out.println(newText);
            } else {
                printTrueText();
                //controlLetters();
                btn_select.setEnabled(false);
            }
        }
        
        //if there is no posssible word in binary search tree this if statement
        //prints the same word to textarea.
        if(model.isEmpty()){
            trueText.add(wordsList.get(this.index));
             if (index < this.wordsList.size() - 1) {
                index++;
                listing();
                System.out.println(newText);
            } else {
                printTrueText();
                //controlLetters();
                btn_select.setEnabled(false);
            }
        }
    }
    
    
    
/*    public void controlLetters() {
        char character;
        character = newText.charAt(0);

        if (character >= 'a' && character <= 'z') {
            System.out.println(character);
            character = (char) (character - ('a' - 'A'));
            StringBuilder sb = new StringBuilder(newText);
            sb.setCharAt(0, character);
            newText = sb.toString();
            textArea.setText(newText);
        }

        for (int i = 0; i < newText.length(); i++) {
            character = newText.charAt(i);
            if (character == '.') {
                if (i + 1 != newText.length()) {
                    
                    if (character >= 'a' && character <= 'z') {
                        System.out.println(character);
                        character = (char) (character - ('a' - 'A'));
                        StringBuilder sb = new StringBuilder(newText);
                        sb.setCharAt(i+1, character);
                        newText = sb.toString();
                        textArea.setText(newText);
                    }
                }

            }
        }
    }*/

    //this method removes array list.
    public void removeArrayList(ArrayList a) {
        int size = a.size();
        for (int i = 0; i < size; i++) {
            a.remove(0);
        }
    }
    /*
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_control;
    private javax.swing.JButton btn_restart;
    private javax.swing.JButton btn_select;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> keyList;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
