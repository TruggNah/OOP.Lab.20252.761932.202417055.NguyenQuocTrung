<<<<<<< HEAD
import javax.swing.JOptionPane;

public class SloveX {
    public static void main(String[] args) {
        String checkType, aone, atwo, athree, afour, bone, btwo;
        String strNotification = "Results:\n";

        checkType = JOptionPane.showInputDialog(null,
                "We have three type of sloving the 'X'\n Please chose 1 or 2 or 3 :\n1 is ax + b = 0\n2 is a11*x1 + a12*x2 = b1 and a21*x1 + a22*x2 = b2\n3 is ax^2 + bx + c = 0", "Input type of sloving X",
                JOptionPane.INFORMATION_MESSAGE);
        double point = Double.parseDouble(checkType);

        if(point == 1) {
                aone = JOptionPane.showInputDialog(null,
                        "Please input a to slove ax + b = 0: ", "Input a",
                        JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(aone);
                atwo = JOptionPane.showInputDialog(null,
                        "Please input b to slove ax + b = 0: ", "Input b",
                        JOptionPane.INFORMATION_MESSAGE);
                double b = Double.parseDouble(atwo);
                double s = - b / a;
                strNotification += "x = " + s  + "\n";
                JOptionPane.showMessageDialog(null, strNotification,
                        "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (point == 2){
                aone = JOptionPane.showInputDialog(null,
                        "Please input a11 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input a11",
                        JOptionPane.INFORMATION_MESSAGE);
                double a11 = Double.parseDouble(aone);
                atwo = JOptionPane.showInputDialog(null,
                        "Please input a12 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input a12",
                        JOptionPane.INFORMATION_MESSAGE);
                double a12 = Double.parseDouble(atwo);
                athree = JOptionPane.showInputDialog(null,
                        "Please input a21 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input a21",
                        JOptionPane.INFORMATION_MESSAGE);
                double a21 = Double.parseDouble(athree);
                afour = JOptionPane.showInputDialog(null,
                        "Please input a22 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input a22",
                        JOptionPane.INFORMATION_MESSAGE);
                double a22 = Double.parseDouble(afour);
                bone = JOptionPane.showInputDialog(null,
                        "Please input b1 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input b1",
                        JOptionPane.INFORMATION_MESSAGE);
                double b1 = Double.parseDouble(bone);
                btwo = JOptionPane.showInputDialog(null,
                        "Please input b2 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input b2",
                        JOptionPane.INFORMATION_MESSAGE);
                double b2 = Double.parseDouble(btwo);
                double s = a11*a22 - a12*a21;
                double x1 = (b1*a22 - b2*a12)/s;
                double x2 = (a11*b2 - a21*b1)/s;
                strNotification += "x1 = " + x1 + " ,x2 = " + x2 + "\n";
                JOptionPane.showMessageDialog(null, strNotification,
                        "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                aone = JOptionPane.showInputDialog(null,
                        "Please input a to slove ax^2 + bx + c = 0: ", "Input a",
                        JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(aone);
                atwo = JOptionPane.showInputDialog(null,
                        "Please input b to slove ax^2 + bx + c = 0: ", "Input b",
                        JOptionPane.INFORMATION_MESSAGE);
                double b = Double.parseDouble(atwo);
                athree = JOptionPane.showInputDialog(null,
                        "Please input b to slove ax^2 + bx + c = 0: ", "Input c",
                        JOptionPane.INFORMATION_MESSAGE);
                double c = Double.parseDouble(athree);
                double delta = b*b - 4*a*c;
                if(delta > 0) {
                    double x1 = (-b + Math.sqrt(delta))/(2*a);
                    double x2 = (-b - Math.sqrt(delta))/(2*a);
                    strNotification += "x1 = " + x1 + " ,x2 = " + x2 + "\n";
                    JOptionPane.showMessageDialog(null, strNotification,
                            "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (delta == 0) {
                    double x = -b/(2*a);
                    strNotification += "x = " + x + "\n";
                    JOptionPane.showMessageDialog(null, strNotification,
                            "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    strNotification += "No solution for x\n";
                    JOptionPane.showMessageDialog(null, strNotification,
                            "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        System.exit(0);
    }
=======
import javax.swing.JOptionPane;

public class SloveX {
    public static void main(String[] args) {
        String checkType, aone, atwo, athree, afour, bone, btwo;
        String strNotification = "Results:\n";

        checkType = JOptionPane.showInputDialog(null,
                "We have three type of sloving the 'X'\n Please chose 1 or 2 or 3 :\n1 is ax + b = 0\n2 is a11*x1 + a12*x2 = b1 and a21*x1 + a22*x2 = b2\n3 is ax^2 + bx + c = 0", "Input type of sloving X",
                JOptionPane.INFORMATION_MESSAGE);
        double point = Double.parseDouble(checkType);

        if(point == 1) {
                aone = JOptionPane.showInputDialog(null,
                        "Please input a to slove ax + b = 0: ", "Input a",
                        JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(aone);
                atwo = JOptionPane.showInputDialog(null,
                        "Please input b to slove ax + b = 0: ", "Input b",
                        JOptionPane.INFORMATION_MESSAGE);
                double b = Double.parseDouble(atwo);
                double s = - b / a;
                strNotification += "x = " + s  + "\n";
                JOptionPane.showMessageDialog(null, strNotification,
                        "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (point == 2){
                aone = JOptionPane.showInputDialog(null,
                        "Please input a11 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input a11",
                        JOptionPane.INFORMATION_MESSAGE);
                double a11 = Double.parseDouble(aone);
                atwo = JOptionPane.showInputDialog(null,
                        "Please input a12 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input a12",
                        JOptionPane.INFORMATION_MESSAGE);
                double a12 = Double.parseDouble(atwo);
                athree = JOptionPane.showInputDialog(null,
                        "Please input a21 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input a21",
                        JOptionPane.INFORMATION_MESSAGE);
                double a21 = Double.parseDouble(athree);
                afour = JOptionPane.showInputDialog(null,
                        "Please input a22 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input a22",
                        JOptionPane.INFORMATION_MESSAGE);
                double a22 = Double.parseDouble(afour);
                bone = JOptionPane.showInputDialog(null,
                        "Please input b1 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input b1",
                        JOptionPane.INFORMATION_MESSAGE);
                double b1 = Double.parseDouble(bone);
                btwo = JOptionPane.showInputDialog(null,
                        "Please input b2 to slove a11*x1 + a12*x2 = b1, a21*x1 + a22*x2 = b2: ", "Input b2",
                        JOptionPane.INFORMATION_MESSAGE);
                double b2 = Double.parseDouble(btwo);
                double s = a11*a22 - a12*a21;
                double x1 = (b1*a22 - b2*a12)/s;
                double x2 = (a11*b2 - a21*b1)/s;
                strNotification += "x1 = " + x1 + " ,x2 = " + x2 + "\n";
                JOptionPane.showMessageDialog(null, strNotification,
                        "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                aone = JOptionPane.showInputDialog(null,
                        "Please input a to slove ax^2 + bx + c = 0: ", "Input a",
                        JOptionPane.INFORMATION_MESSAGE);
                double a = Double.parseDouble(aone);
                atwo = JOptionPane.showInputDialog(null,
                        "Please input b to slove ax^2 + bx + c = 0: ", "Input b",
                        JOptionPane.INFORMATION_MESSAGE);
                double b = Double.parseDouble(atwo);
                athree = JOptionPane.showInputDialog(null,
                        "Please input b to slove ax^2 + bx + c = 0: ", "Input c",
                        JOptionPane.INFORMATION_MESSAGE);
                double c = Double.parseDouble(athree);
                double delta = b*b - 4*a*c;
                if(delta > 0) {
                    double x1 = (-b + Math.sqrt(delta))/(2*a);
                    double x2 = (-b - Math.sqrt(delta))/(2*a);
                    strNotification += "x1 = " + x1 + " ,x2 = " + x2 + "\n";
                    JOptionPane.showMessageDialog(null, strNotification,
                            "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (delta == 0) {
                    double x = -b/(2*a);
                    strNotification += "x = " + x + "\n";
                    JOptionPane.showMessageDialog(null, strNotification,
                            "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    strNotification += "No solution for x\n";
                    JOptionPane.showMessageDialog(null, strNotification,
                            "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        System.exit(0);
    }
>>>>>>> 0088b2f309d9d772e1cc0a1f61ca44a71985b779
}