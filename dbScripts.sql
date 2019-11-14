CREATE TABLE student (
    ID int NOT NULL,
    NAME varchar(32) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE course (
    ID int NOT NULL,
    NAME varchar(32) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE student_course (
    STUDENT_ID int NOT NULL,
    COURSE_ID int NOT NULL,
  	FOREIGN KEY(STUDENT_ID) REFERENCES student(id),
    FOREIGN KEY(COURSE_ID) REFERENCES course(id)
);