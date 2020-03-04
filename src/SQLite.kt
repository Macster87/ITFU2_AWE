import java.sql.*

object SQLite {
    /**
     * Connect to a sample database
     */
    private fun connect() {
        var conn: Connection? = null
        try { // db parameters
            val url = "jdbc:sqlite:BLZ.sqlite"
            // create a connection to the database
            conn = DriverManager.getConnection(url)
            println("Connection to SQLite has been established.")
            selectAll(conn)
        } catch (e: SQLException) {
            println(e.message)
        } finally {
            try {
                conn?.close()
            } catch (ex: SQLException) {
                println(ex.message)
            }
        }
    }

    private fun selectAll(conn: Connection) {
        val query = "SELECT * FROM BLZ"
        val stmt: Statement = conn.createStatement()
        val rs: ResultSet = stmt.executeQuery(query)

        while(rs.next()) print(rs.getString("Ort") + ", ")
    }

    /**
     * @param args the command line arguments
     */
    @JvmStatic
    fun main(args: Array<String>) {
        connect()
    }
}