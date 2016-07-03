package jdbcdemo;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		testCode();
		insertData();
		updateBatch();
	}
	private static void updateBatch() {
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String password = "student";
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			Statement myStmt = myConn.createStatement();
			myConn.setAutoCommit(false);
			// No net change
			myStmt.addBatch("Update Employees set email = null where first_name = 'Jai';");
			myStmt.addBatch("Update Employees set email = 'jai.asher88@gmail.com' where last_name = 'Asher';");
			int[] rowsAfected = myStmt.executeBatch();
			System.out.println("Update Complete.");
			System.out.println("Rows affected = " + rowsAfected[0]);
			myConn.commit();
			myConn.setAutoCommit(true);
			myStmt.close();
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	private static void insertData() {
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String password = "student";
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			Statement myStmt = myConn.createStatement();
			
			String sql = "Insert into employees "
					+ " (last_name, first_name, email)"
					+ " values ('Jai', 'Asher', 'jai.asher88@gmail.com');";
			int rowsAfected = myStmt.executeUpdate(sql);
			System.out.println("Insert Complete.");
			System.out.println("Rows affected = " + rowsAfected);
			myStmt.close();
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
	}
	private static void testCode() {
		// TODO Auto-generated method stub
		
		try {
			//Get Connection to DB
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","student", "student");
			// Create a statement
			Statement myStmt = myConn.createStatement();
			//Execute a sql query
			ResultSet myRs = myStmt.executeQuery("select * from employees;");
			//Process the result set
			while(myRs.next()) {
				System.out.println(myRs.getString("last_name") +"," + myRs.getString("first_name"));
			}
			myStmt.close();
			myConn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}

/*
 * It is also possible to have a parameterized batch update, as shown in the following code fragment, where con is a Connection object:
*/


/*
con.setAutoCommit(false);
PreparedStatement pstmt = con.prepareStatement(
                              "INSERT INTO COFFEES VALUES( " +
                              "?, ?, ?, ?, ?)");
pstmt.setString(1, "Amaretto");
pstmt.setInt(2, 49);
pstmt.setFloat(3, 9.99);
pstmt.setInt(4, 0);
pstmt.setInt(5, 0);
pstmt.addBatch();

pstmt.setString(1, "Hazelnut");
pstmt.setInt(2, 49);
pstmt.setFloat(3, 9.99);
pstmt.setInt(4, 0);
pstmt.setInt(5, 0);
pstmt.addBatch();

// ... and so on for each new
// type of coffee

int [] updateCounts = pstmt.executeBatch();
con.commit();
con.setAutoCommit(true);

*
*
*
*public void updateCoffeeSales(HashMap<String, Integer> salesForWeek)
    throws SQLException {

    PreparedStatement updateSales = null;
    PreparedStatement updateTotal = null;

    String updateString =
        "update " + dbName + ".COFFEES " +
        "set SALES = ? where COF_NAME = ?";

    String updateStatement =
        "update " + dbName + ".COFFEES " +
        "set TOTAL = TOTAL + ? " +
        "where COF_NAME = ?";

    try {
        con.setAutoCommit(false);
        updateSales = con.prepareStatement(updateString);
        updateTotal = con.prepareStatement(updateStatement);

        for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) {
            updateSales.setInt(1, e.getValue().intValue());
            updateSales.setString(2, e.getKey());
            updateSales.executeUpdate();
            updateTotal.setInt(1, e.getValue().intValue());
            updateTotal.setString(2, e.getKey());
            updateTotal.executeUpdate();
            con.commit();
        }
    } catch (SQLException e ) {
        JDBCTutorialUtilities.printSQLException(e);
        if (con != null) {
            try {
                System.err.print("Transaction is being rolled back");
                con.rollback();
            } catch(SQLException excep) {
                JDBCTutorialUtilities.printSQLException(excep);
            }
        }
    } finally {
        if (updateSales != null) {
            updateSales.close();
        }
        if (updateTotal != null) {
            updateTotal.close();
        }
        con.setAutoCommit(true);
    }
}
*/
