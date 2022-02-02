use batch2;
create table travel_details
(
booking_Id int primary key auto_increment ,
name varchar(25) not null,
vehicle_Type varchar(25) not null,
vehicle_Name varchar(25) not null,
tot_Amount double not null,
booking_date date,
address_Proof varchar(75) not null,
contact_No varchar(25) not null,
email_Id varchar(25) not null
);
select * from travel_details;
