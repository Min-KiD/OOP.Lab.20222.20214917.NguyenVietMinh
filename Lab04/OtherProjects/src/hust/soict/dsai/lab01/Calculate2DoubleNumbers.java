package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;

public class Calculate2DoubleNumbers{
  public static void main(String[] args) {
    String num1String = JOptionPane.showInputDialog(null, "Enter the first number:", "Input First Number", JOptionPane.INFORMATION_MESSAGE);
    double num1 = Double.parseDouble(num1String);

    String num2String = JOptionPane.showInputDialog(null, "Enter the second number:", "Input Second Number", JOptionPane.INFORMATION_MESSAGE);
    double num2 = Double.parseDouble(num2String);

    double sum = num1 + num2;
    double difference = num1 - num2;
    double product = num1 * num2;
    double quotient = num1 / num2;
    
    String results = "Sum: " + sum + "\n" +
                         "Difference: " + difference + "\n" +
                         "Product: " + product + "\n" +
                         "Quotient: " + quotient;
        JOptionPane.showMessageDialog(null, results, "Calculator", JOptionPane.INFORMATION_MESSAGE);
   }
}
