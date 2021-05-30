
drop table IF EXISTS VIDEO;

create table VIDEO (
VIDEO_ID varchar2 primary key ,
TITLE varchar2,
THUMBNAIL varchar2,
PUBLISHED_AT datetime
);

SELECT * FROM VIDEO
WHERE TO_CHAR(PUBLISHED_AT, 'yyyymmddhh') < '2020021810'
;
update VIDEO set PUBLISHED_AT = '2020-02-19 00:00:00'
where VIDEO_ID = 'lexGRsTIcAM'