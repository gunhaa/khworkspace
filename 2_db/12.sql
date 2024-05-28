-- 1. 전지연 사원이 속해있는 부서원들을 조회하시오 (단, 전지연은 제외)

-- 사번, 사원명, 전화번호, 고용일 ,부서명

SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE DEPT_TITLE=(SELECT DEPT_TITLE
                  FROM EMPLOYEE
                  JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
                  WHERE EMP_NAME='전지연')
AND EMP_NAME!='전지연';                

--2. 고용일이 2000년도 이후인 사원들 중 급여가 가장 높은 사원의 
-- 사번 , 사원명, 전화번호, 급여, 직급명을 조회하시오

SELECT EMP_ID, EMP_NAME, PHONE, SALARY, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE (SALARY, HIRE_DATE) IN (SELECT SALARY, HIRE_DATE
                            FROM EMPLOYEE
                            JOIN JOB USING(JOB_CODE)
                            WHERE HIRE_DATE LIKE ('20%'))
AND ROWNUM=1;


-- 3. 노옹철 사원과 같은 부서, 같은 직급인 사원을 조회하시오.(단 노옹철사원은 제외
-- 사번, 이름, 부서코드 ,직급코드,부서명,직급명

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN JOB USING (JOB_CODE)
WHERE (DEPT_TITLE,JOB_NAME) = (SELECT DEPT_TITLE,JOB_NAME
                                FROM EMPLOYEE
                                JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
                                JOIN JOB USING (JOB_CODE)
                                WHERE EMP_NAME='노옹철')
AND EMP_NAME != '노옹철';

--4. 2000년도에 입사한 사원과 부서와 직급이 같은 사원을 조회하시오
--사번, 이름, 부서코드,직급코드, 고용일

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE , JOB_CODE) IN (SELECT DEPT_CODE , JOB_CODE 
                                FROM EMPLOYEE
                                WHERE HIRE_DATE LIKE ('2000%'));
    --값은 한개인데 왜 =을 못씀???
    
--5. 77년생 여자 사원과 동일한 부서이면서 동일한 사수를 가지고 있는 사원을 조회하시오
-- 사번, 이름 ,부서코드, 사수번호, 주민번호, 고용일

SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID, EMP_NO, HIRE_DATE
FROM EMPLOYEE A
WHERE (DEPT_CODE, MANAGER_ID) = (SELECT DEPT_CODE, MANAGER_ID
                                FROM EMPLOYEE B
                                WHERE SUBSTR(EMP_NO,1,2)='77'
                                AND SUBSTR(EMP_NO,8,1)='2');

-- 6. 부서 별 입사일이 가장 빠른 사원의
-- 사번, 이름, 부서명(NULL이면 '소속없음'), 직급명, 입사일을 조회하고
--입사일이 빠른 순으로 조회하시오
--단, 퇴사한 직원은 제외하고 조회

SELECT EMP_ID , EMP_NAME, NVL(DEPT_TITLE, '소속없음'), JOB_NAME, HIRE_DATE
FROM EMPLOYEE
LEFT JOIN JOB USING(JOB_CODE)
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
ORDER BY 5;

SELECT EMP_ID,EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE ORDER BY 2;


SELECT * FROM EMPLOYEE WHERE EMP_ID = '200';

SELECT * FROM EMPLOYEE WHERE SALARY>='3000000';

INSERT INTO EMPLOYEE2 VALUES(901,'테스트', '001212-1234567', 'TEST@OR.KR', '01012341234', 'D9', 'J1', 'S1', 1000000, 0.6, NULL ,SYSDATE,NULL,'N');
ROLLBACK;

SELECT * FROM EMPLOYEE2 ORDER BY DEPT_CODE;
DELETE FROM EMPLOYEE2 WHERE EMP_ID=900;
ROLLBACK;

--UPDATE 테이블명 SET 컬럼명 = 바꿀값 [WHERE 컬럼명 비교연산자 비교값];

UPDATE EMPLOYEE2 SET EMAIL = 'change', PHONE = '77777777777', SALARY = 77777 WHERE EMP_ID='901';

--부서코드, 보너스율을 입력 받아 해당 부서의 보너스를 모두 수정

UPDATE EMPLOYEE2 SET BONUS='0.1' WHERE DEPT_CODE='D1';
