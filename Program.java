import javax.swing.JOptionPane;

public class Program {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, Importer.read("file.txt"));
    }
}