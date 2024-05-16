
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Tokenizer {
    private static boolean DEBUG = true;// false;

    private static final Pattern TOKEN_PATTERN = Pattern.compile(
       "\\s*([a-zA-Z_][a-zA-Z_0-9]*|[-+*/%^()=;]|[0-9]+)");


    private List<Token> tokens;
    private int currentTokenIndex;

    public Tokenizer(String input) {
        tokens = tokenize(input);
        currentTokenIndex = 0;
    }

    private List<Token> tokenize(String input) {
    //    List<Token> tokens = new ArrayList<>();
    //    for (int i = 0; i < input.length(); i++) {
    //        String tokenString = String.valueOf(input.charAt(i));
    //        tokens.add(new Token(tokenString, tokenString));
    //    }
        List<Token> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERN.matcher(input);

        while (matcher.find()) {
            String tokenValue = matcher.group(1);
            tokens.add(new Token(tokenValue, tokenValue));
        }
    
        if(DEBUG) {
            iPrint.println(" raw tokens: ");
            System.out.println( " raw tokens: " );
            String line = null;
            for (Token t : tokens) {
                line += ", "+t; }
            iPrint.println( line );
            System.out.println( line );
        }

        return tokens;
    }

    public List<Token> tokenize() {
        List<Token> resultTokens = new ArrayList<>();
        for (Token token : tokens) {
            if(DEBUG) iPrint.println("TOKENIZE: "+token);
            if (isIdentifier(token.getName())) {
                resultTokens.add(new Token("ID", token.getName(), token.getName()));
            } else
            if (isOperator(token.getName())) {
                resultTokens.add(new Token("OPERATOR", token.getName(), token.getName()));
            } else
            if (isNumber(token.getName())) {
                resultTokens.add(new Token("NUMBER", token.getName(), token.getName()));
            } else
            if (isWhiteSpace(token.getName())) {
		continue;
            } else {
                iPrint.println("Error identifing token type :"+token.getName()+" ("+token+")");
                iPrint.println(" resulting tokens :"+resultTokens);
                System.exit(1);
            }
        }
        if(DEBUG) {
            //iPrint.println(" tokens: ");
            System.out.println(" tokens: ");
            String line = null;
            for (Token t : resultTokens) { 
                line += ", "+t; }
            //iPrint.println( line );
            System.out.println( line );
        }

        return resultTokens;
    }


    private boolean isWhiteSpace(String tokenValue) {
        return tokenValue.isBlank(); 
    }

    private boolean isIdentifier(String tokenValue) {
        return tokenValue.matches("[a-zA-Z_][a-zA-Z_0-9]*");
    }

    private boolean isOperator(String tokenValue) {
        return tokenValue.matches("[-+*/%^=();]");
    }


    private boolean isNumber(String tokenValue) {
        return tokenValue.matches("[-+]?[0-9]+"); //("\\d+")
    }
}


