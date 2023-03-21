CREATE TABLE CENSUSYEAR
(
    censusYearID INT NOT NULL PRIMARY KEY,
    censusYear INT NOT NULL
);

CREATE TABLE GEOGRAPHICAREA
(
    geographicAreaID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code INT NOT NULL,
    level INT NOT NULL,
    name VARCHAR(40) NOT NULL,
    alternativeCode INT NOT NULL
);

CREATE TABLE AGEGROUP
(
    ageGroupID INT NOT NULL PRIMARY KEY,
    description VARCHAR(40) NOT NULL
);

CREATE TABLE AGE
(
    ageID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ageGroup INT NOT NULL,
    censusYear INT NOT NULL,
    geographicArea INT NOT NULL,
    combined INT NOT NULL,
    male INT NOT NULL,
    female INT NOT NULL,
    CONSTRAINT ageGroupFK
        FOREIGN KEY (ageGroup)
        REFERENCES AGEGROUP(ageGroupID),
    CONSTRAINT censusYearFK
        FOREIGN KEY (censusYear)
        REFERENCES CENSUSYEAR(censusYearID), 
    CONSTRAINT geographicAreaFK
        FOREIGN KEY (geographicArea)
        REFERENCES GEOGRAPHICAREA(geographicAreaID)
);


CREATE TABLE HOUSEHOLDEARNERS
(
    id SMALLINT NOT NULL PRIMARY KEY,
    description VARCHAR(50) NOT NULL
);

CREATE TABLE TOTALINCOME
(
    id SMALLINT NOT NULL PRIMARY KEY,
    description VARCHAR(40) NOT NULL
);

CREATE TABLE HOUSEHOLDSBYAGERANGE
(
    id SMALLINT NOT NULL PRIMARY KEY,
    description VARCHAR(70) NOT NULL
);

CREATE TABLE HOUSEHOLDSIZE
(
    id SMALLINT NOT NULL PRIMARY KEY,
    description VARCHAR(40) NOT NULL
);

CREATE TABLE HOUSEHOLDTYPE
(
    id SMALLINT NOT NULL PRIMARY KEY,
    description VARCHAR(70) NOT NULL
);

CREATE TABLE HOUSEHOLD
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    geographicArea INT NOT NULL,
    householdType SMALLINT NOT NULL,
    householdSize SMALLINT NOT NULL,
    householdsByAgeRange SMALLINT NOT NULL,
    householdEarners SMALLINT NOT NULL,
    totalIncome SMALLINT NOT NULL,
    censusYear INT NOT NULL,
    numberReported INT NOT NULL,
    CONSTRAINT HOUSEHOLD_GEOGRAPHICAREA_FK
        FOREIGN KEY (geographicArea)
        REFERENCES GEOGRAPHICAREA(geographicAreaID),
    CONSTRAINT HOUSEHOLD_GEOGRAPHICAREAhouseholdTypeFK
        FOREIGN KEY (householdType)
        REFERENCES HOUSEHOLDTYPE(id),
    CONSTRAINT householdTypeFK
        FOREIGN KEY (householdType)
        REFERENCES HOUSEHOLDTYPE(id),
    CONSTRAINT householdSizeFK
        FOREIGN KEY (householdSize)
        REFERENCES HOUSEHOLDSIZE(id),
	CONSTRAINT householdsByAgeRangeFK
        FOREIGN KEY (householdsByAgeRange)
        REFERENCES HOUSEHOLDSBYAGERANGE(id),
    CONSTRAINT householdEarnersFK
        FOREIGN KEY (householdEarners)
        REFERENCES HOUSEHOLDEARNERS(id),
    CONSTRAINT totalIncomeFK
        FOREIGN KEY (totalIncome)
        REFERENCES TOTALINCOME(id)
);



