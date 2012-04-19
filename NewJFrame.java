package RPS;

import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author KAI
 */
public class NewJFrame extends javax.swing.JFrame {

    private static final int defaultThrowCount=50;
    private static int throwCount=defaultThrowCount;
    static Player player1=new HumanPlayer();
    static Player player2=new ComputerPlayer();
    static Scanner in=new Scanner(System.in);
    static Match current=null;
    
    private static final int defaultAiType=0;
    private static int aiType=defaultAiType;
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        ((ComputerPlayer) player2).setAI(aiType);
        current=new Match(throwCount);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        throwcountLabel = new javax.swing.JLabel();
        AILabel = new javax.swing.JLabel();
        throwcountTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        AIList = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        scoreLabel = new javax.swing.JLabel();
        winsLabel = new javax.swing.JLabel();
        lossesLabel = new javax.swing.JLabel();
        tiesLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pButton = new javax.swing.JButton();
        rButton = new javax.swing.JButton();
        sButton = new javax.swing.JButton();
        throwchoiceLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        throwcountLabel.setText("Number of throw:");

        AILabel.setText("AI Level:");

        throwcountTextField.setText("50");
        throwcountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                throwcountTextFieldActionPerformed(evt);
            }
        });

        AIList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Random", "Smart" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        AIList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        AIList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AIList.setSelectedIndex(0);
        AIList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                AIListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(AIList);

        scoreLabel.setText("Score:");

        winsLabel.setText("Wins: 0");

        lossesLabel.setText("Losses: 0");

        tiesLabel.setText("Ties: 0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lossesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(winsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(winsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lossesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tiesLabel)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jLabel4.setText("Computer Choice");

        jLabel5.setText("jLabel5");

        jButton1.setText("Help!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(throwcountLabel)
                                    .addComponent(AILabel))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(throwcountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(throwcountLabel)
                    .addComponent(throwcountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AILabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(47, 47, 47))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        pButton.setText("Paper");
        pButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 26, 0, 22);
        jPanel2.add(pButton, gridBagConstraints);

        rButton.setText("Rock");
        rButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 37);
        jPanel2.add(rButton, gridBagConstraints);

        sButton.setText("Scissors");
        sButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 31, 0, 28);
        jPanel2.add(sButton, gridBagConstraints);

        throwchoiceLabel.setText("Throw Choice:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(9, 20, 8, 20);
        jPanel2.add(throwchoiceLabel, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonActionPerformed
     
        disableFields();
        int winner;
        int cputhrow=player2.getThrows();
        winner=current.checkRound(0, cputhrow);
         throwchoiceLabel.setText("Throw Choice: rock");
        updateScore(winner);
       
    }//GEN-LAST:event_rButtonActionPerformed

    private void pButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pButtonActionPerformed
        disableFields();
        int winner;
        int cputhrow=player2.getThrows();
        winner=current.checkRound(1, cputhrow);
        throwchoiceLabel.setText("Throw Choice: paper");
        updateScore(winner);
        
    }//GEN-LAST:event_pButtonActionPerformed

    private void sButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sButtonActionPerformed
        disableFields();
        int winner;        
        int cputhrow=player2.getThrows();
        winner=current.checkRound(2, cputhrow);
        throwchoiceLabel.setText("Throw Choice: scissors");
        updateScore(winner);
        
    }//GEN-LAST:event_sButtonActionPerformed

    private void AIListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_AIListValueChanged
        if (AIList.getSelectedIndex()==0)
        {
            aiType=0;
            
        }
        else if (AIList.getSelectedIndex()==1)
        {
            aiType=1;
        }
        ((ComputerPlayer) player2).setAI(aiType);
    }//GEN-LAST:event_AIListValueChanged

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
    String adfh="A match consists of one or more rounds,shown by the 'Number\n"+
       "of throws:' field in the top left of the screen.\n"+
       "To play a round, select either Rock, Paper, or Scissors."+
       "\nThe computer will choose one of the same choices, based on\n"+
       "the difficulty selected."+
       "The winner is determined as follows:\n"+
       "  -Rock crushes Scissors\n"+
       "  -Scissors cuts Paper\n"+
       "  -Paper covers Rock\n"+
       "The player with the most wins at the end of\n"+
       "the match is the winner!";
      JOptionPane.showMessageDialog(null,adfh,"HELP PAGE",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void throwcountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_throwcountTextFieldActionPerformed

    }//GEN-LAST:event_throwcountTextFieldActionPerformed
/**  //commented out the main method
    /**
     * @param args the command line arguments
     
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    */
    
    private void updateScore(int winner) 
    {
        switch(winner)
        {
            case -1: player1.incrementWins();
                player2.incrementLosses();
                winsLabel.setText("Wins: "+player1.getStats().getWins());
                break;
            case 0: player1.incrementTies();
                player2.incrementTies();
                tiesLabel.setText("Ties: "+player1.getStats().getTies());
                break;
            case 1: player1.incrementLosses();
                player2.incrementWins();
                lossesLabel.setText("Losses: "+player1.getStats().getLosses());
                break;
            default:
                
        }
        
        String temp=throwcountTextField.getText();
        int value=Integer.parseInt(temp);
        value--;
        if(value<=0)
        {//end match
         value=0;
        }
        throwcountTextField.setText(new Integer(value).toString());
        throwCount=value;
        current.setThrowCount(throwCount);
        String victor="";
        if(current.matchIsOver())
          {
          
           if (player1.getStats().getWins()>player2.getStats().getWins())
                       victor="You won!";
           else if (player1.getStats().getWins()<player2.getStats().getWins())
               victor="You lost!";
           else   
               victor="You tied!";
           
               
           JOptionPane.showMessageDialog(null,victor,"The game is over:",JOptionPane.WARNING_MESSAGE);
           current.setThrowCount(defaultThrowCount);
           throwcountTextField.setText(new Integer(defaultThrowCount).toString());
          }
          
        
    }
    public void disableFields() {
       throwcountTextField.setEditable(false);
       AIList.setEnabled(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AILabel;
    private javax.swing.JList AIList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lossesLabel;
    private javax.swing.JButton pButton;
    private javax.swing.JButton rButton;
    private javax.swing.JButton sButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel throwchoiceLabel;
    private javax.swing.JLabel throwcountLabel;
    private javax.swing.JTextField throwcountTextField;
    private javax.swing.JLabel tiesLabel;
    private javax.swing.JLabel winsLabel;
    // End of variables declaration//GEN-END:variables
}
