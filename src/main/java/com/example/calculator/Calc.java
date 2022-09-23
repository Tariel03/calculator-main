package com.example.calculator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Calc {
    @FXML
    private Button DeleteAll;

    @FXML
    private Button delete;

    @FXML
    private Button divide;

    @FXML
    private Button eight;
    @FXML
    private Button pi;

    @FXML
    private Button pow;

    @FXML
    private Button sqrt;

    @FXML
    private Button numberOfEuler;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button minus;

    @FXML
    private Button multiply;

    @FXML
    private Button nine;

    @FXML
    private Button one;
    @FXML
    private Button parents;
    @FXML
    private Button plus;

    @FXML
    private Button point;

    @FXML
    private Label result;
    @FXML
    private Label result1;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Button three;
    @FXML
    private Button equal;

    @FXML
    private AnchorPane face;
    public static double number = 0;
    public static double resultat = 0;
    @FXML
    private Button logth;

    @FXML
    private Button two;
    @FXML
    private Button zero;
    @FXML
    private Button Round;

    @FXML
    void initiliaze(){
    one.setOnMouseClicked(mouseEvent -> {
        addOne();
    });
    two.setOnMouseClicked(mouseEvent -> {
        addTwo();
    });
    three.setOnMouseClicked(mouseEvent -> {
        addThree();
        });
    four.setOnMouseClicked(mouseEvent -> {
      addFour();
        });
    five.setOnMouseClicked(mouseEvent -> {
        addFive();
        });
    six.setOnMouseClicked(mouseEvent -> {
        addSix();
        });
    seven.setOnMouseClicked(mouseEvent -> {
        addSeven();
        });
    eight.setOnMouseClicked(mouseEvent -> {
        addEight();
        });
    nine.setOnMouseClicked(mouseEvent -> {
        addNine();
    });
    zero.setOnMouseClicked(mouseEvent -> {
        addZero();
    });
    plus.setOnMouseClicked(mouseEvent -> {
        plus();
    });
    minus.setOnMouseClicked(mouseEvent -> {
        minus();
        });
    multiply.setOnMouseClicked(mouseEvent -> {
        multiply();
        });
    divide.setOnMouseClicked(mouseEvent -> {
        divide();
        });
    equal.setOnMouseClicked(mouseEvent -> {
        equal();
    });
    DeleteAll.setOnMouseClicked(mouseEvent -> {
        deleteAll();
    });
    delete.setOnMouseClicked(mouseEvent -> {
        delete();
    });
    logth.setOnMouseClicked(MouseEvent -> {
        addLog();
    });
    parents.setOnMouseClicked(MouseEvent->{
        addParents();
    });
    point.setOnMouseClicked(mouseEvent -> {
        addPoint();
    });
    pi.setOnMouseClicked(MouseEvent->{
        addPi();
    });
    numberOfEuler.setOnMouseClicked(MouseEvent->{
        addEuler();
    });
    sqrt.setOnMouseClicked(MouseEvent->{
        addSqrt();

    });
    pow.setOnMouseClicked(MouseEvent -> {
        addPow();
    });

    }

    private void addPow() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"^");

    }

    private void addSqrt() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"sqrt");
    }

    private void sqrt() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        int index = res.indexOf("(");
        String num1 = "";
        for(int i = index;i<res.length();i++){
            if (Character.isDigit(res.charAt(i))) {num1+=res.charAt(i);}
        }

        number = Math.sqrt(Double.parseDouble(num1));
        result.setText(String.valueOf(number));

    }

    private void addEuler() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+Math.E);
        else
            result.setText(String.valueOf(Math.E));
    }

    private void addPi() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+Math.PI);
        else
            result.setText(String.valueOf(Math.PI));
    }

    private void addPoint() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        if (!res.equals("")) {
            result.setText(res + ".");
        }
        else{
            result.setText(res+"0.");
        }
    }

    private void addLog() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        result.setText(res+"log");
    }

    private void addParents() {
        String res = result.getText();
        int count1 = 0;
        int count2 = 0;
        if (!result.equals("")){
            for (int i = 0;i<res.length();i++){
            if (res.charAt(i) == ')'){
                count1++;
            }else if(res.charAt(i)=='('){
                count2++;
            }
        }
        if (count1>count2 || count2==count1){
            result.setText(res+"(");
        }
        else if (count2>count1){
            result.setText(res+")");
        }

        }
    }
    private void log() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        String num2 = "";
        String num1= "";
        int indexofParent = res.indexOf("(");
        for(int i = 0;i<=indexofParent;i++){
            if (Character.isDigit(res.charAt(i))) {num1+=res.charAt(i);}
        }
        indexofParent = res.indexOf("(");
        for (int i = indexofParent;i<res.length();i++){
            if (Character.isDigit(res.charAt(i))) {num2+=res.charAt(i);}
        }
        number = Math.log(Double.parseDouble(num2))/Math.log(Double.parseDouble(num1));
        System.out.println(num1);
        System.out.println(num2);
        result.setText(String.valueOf(number));
    }

    private void delete() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        buffer.deleteCharAt(buffer.length()-1);
        res = String.valueOf(buffer);
        result.setText(res);
    }

    private void deleteAll() {
        result.setText("");
    }

    private void equal() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        if (buffer.indexOf("+") >= 0) {
            add();
        }
        if (buffer.indexOf("-") >= 0){
            subtract();
        }
        if (buffer.indexOf("*")>= 0){
            enlarge();
        }
        if (buffer.indexOf(":")>=0){
            part();
        }
        if (buffer.indexOf("log")>=0){
            log();
        }
        if (buffer.indexOf("sqrt")>=0){
            sqrt();
        }
        if (buffer.indexOf("^")>=0){
            pow();
        }

    }


    private void pow() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        String num2 = "";
        String num1= "";
        int indexofPower = res.indexOf("^");
        for(int i = 0;i<=indexofPower;i++){
            if (Character.isDigit(res.charAt(i))) {num1+=res.charAt(i);}
        }
        for (int i = indexofPower;i<res.length();i++){
            if (Character.isDigit(res.charAt(i))) {num2+=res.charAt(i);}
        }
        number = Math.pow(Double.parseDouble(num1),(Double.parseDouble(num2)));
        System.out.println(num1);
        System.out.println(num2);
        result.setText(String.valueOf(number));

    }


    private void part() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        int plusIndex = buffer.indexOf(":");
        System.out.println(res);
        double number1 = 0;
        double number2 = 0;
        Double [] numbers = {};
        for (int i = 0; i < buffer.length(); i++) {
            String numbeer1 = "";
            int j = 0;
            while (buffer.charAt(j) != ' ') {
                numbeer1 += String.valueOf(buffer.charAt(j));
                j++;
            }
            number1 = Double.parseDouble(numbeer1);
            numbeer1 = "";

            int indexOfplus = buffer.indexOf(":");
            for (int k = indexOfplus + 2; k < buffer.length(); k++)
                numbeer1 += String.valueOf(buffer.charAt(k));
            number2 = Double.parseDouble(numbeer1);

        }
        if (number2!= 0) {
            number =  (number1 / number2);
            result.setText(String.valueOf(number));
        }else{
            result.setText("Not possible to divide by 0");
        }


    }

    private void enlarge() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        int plusIndex = buffer.indexOf("*");
        System.out.println(res);
        double number1 = 0;
        double number2 = 0;
        for (int i = 0; i < buffer.length(); i++) {
            String numbeer1 = "";
            int j = 0;
            while (buffer.charAt(j) != ' ') {
                numbeer1 += String.valueOf(buffer.charAt(j));
                j++;
            }
            number1 = Double.parseDouble(numbeer1);
            numbeer1 = "";

            int indexOfplus = buffer.indexOf("*");
            for (int k = indexOfplus + 2; k < buffer.length(); k++)
                numbeer1 += String.valueOf(buffer.charAt(k));
            number2 = Double.parseDouble(numbeer1);

        }
        number = number1*number2;
        result.setText(String.valueOf(number));
        }

    private void subtract() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        int plusIndex = buffer.indexOf("-");
        System.out.println(res);
        double number1 = 0;
        double number2 = 0;
        for (int i = 0; i < buffer.length(); i++) {
            String numbeer1 = "";
            int j = 0;
            while (buffer.charAt(j) != ' ') {
                numbeer1 += String.valueOf(buffer.charAt(j));
                j++;
            }
            number1 = Double.parseDouble(numbeer1);
            numbeer1 = "";

            int indexOfplus = buffer.indexOf("-");
            for (int k = indexOfplus + 2; k < buffer.length(); k++)
                numbeer1 += String.valueOf(buffer.charAt(k));
            number2 = Double.parseDouble(numbeer1);

        }
        number = number1 - number2;
        result.setText(String.valueOf(number));

    }

    private void add() {
        String res = result.getText();
        StringBuffer buffer = new StringBuffer(res);
        int plusIndex = buffer.indexOf("+");
        System.out.println(res);
        double number1 = 0;
        double number2 = 0;
        for (int i = 0; i < buffer.length(); i++) {
            String numbeer1 = "";
            int j = 0;
            while (buffer.charAt(j) != ' ') {
                numbeer1 += String.valueOf(buffer.charAt(j));
                j++;
            }
            number1 = Double.parseDouble(numbeer1);
            numbeer1 = "";

            int indexOfplus = buffer.indexOf("+");
            for (int k = indexOfplus + 2; k < buffer.length(); k++)
                numbeer1 += String.valueOf(buffer.charAt(k));
            number2 = Double.parseDouble(numbeer1);

        }
        number = number1 + number2;
        result.setText(String.valueOf(number));
    }

    private void divide() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+" : ");
    }

    private void multiply() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+" * ");
    }


    private void minus() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+" - ");
    }

    private void plus() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+" + ");
    }


    private void addZero() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"0");
        else
            result.setText("0");

    }

    private void addNine() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"9");
        else
            result.setText("9");
    }

    private void addEight() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"8");
        else
            result.setText("8");

    }

    private void addSeven() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"7");
        else
            result.setText("7");

    }

    private void addSix() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res + "6");
        else
            result.setText("6");
    }

    private void addFive() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"5");
        else
            result.setText("5");

    }

    private void addFour() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"4");
        else
            result.setText("4");

    }

    private void addThree() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"3");
        else
            result.setText("3");

    }

    private void addTwo() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"2");
        else
            result.setText("2");

    }

    private void addOne() {
        String res = result.getText();
        if (!result.equals(""))
            result.setText(res+"1");
        else
            result.setText("1");
    }
}
