package sample.neo4j

import org.neo4j.visualization.graphviz.GraphvizWriter
import org.neo4j.walk.Walker

class GraphvizController {

    static final String DOT_BINARY = "/usr/bin/dot"
    static File dotBinaryFile = new File(DOT_BINARY)
    def graphDatabaseService

    def beforeInterceptor = {
        assert graphDatabaseService !=  null, "graphDatabaseService is null, most likely since you're running Neo4j remotely"
        assert dotBinaryFile.exists() && dotBinaryFile.canExecute(), "$DOT_BINARY not found or not executable"
    }

    /**
     * be careful, if your graph grows larger than a handful of nodes,
     * change {@link Walker#fullGraph(org.neo4j.graphdb.GraphDatabaseService)} into some more reasonable.
     * @return
     */
    def index() {

        def tx = graphDatabaseService.beginTx()
        try {

            File dotFile = File.createTempFile("temp", ".dot")

            GraphvizWriter graphvizWriter = new GraphvizWriter()
            graphvizWriter.emit(dotFile, Walker.fullGraph(graphDatabaseService))

            if (dotBinaryFile.exists() && dotBinaryFile.canExecute()) {

                def proc =  "${DOT_BINARY} -Tsvg ${dotFile.absolutePath}".execute()
//            proc.waitFor()
                def svg = proc.in.text

                response.contentType = "image/svg+xml"
                response.contentLength = svg.size()
                response.outputStream << svg
                response.outputStream.flush()
            } else {
                log.warn("$DOT_BINARY not found or not executable. Install graphviz package, e.g. apt-get install graphviz on Debian/Ubuntu")
                response.contentType = "text/plain"
                render dotFile.text
            }
            dotFile.delete()
            tx.success()
        } finally {
            tx.close()
        }

    }
}
