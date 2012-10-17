package sample.neo4j

import org.neo4j.graphdb.TraversalPosition
import org.neo4j.graphdb.StopEvaluator
import org.neo4j.graphdb.ReturnableEvaluator
import org.neo4j.visualization.asciidoc.AsciidocHelper
import org.neo4j.visualization.graphviz.GraphvizWriter
import org.neo4j.walk.Walker

class SpeakerController {

    def scaffold = true

    def graphDatabaseService

    def search() {
        render Speaker.where { name=='Peter'}.list()
    }

    def cypher() {
        render Speaker.cypherStatic("start n=node({this}) match n-[:INSTANCE]->m return m")
    }

    def traverse() {
        render Speaker.traverseStatic(

                { TraversalPosition tp ->
                    //log.error "${tp.depth()}, ${tp.currentNode().id}"
                    tp.depth() in (1..2)
                } as StopEvaluator,

                ReturnableEvaluator.ALL_BUT_START_NODE
        )
    }

    def massCreate() {
        def time = performanceService.massCreate(params.int("id"))
        render "done in $time"
    }

    def count() {
        def result = performanceService.count()
        render "couned ${result[0]} in ${result[1]} [ms]"
    }

    def info() {
        def file = File.createTempFile("temp", ".dot")

        OutputStream out = new FileOutputStream(file);
        GraphvizWriter writer = new GraphvizWriter();
        writer.emit(out, Walker.fullGraph(graphDatabaseService));
        out.close();

        def proc = "/usr/bin/dot -Tsvg $file.absolutePath".execute()
        proc.waitFor()

        file.delete()
        def svg = proc.in.text

        response.contentType = "image/svg+xml"
        response.contentLength = svg.size()
        response.outputStream << svg
        response.outputStream.flush()
    }

    def commonTalks() {
        response.contentType = "text/plain"
        def talks = Talk.cypherStatic("""START rob=node(6), john=node(12)
MATCH rob-[:attendsTo]->talk<-[attendsTo]-john
RETURN talk
         """).collect { Talk.createInstanceForNode(it.talk)}

        render talks
    }
}