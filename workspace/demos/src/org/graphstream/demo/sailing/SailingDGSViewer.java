package org.graphstream.demo.sailing;

import java.io.IOException;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceDGS;

public class SailingDGSViewer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Graph graph = new SingleGraph("Sailing");
		graph.display(false);
		
		FileSource source = new FileSourceDGS();
		source.addSink(graph);
		source.begin("data/tracks.dgs");
		while (source.nextStep()) {
			Thread.sleep(1);
			// do something here
		}
	}

}
