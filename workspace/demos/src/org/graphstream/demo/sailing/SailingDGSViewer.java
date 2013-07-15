package org.graphstream.demo.sailing;

import java.io.IOException;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceDGS;
import org.graphstream.ui.swingViewer.Viewer;
import org.graphstream.ui.swingViewer.util.Camera;

public class SailingDGSViewer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Graph graph = new SingleGraph("Sailing");
		Viewer v = graph.display(false);
//		Camera c = v.getDefaultView().getCamera();
//		c.setGraphViewport(-1700, -700, 1700, 700);
		
		FileSource source = new FileSourceDGS();
		source.addSink(graph);
		source.begin("data/tracks.dgs");
		while (source.nextStep()) {
			Thread.sleep(5);
			// do something here
		}
	}

}
