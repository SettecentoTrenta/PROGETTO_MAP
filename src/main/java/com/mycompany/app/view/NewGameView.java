/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.app.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.nio.file.Path;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.Timer;
import javax.swing.plaf.metal.MetalButtonUI;

import javax.swing.JFrame;

import com.mycompany.app.controller.HelpViewController;
import com.mycompany.app.controller.LevelController;
import com.mycompany.app.controller.NewGameController;
import com.mycompany.app.model.InventoryModel;
import com.mycompany.app.utils.audio.AudioManager;
import com.mycompany.app.utils.commands.Commands;
import com.mycompany.app.utils.parser.Parser;
import com.mycompany.app.utils.save.logic.SaveGame;
import com.mycompany.app.utils.save.logic.SaveManager;

/**
 * Vista di nuova partita.
 */
public final class NewGameView extends javax.swing.JPanel {

    /**
     * Controller.
     */
    private NewGameController c;

    /**
     * The button to go back to the menu.
     */
    private JButton goBackButton;
    /**
     * The button to save the game.
     */
    private JButton saveGameButton;
    /**
     * The button to show the help dialog.
     */
    private JButton helpButton;
    /**
     * The button to start or stop the music.
     */
    private static JButton musicButton;
    /**
     * The timer label.
     */
    private static JLabel timerLabel;
    /**
     * The image panel.
     */
    private static JPanel imagePanel;
    /**
     * The text pane to display the text of the game.
     */
    private static JTextPane displayTextPane;
    /**
     * The scroll pane for the text pane.
     */
    private JScrollPane scrollPaneDisplayText;
    /**
     * The text area to display the inventory.
     */
    private static JTextArea inventoryTextArea;
    /**
     * The scroll pane for the inventory text area.
     */
    private JScrollPane scrollPaneInventoryText;
    /**
     * The user input field.
     */
    private JTextField userInputField;
    /**
     * The toolbar containing the buttons and the timer label
     */
    private JToolBar toolBar;
    /**
     * The imagePanel card layout.
     */
    /*
    private static CardLayout cardLayout;
    */

    /**
     * The timer.
     */
    private Timer timer;

    /**
     * The start time.
     */
    private long startTime;

    /**
     * The card layout.
     */
    private CardLayout cardLayout;

    /**
     * The level controller.
     */
    private LevelController levelController;

    /**
     * Creates new form NewGameView.
     */
    public NewGameView() {

        UIManager.put("ScrollBar.width", 0);
        SwingUtilities.updateComponentTreeUI(this);

        levelController = new LevelController();

        Commands.setLvlController(levelController);

        startTime = System.currentTimeMillis();
        timerLabel = new JLabel("Tempo: 0", SwingConstants.CENTER);

        Thread timerThread = new Thread(() -> {
            timer = new Timer(1000, e -> {
                long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                long hours = elapsedTime / 3600;
                long minutes = (elapsedTime % 3600) / 60;
                long seconds = elapsedTime % 60;
                String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                timerLabel.setText(timeString);
            });

            startTime = System.currentTimeMillis();
            timer.start();
        }, "TimerThread");

        timerThread.start();

        initComponents();
        initImagePanel();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(d.width / 2 - this.getSize().width / 2, d.height / 2 - this.getSize().height / 2);

        c = new NewGameController();
    }

    public NewGameView(SaveGame game) {

        levelController = game.getLevelController();
        Commands.loadController(game.getLevelController());
        levelController.setPlayerPosition(game.getPlayerX(), game.getPlayerY());

        UIManager.put("ScrollBar.width", 0);
        SwingUtilities.updateComponentTreeUI(this);

        startTime = System.currentTimeMillis();
        timerLabel = new JLabel("Tempo: 0", SwingConstants.CENTER);

        Thread timerThread = new Thread(() -> {
            timer = new Timer(1000, e -> {
                long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                long hours = elapsedTime / 3600;
                long minutes = (elapsedTime % 3600) / 60;
                long seconds = elapsedTime % 60;
                String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                timerLabel.setText(timeString);
            });

            startTime = System.currentTimeMillis();
            timer.start();
        }, "TimerThread");

        timerThread.start();

        initComponents();
        initImagePanel();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(d.width / 2 - this.getSize().width / 2, d.height / 2 - this.getSize().height / 2);

        inventoryTextArea.setText(" Inventario:\n");

        for (InventoryModel item : game.getInventory()) {
            inventoryTextArea.append(item.getItemName() + "\n");
        }

        c = new NewGameController();
    }

    private void initImagePanel() {
        imagePanel.setPreferredSize(new Dimension(440, 400));
        imagePanel.setMaximumSize(new Dimension(440, 400));
        imagePanel.setMinimumSize(new Dimension(440, 400));
        imagePanel.setBorder(BorderFactory.createLineBorder(new Color(107, 90, 13), 5));
        imagePanel.setBackground(new Color(107, 90, 13));

        cardLayout = new CardLayout();

        cardLayout.setVgap(0);
        cardLayout.setHgap(0);
        cardLayout.minimumLayoutSize(imagePanel);
        cardLayout.preferredLayoutSize(imagePanel);
        cardLayout.maximumLayoutSize(imagePanel);

        imagePanel.setLayout(cardLayout);


        imagePanel.add(new JPanel(null) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon image = new ImageIcon("src/main/java/com/mycompany/app/resources/img/Space Background.png");
                g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        }, "Space");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

           // Setting properties of the panel
        setBackground(new Color(25, 30, 66));
        setPreferredSize(new Dimension(800, 600));

        // Initialization of the components
        imagePanel = new JPanel();
        toolBar = new JToolBar();
        goBackButton = new JButton();
        saveGameButton = new JButton();
        helpButton = new JButton();
        musicButton = new JButton();
        timerLabel = new JLabel();
        userInputField = new JTextField();
        scrollPaneInventoryText = new JScrollPane();
        inventoryTextArea = new JTextArea();
        scrollPaneDisplayText = new JScrollPane();
        displayTextPane = new JTextPane();

        // Setting the properties of the toolbar and its components
        toolBar.setBorderPainted(false);
        toolBar.setFloatable(false);
        toolBar.setBackground(new Color(25, 30, 66));
        toolBar.add(Box.createHorizontalStrut(5));

        // Setting the properties of the go back button
        goBackButton.setUI(new MetalButtonUI() {
            protected Color getSelectColor () {
                return new Color(133, 106, 5, 50);

            }
        });
        goBackButton.setFocusPainted(false);
        goBackButton.setBackground(new Color(204, 173, 27));
        goBackButton.setForeground(new Color(255, 255, 255));
        goBackButton.setBorderPainted(true);
        goBackButton.setBorder(BorderFactory.createLineBorder(new Color(107, 90, 13), 2));
        //goBackButton.setFont(new Font("Papyrus", 1, 16));
        goBackButton.setText(" Indietro ");
        goBackButton.setFocusable(false);
        goBackButton.setHorizontalTextPosition(SwingConstants.CENTER);
        goBackButton.setVerticalTextPosition(SwingConstants.CENTER);
        goBackButton.addActionListener(e -> {
            goBackButtonActionPerformed(e);
        });
        toolBar.add(goBackButton);

        // Adding a horizontal strut to the toolbar
        toolBar.add(Box.createHorizontalStrut(10));

        // Setting the properties of the save game button
        saveGameButton.setUI(new MetalButtonUI() {
            protected Color getSelectColor () {
                return new Color(133, 106, 5, 50);

            }
        });
        saveGameButton.setFocusPainted(false);
        saveGameButton.setBackground(new Color(204, 173, 27));
        saveGameButton.setForeground(new Color(255, 255, 255));
        saveGameButton.setBorderPainted(true);
        saveGameButton.setBorder(BorderFactory.createLineBorder(new Color(107, 90, 13), 2));
        // saveGameButton.setFont(new Font("Papyrus", 1, 16));
        saveGameButton.setText(" Salva ");
        saveGameButton.setToolTipText("");
        saveGameButton.setFocusable(false);
        saveGameButton.setHorizontalTextPosition(SwingConstants.CENTER);
        saveGameButton.setVerticalTextPosition(SwingConstants.CENTER);
        saveGameButton.addActionListener(e -> {
            saveGameButtonActionPerformed(e);
        });

        toolBar.add(saveGameButton);

        // Adding a horizontal strut to the toolbar
        toolBar.add(Box.createHorizontalStrut(10));

        // Setting the properties of the help button
        helpButton.setUI(new MetalButtonUI() {
            protected Color getSelectColor () {
                return new Color(133, 106, 5, 50);

            }
        });
        helpButton.setFocusPainted(false);
        helpButton.setBackground(new Color(204, 173, 27));
        helpButton.setForeground(new Color(255, 255, 255));
        helpButton.setBorderPainted(true);
        helpButton.setBorder(BorderFactory.createLineBorder(new Color(107, 90, 13), 2));
        helpButton.setFont(new Font("Algerian", 3, 25));
        helpButton.setMargin(new Insets(0, 10, 0, 0));
        helpButton.setText("  ?  ");
        helpButton.setFocusable(false);
        helpButton.setHorizontalTextPosition(SwingConstants.CENTER);
        helpButton.setVerticalTextPosition(SwingConstants.CENTER);
        helpButton.addActionListener(e -> {
            helpButtonActionPerformed(e);
        });
        toolBar.add(helpButton);

        // Adding a horizontal strut to the toolbar
        toolBar.add(Box.createHorizontalStrut(10));

        // Setting the properties of the music button
        Dimension musicButtonDim = new Dimension(34, 24);
        musicButton.setPreferredSize(musicButtonDim);
        musicButton.setMaximumSize(musicButtonDim);
        musicButton.setMinimumSize(musicButtonDim);
        musicButton.setUI(new MetalButtonUI() {
            protected Color getSelectColor () {
                return new Color(133, 106, 5, 50);

            }
        });
        musicButton.setFocusPainted(false);
        musicButton.setBackground(new Color(204, 173, 27));
        musicButton.setForeground(new Color(255, 255, 255));
        musicButton.setBorderPainted(true);
        musicButton.setBorder(BorderFactory.createLineBorder(new Color(107, 90, 13), 2));
        musicButton.setFont(musicButton.getFont().deriveFont(18f));
        musicButton.setText(" 🔊 ");
        musicButton.setFocusable(false);
        musicButton.setHorizontalTextPosition(SwingConstants.CENTER);
        musicButton.setVerticalTextPosition(SwingConstants.CENTER);
        musicButton.addActionListener(e -> {
            new Thread(() -> {
                if (AudioManager.mixerStatus()) {
                    AudioManager.stopClip();
                } else {
                    AudioManager.loadClip(Path.of("src/main/java/com/mycompany/app/resources/audio/audio_track.wav"));
                    AudioManager.startClip();
                }
            }, "MusicThread").start();
        
        });
        toolBar.add(musicButton);

        // Adding a horizontal strut to the toolbar
        toolBar.add(Box.createHorizontalStrut(483));

        // Setting the properties of the timer label
        timerLabel.setOpaque(true);
        timerLabel.setBackground(new Color(204, 173, 27));
        timerLabel.setForeground(new Color(255, 255, 255));
        timerLabel.setBorder(BorderFactory.createLineBorder(new Color(107, 90, 13), 2));
        timerLabel.setFont(new Font("Algerian", 3, 20));
        timerLabel.setFocusable(false);
        timerLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        timerLabel.setVerticalTextPosition(SwingConstants.CENTER);
        timerLabel.setText(" 00:00:00 ");
        toolBar.add(timerLabel);

        // Setting the properties of the inventory text area
        Image inventoryImg = new ImageIcon("src/main/java/com/mycompany/app/resources/img/papyrUserInputField.png").getImage();

        JViewport inventoryView = new JViewport() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(inventoryImg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        inventoryTextArea.setEditable(false);
        inventoryTextArea.setAutoscrolls(false);
        inventoryTextArea.setBorder(null);
        inventoryTextArea.setEnabled(false);
        inventoryTextArea.setFocusable(false);
        inventoryTextArea.setOpaque(false);
        inventoryTextArea.setPreferredSize(new Dimension(440, 100));
        inventoryTextArea.setMaximumSize(new Dimension(440, 100));
        inventoryTextArea.setMinimumSize(new Dimension(440, 100));
        inventoryTextArea.setFont(new Font("Georgia", 0, 20));
        inventoryTextArea.setText(" Inventario:\n");

        scrollPaneInventoryText.setViewport(inventoryView);
        scrollPaneInventoryText.setViewportView(inventoryTextArea);
        scrollPaneInventoryText.setPreferredSize(new Dimension(440, 100));
        scrollPaneInventoryText.setMaximumSize(new Dimension(440, 100));
        scrollPaneInventoryText.setMinimumSize(new Dimension(440, 100));
        scrollPaneInventoryText.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 5, new Color(107, 90, 13)));

        Image img = new ImageIcon("src/main/java/com/mycompany/app/resources/img/papyrUserInputField.png").getImage();

        
        JViewport view = new JViewport() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        

        displayTextPane.setEditable(false);
        displayTextPane.setFocusable(false);
        displayTextPane.setAutoscrolls(false);
        displayTextPane.setFont(new Font("Georgia", 0, 20));
        displayTextPane.setBorder(null);
        displayTextPane.setOpaque(false);
        displayTextPane.setForeground(Color.WHITE);

        scrollPaneDisplayText.setBackground(new Color(204, 173, 27));
        scrollPaneDisplayText.setViewport(view);
        scrollPaneDisplayText.setViewportView(displayTextPane);
        scrollPaneDisplayText.setPreferredSize(new Dimension(335, 550));
        scrollPaneDisplayText.setMaximumSize(new Dimension(335, 550));
        scrollPaneDisplayText.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneDisplayText.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneDisplayText.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 0, new Color(107, 90, 13)));

        userInputField.addActionListener(e -> {
            userInputFieldActionPerformed(e);
        });
        userInputField.setMargin(new Insets(0, 0, 0, 0));
        userInputField.setForeground(new Color(0, 0, 0));
        userInputField.setFont(new Font("Georgia", 0, 20));
        userInputField.setOpaque(false);
        userInputField.setPreferredSize(new Dimension(335, 31));
        userInputField.setMaximumSize(new Dimension(335, 31));
        userInputField.setMinimumSize(new Dimension(335, 31));
        userInputField.setBorder(BorderFactory.createMatteBorder(0, 5, 5, 0, new Color(107, 90, 13)));
        userInputField.setBounds(0, 0, 335, 31);
        userInputField.setForeground(Color.WHITE);
        //UserInputManager.startInputListener();

        Image img2 = new ImageIcon("src/main/java/com/mycompany/app/resources/img/papyrUserInputField.png").getImage();

        JPanel userInputFieldPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img2, 0, 0, getWidth(), getHeight(), this);
            }
        };
        userInputFieldPanel.setLayout(null);
        userInputFieldPanel.setPreferredSize(new Dimension(335, 31));
        userInputFieldPanel.setMaximumSize(new Dimension(335, 31));
        userInputFieldPanel.setMinimumSize(new Dimension(335, 31));
        userInputFieldPanel.setBorder(null);
        userInputFieldPanel.add(userInputField);

        // Setting the layout of the panel
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(toolBar, 800, 800, 800)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(userInputFieldPanel, 335, 335, 335))
                                        .addComponent(scrollPaneDisplayText))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPaneInventoryText, 440, 440, 440)
                                        .addComponent(imagePanel, 440, 440, 440))
                                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(imagePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(scrollPaneInventoryText, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(scrollPaneDisplayText)
                                                .addComponent(userInputFieldPanel, 31, 31, 31)))
                                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sets the text of the music button.
     * @param text the text
     */
    public static void musicButtonSetValue(final String value) {
        musicButton.setText(value);
    }

    /**
     * Set the current input.
     * @param evt evt
     */
    private void userInputFieldActionPerformed(ActionEvent evt) {
        String userInput = userInputField.getText();
        userInputField.setText("");

        String old = displayTextPane.getText();

        StringBuilder result = new StringBuilder(old);
        result.append("> ")
              .append(userInput);

        Parser parser = new Parser();
        result.append("\n")
              .append("< ")
              .append(parser.parseInput(userInput))
              .append("\n");
        
        displayTextPane.setText(result.toString());
    }

    /**
     * Go back to the start view.
     * @param evt evt
     */
    private void goBackButtonActionPerformed(ActionEvent evt) {
        c.openStartView();
        Frame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        
        timer.stop();
        timerLabel.setText("00:00:00");
    }

    private void saveGameButtonActionPerformed(ActionEvent evt) {
        SaveGame game = new SaveGame(InventoryModel.getList(), this.levelController);
        
        game.setPlayerX(levelController.getPlayerX());
        game.setPlayerY(levelController.getPlayerY());

        try {
            SaveManager.saveFile(game);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Help button.
     * @param evt evt
     */
    private void helpButtonActionPerformed(ActionEvent evt) {
        HelpViewController controller = new HelpViewController();
        controller.openHelpView();
    }

    /**
     * Get the display text pane.
     * @return the display text pane
     */
    public static JTextArea getInventory() {
        return inventoryTextArea;
    }
}
