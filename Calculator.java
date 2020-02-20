package com.example.ex1;

public class Calculator {
    // 3 + 6 = 9
    // 3 & 6 are called the operand.
    // The + is called the operator.
    // 9 is the result of the operation.
    private double mOperand;
    private double mWaitingOperand;
    private String mWaitingOperator;
    private double mCalculatorMemory;
    // operator types
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";
    public static final String CLEAR = "C" ;
    public static final String TOGGLESIGN = "+/-";
    // constructor
    public Calculator() {
        // initialize variables
        mOperand = 0; // currently entered / calculated value
        mWaitingOperand = 0; // previously entered / calculated value
        mWaitingOperator = "";
    }
    public void setOperand(double operand) { mOperand = operand; }
    public double getResult() { return mOperand; }
    public String toString() { return Double.toString(mOperand); }
    protected double performOperation(String operator) {
        if (operator.equals(CLEAR)) {
            mOperand = 0;
            mWaitingOperator = "";
            mWaitingOperand = 0;
        } else if (operator.equals(TOGGLESIGN)) {
            mOperand = -mOperand;
        } else {
            performWaitingOperation();
            mWaitingOperator = operator;
            mWaitingOperand = mOperand;
        }
        return mOperand;
    }
    protected void performWaitingOperation() {
        if (mWaitingOperator.equals(ADD)) {
            mOperand = mWaitingOperand + mOperand;
        } else if (mWaitingOperator.equals(SUBTRACT)) {
            mOperand = mWaitingOperand - mOperand;
        } else if (mWaitingOperator.equals(MULTIPLY)) {
            mOperand = mWaitingOperand * mOperand;
        } else if (mWaitingOperator.equals(DIVIDE)) {
            if (mOperand != 0) {
                mOperand = mWaitingOperand / mOperand;
            }
        }
    }
}
