select * from student(
    id int primary key,
    roll_no varchar2(10) not null,
    student_name varchar2(40) not null,
    branch varchar2(40) not null,
    email_id varchar2(40) not null,
    phone_no varchar2(20) not null,
    password varchar2(40) not null,
    category varchar2(40) not null,
    student_photo blob,
    fee_due_date date not null,
    fee_amount float not null
);

create sequence id_seq;