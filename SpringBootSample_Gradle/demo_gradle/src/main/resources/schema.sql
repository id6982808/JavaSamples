DROP TABLE my_data IF EXISTS;

CREATE TABLE my_data  (
    id INTEGER IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(20),
    mail VARCHAR(20),
    tel VARCHAR(20),
    age INTEGER
);

DROP TABLE item IF EXISTS;

CREATE TABLE item (
	id BIGINT IDENTITY NOT NULL PRIMARY KEY,
	name VARCHAR(255),
	price FLOAT,
	vendor VARCHAR(255)
);

DROP TABLE zaiko IF EXISTS;

CREATE TABLE zaiko (
	id BIGINT IDENTITY NOT NULL PRIMARY KEY,
	product_name VARCHAR(200) NOT NULL,
	zaikosu INTEGER,
	biko VARCHAR(50),
);

DROP TABLE zaiko_location IF EXISTS;

CREATE TABLE zaiko_location (
	id BIGINT IDENTITY NOT NULL PRIMARY KEY,
	location_name VARCHAR(200),
	zaiko_id BIGINT,
	constraint fk_zaiko_id foreign  key(zaiko_id) references zaiko(id)
);

CREATE TABLE IF NOT EXISTS item_master (
	item_master_id BIGINT NOT NULL,
	item_master_cd BIGINT NOT NULL,
	item_name VARCHAR(200) NOT NULL,
	item_price BIGINT NOT NULL,
	primary key (item_master_id, item_master_cd)
)













