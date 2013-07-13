package org.graphstream.demo.sailing;

import java.io.IOException;

import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.GraphParseException;


public class TagGraph {

	public static void main(String[] args) throws ElementNotFoundException, IOException, GraphParseException {
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		Graph graph = new MultiGraph("Tag Exchange");
		graph.read("data/tag_exchange.dgs");
		graph.addAttribute("ui.quality");
		graph.addAttribute("ui.antialias");
		graph.addAttribute("ui.stylesheet", "url('data/style_tag.css')");
		graph.display();
		
		System.out.printf("%10s%10s%10s%10s\n", "Boat", "Received", "Sent", "Balance");
		for (Node node : graph) {
			int balance = node.getInDegree() - node.getOutDegree();
			if (balance > 0)
				node.addAttribute("ui.class", "pos");
			else if (balance < 0)
				node.addAttribute("ui.class", "neg");
			System.out.printf("%10s%10d%10d%10d\n", node.getId(), node.getInDegree(), node.getOutDegree(), balance);
		}
	}
}
