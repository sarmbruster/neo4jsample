package sample.neo4j

import org.neo4j.graphdb.TraversalPosition
import org.neo4j.graphdb.StopEvaluator
import org.neo4j.graphdb.ReturnableEvaluator
import org.neo4j.visualization.asciidoc.AsciidocHelper
import org.neo4j.visualization.graphviz.GraphvizWriter
import org.neo4j.walk.Walker

class SpeakerController {

    def scaffold = true

    def search() {
        render Speaker.where { name=='Peter'}.list()
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

    /*def massCreate() {
        def time = performanceService.massCreate(params.int("id"))
        render "done in $time"
    }

    def count() {
        def result = performanceService.count()
        render "couned ${result[0]} in ${result[1]} [ms]"
    }*/

    def commonTalks() {
        response.contentType = "text/plain"
        def talks = Talk.cypherStatic("""START rob=node(6), john=node(12)
MATCH rob-[:attendsTo]->talk<-[attendsTo]-john
RETURN talk
         """).collect { Talk.createInstanceForNode(it.talk)}

        render talks
    }
}