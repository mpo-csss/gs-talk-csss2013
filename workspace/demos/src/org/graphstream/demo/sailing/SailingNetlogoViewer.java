package org.graphstream.demo.sailing;

import java.io.IOException;
import java.net.UnknownHostException;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.netstream.NetStreamReceiver;
import org.graphstream.stream.thread.ThreadProxyPipe;

public class SailingNetlogoViewer {
	public SailingNetlogoViewer() throws UnknownHostException, IOException, InterruptedException {
		Graph g = new SingleGraph("sailing");
		NetStreamReceiver rcv = new NetStreamReceiver("localhost", 2013);
		ThreadProxyPipe pipe = rcv.getDefaultStream();
		pipe.addSink(g);
		g.display();
		
		while (true) {
			pipe.blockingPump();
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		new SailingNetlogoViewer();
	}

}
