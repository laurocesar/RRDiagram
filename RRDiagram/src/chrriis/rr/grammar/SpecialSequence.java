/*
 * Christopher Deckers (chrriis@nextencia.net)
 * http://www.nextencia.net
 *
 * See the file "readme.txt" for information on usage and redistribution of
 * this file, and for a DISCLAIMER OF ALL WARRANTIES.
 */
package chrriis.rr.grammar;

import chrriis.rr.diagram.RRElement;
import chrriis.rr.diagram.RRText;
import chrriis.rr.diagram.RRText.Type;

/**
 * @author Christopher Deckers
 */
public class SpecialSequence extends Expression {

  private String text;

  public SpecialSequence(String text) {
    this.text = text;
  }

  @Override
  protected RRElement toRRElement(GrammarToRRDiagram grammarToRRDiagram) {
    return new RRText(Type.SPECIAL_SEQUENCE, text, null);
  }

  @Override
  protected void toBNF(GrammarToBNF grammarToBNF, StringBuilder sb, boolean isNested) {
    sb.append("(? ");
    sb.append(text);
    sb.append(" ?)");
  }

}
