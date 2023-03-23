import javax.swing.*;

public class AlertDialog {
    String title, text, yesButtonText, noButtonText;

    static class Builder {
        String title, text, yesButtonText, noButtonText;

        public Builder(String title, String text){
            this.title = title;
            this.text = text;
        }

        Builder setYesButtonText (String texto){
            this.yesButtonText = texto;
            return this;
        }
        Builder setNoButtonText (String texto){
            this.noButtonText = texto;
            return this;
        }

        Builder setYes(String texto){
            this.yesButtonText = texto;
            return null;
        }
        Builder setNo(String texto){
            this.noButtonText = texto;
            return null;
        }

        AlertDialog build(){
            AlertDialog alertDialog = new AlertDialog();
            alertDialog.title = this.title;
            alertDialog.text = this.text;
            alertDialog.yesButtonText = this.yesButtonText;
            alertDialog.noButtonText = this.noButtonText;
            return alertDialog;

        }
        void show(){
            AlertDialog alertDialog = build();

            JPanel jPanel = new JPanel();
            jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
            jPanel.add(new JLabel(alertDialog.text));
            if (alertDialog.yesButtonText != null)
                jPanel.add(new JButton(alertDialog.yesButtonText));
            if (alertDialog.noButtonText != null)
                jPanel.add(new JButton(alertDialog.noButtonText));


            JFrame jFrame = new JFrame(title);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.add(jPanel);
            jFrame.pack();
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }

    }
}

