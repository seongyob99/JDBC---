CREATE TABLE boards (
    boardNo NUMBER PRIMARY KEY,      -- 게시글 번호
    title VARCHAR2(100) NOT NULL,    -- 게시글 제목
    content VARCHAR2(1000) NOT NULL, -- 게시글 내용
    writer VARCHAR2(100) NOT NULL,   -- 작성자
    regdate DATE DEFAULT SYSDATE     -- 등록일자, 기본값 현재 날짜
);

