import java.sql.Connection; // java.sql에 포함된 클래스들 
import java.sql.DriverManager; // java.sql에 포함된 클래스들 
import java.sql.ResultSet; // java.sql에 포함된 클래스들 
import java.sql.Statement; // java.sql에 포함된 클래스들 

public class JDBC_Connection {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 URL
        String user = "사용자 이름"; // 데이터베이스 사용자 이름
        String password = "비밀번호"; // 데이터베이스 비밀번호

        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle JDBC 드라이버 클래스를 로드하는 코드
            
            // 데이터베이스 연결
            Connection connection = DriverManager.getConnection(url, user, password); // 데이터베이스 연결을 설정하는 코드. URL, 사용자 이름, 비밀번호 정보 사용
            // System.out.println("데이터베이스에 성공적으로 연결되었습니다!");

            // SQL 쿼리 실행
            Statement statement = connection.createStatement();  // SQL 쿼리를 실행하기 위한 Statement 객체
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table_name"); // 데이터베이스에서 select 쿼리 실행 후 그 결과를 resultset으로 반환

            // 결과 출력
            while (resultSet.next()) {
                System.out.println("데이터: " + resultSet.getString("your_column_name"));
            }

            // 리소스 해제
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
