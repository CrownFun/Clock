package clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public final class ClockGui extends javax.swing.JFrame {
    
    public ClockGui() {
        initComponents();
        showTime(labelClock);
        showData(labelData, labelDay);
    }
    
    public static void showData(JLabel labelData, JLabel labelDay) {
        Calendar calendar = Calendar.getInstance();
        labelData.setText((new SimpleDateFormat("dd MMMMMMMMMMMM YYYY").format(calendar.getTime())));
        labelDay.setText(new SimpleDateFormat("EEEEEEEE").format(calendar.getTime()));
    }
    
    public static void showTime(JLabel jLabel) {
        
        Thread clock;
        clock = new Thread() {
            @Override
            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int second = cal.get(Calendar.SECOND);
                    String sec;
                    if (second < 10) {
                        sec = "0" + second;
                    } else {
                        sec = "" + second;
                    }
                    int minute = cal.get(Calendar.MINUTE);
                    String min;
                    if (minute < 10) {
                        min = "0" + minute;
                    } else {
                        min = "" + minute;
                    }
                    int hour = cal.get(Calendar.HOUR);
                    int h = cal.get(Calendar.AM_PM);
                    
                    if (h == 0) {
                        hour = hour;
                    } else {
                        hour = hour + 12;
                    }
                    jLabel.setText((hour) + ":" + min + ":" + sec);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null, e);
                        
                    }
                }
            }
        };
        clock.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelClock = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        labelDay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zegar");
        setPreferredSize(new java.awt.Dimension(360, 190));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        labelClock.setFont(new java.awt.Font("DS-Digital", 0, 55)); // NOI18N
        labelClock.setForeground(new java.awt.Color(0, 204, 0));
        labelClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClock.setText("21:14:17");
        jPanel1.add(labelClock);
        labelClock.setBounds(60, 40, 230, 80);

        labelData.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labelData.setForeground(new java.awt.Color(0, 204, 0));
        jPanel1.add(labelData);
        labelData.setBounds(10, 10, 200, 30);

        labelDay.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labelDay.setForeground(new java.awt.Color(0, 204, 0));
        labelDay.setText("poniedziałek");
        jPanel1.add(labelDay);
        labelDay.setBounds(210, 120, 130, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(ClockGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClockGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClockGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClockGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ClockGui().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelClock;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelDay;
    // End of variables declaration//GEN-END:variables
}
