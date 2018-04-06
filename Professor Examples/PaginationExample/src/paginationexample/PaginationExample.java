//  Program: PaginationExample.java
//  Modified by: Gary R. Smith
/*  Taken from Oracles web site and augmented with comments and additional code.
 */
package paginationexample;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import javax.swing.JOptionPane;

public class PaginationExample implements Printable, ActionListener
{

    int[] pageBreaks;    //  Array of page break line positions.
    String[] textLines;  //  Stores the detail lines of the report.
    int numLines = 200;  //  Estimated number of detail lines in the report.

    //  Loads data into an array.
    private void initTextLines()
    {
        if (textLines == null)
        {
            textLines = new String[numLines];
            for (int i = 0; i < numLines; i++)
            {
                textLines[i] = "This is line number " + (i + 1);
            }
        }
    }

    public int print(Graphics g, PageFormat pf, int pageIndex)
            throws PrinterException
    {

        //  This is used to calculate the number of pages in the report.
        //  You may have to adjust those depending upon the heading you have.
        Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        if (pageBreaks == null)
        {
            initTextLines();
            int linesPerPage = (int) (pf.getImageableHeight() / lineHeight);
            //  Here is where you would subtract whatever heading lines you
            //  have.  Be sure to account for any blank lines.
            //  linesPerPage -= number of heading lines
            int numBreaks = (textLines.length - 1) / linesPerPage;
            pageBreaks = new int[numBreaks];
            for (int b = 0; b < numBreaks; b++)
            {
                pageBreaks[b] = (b + 1) * linesPerPage;
            }
        }
        System.out.println("pageBreaks.length: " + pageBreaks.length);

        if (pageIndex > pageBreaks.length)
        {
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         * Since we are drawing text we
         */
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Draw each line that is on this page.
         * Increment 'y' position by lineHeight for each line.
         */
        int y = 0;
        y += lineHeight;
        //  This is a heading line
        g.drawString("Some Report Title", 200, y);

        //  This starts the detail (report body) line output.
        int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex - 1];
        int end
                = (pageIndex == pageBreaks.length) ? textLines.length : pageBreaks[pageIndex];
        for (int line = start; line < end; line++)
        {
            y += lineHeight;
            g.drawString(textLines[line], 0, y);
        }

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

    public void actionPerformed(ActionEvent e)
    {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok)
        {
            try
            {
                job.print();
            } catch (PrinterException ex)
            {
                // The job did not successfully complete
                JOptionPane.showMessageDialog(null, "Ooops.  your report did not print!");
            }
        }
    }

    public static void main(String args[])
    {
        //  Gets the native look and feel
        try
        {
            String cn = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(cn);
        } catch (Exception cnf)
        {
        }
        JFrame f = new JFrame("Printing Pagination Example");
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        JButton printButton = new JButton("Print Pages");
        printButton.addActionListener(new PaginationExample());
        f.add("Center", printButton);
        f.pack();
        f.setVisible(true);
    }
}
