/*
 *	Name: Anthony Dao 
 * 	USERNAME: adao4 
 * 	Email: adao4@toromail.csudh.edu
 */


/*

Grammar 

STATEMENTS  ::= EXPRESSION 
                | EXPRESSION ';'  STATEMENTS 
EXPRESSION    ::= ID "=" SUM	 
                | SUM
SUM           ::= TERM "+" SUM
                | TERM "-" SUM
                | TERM
TERM          ::= FACTOR "*" TERM
                | FACTOR "/" TERM
                | FACTOR "%" TERM
                | FACTOR
FACTOR        ::= PRIMARY "^" FACTOR
                | PRIMARY
PRIMARY       ::= "-" ELEMENT
                | ELEMENT
ELEMENT       ::= ID
                | NUMBER
                | "(" EXPRESSION ")"
ID            ::= NUMBER
                | 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k'
                | 'l' | 'm' | 'n' | 'o' | 'p' | 'q' | 'r' | 's' | 't' | 'u' | 'v'
                | 'w' | 'x' | 'y' | 'x'
NUMBER        ::= DIGIT
                | NUMBER DIGIT
DIGIT         ::= '1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'|'0' 




a few rewritten in eBNF

STATEMENTS  ::= EXPRESSION { ";"  EXPRESSION }
EXPRESSION    ::= ID "=" SUM    | SUM
SUM           ::= TERM { ("+" "-" ) TERM }
TERM          ::= FACTOR { ("*" "/" "%") FACTOR


*/




import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private List<Token> tokens;
    private int currentTokenIndex;
    private int value;
    public Map<String, Integer> symbolTable; 
    // Use a map to store variable names and their values.
                              
    public static boolean  DEBUG = false; 


    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.currentTokenIndex = 0;
        this.symbolTable = new HashMap<>(); // Initialize the symbol table.
    }

    public int Statements(){
        iPrint.println(1,"Statements ==>");
	value = Expression();
	while (match(";")) {
	    consume(";");
	    value = Expression();	
	}
        iPrint.println(-1,"Statements <==");
	return value;
    }

    public int Expression() {
        int result = 0;
        iPrint.println(1,"Expression ==>");
        if (match("ID")) {
            Token identifierToken = tokens.get(currentTokenIndex);;
            consume("ID");
            String identifierName = identifierToken.getName();

            // Check if the identifier exists in the symbol table.
            if (symbolTable.containsKey(identifierName)) {
                //if(DEBUG) iPrint.println("getting value from symboltable");
                result = symbolTable.get(identifierName);
                //if(DEBUG) iPrint.println("ID: " + identifierName + " = " + result);
                //if(DEBUG) iPrint.println(symbolTable);
            } else {
                //if(DEBUG) iPrint.println("putting ID into symboltable");
                result = 0; 
		//if(DEBUG) iPrint.println("Name: "+identifierName+" value: "+result);
                symbolTable.put(identifierName, result);
                //if(DEBUG) iPrint.println(symbolTable);      
            }
            if(match("=")) {
                consume("=");
            	value = Sum();
                // update sys-tab
		symbolTable.put(identifierName, value);
                iPrint.println("Assignment: " + identifierToken.getName() + " = " + value);
	    } else {
            	//if(DEBUG) iPrint.println("Back tracking: no assignment found");
            	currentTokenIndex -= 1;  // backup one token 
	    	//if(DEBUG) 
                   //iPrint.println("current token is now: "+tokens.get(currentTokenIndex));
            	iPrint.println("Expression: ");
            	value = Sum();
	    }
        } else {
            iPrint.println("Expression: ");
            value = Sum();
        }
	//if(DEBUG) 
	    iPrint.println("value = "+value);
        iPrint.println(-1,"Expression <==");
	return value;
    }

    public int Sum() {
        iPrint.println(1,"Sum ==>");
        int leftOperand = Term();
        while (match("+", "-")) {
            Token operatorToken = tokens.get(currentTokenIndex);
            consume("+-");
            int rightOperand = Term();
            if (operatorToken.getValue().equals("+")) {
                leftOperand += rightOperand;
            } else {
                leftOperand -= rightOperand;
            }
            iPrint.println("Addition/Subtraction");
        }
	//if(DEBUG) 
            iPrint.println("leftOperand = "+leftOperand);
        iPrint.println(-1,"Sum <==");
        return leftOperand;
    }

    public int Term() {
        iPrint.println(1,"Term ==>");
        int leftOperand = Factor();
        while (match("*", "/", "%")) {
        	// Create Token Object to match expresses given by user
        	Token operatorToken = tokens.get(currentTokenIndex);		// ADDED LINE
            consume("*/%");
            int rightOperand = Factor();								// ADDED LINE -  Initializes rightOperand to next value after Operator Value is consumed 
            if(operatorToken.getValue().equals("*")) { 					// ADDED LINE - Checks to see if * Operator is in tokens.
            	leftOperand *= rightOperand;							// ADDED LINE - if true, multiply Operands
            } else if(operatorToken.getValue().equals("/")) {			// ADDED LINE - Checks to see if / Operator is in tokens.
            	leftOperand /= rightOperand;							// ADDED LINE - if true, divide Operands
            } else {													// Else if modulus operator 
            	leftOperand %= rightOperand;							// Set LeftOperand(return variable) to the remainder 
            }	
            iPrint.println("Multiplication/Division/Modulus");
        }
	if(DEBUG) 
             iPrint.println("leftOperand = "+leftOperand);
        iPrint.println(-1,"Term <==");
        return leftOperand;
    }

    public int Factor() {
        iPrint.println(1,"Factor ==>");
        int leftOperand = Primary();
        int rightOperand=0; 
        while (match("^")) {
        	Token operatorToken = tokens.get(currentTokenIndex); 	// ADDED LINE - Create Token Object to for if statements
        	consume("^");
        	if(operatorToken.getValue().equals("^")) {				// ADDED LINE - if statement for checking for ^ operator
        		rightOperand = leftOperand;							// ADDED LINE - Sets rightOperand to LeftOperand for exponent operation
        		leftOperand = 1;									// ADDED LINE - Sets leftOperand to 1
        	for(int pow = Primary(); pow > 0; pow --) {				// ADDED LINE - For loop to perform exponential operation. 
        		leftOperand *= rightOperand;						// ADDED LINE - Int Pow set to number of multiplications need for exponential expression
        		}
        	}
        }
	if(DEBUG) 
            iPrint.println("leftOperand = "+leftOperand);
        iPrint.println(-1,"Factor <==");
        return leftOperand;
    }

    public int Primary() {
        iPrint.println(1,"Primary ==>");
        int result;
        if (match("-")) {
            Token operatorToken = tokens.get(currentTokenIndex);
            consume("-");
            int operand = Element();
            iPrint.println("Unary Negation");
            result = -operand;
        } else {
            result =  Element();
        }
	//if(DEBUG) 
            iPrint.println("result = "+result);
        iPrint.println(-1,"Primary <==");
	return result;
    }

    public int Element() {
        iPrint.println(1,"Element ==>");
        int result;
        if (match("ID")) {
            //if(DEBUG) iPrint.print("ID: ");
            Token identifierToken = tokens.get(currentTokenIndex);
	    String identifierName = identifierToken.getName();
            consume("ID");
            //if(DEBUG) iPrint.println(" {"+identifierToken+"} ");

            //// Check if the identifier exists in the symbol table.
            if (symbolTable.containsKey(identifierName)) {
                //if(DEBUG) iPrint.println("pulling from symboltable");
                result = symbolTable.get(identifierName);
                //if(DEBUG) iPrint.println("ID: " + identifierName + " = " + result);
		//if(DEBUG) iPrint.println(symbolTable);	
            } else {
                //if(DEBUG) iPrint.println("pulling ID/value into symboltable");
		result = 0; 
		symbolTable.put(identifierName, result);
		//if(DEBUG) iPrint.println(symbolTable);	
            }
        } else if (match("NUMBER")) {
            int constant = 0;
            Token numberToken = tokens.get(currentTokenIndex);
            consume("NUMBER");
            try {
               constant = Integer.parseInt(numberToken.getValue());
            } catch (Exception e) { 
                iPrint.println("Trying to get value: " + e.getMessage());
                System.exit(1);
            }
            if(DEBUG) iPrint.println("NUMBER (constant): " + constant);
            result = constant;
        } else if (match("(")) {
            consume(")");
            result = Expression();
            consume(")");
        } else {
            throw new RuntimeException("Unexpected token: " 
			+ tokens.get(currentTokenIndex).getValue());
        }
	//if(DEBUG) 
            iPrint.println("result = "+result);
        iPrint.println(-1,"Element <==");
        return result;
    }

    private boolean match(String... expectedTokens) {
        try {
            if(currentTokenIndex >= tokens.size())
                return false;
            Token currentToken = tokens.get(currentTokenIndex);
            String value = currentToken.getValue();
            String name = currentToken.getName();
            String type = currentToken.getType();
            //if(DEBUG) iPrint.print("entering MATCH: token: " + currentToken);
            //if(DEBUG) {
            //    iPrint.aprint(" called expecting:");
            //    String line = "";
            //    for (String str : expectedTokens) {
            //       line += str + ", ";
            //    }
            //    iPrint.aprintln(line);
            //}
            for (String expected : expectedTokens) {
                if (type.equals(expected) || name.equals(expected) || value.equals(expected)) {
                    iPrint.aprintln("    MATCH: matched " + currentToken);
                    return true;
                }
            }
        } catch (Exception e) {
            iPrint.zeroLevel();
            iPrint.println("(match) error " + e.getMessage());
            System.exit(1);
        }
        return false;
    }


    private Token consume(String expected) {
        Token currentToken = null ;
        try {
            iPrint.println("    CONSUME: consumed " + expected );
            if (currentTokenIndex < tokens.size()) {
                currentToken = tokens.get(currentTokenIndex);
                currentTokenIndex++;
            } else {
                iPrint.zeroLevel();
                iPrint.aprintln("\nconsume: Unexpected end of input");
                System.exit(1);
            }
        } catch (Exception e) {
                iPrint.println("(consume): " + e.getMessage());
                System.exit(1);
        }
        return currentToken;
    }


    public static void main(String[] args) {
        // if any arguments on the command line (other than java Parser)
        // tuen OFF the fancy printing
        iPrint.setIndentValue("  ");
	iPrint.noLevel();
	iPrint.noprint();

            for (int i=0; i<args.length; i++) {
                if(args[i].toLowerCase().indexOf("print") != -1 ? true : false) {
		    iPrint.yesprint();
                    System.out.println("indentation print turned  on");
                }//else {
		//    iPrint.noprint();
                //    System.out.println("indentation print turned  on");
		//}
                if(args[i].toLowerCase().indexOf("level") != -1 ? true : false) {
        	    iPrint.showLevel();
                    System.out.println("Showing level turned  on");
                }//else{
		//    iPrint.noLevel();
                //    iPrint.println("Showing level turned  off");
		//}
                if(args[i].toLowerCase().indexOf("debug") != -1 ? true : false) {
                    DEBUG = true; 
                    System.out.println("Debugging turned  on");
		    iPrint.yesprint();
                    System.out.println("indentation print turned  on");
		    iPrint.showLevel();
                    System.out.println("Showing level turned  on");
                }
            }
	System.out.println("indentation print is :"+ iPrint.NOPRINT );
	System.out.println("show levels print is :"+ iPrint.showlevel );
	System.out.println("DEBUGGING is "+ DEBUG );


        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print("Enter an expression (or 'exit' to quit): ");
            try{
                input = scanner.nextLine();
            } catch ( NoSuchElementException e){
                System.exit(1);
            }
            if (input.equalsIgnoreCase("exit")|| 
            	   input.equalsIgnoreCase("quit")) {
                break;
            }

            Tokenizer tokenizer = new Tokenizer(input);
            List<Token> tokens = tokenizer.tokenize();

            if(DEBUG)
               for( Token t : tokens )
                  iPrint.println(t.toString());

            Parser parser = new Parser(tokens);
            try {
                int result = parser.Statements();
                System.out.println("Result: " + result);
                if(parser.symbolTable.size()>0) 
			System.out.println(parser.symbolTable.toString());
            } catch (Exception e) {
                System.out.println("Execption thrown \n Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}



