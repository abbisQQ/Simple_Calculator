package com.abbisqq.elegantcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,add,divide,equal,dot,delete;
    private TextView upper, lower;
    private String numberOne,numberTwo,numberSave="";
    private float result;
    private boolean equalclicked=false;
    private String operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find all the buttons we need
        one = (Button)findViewById(R.id.one);
        two =(Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four =(Button)findViewById(R.id.four);
        five =(Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        add = (Button)findViewById(R.id.add);
        divide = (Button)findViewById(R.id.divide);
        equal = (Button)findViewById(R.id.equal);
        dot = (Button)findViewById(R.id.dot);
        delete=(Button)findViewById(R.id.delete);

        //and the text views
        upper = (TextView)findViewById(R.id.panel1);
        lower = (TextView)findViewById(R.id.panel2);

        //adding on click listeners
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        equal.setOnClickListener(this);
        delete.setOnClickListener(this);
        dot.setOnClickListener(this);
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        divide.setOnClickListener(this);
        plus.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

            if(equalclicked) {
                if (view != add && view != plus && view != minus && view != divide && view!=equal) {

                    upper.setText("");
                    lower.setText("");
                    numberOne = null;
                    numberTwo = null;
                    numberSave = "";
                    operator = null;

                }

                equalclicked = false;
            }


            if (view == one) {
                upper.setText(upper.getText() + "1");
                numberSave +="1";
            } else if (view == two) {
                upper.setText(upper.getText() + "2");
                numberSave +="2";
            } else if (view == three) {
                upper.setText(upper.getText() + "3");
                numberSave +="3";
            } else if (view == four) {
                upper.setText(upper.getText() + "4");
                numberSave +="4";
            } else if (view == five) {
                upper.setText(upper.getText() + "5");
                numberSave +="5";
            } else if (view == six) {
                upper.setText(upper.getText() + "6");
                numberSave +="6";
            } else if (view == seven) {
                upper.setText(upper.getText() + "7");
                numberSave +="7";
            } else if (view == eight) {
                upper.setText(upper.getText() + "8");
                numberSave +="8";
            } else if (view == nine) {
                upper.setText(upper.getText() + "9");
                numberSave +="9";
            } else if (view == zero) {
                upper.setText(upper.getText() + "0");
                numberSave +="0";


            } else if (view == add) {
                if (upper.getText() != "") {
                    if (upper.getText().toString().endsWith("+") || upper.getText().toString().endsWith("-") || upper.getText().toString().endsWith("*") || upper.getText().toString().endsWith("/")) {
                        upper.setText(upper.getText().subSequence(0, upper.length() - 1) + "+");
                    } else {
                        addPressed();
                        assignValue();
                        calculation();
                    }
                    operator = "+";
                }
            } else if (view == minus) {
                if (upper.getText() != "") {
                    if (upper.getText().toString().endsWith("+") || upper.getText().toString().endsWith("-") || upper.getText().toString().endsWith("*") || upper.getText().toString().endsWith("/")) {
                        upper.setText(upper.getText().subSequence(0, upper.length() - 1) + "-");
                    } else {
                        minusPressed();
                        assignValue();
                        calculation();

                    }
                    operator = "-";
                }
            } else if (view == plus) {
                if (upper.getText() != "") {
                    if (upper.getText().toString().endsWith("+") || upper.getText().toString().endsWith("-") || upper.getText().toString().endsWith("*") || upper.getText().toString().endsWith("/")) {
                        upper.setText(upper.getText().subSequence(0, upper.length() - 1) + "*");
                    } else {
                        plusPressed();
                        assignValue();
                        calculation();
                    }
                    operator = "*";
                }
            } else if (view == divide) {
                if (upper.getText() != "") {
                    if (upper.getText().toString().endsWith("+") || upper.getText().toString().endsWith("-") || upper.getText().toString().endsWith("*") || upper.getText().toString().endsWith("/")) {
                        upper.setText(upper.getText().subSequence(0, upper.length() - 1) + "/");
                    } else {
                        dividePressed();
                        assignValue();
                        calculation();
                    }
                    operator = "/";
                }
            }


            else if (view == dot) {

                if (upper.getText() == "") {
                    upper.setText("0.");
                    numberSave ="0.";

                }else if(upper.getText().toString().endsWith("+")||upper.getText().toString().endsWith("-")||upper.getText().toString().endsWith("*")||upper.getText().toString().endsWith("/")){
                    upper.setText(upper.getText() + "0.");
                    numberSave +="0.";
                }  else if(!upper.getText().toString().endsWith(".")&&!numberSave.contains(".")) {
                    upper.setText(upper.getText() + ".");
                    numberSave += ".";

                }


            } else if (view == delete) {
                upper.setText("");
                lower.setText("");
                numberOne=null;
                numberTwo=null;
                numberSave="";
                operator=null;
                result=0;
            }else if(view==equal){
                equalsPressed();
            }



        }


    public void minusPressed() {




       if(upper.getText() == "") {
            upper.setText(upper.getText() + "-");
            lower.setText("");
        } else if (!upper.getText().toString().endsWith("-")) {
            if(upper.getText().toString().contains("+")||upper.getText().toString().contains("-")||upper.getText().toString().contains("*")||upper.getText().toString().contains("/")) {
                upper.setText("("+upper.getText()+")" + "-");

            }else {
                upper.setText(upper.getText()+ "-");
            }
            lower.setText("");
        }
    }





    public void addPressed(){



        if(upper.getText().toString().contains("+")||upper.getText().toString().contains("-")||upper.getText().toString().contains("*")||upper.getText().toString().contains("/")) {
            upper.setText("("+upper.getText()+")" + "+");

        }else {
            upper.setText(upper.getText()+ "+");
        }
        lower.setText("");
    }

    public void plusPressed(){



        if(upper.getText().toString().contains("+")||upper.getText().toString().contains("-")||upper.getText().toString().contains("*")||upper.getText().toString().contains("/")) {
            upper.setText("("+upper.getText()+")" + "*");

        }else {
            upper.setText(upper.getText()+ "*");
        }
        lower.setText("");
    }

    public void dividePressed() {



        if (upper.getText().toString().contains("+") || upper.getText().toString().contains("-") || upper.getText().toString().contains("*") || upper.getText().toString().contains("/")) {
            upper.setText("(" + upper.getText() + ")" + "/");

        } else {
            upper.setText(upper.getText() + "/");
        }
        lower.setText("");
    }

    public void equalsPressed(){
            if(upper.getText().toString().endsWith("+")||upper.getText().toString().endsWith("-")||upper.getText().toString().endsWith("*")||upper.getText().toString().endsWith("/")){

        }else {
                assignValue();
                calculation();
                equalclicked = true;
            }






    }


    public void assignValue(){

        if(!upper.getText().toString().endsWith("+")||!upper.getText().toString().endsWith("-")||!upper.getText().toString().endsWith("*")||!upper.getText().toString().endsWith("/")) {
            if (numberOne != null) {
                numberTwo = numberSave;
            } else {
                numberOne = numberSave;
            }
            numberSave="";
        }




    }

public void calculation() {
    if (operator != null) {
        if (numberOne != null && numberTwo != null) {
            if (numberOne != "" && numberTwo != "") {
                if (operator.equals("+")) {
                    result = Float.parseFloat(numberOne) + Float.parseFloat(numberTwo);
                } else if (operator.equals("-")) {
                    result = Float.parseFloat(numberOne) - Float.parseFloat(numberTwo);

                } else if (operator.equals("*")) {
                    result = Float.parseFloat(numberOne) * Float.parseFloat(numberTwo);
                } else if (operator.equals("/")) {
                    result = Float.parseFloat(numberOne) / Float.parseFloat(numberTwo);
                }
            }
            if (result % 1 == 0) {

                lower.setText(String.valueOf((int) result));
            } else {
                lower.setText(String.valueOf(result));
            }
            numberOne = String.valueOf(result);
            numberTwo = null;
        }

    }
}
    }

