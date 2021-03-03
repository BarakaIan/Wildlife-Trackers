CREATE DATABASE wildlife_tracker;
\c wildlife_tracker;
CREATE TABLE animals (id SERIAL PRIMARY KEY, name VARCHAR, type VARCHAR);
CREATE TABLE sightings (id SERIAL PRIMARY KEY, name VARCHAR, location VARCHAR, rangerName VARCHAR);