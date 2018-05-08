package com.lunasa.calculator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleCalculator {

    private static final Pattern exp = Pattern.compile("^\\s*(-?\\d*[.]?\\d*)?\\s*([+\\-*\\/])\\s*(-?\\d*\\.?\\d*)$");

    private static double calculate(double x, double y, String operation) {
        switch (operation) {
            case "+":
                return x+y;
            case "-":
                return x-y;
            case "/":
                return x/y;
            case "*":
                return x*y;
            default:
                throw new IllegalArgumentException("Unknown operation " + operation);
        }
    }

    private InputStream input;
    private PrintStream output;

    public ConsoleCalculator(InputStream input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        Scanner calcScan = new Scanner(input);
        output.println("Enter a simple expression (e.g. 2+2):");
        while(calcScan.hasNextLine()) {
            String line = calcScan.nextLine();
            Matcher m = exp.matcher(line);
            if (m.matches()) {
                double x = Double.parseDouble(m.group(1));
                double y = Double.parseDouble(m.group(3));
                String op = m.group(2);
                output.println(calculate(x, y, op));
            } else {
                output.println("Don't recognize the expression");
            }
            output.println("Enter a simple expression (e.g. 2+2):");
        }
    }
}
