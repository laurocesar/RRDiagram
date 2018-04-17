package com.laurocesar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.nextencia.rrdiagram.grammar.model.BNFToGrammar;
import net.nextencia.rrdiagram.grammar.model.Grammar;
import net.nextencia.rrdiagram.grammar.model.GrammarToRRDiagram;
import net.nextencia.rrdiagram.grammar.model.Rule;
import net.nextencia.rrdiagram.grammar.rrdiagram.RRDiagram;
import net.nextencia.rrdiagram.grammar.rrdiagram.RRDiagramToSVG;
import net.nextencia.rrdiagram.grammar.rrdiagram.RRElement;

public class RRDiagramTest {

    public static void main(String[] args) {
	BNFToGrammar bnfToGrammar = new BNFToGrammar();

	FileReader fr;
	try {
	    ClassLoader classLoader = RRDiagramTest.class.getClassLoader();

	    fr = new FileReader(new File(classLoader.getResource("ontoprolog_sintaxe_ebnf.txt").getFile()));

	    Grammar grammar = bnfToGrammar.convert(fr);

	    GrammarToRRDiagram gtrrd = new GrammarToRRDiagram();
	    RRDiagramToSVG rrDiagramToSVG = new RRDiagramToSVG();

	    for (Rule r : grammar.getRules()) {
		RRDiagram rrd = gtrrd.convert(r);

		String svg = rrDiagramToSVG.convert(rrd);

		System.out.println(svg);

	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void grammar(Rule... rules) {
	Grammar grammar = new Grammar(rules);
	GrammarToRRDiagram grammarToRRDiagram = new GrammarToRRDiagram();
	for (Rule rule : grammar.getRules()) {
	    RRDiagram rrDiagram = grammarToRRDiagram.convert(rule);

	    // Do something with diagram, like get the SVG.
	}

    }

    public String convertToSVG(RRElement rrElement) {
	RRDiagram rrDiagram = new RRDiagram(rrElement);
	RRDiagramToSVG rrDiagramToSVG = new RRDiagramToSVG();
	String svg = rrDiagramToSVG.convert(rrDiagram);
	return svg;
    }

}
