
create table board(
	num number,
	title varchar2(200),
	writer varchar2(200),
	fileName varchar2(200),
	content varchar2(1000),
	day date
)

create sequence num start with 1 increment by 1;

insert into board values(num.nextval, '��������','������',NULL,'���������Դϴ� ������',sysdate);
insert into board values(num.nextval, '������~ ������������', '������', NULL, '����~ ������ ��������', sysdate);

select * from BOARD;

drop table board cascade constraints



