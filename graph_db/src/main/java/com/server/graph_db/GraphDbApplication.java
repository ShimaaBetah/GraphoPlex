package com.server.graph_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.server.graph_db.vertex.Vertex;
import com.server.graph_db.vertex.Edge;
import com.server.graph_db.vertex.VertexService;

@SpringBootApplication

public class GraphDbApplication implements CommandLineRunner {

	@Autowired
	VertexService vertexService;

	public static void main(String[] args) {
		SpringApplication.run(GraphDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//loadData();
	}




	public void loadData() throws Exception{
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
			inputStream = new FileInputStream("/home/shimaa/Thesis/distributed-graph-database/graph_db/src/web-Google.txt");
			sc = new Scanner(inputStream, "UTF-8");
			int currentAddedVertex = -1;
			Vertex addedVertex = null;
			System.out.println("start");
			while (sc.hasNextLine()) {
				// split the line into two parts
				String[] edgeVerices = sc.nextLine().split("\t");
				int sourceVertexId = Integer.parseInt(edgeVerices[0]);
				int destinationVertexId = Integer.parseInt(edgeVerices[1]);
				// if the source vertex is not added before
				if (sourceVertexId != currentAddedVertex) {
					addedVertex = new Vertex(sourceVertexId);
					addedVertex.addOutgoingEdge(new Edge(destinationVertexId));
					vertexService.addVertex(addedVertex);
					currentAddedVertex = sourceVertexId;
				} else {
					// if the source vertex is added before
					vertexService.addEdge(sourceVertexId, new Edge(destinationVertexId));
				}

			}

			System.out.println("end");
            

			// note that Scanner suppresses exceptions
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
		}
	
	}

}
