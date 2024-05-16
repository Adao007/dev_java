/*

 a Token class that includes both the token name (e.g., "ID" or "NUMBER") and the token value (the actual string representing the token).
*/

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Token {
    private  String type;
    private  String name;
    private  String value;
    private  int ivalue;

    public Token(String type, String name, String value) {
        this.type = type;
        this.name = name;
        this.value = value;
        if(value == "") {
            value="0";
            ivalue = 0;
        }
        else ivalue = convert(value);
        //System.out.println(this);
    }

    public Token(String type, String name) {
        this(type, name, "0");
    }
    
    public Token(String type, String name, int v) {
        this.type = type;
        this.name = name;
        setValue(v);
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public int getInt() {
        return ivalue;
    }

    public void setValue(String str) {
        value = str;
        if(value == "") {
            value="0";
            ivalue = 0;
        }
        else ivalue = convert(value);
    }

    public void setValue(int v){
        ivalue = v;
        value = ""+v;
    }

    public String toString () {
        return "Type:"+type+" Name:"+name+" value:"+value+"";
    }

    private int convert (String value) {
        int result = 0;
        try { result = Integer.parseInt(value);
        } catch(Exception e) { 
            result=0; //e.printStackTrace(System.out); 
        }
        return result;
    }
}

