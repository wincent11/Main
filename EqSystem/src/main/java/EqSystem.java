import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class EqSystem {
    static final Pattern OPERATORS = Pattern.compile("[+\\-*/]");
    static final Pattern EQUALS_MODEL = Pattern.compile("(.*)=(.*)");
    static final Pattern BRACKETS = Pattern.compile("[\\(\\)]");
    static final Pattern VARIABLE_MODEL = Pattern.compile("(.*\\d)(\\w)");
    static final Pattern MULTIPLICATION_MODEL = Pattern.compile(".*([\\+-]\\d*\\w+)(\\([\\w*[/\\+\\*-]]*\\w+\\)).*");
    static final Pattern ADD_ONE_MODEL = Pattern.compile("(.*[\\-])(\\(.*\\).*)");

    public static void main(String[] args) {
//        System.out.println(simplify(new String[]{"a + a = b", "b - d = c", "a + b = d"}, "c + a + b"));
        System.out.println(simplify(new String[]{"a + 3g = k", "70a = g"}, "-k + a"));
//        System.out.println(MULTIPLICATION_MODEL.matcher("b-a-2a(a-b)+5d+1a-(a+b)").replaceAll("$1_$2"));
//        System.out.println("((x-x))".matches(MULTIPLICATION_MODEL.pattern()));
//        System.out.println(VARIABLE_MODEL.matcher("-a").replaceAll("$1_$2"));
    }


    public static String simplify(String[] examples, String formula) {


        //include examples in main formula
        formula = simplifyMainFormula(examples, formula);

        //add one after minus symbol
        formula = addOne(formula);

        //make multiplication onn brackets
        formula = multiplicationBrackets(formula);

        while (formula.contains(")")) {
            String model = formula.replaceAll(".*(\\([\\w*[/\\+\\*-]]*\\w+\\)).*", "$1");
            formula = calculate(model, formula);
        }

        formula = calculate(formula, formula);
        return formula;
    }


    static String calculate(String model, String formula) {

        LinkedList<String> variables = new LinkedList<>(Arrays.asList(model.replaceAll(BRACKETS.pattern(), "").replaceAll("(" + OPERATORS.pattern() + "\\w)", "_$1").split("_")));
        variables.remove("");
        LinkedList<String> variablesResult = variables;
        StringBuilder resultFormula = new StringBuilder();

        for (String item : variables) {
            Integer itemNumber = 1;
            if (item.matches(".*\\d.*")) {
                itemNumber = Integer.parseInt(VARIABLE_MODEL.matcher(item).replaceAll("$1"));
            }
            String itemLetter;
            if (item.matches(".*[a-zA-Z].*")) {
                itemLetter = VARIABLE_MODEL.matcher(item).replaceAll("$2");
            } else {
                itemLetter = null;
            }

            for (int i = 1; i < variablesResult.size(); i++) {
                Integer currentNumber = 1;
                String currentLetter = null;
                if (variablesResult.get(i).matches(".*\\d.*")) {
                    currentNumber = Integer.parseInt(VARIABLE_MODEL.matcher(variablesResult.get(i)).replaceAll("$1"));
                }
                if (variablesResult.get(i).matches(".*[a-zA-Z].*")) {
                    currentLetter = VARIABLE_MODEL.matcher(variablesResult.get(i)).replaceAll("$2");
                    if (currentLetter.contains(itemLetter)) {
                        if (currentLetter.substring(0,1).equals("+")) {
                            itemNumber = itemNumber + currentNumber;
                            variablesResult.remove(i);
                            i--;
                        }else {
                            itemNumber = itemNumber - currentNumber;
                            variablesResult.remove(i);
                            i--;
                        }
                    }
                }
            }
            if (itemLetter == null) {
                resultFormula.append(itemNumber);
            } else
                resultFormula.append(itemNumber + itemLetter);
        }

        formula = formula.replace(model, resultFormula.toString());
        return formula;
    }

    static String simplifyMainFormula(String[] examples, String formula) {
        Map<String, String> components = new HashMap<>();

        formula = formula.replaceAll("\\s", "");// remove white-space


        Arrays.asList(examples).forEach(comp ->
                components.put(EQUALS_MODEL.matcher(comp.replaceAll("\\s", "")).replaceAll("$2"),
                        EQUALS_MODEL.matcher(comp.replaceAll("\\s", "")).replaceAll("$1"))
        );

        while (true) {
            boolean breakpoint = true;
            for (String item : formula.split("")) {
                if (components.containsKey(item)) {
                    formula = formula.replaceAll(item, "(" + components.get(item) + ")");
                    breakpoint = false;
                }
            }
            if (breakpoint) break;
        }
        return formula;
    }

    static String multiplicationBrackets(String formula) {
        while (formula.matches(MULTIPLICATION_MODEL.pattern())) {
            String model = MULTIPLICATION_MODEL.matcher(formula).replaceAll("$1$2");
            String itemPredicate = MULTIPLICATION_MODEL.matcher(formula).replaceAll("$1");
            String itemMainExpression = MULTIPLICATION_MODEL.matcher(formula).replaceAll("$2");

            Integer itemNumber = 1;
            if (itemPredicate.matches(".*\\d.*")) {
                itemNumber = Integer.parseInt(VARIABLE_MODEL.matcher(itemPredicate).replaceAll("$1"));
            }
            String itemLetter = "";
            if (itemPredicate.matches(".*[a-zA-Z].*")) {
                itemLetter = VARIABLE_MODEL.matcher(itemPredicate).replaceAll("$2");
            }

            LinkedList<String> variables = new LinkedList<>(Arrays.asList(itemMainExpression.replaceAll(BRACKETS.pattern(), "").replaceAll("(" + OPERATORS.pattern() + "\\w)", "_$1").split("_")));
            variables.remove("");
            LinkedList<String> variablesResult = variables;
            StringBuilder resultFormula = new StringBuilder();


            for (int i = 0; i < variablesResult.size(); i++) {
                Integer currentNumber = 1;
                String currentLetter = "";
                if (variablesResult.get(i).matches(".*\\d.*")) {
                    currentNumber = Integer.parseInt(VARIABLE_MODEL.matcher(variablesResult.get(i)).replaceAll("$1"));
                }
                currentLetter = VARIABLE_MODEL.matcher(variablesResult.get(i)).replaceAll("$2");

                currentNumber = currentNumber * itemNumber;

                resultFormula.append(currentNumber < 0 ? currentNumber : "+" + currentNumber);
                resultFormula.append(itemLetter + currentLetter);
            }

            formula = formula.replace(model, resultFormula.toString());
        }
        return formula;
    }

    static String addOne(String formula) {
        return ADD_ONE_MODEL.matcher(formula).replaceAll("$11$2");
    }
}
