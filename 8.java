import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame implements ActionListener {
    JTextField t1, t2;
    JComboBox<String> branch;
    JRadioButton male, female;
    JCheckBox java, python;
    JButton submit, clear;
    JTextArea area;
    StudentForm() {
        setTitle("Student Registration Form");
        setSize(450, 500);
        setLayout(new FlowLayout());
        add(new JLabel("USN"));
        t1 = new JTextField(20);
        add(t1);
        add(new JLabel("Name"));
        t2 = new JTextField(20);
        add(t2);
        add(new JLabel("Branch"));
        String b[] = {"Computer Science", "Information Technology", "ECE", "EEE"};
        branch = new JComboBox<>(b);
        add(branch);
        add(new JLabel("Gender"));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        add(male);
        add(female);
        add(new JLabel("Skills"));
        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        add(java);
        add(python);
        submit = new JButton("Submit");
        clear = new JButton("Clear");
        add(submit);
        add(clear);
        area = new JTextArea(8, 30);
        area.setEditable(false);
        add(area);
        submit.addActionListener(this);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                t2.setText("");
                male.setSelected(false);
                female.setSelected(false);
                java.setSelected(false);
                python.setSelected(false);
                area.setText("");
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String gender = "";
        if (male.isSelected())
            gender = "Male";
        else if (female.isSelected())
            gender = "Female";
        String skills = "";
        if (java.isSelected())
            skills += "Java ";
        if (python.isSelected())
            skills += "Python";
        area.setText(
                "Student Details\n\n" +
                "USN : " + t1.getText() +
                "\nName : " + t2.getText() +
                "\nBranch : " + branch.getSelectedItem() +
                "\nGender : " + gender +
                "\nSkills : " + skills);
    }
    public static void main(String[] args) {
        new StudentForm();
    }
}
