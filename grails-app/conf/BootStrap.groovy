import org.neo4j.server.WrappingNeoServerBootstrapper

class BootStrap {

    def graphDatabaseService

    def neoServer

    def init = { servletContext ->
        neoServer = new WrappingNeoServerBootstrapper(graphDatabaseService)
        neoServer.start()
    }

    def destroy = {
        neoServer.stop()
    }
}
