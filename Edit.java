import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;


public class Edit {
    GUI gui;
    public Edit(GUI gui){
        this.gui = gui;
    }

    public void dateTime() {
        gui.gcalendar = new GregorianCalendar();
        String hour = String.valueOf(gui.gcalendar.get(Calendar.HOUR));
        String min = String.valueOf(gui.gcalendar.get(Calendar.MINUTE));
        String sec = String.valueOf(gui.gcalendar.get(Calendar.SECOND));
        String date = String.valueOf(gui.gcalendar.get(Calendar.DATE));
        String month = String.valueOf(gui.gcalendar.get(Calendar.MONTH) + 1); // Month starts from 0
        String year = String.valueOf(gui.gcalendar.get(Calendar.YEAR));

        if (Integer.parseInt(hour) < 10)
            hour = "0" + hour;

        if (Integer.parseInt(min) < 10)
            min = "0" + min;

        if (Integer.parseInt(sec) < 10)
            sec = "0" + sec;

        if (Integer.parseInt(date) < 10)
            date = "0" + date;

        if (Integer.parseInt(month) < 10)
            month = "0" + month;

        if (Integer.parseInt(year) < 10)
            year = "0" + year;

        String total = "Time :- " + hour + ":" + min + ":" + sec + "    Date :- " + date + "/" + month + "/" + year;

        StyledDocument doc = gui.textArea.getStyledDocument();
        try {
            int loc = doc.getLength(); // Get the end position of the document
            doc.insertString(loc, total, null); // Insert the text at the end
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    public void boldText() {
        StyledDocument doc = gui.textArea.getStyledDocument();
        int start = gui.textArea.getSelectionStart();
        int end = gui.textArea.getSelectionEnd();

        AttributeSet attrs = doc.getCharacterElement(start).getAttributes();
        MutableAttributeSet attrSet = new SimpleAttributeSet(attrs);
        StyleConstants.setBold(attrSet, !StyleConstants.isBold(attrs));
        doc.setCharacterAttributes(start, end - start, attrSet, false);
    }

    public void italicizeText() {
        StyledDocument doc = gui.textArea.getStyledDocument();
        int start = gui.textArea.getSelectionStart();
        int end = gui.textArea.getSelectionEnd();

        AttributeSet attrs = doc.getCharacterElement(start).getAttributes();
        MutableAttributeSet attrSet = new SimpleAttributeSet(attrs);
        StyleConstants.setItalic(attrSet, !StyleConstants.isItalic(attrs));
        doc.setCharacterAttributes(start, end - start, attrSet, false);
    }



  }
