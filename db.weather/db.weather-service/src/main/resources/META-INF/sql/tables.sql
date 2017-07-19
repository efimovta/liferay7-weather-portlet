create table Weather_Weather (
	weatherId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	source VARCHAR(75) null,
	city VARCHAR(75) null,
	country VARCHAR(75) null,
	lat DOUBLE,
	lon DOUBLE,
	condition_ VARCHAR(75) null,
	avgTemp DOUBLE,
	minTemp DOUBLE,
	maxTemp DOUBLE,
	date_ DATE null
);