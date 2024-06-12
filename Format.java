import java.awt.Font;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
public class Format {
    GUI gui;
    Font arial , comicSansMS , timesNewRoman; 
    String selectedFont;
    
    public Format(GUI gui){
        this.gui = gui;
    }

    public void wordWrap() {
        StyledDocument doc = gui.textArea.getStyledDocument();
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(attrs, 0.1f); // Adjust line spacing if needed

        if (!gui.wordWrapOn) {
            gui.wordWrapOn = true;
            doc.setParagraphAttributes(0, doc.getLength(), attrs, false);
            gui.iWrap.setText("Word Wrap : ON");
        } else {
            gui.wordWrapOn = false;
            StyleConstants.setLineSpacing(attrs, 0); // Reset line spacing
            doc.setParagraphAttributes(0, doc.getLength(), attrs, false);
            gui.iWrap.setText("Word Wrap : OFF");
        }
    }

    public void createFont(int fontSize){

        arial = new Font("Arial" , Font.PLAIN , fontSize);
        comicSansMS = new Font("Comic Sans MS" , Font.PLAIN , fontSize);
        timesNewRoman = new Font("Times New Roman" , Font.PLAIN , fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font){
        selectedFont = font;

        switch (selectedFont) {
            case "Arial":   gui.textArea.setFont(arial);
                            break;
            case "Comic Sans MS" : gui.textArea.setFont(comicSansMS);     
                            break;
            case "Times New Roman" : gui.textArea.setFont(timesNewRoman);
                            break;
            default:
                break;
        }
    }
    public void zoomIn() {
        Font currentFont = gui.textArea.getFont();
        int newSize = currentFont.getSize() + 1;
        Font newFont = new Font(currentFont.getName(), currentFont.getStyle(), newSize);
        gui.textArea.setFont(newFont);
    }

    public void zoomOut() {
        Font currentFont = gui.textArea.getFont();
        int newSize = Math.max(currentFont.getSize() - 1, 1); // Ensure font size doesn't go below 1
        Font newFont = new Font(currentFont.getName(), currentFont.getStyle(), newSize);
        gui.textArea.setFont(newFont);
    }
    
}