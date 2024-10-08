SELECT EMP_NAME, SALARY, SALARY*12 as 연봉 FROM EMPLOYEE;

select sysDATE FROM DUAL;

SELECT SYSDATE/365 FROM DUAL;
--EMPLOYEE 테이블에서
--부서코드가 'D9'DLS WLRDNJSDML
--사번, 이름, 부서코드, 전화번호 조회
SELECT * FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, PHONE FROM EMPLOYEE WHERE DEPT_CODE='D9';

--EMPLOYEE 테이블에서 성이 '전'씨인 사원의 사번, 이름 조회

SELECT EMP_NO, EMP_NAME FROM EMPLOYEE WHERE EMP_NAME LIKE '전%';

--EMPLOYEE 테이블에서 성이 '하'가 포함된 사원의 사번, 이름 조회

SELECT EMP_NO, EMP_NAME FROM EMPLOYEE WHERE EMP_NAME LIKE '%하%';

-- 010으로 시작하지 "않는" 사람들 조회
--> NOT LIKE (LIKE 결과 부정)

SELECT * FROM EMPLOYEE WHERE PHONE NOT LIKE '010%';

-- EMPLOYEE 테이블에서 메일 주소 '_'의 앞이 4자 이면서 DEPT_CODE가 D9 또는 D6이고
-- 고용일이 90/01/01 ~ 00/12/01이고, 급여가 270만 이상인 사원 전체를 조회

SELECT * FROM EMPLOYEE WHERE EMAIL LIKE '____$_%' ESCAPE '$' AND (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6') AND HIRE_DATE BETWEEN '1990/01/01' AND '2000/12/01' AND SALARY >= 2700000;

--EMPLOYEE 테이블에서
--부서코드가 D1또는 D6또는 D9인 사원의 사번, 이름, 부서코드 조회
SELECT EMP_NO, EMP_NAME , DEPT_CODE FROM EMPLOYEE WHERE (DEPT_CODE = 'D1' OR DEPT_CODE='D6');

--12글자인 이메일만 조회
SELECT EMAIL FROM EMPLOYEE WHERE LENGTH(EMAIL)='12';

-- EMPLOYEE 테이블에서 사원명, 이메일 중 아이디만 조회
SELECT EMAIL FROM EMPLOYEE;
SELECT EMAIL ,SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1)FROM EMPLOYEE ; 

-- 직원들의 성별 구분하기
SELECT EMP_NAME , DECODE(SUBSTR(EMP_NO, 8,1),1,'남자',2,'여자') FROM EMPLOYEE;

--EMPLOYEE 테이블에서 부서코드, 부서(그룹) 별 급여 합계 조회
SELECT * FROM EMPLOYEE;
SELECT DEPT_CODE, SUM(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE;

--EMPLOYEE 테이블에서
--성별과 성별 별 급여 평균(정수처리), 급여 합계 ,인원수 조회하고
--인원 수로 내림차순 정렬

SELECT DECODE(SUBSTR(EMP_NO, 8,1),1,'남자',2,'여자') ,AVG(SALARY), SUM(SALARY), COUNT(*) FROM EMPLOYEE GROUP BY DECODE(SUBSTR(EMP_NO, 8,1),1,'남자',2,'여자') ;

--EMPLOYEE 테이블에서 부서코드가 'D5' , 'D6'인 부서의 평균 급여 조회

SELECT DEPT_CODE, AVG(SALARY) FROM EMPLOYEE WHERE DEPT_CODE IN('D5','D6') GROUP BY DEPT_CODE;

-- 부서별 평균 급여가 3000000원 이상인 부서를 조회하여 부서코드 오름차순 정렬
SELECT DEPT_CODE, AVG(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE HAVING AVG(SALARY)>=3000000;

-- 1. EMPLOYEE 테이블에서 각 부서별 가장 높은 급여, 가장 낮은 급여를 조회하여
-- 부서 코드 오름차순으로 정렬하세요.

SELECT DEPT_CODE ,MAX(SALARY),MIN(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE ORDER BY DEPT_CODE ASC;

-- 2.EMPLOYEE 테이블에서 각 직급별 보너스를 받는 사원의 수를 조회하여
-- 직급코드 오름차순으로 정렬하세요

SELECT COUNT(BONUS) FROM EMPLOYEE GROUP BY DEPT_CODE ORDER BY DEPT_CODE;
-- 3.EMPLOYEE 테이블에서 
--  70년대생의 부서별 급여 평균이 300만 이상인 부서를 조회하여
-- 부서 코드 오름차순으로 정렬하세요
SELECT DEPT_CODE ,AVG(SALARY) FROM EMPLOYEE WHERE SUBSTR(EMP_NO,1,2) BETWEEN '70' AND '79' GROUP BY DEPT_CODE HAVING AVG(SALARY)> 3000000 ORDER BY DEPT_CODE DESC;

CREATE USER HGH IDENTIFIED BY HGH1234;
GRANT CREATE SESSION TO HGH;
GRANT CREATE TABLE TO HGH;
ALTER USER HGH DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;
GRANT CONNECT , RESOURCE TO HGH;


-- [연습 문제]
-- 회원가입용 테이블 생성(USER_TEST)
-- 컬럼명 : USER_NO(회원번호) - 기본키(PK_USER_TEST), 
--         USER_ID(회원아이디) - 중복금지(UK_USER_ID),
--         USER_PWD(회원비밀번호) - NULL값 허용안함(NN_USER_PWD),
--         PNO(주민등록번호) - 중복금지(UK_PNO), NULL 허용안함(NN_PNO),
--         GENDER(성별) - '남' 혹은 '여'로 입력(CK_GENDER),
--         PHONE(연락처),
--         ADDRESS(주소),
--         STATUS(탈퇴여부) - NOT NULL(NN_STATUS), 'Y' 혹은 'N'으로 입력(CK_STATUS)
-- 각 컬럼의 제약조건에 이름 부여할 것
-- 5명 이상 INSERT할 것

CREATE TABLE USER_TEST(
    USER_NO NUMBER CONSTRAINT PK_USER_TEST PRIMARY KEY,
    USER_ID VARCHAR2(20) CONSTRAINT UK_USER_ID UNIQUE,
    USER_PWD VARCHAR2(30) CONSTRAINT NN_USER_PWD NOT NULL,
    PNO NUMBER(14) CONSTRAINT UK_PNK UNIQUE CONSTRAINT UK_PNO NOT NULL,
    GENDER VARCHAR2(2) CONSTRAINT CK_GENDER CHECK(GENDER IN ('SKA' ,'DU'))
);

INSERT INTO USER_TEST VALUES(123,123,123,123,123);


-- 9. 제약조건 추가
ALTER TABLE 테이블명 ADD PRIMARY KEY;

-- DDL(DATA DEFINITION LANGUAGE) : 데이터 정의 언어로 객체를 만들고 , 수정하고 , 삭제하는 구문

CREATE SEQUENCE SEQ_EMP_NO START WITH 223 INCREMENT BY 1;
SELECT SEQ_EMP_ID.CURRVAL FROM DUAL;
SELECT SEQ_EMP_NO.NEXTVAL FROM DUAL;
INSERT INTO EMPLOYEE VALUES (123,123,123);

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER SAMPLE IDENTIFIED BY 1234;
GRANT CONNECT,RESOURCE TO SAMPLE;

CREATE TABLE SAMPLE (
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30)
);
SELECT * FROM SAMPLE;
ALTER USER SAMPLE DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
INSERT INTO SAMPLE VALUES (1, 'WW', 'WW1234', 'WHW');


CREATE TABLE SAMPLE(
    USER_NO NUMBER(10),
    USER_ID VARCHAR(14)
)

INSERT INTO SAMPLE VALUES('11', 'ID');