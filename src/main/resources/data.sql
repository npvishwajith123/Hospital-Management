insert into DoctorDepartment(departmentName, description) values ('Cardiology','Heart and Blood Vessel Treatment');
insert into DoctorDepartment(departmentName, description) values ('Neurology','Brain and Nervous System Care');
insert into DoctorDepartment(departmentName, description) values ('Orthopedics','Musculoskeletal System Treatment');

insert into DoctorRecords(name, specialization, departmentId, yearsOfExperience) values('Dr. Emily Green', 'Cardiology', 1, 10);
insert into DoctorRecords(name, specialization, departmentId, yearsOfExperience) values('Dr. Alex White', 'Neurology', 2, 8);
insert into DoctorRecords(name, specialization, departmentId, yearsOfExperience) values('Dr. Susan Black', 'Orthopedics', 3, 12);

insert into PatientRecords(name, age, address, diagnosis, appointmentDate, doctorId) values('John Doe',45,'123 Main St','Fever','2024-11-10', 1);
insert into PatientRecords(name, age, address, diagnosis, appointmentDate, doctorId) values('Jane Smith',30,'456 Elm St','Headache','2024-11-12', 2);
insert into PatientRecords(name, age, address, diagnosis, appointmentDate, doctorId) values('Michael Brown',27,'789 Maple Ave','Cough','2024-11-15', 3);

insert into HospitalDatabase(hospitalName, location, numberOfDepartments, contactInfo) values('General Hospital','City Center',5,'123-456-7890');
insert into HospitalDatabase(hospitalName, location, numberOfDepartments, contactInfo) values('Sunshine Medical Center','Uptown',3,'987-654-3210');

insert into Roles(roleName) values('ROLE_PATIENT');
insert into Roles(roleName) values('ROLE_DOCTOR');
insert into Roles(roleName) values('ROLE_ADMIN');

insert into Users(userName, password, roleId, associateDoctorId, associatePatientId) values ('jdoe','pass123', 1, null, 1);
insert into Users(userName, password, roleId, associateDoctorId, associatePatientId) values ('asmith','pass456', 2, 2, null);
insert into Users(userName, password, roleId, associateDoctorId, associatePatientId) values ('mblack','pass789', 3, null, 3);

