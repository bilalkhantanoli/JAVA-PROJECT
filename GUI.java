import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

public class GUI implements ActionListener{

    JFrame window;
    JTextPane textArea;
//    JtextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit , menuFormat , menuAbout;
    JMenuItem iNew , iOpen , iSave , iSaveAs, iExit;
    JMenuItem iWrap, iFontArial , iFontCSMS , iFontTNR , iFontSize8, iFontSize12 , iFontSize16 , iFontSize20 , iFontSize24 , iFontSize28;
    JMenuItem iTD;
    JMenuItem iAbout;

    File file = new File(this);
    Format format = new Format(this);
    Edit edit = new Edit(this);
	public GregorianCalendar gcalendar;

    public static void main(String[] args) {
        new GUI();
    }
    KeyStroke boldKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_B, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
    KeyStroke italicKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_I, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEdit();
        createFormatMenu();
        createAboutMenu();

        format.selectedFont = "Arial";
        format.createFont(12);
        format.wordWrap();
        window.setVisible(true);
        
        // Add a WindowAdapter to handle window closing event
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                file.exit(); // Call the exit() method when window is closing
            }
        });

    }

    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea(){
        textArea = new JTextPane();
        scrollPane = new JScrollPane(textArea , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menuFile);
        
        menuEdit = new JMenu("Edit");
        menuEdit.setMnemonic(KeyEvent.VK_E);
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuFormat.setMnemonic(KeyEvent.VK_O);
        menuBar.add(menuFormat);

        menuAbout = new JMenu("About Us");
        menuAbout.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menuAbout);
    }

    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        iNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        iOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        iSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        iExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        menuFile.add(iExit);
    }

    public void createEdit() {

    	    JMenuItem iBold = new JMenuItem("Bold (Ctrl + B)");
    	    iBold.addActionListener(this);
    	    iBold.setActionCommand("Bold");
    	    menuEdit.add(iBold);
    	    textArea.getInputMap().put(boldKeyStroke, "boldAction");
            textArea.getActionMap().put("boldAction", new StyledEditorKit.BoldAction());

    	    JMenuItem iItalic = new JMenuItem("Italic (Ctrl + I)");
    	    iItalic.addActionListener(this);
    	    iItalic.setActionCommand("Italic");
    	    menuEdit.add(iItalic);
            textArea.getInputMap().put(italicKeyStroke, "italicAction");
            textArea.getActionMap().put("italicAction", new StyledEditorKit.ItalicAction());
    	    
    	    JMenuItem iTD = new JMenuItem("Time & Date");
    	    iTD.addActionListener(this);
    	    iTD.setActionCommand("Date");
    	    menuEdit.add(iTD);
    }

    public void createFormatMenu(){
        iWrap = new JMenuItem("Word Wrap : OFF");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);
        
        JMenuItem iZoomIn = new JMenuItem("Zoom In");
        iZoomIn.addActionListener(this);
        iZoomIn.setActionCommand("Zoom In");
        iZoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ActionEvent.CTRL_MASK));
        menuFormat.add(iZoomIn);

        JMenuItem iZoomOut = new JMenuItem("Zoom Out");
        iZoomOut.addActionListener(this);
        iZoomOut.setActionCommand("Zoom Out");
        iZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
        menuFormat.add(iZoomOut);
        
        JMenu menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        JMenu menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);
    }

    public void createAboutMenu(){
        iAbout = new JMenuItem("About Us");
        iAbout.addActionListener(this);
        iAbout.setActionCommand("About Us");
        menuAbout.add(iAbout);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        switch(command){
            case "New":
                file.newFile();
                break;
            case "Open":
                file.open();
                break;
            case "SaveAs":
                file.saveAs();
                break;
            case "Save":
                file.save();
                break;
            case "Exit":
                file.exit();
                break; 
            case "Word Wrap":
                format.wordWrap();
                break;
            case "Arial":
            case "Comic Sans MS":
            case "Times New Roman":
                format.setFont(command);
                break;
            case "size8":
            case "size12":
            case "size16":
            case "size20":
            case "size24":
            case "size28":
                format.createFont(Integer.parseInt(command.substring(4)));
                break;
            case "About Us":
                showAboutUs();
                break; 
            case "Date":
                edit.dateTime();
                break;
            case "Bold":
            	edit.boldText();
                break;
            case "Italic":
                edit.italicizeText();
                break;        
            case "Zoom In":
                format.zoomIn();
                break;
            case "Zoom Out":
                format.zoomOut();
                break;
        }
    }

    private void showAboutUs() {
        String aboutMessage = "This Notepad application created in Java.";
        aboutMessage += "\nVersion 1.0";
        aboutMessage += "\n\nThank you for using our program!";
        javax.swing.JOptionPane.showMessageDialog(window, aboutMessage, "About Us", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
}
