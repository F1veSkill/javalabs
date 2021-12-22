package ru.mirea.prac9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class LabClassUI {

    private final LabClass labClass;

    private final JFrame frame;
    JList<String> table;

    public LabClassUI(){

        labClass = new LabClass();

        frame = new JFrame("Student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar bar = new JMenuBar();
        bar.add(createMenu());

        frame.setJMenuBar(bar);
        createTable(labClass.getStudents());

        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    private JMenu createMenu(){
        JMenu menu = new JMenu("Редактирование");
        JMenuItem addStudent = new JMenuItem("Добавить студента");
        JMenuItem findStudentById = new JMenuItem("Найти студента по ID");
        JMenuItem sort = new JMenuItem("Сортировать");


        addStudent.addActionListener(a -> createDialog());
        findStudentById.addActionListener(a-> createFindDialog());
        sort.addActionListener(a->labClass.sort());

        menu.add(addStudent);
        menu.add(findStudentById);
        return menu;
    }

    private void createTable(List<Student> students){
        DefaultListModel<String> dlm = new DefaultListModel<>();
        for (Student s:students) {
            dlm.addElement(s.toString());
        }
        table = new JList<>(dlm);
        frame.add(table);
    }


    private void createDialog(){
        AddStudentDialog dialog = new AddStudentDialog();
        dialog.addNewStudentListener( a-> {

            try {
                labClass.add(new Student(dialog.getId(), dialog.getStudentName(),
                        dialog.getSurname(), dialog.getPatronymic(), dialog.getGrade()));
                System.out.println(labClass.getStudents().toString());
                createTable(labClass.getStudents());
            } catch (EmptyStringException | NumberFormatException ex)
            {
                JDialog e = new JDialog(dialog, "Проверьте данные");
                e.add(new JLabel("Проверьте данные"));
                e.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                e.setSize(150, 100);
                e.pack();
                e.setVisible(true);
            }

        });
    }

    private void createFindDialog(){
        FindStudentDialog dialog = new FindStudentDialog();
        dialog.addFindListener( a-> {

            try {
                System.out.println(labClass.findById(dialog.getInfo()).toString());
                createTable(labClass.findById(dialog.getInfo()));
            } catch (EmptyStringException ex)
            {
                JDialog e = new JDialog(dialog, "Проверьте данные");
                e.add(new JLabel("Проверьте данные"));
                e.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                e.setSize(150, 100);
                e.pack();
                e.setVisible(true);
            }

        });
    }


    static class AddStudentDialog extends BaseDialog {


        private JTextField labelId;
        private JTextField labelName;
        private JTextField labelSurname;
        private JTextField labelPatronymic;
        private JTextField labelGrade;

        private JButton createStudentButton;

        public AddStudentDialog(){
            setLayout(new BorderLayout());
            createGUI();
            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            setSize(150, 100);
            pack();
            setVisible(true);
        }

        private void createGUI(){
            initComponent();
            Box box = new Box(BoxLayout.X_AXIS);
            box.add(labelId, BorderLayout.CENTER);
            box.add(labelName, BorderLayout.CENTER);
            box.add(labelSurname, BorderLayout.CENTER);
            box.add(labelPatronymic, BorderLayout.CENTER);
            box.add(labelGrade, BorderLayout.CENTER);

            add(box, BorderLayout.CENTER);
            add(createStudentButton, BorderLayout.SOUTH);
        }

        private void initComponent(){

            labelId = new JTextField("id");
            labelName = new JTextField("name");
            labelSurname = new JTextField("surname");
            labelPatronymic = new JTextField("Patronymic");
            labelGrade = new JTextField("grade");

            createStudentButton = new JButton("применить");
        }

        public void addNewStudentListener(ActionListener actionListener){
            createStudentButton.addActionListener(actionListener);
        }

        public String getId() {
            return labelId.getText();
        }

        public String getStudentName() throws EmptyStringException{
            String name = labelName.getText();
            checkData(name);
            return name;
        }

        public String getSurname() throws EmptyStringException {
            String surname = labelSurname.getText();
            checkData(surname);
            return surname;
        }

        public String getPatronymic() throws EmptyStringException {
            String patronymic  = labelPatronymic.getText();
            checkData(patronymic);
            return patronymic;
        }

        public int getGrade() throws EmptyStringException{
            String grade = labelGrade.getText();
            checkData(grade);
            return Integer.decode(grade);
        }
    }

    static class FindStudentDialog extends BaseDialog {

        private final JButton find;
        private final JTextField label;

        public void addFindListener(ActionListener actionListener){
            find.addActionListener(actionListener);
        }

        public String getInfo() throws EmptyStringException {
            String name = label.getText();
            checkData(name);
            return name;
        }

        public FindStudentDialog(){
            setLayout(new BorderLayout());

            label = new JTextField("");
            add(label, BorderLayout.CENTER);

            find = new JButton("Найти");
            add(find, BorderLayout.SOUTH);

            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            setSize(150, 100);
            pack();
            setVisible(true);
        }
    }

    static class BaseDialog extends JDialog{
        public void checkData(String str) throws EmptyStringException {
            if (str == null) {
                throw new EmptyStringException();
            }
        }
    }
}
