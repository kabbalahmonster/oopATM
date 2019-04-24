import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * Validates a given JTextField matches a given pattern
 * @author Nick Showalter
 *
 */
public class TextFieldValidator {
	
	private String regExp;
	private Color errorColor;
	private Border defaultBorder;
	private JTextField target;

	/**
	 * TextFieldCalidator constructor method. Requires JTextField and Color as arguments. Defaults regular expression to "\\w"
	 * @param myTarget JTextField to validate
	 * @param myErrorColor Color to indicate error
	 */
	public TextFieldValidator (JTextField myTarget, Color myErrorColor) {
		target = myTarget;
		regExp = new String("\\w");
		errorColor = myErrorColor;
		defaultBorder = myTarget.getBorder();
	}
	
	/** 
	 * TextFieldCalidator constructor method. Requires JTextField as argument. Sets errorColor to Red by default
	 * @param myTarget JTextField to validate
	 */
	public TextFieldValidator (JTextField myTarget) {
		this(myTarget, Color.RED);
	}
	
	//-----------------------------------------sets
	
	/**
	 * Sets regular expression to use for error checking.
	 * @param myRegExp Regular expression for error checking
	 */
	public void setRegExp(String myRegExp) {
		regExp = myRegExp;
		
	}
	
	/**
	 * Sets error indication color
	 * @param myColor Color to indicate error
	 */
	public void setErrorColor(Color myColor) {
		errorColor = myColor;
	}
	
	
	//------------------------------------------public methods
	
	/**
	 * Checks if target JTextField text matches regular expression.
	 * @return True if text matches regular expression, false if not
	 */
	public Boolean check() {
		if (target.getText().matches(regExp)) {
			reset();
			return true;
		} else {
			target.setBorder(BorderFactory.createLineBorder(Color.RED, 2) );
			return false;
		}
	}
	
	
	/**
	 * Resets JTextField border color to its default
	 */
	public void reset() {
		target.setBorder(defaultBorder);
	}
}
