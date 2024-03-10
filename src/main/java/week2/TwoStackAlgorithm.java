package week2;

public class TwoStackAlgorithm {
    public static Double calculate(String expression) {

        QueueBasedStack<Double> valueStack = new QueueBasedStack<>();
        QueueBasedStack<Character> operatorStack = new QueueBasedStack<>();

        String[] operations = expression.split("\\s+");

        for (String operation : operations) {

            char c = operation.charAt(0);

            if (Character.isDigit(c) || c == '.') {

                valueStack.push(Double.parseDouble(operation));

            } else if (c == ')') {

                char operator = operatorStack.pop();

                if(operator == '√'){

                    double number = valueStack.pop();
                    evaluateOperation(valueStack, operator, number);

                }else{

                    double number2 = valueStack.pop();
                    double number1 = valueStack.pop();
                    evaluateOperation(valueStack, operator, number1, number2);

                }

            } else if (isOperator(c)) {
                operatorStack.push(c);
            }else if (c == '('){}
        }
        if (valueStack.size() == 1 && operatorStack.isEmpty()) {
            return valueStack.pop();
        } else {
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    private static void evaluateOperation(QueueBasedStack<Double> valueStack , char operator, double number1, double number2){

        double result;

        switch(operator){

            case'+':
                result = number1 + number2;
                break;

            case '-':
                result = number1 - number2;
                break;

            case '*':
                result = number1 * number2;
                break;

            case '/':
                if (number2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = number1 / number2;
                break;

            case '%':
                result = number1 % number2;
                break;

            case '^':
                result = Math.pow(number1 , number2);
                break;


            default:
                throw new IllegalArgumentException("Invalid operator");

        }

        valueStack.push(result);

    }

    private static void evaluateOperation(QueueBasedStack<Double> valueStack , char operator, double number){

        double result;

        switch(operator){
            case '√':
                result = Math.sqrt(number);
                break;

            default:
                throw new IllegalArgumentException("Invalid operator");

        }

        valueStack.push(result);

    }

    private static boolean isOperator(char c) {

        return c == '-' || c == '+' || c == '*' || c == '/' || c == '%' || c == '^' || c == '√';

    }

}