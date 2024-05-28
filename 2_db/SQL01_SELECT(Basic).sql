-- 1번

SELECT DEPARTMENT_NAME AS "학과 명" , CATEGORY "계열"
 FROM TB_DEPARTMENT;

-- 2번 

SELECT DEPARTMENT_NAME || '의 정원은 ' ||  CAPACITY || '명입니다.' AS "학과별 정원"
FROM TB_DEPARTMENT;

-- 3번 // 국어국문학과 001

SELECT DEPARTMENT_NO , DEPARTMENT_NAME
FROM TB_DEPARTMENT
WHERE DEPARTMENT_NAME = '국어국문학과';

SELECT STUDENT_NAME, DEPARTMENT_NO, ABSENCE_YN , STUDENT_SSN
FROM TB_STUDENT 
WHERE DEPARTMENT_NO LIKE '001' 
AND ABSENCE_YN LIKE 'Y'
--AND STUDENT_SSN LIKE '_______2______';
AND SUBSTR(STUDENT_SSN,8, 1) = 2; 

--4번
SELECT STUDENT_NAME , STUDENT_NO
FROM TB_STUDENT
WHERE STUDENT_NO IN ('A513079','A513090', 'A513091' , 'A513110', 'A513119');
--5번
SELECT DEPARTMENT_NAME , CATEGORY , CAPACITY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN '20' AND '30';

--6번

SELECT PROFESSOR_NAME , DEPARTMENT_NO
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

--7번

SELECT STUDENT_NAME , DEPARTMENT_NO
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

--8번

SELECT CLASS_NO 
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 9번

SELECT DISTINCT CATEGORY
FROM TB_DEPARTMENT
ORDER BY CATEGORY;
-- 10번

SELECT STUDENT_NO , STUDENT_NAME , STUDENT_SSN 
FROM TB_STUDENT
WHERE ABSENCE_YN LIKE 'N'
AND ENTRANCE_DATE LIKE '2002%'
AND STUDENT_ADDRESS LIKE '%전주%' ;