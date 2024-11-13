import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BoardManager {
    public static void main(String[] args) {
        // 데이터베이스 연결 정보 설정
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "사용자 이름";
        String password = "비밀번호";
        
        // 게시글 데이터 (예시 데이터)
        String title = "게시글 제목 예시";
        String content = "게시글 내용 예시";
        String writer = "작성자 예시";

        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 데이터베이스 연결
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스에 연결되었습니다.");

            // SQL INSERT 쿼리 작성
            String sql = "INSERT INTO boards (boardNo, title, content, writer) VALUES (boards_seq.NEXTVAL, ?, ?, ?)";

            // PreparedStatement 객체 생성 및 파라미터 설정
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, title);   // 첫 번째 파라미터에 제목 삽입
            pstmt.setString(2, content); // 두 번째 파라미터에 내용 삽입
            pstmt.setString(3, writer);  // 세 번째 파라미터에 작성자 삽입

            // SQL 실행 및 결과 확인
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("게시글이 성공적으로 저장되었습니다!");
            }

            // 리소스 해제
            pstmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
