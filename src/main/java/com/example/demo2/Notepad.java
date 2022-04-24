package com.example.demo2;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class Notepad extends JFrame implements ActionListener {

    JTextArea t;
    JFrame f;

    Notepad()
    {
        f = new JFrame("Notepad");

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch (Exception e) {
        }

        t = new JTextArea();

        JMenuBar menu = new JMenuBar();

        JMenu file = new JMenu("File");

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem print = new JMenuItem("Print");

        newFile.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        print.addActionListener(this);

        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(print);

        JMenu edit = new JMenu("Edit");

        JMenuItem cut = new JMenuItem("cut");
        JMenuItem copy = new JMenuItem("copy");
        JMenuItem paste = new JMenuItem("paste");

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);

        JMenu font = new JMenu("Font");

        JMenuItem bold = new JMenuItem("bold");
        JMenuItem italic = new JMenuItem("italic");
        JMenuItem plain = new JMenuItem("plain");

        bold.addActionListener(this);
        italic.addActionListener(this);
        plain.addActionListener(this);

        font.add(bold);
        font.add(italic);
        font.add(plain);

        JMenu fontStyle = new JMenu("Font Style");

        JMenuItem arial = new JMenuItem("Arial");
        JMenuItem calibri = new JMenuItem("Calibri");
        JMenuItem serif = new JMenuItem("Serif");
        JMenuItem timesNewRoman = new JMenuItem("Times New Roman");

        timesNewRoman.addActionListener(this);
        calibri.addActionListener(this);
        arial.addActionListener(this);
        serif.addActionListener(this);

        fontStyle.add(arial);
        fontStyle.add(calibri);
        fontStyle.add(serif);
        fontStyle.add(timesNewRoman);

        JMenu fontSize = new JMenu("Font Size");

        JMenuItem eight = new JMenuItem("8");
        JMenuItem ten = new JMenuItem("10");
        JMenuItem eleven = new JMenuItem("11");
        JMenuItem twelve = new JMenuItem("12");
        JMenuItem sixteen = new JMenuItem("16");
        JMenuItem twenty = new JMenuItem("20");
        JMenuItem twentyFive = new JMenuItem("25");
        JMenuItem thrity = new JMenuItem("30");
        JMenuItem fourtyEight = new JMenuItem("48");
        JMenuItem sixtyFour = new JMenuItem("64");

        eight.addActionListener(this);
        ten.addActionListener(this);
        eleven.addActionListener(this);
        twelve.addActionListener(this);
        sixteen.addActionListener(this);
        twenty.addActionListener(this);
        twentyFive.addActionListener(this);
        thrity.addActionListener(this);
        fourtyEight.addActionListener(this);
        sixtyFour.addActionListener(this);

        fontSize.add(eight);
        fontSize.add(ten);
        fontSize.add(eleven);
        fontSize.add(twelve);
        fontSize.add(sixteen);
        fontSize.add(twenty);
        fontSize.add(twentyFive);
        fontSize.add(thrity);
        fontSize.add(fourtyEight);
        fontSize.add(sixtyFour);

        JMenuItem close = new JMenuItem("close");

        close.addActionListener(this);

        menu.add(file);
        menu.add(edit);
        menu.add(font);
        menu.add(fontStyle);
        menu.add(fontSize);
        menu.add(close);

        f.setJMenuBar(menu);
        f.add(t);
        f.setSize(500, 500);
        f.show();
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        if (s.equals("cut")) {
            t.cut();
        }
        else if (s.equals("copy")) {
            t.copy();
        }
        else if (s.equals("paste")) {
            t.paste();
        }
        else if (s.equals("bold")) {
            Font fontType = new Font("Times New Roman", Font.BOLD, 12);
            t.setFont(fontType);
        }
        else if (s.equals("italic")) {
            Font fontType = new Font("Times New Roman", Font.ITALIC, 12);
            t.setFont(fontType);
        }
        else if (s.equals("plain")) {
            Font fontType = new Font("Times New Roman", Font.PLAIN, 12);
            t.setFont(fontType);
        }
        else if (s.equals("Times New Roman")) {
            Font fontType = new Font("Times New Roman", Font.PLAIN, 12);
            t.setFont(fontType);
        }
        else if (s.equals("Arial")) {
            Font fontType = new Font("Arial", Font.PLAIN, 12);
            t.setFont(fontType);
        }
        else if (s.equals("Serif")) {
            Font fontType = new Font("Serif", Font.PLAIN, 12);
            t.setFont(fontType);
        }
        else if (s.equals("Calibri")) {
            Font fontType = new Font("Calibri", Font.PLAIN, 12);
            t.setFont(fontType);
        }
        else if (s.equals("8")) {
            Font fontType = new Font("Times New Roman", Font.BOLD, 8);
            t.setFont(fontType);
        }
        else if (s.equals("10")) {
            Font fontType = new Font("Times New Roman", Font.ITALIC, 10);
            t.setFont(fontType);
        }
        else if (s.equals("11")) {
            Font fontType = new Font("Times New Roman", Font.PLAIN, 11);
            t.setFont(fontType);
        }
        else if (s.equals("12")) {
            Font fontType = new Font("Times New Roman", Font.PLAIN, 12);
            t.setFont(fontType);
        }
        else if (s.equals("16")) {
            Font fontType = new Font("Times New Roman", Font.PLAIN, 16);
            t.setFont(fontType);
        }
        else if (s.equals("20")) {
            Font fontType = new Font("Times New Roman", Font.PLAIN, 20);
            t.setFont(fontType);
        }
        else if (s.equals("25")) {
            Font fontType = new Font("Times New Roman", Font.PLAIN, 25);
            t.setFont(fontType);
        }
        else if (s.equals("30")) {
            Font fontType = new Font("Times New Roman", Font.PLAIN, 30);
            t.setFont(fontType);
        }
        else if (s.equals("48")) {
            Font fontType = new Font("Times New Roman", Font.PLAIN, 48);
            t.setFont(fontType);
        }
        else if (s.equals("64")) {
            Font fontType = new Font("Times New Roman", Font.PLAIN, 64);
            t.setFont(fontType);
        }
        else if (s.equals("Save")) {
            JFileChooser j = new JFileChooser("f:");
            int r = j.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {

                File fi = new File(j.getSelectedFile().getAbsolutePath());

                try {
                    FileWriter wr = new FileWriter(fi, false);
                    BufferedWriter w = new BufferedWriter(wr);

                    w.write(t.getText());
                    w.flush();
                    w.close();
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
            else
                JOptionPane.showMessageDialog(f, "the user cancelled the operation");
        }
        else if (s.equals("Print")) {
            try {
                t.print();
            }
            catch (Exception evt) {
                JOptionPane.showMessageDialog(f, evt.getMessage());
            }
        }
        else if (s.equals("Open")) {
            JFileChooser j = new JFileChooser("f:");
            int r = j.showOpenDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                File fi = new File(j.getSelectedFile().getAbsolutePath());

                try {
                    String s1 = "", sl = "";

                    FileReader fr = new FileReader(fi);

                    BufferedReader br = new BufferedReader(fr);

                    sl = br.readLine();

                    while ((s1 = br.readLine()) != null) {
                        sl = sl + "\n" + s1;
                    }

                    t.setText(sl);
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
            else
                JOptionPane.showMessageDialog(f, "the user cancelled the operation");
        }
        else if (s.equals("New")) {
            t.setText("");
        }
        else if (s.equals("close")) {
            f.setVisible(false);
        }
    }

    public static void main()
    {
        Notepad notepad = new Notepad();
    }
}