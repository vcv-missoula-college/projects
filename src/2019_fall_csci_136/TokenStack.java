import java.util.ArrayList;

public class TokenStack {
	 /** Member variables **/
	  private ArrayList<Token> tokens;

	  /** Constructors **/
	  public TokenStack() {
	    tokens = new ArrayList<Token>();
	  }

	  /** Accessor methods **/
	  public boolean isEmpty() {
	    return tokens.size() == 0;
	  }
	  public Token top() {
	    return tokens.get(tokens.size()-1);
	  }

	  /** Mutator methods **/
	  public void push(Token t) {
	    tokens.add(t);
	  }
	  public void pop() {
	    tokens.remove(tokens.size()-1);
	  }
}
