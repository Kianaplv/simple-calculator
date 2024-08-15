//video link pishnahadi brocode baraye machine hesab ro ghabl zadan in code didam.
//in barname baraye ejraye yek amaliat mohasebatist
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame {
    public static void main(String[] args) {
        JFrame frame= new JFrame("calculator");//frame setting
        frame.setSize(500,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0xFF66B2));
        frame.setLayout(null);
        JPanel panel= new JPanel();//panel setting
        panel.setBounds(70,150,350,350);
        panel.setBackground(new Color(0xFF66B2));
        panel.setLayout(new GridLayout(4,4,10,10));
        JLabel showLabel= new JLabel();//Label setting
        showLabel.setBounds(130,60,250,60);
        showLabel.setOpaque(true);
        showLabel.setBackground(Color.darkGray); ;
        showLabel.setForeground(Color.WHITE);
        showLabel.setFont(new Font("Ink Free",Font.BOLD,25));
        JButton[] functionButton= new JButton[5];//sakhtan function buttons
        JButton addButton= new JButton("+");
        JButton subtractionButton= new JButton("-");
        JButton multiplyButton= new JButton("*");
        JButton divisionButton= new JButton("/");
        JButton decimalButton= new JButton(".");
        JButton deleteButton= new JButton("Delete");
        JButton clearButton= new JButton("Clear");
        JButton minusButton= new JButton("+/-");
        JButton equalsButton= new JButton("=");
        functionButton[0]=addButton;
        functionButton[1]=subtractionButton;
        functionButton[2]=multiplyButton;
        functionButton[3]=divisionButton;
        functionButton[4]=decimalButton;
        for(int i=0;i<5;i++) {
            functionButton[i].setFont(new Font("Ink Free",Font.BOLD,30));
            functionButton[i].setBackground(new Color(255,204,229));
            functionButton[i].setFocusable(false);
        }
        equalsButton.setFont(new Font("Ink Free",Font.BOLD,30));
        equalsButton.setBackground(new Color(255,204,229));
        equalsButton.setFocusable(false);
        deleteButton.setFont(new Font("Ink Free",Font.BOLD,15));
        clearButton.setFont(new Font("Ink Free",Font.BOLD,15));
        JButton[] numberButton= new JButton[10];//sakhtan number buttons
        for(int i=0;i<10;i++) {
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].setFont(new Font("Ink Free",Font.BOLD,30));
            numberButton[i].setBackground(new Color(255,204,229));
            numberButton[i].setFocusable(false);
        }
        JButton[] treeExtraButton= {deleteButton,clearButton,minusButton};
        for(int i=0;i<3;i++) {
            treeExtraButton[i].setFont(new Font("Ink Free",Font.BOLD,15));
            treeExtraButton[i].setBackground(new Color(255,204,229));
            treeExtraButton[i].setFocusable(false);
        }
        deleteButton.setBounds(70,520,100,80);
        clearButton.setBounds(195,520,100,80);
        minusButton.setBounds(320,520,100,80);

        for(JButton numb : numberButton){
            numb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    showLabel.setText(showLabel.getText()+numb.getLabel());
                }
            });
        }
        for(JButton func : functionButton){
            func.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    showLabel.setText(showLabel.getText()+func.getLabel());
                }
            });
        }
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String totalString= showLabel.getText();
                if(totalString.length()>0) {
                    String answer = totalString.substring(0, totalString.length() - 1);
                    showLabel.setText(answer);
                }
                else
                    showLabel.setText("");
            }
        });
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String totalString= showLabel.getText();
                Double result= Double.parseDouble(totalString);
                result*=-1;
                String answer= Double.toString(result);
                showLabel.setText(answer);
            }
        });

        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String totalString = showLabel.getText();
                String func = "";
                String answer="";
                for (int i = 0; i < totalString.length(); i++) {
                    if ((!Character.isDigit(totalString.charAt(i))&&!(totalString.charAt(i)=='.'))) {
                        func += totalString.charAt(i);
                    }
                }
                String[] input = totalString.split("\\"+func);
                int count=0;
                for(int i=0; i<input[0].length(); i++){
                    if(input[0].charAt(i)=='.')
                        count++;
                }
                if(count>1) {
                    answer="number is invalid";
                    showLabel.setText(answer);
                    return;
                }
                count=0;
                for(int i=0; i<input[1].length(); i++){
                    if(input[1].charAt(i)=='.')
                        count++;
                }
                if(count>1) {
                    answer="number is invalid";
                    showLabel.setText(answer);
                    return;
                }

                double result = 0;
                switch (func) {
                    case "+":{
                        result = Double.parseDouble(input[0]) + Double.parseDouble(input[1]);
                        break;}
                    case "-":{
                        result = Double.parseDouble(input[0]) - Double.parseDouble(input[1]);
                        break;}
                    case "*":{
                        result = Double.parseDouble(input[0]) * Double.parseDouble(input[1]);
                        break;}
                    case "/": {
                        if (Double.parseDouble(input[1]) == 0) {
                            answer = "cannot divided by zero";
                            showLabel.setText(answer);
                            return;
                        } else {
                            result = Double.parseDouble(input[0]) / Double.parseDouble(input[1]);
                            break;
                        }
                    }
                }
                answer= Double.toString(result);
                showLabel.setText(answer);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLabel.setText("");
            }
        });
        frame.add(showLabel); //adding part
        frame.add(panel);
        frame.setVisible(true);
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subtractionButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButton[0]);
        panel.add(equalsButton);
        panel.add(divisionButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(minusButton);
    }
}