package gvsu457.Hangman.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 11/23/2016.
 */
public class HangmanClientGUI extends JFrame implements ActionListener {
    public DefaultListModel listModel = new DefaultListModel();
    public Socket socket;
    private JButton defineWordButton;
    private JTextField defineWordField;
    private JButton guessLetterButton;
    private JTextField guessLetterField;
    private JTextPane imagePanel;
    private JPanel mainPanel;
    private JList letterList;
    public JLabel wordDisplay;
    public JLabel setWordDisplay;
    public DataInputStream in;
    public DataOutputStream out;
    public String theWord;
    public static HangmanClientLogic hangmanClientLogic;


    public HangmanClientGUI(String username, HangmanClientLogic hangmanClientLogic) {

        super(username);
        this.hangmanClientLogic = hangmanClientLogic;
        setContentPane(mainPanel);
        letterList.setModel(listModel);
        setVisible(true);
        pack();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent event) {
                hangmanClientLogic.closeSockets();
                dispose();
            }
        });

        defineWordButton.addActionListener(this);
    }

//    public static void main(String[] args) {
//        hangmanClientLogic = new HangmanClientLogic();
//    }

    public void actionPerformed(ActionEvent e) {

        JComponent event = (JComponent) e.getSource();

        if (event == guessLetterButton) {
            //hangmanClientLogic.sendWordToServer(guessLetterField.getText());
        } else if (event == defineWordButton) {
            if (defineWordButton.getText() != null) {
                hangmanClientLogic.sendWordToServer(defineWordField.getText());
                setWordDisplay.setText(defineWordField.getText());
                hangmanClientLogic.setDisplayForWordAndGuessList();
                setAllFieldsEnabled(false);
            }
        }
        pack();
    }

    public void setWordDisplay(String displayWord) {
        wordDisplay.setText(displayWord);
    }

    public void setAllFieldsEnabled(boolean bool) {
        defineWordButton.setEnabled(bool);
        defineWordField.setEnabled(bool);
    }

    public void setImagePanel(ImageIcon image) {
        imagePanel.setText("");
        imagePanel.insertIcon(image);
    }

    public void addElementToListModel(String guess) {
        listModel.addElement(guess);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        defineWordButton = new JButton();
        defineWordButton.setText("Define Word");
        mainPanel.add(defineWordButton, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        defineWordField = new JTextField();
        mainPanel.add(defineWordField, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(444, 22), null, 0, false));
        imagePanel = new JTextPane();
        imagePanel.setText("");
        mainPanel.add(imagePanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(444, 327), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Missed Letters:");
        mainPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        letterList = new JList();
        mainPanel.add(letterList, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        wordDisplay = new JLabel();
        wordDisplay.setFont(new Font("Arial Black", Font.BOLD, 36));
        wordDisplay.setHorizontalAlignment(0);
        wordDisplay.setHorizontalTextPosition(0);
        wordDisplay.setText("_ _ _ _ _");
        mainPanel.add(wordDisplay, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        setWordDisplay = new JLabel();
        setWordDisplay.setFont(new Font("Arial Black", Font.BOLD, 36));
        setWordDisplay.setHorizontalAlignment(0);
        setWordDisplay.setHorizontalTextPosition(0);
        setWordDisplay.setText("guess");
        mainPanel.add(setWordDisplay, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}

