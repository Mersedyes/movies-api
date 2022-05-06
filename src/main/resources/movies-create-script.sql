-- # 1. go get the json file from glitch
-- # 2. copypasta into a new json file under /resources

# --> You may need to establish a connection to your localhost db here

--  3. create the movies_db
CREATE DATABASE movies_db;

-- # 4. use the movies_db
USE movies_db;

-- # 5. drop the table(s) to which no other tables are dependent (none at first)
DROP TABLE IF EXISTS movies_db;
DROP TABLE IF EXISTS directors;

-- # 6. map the json movie properties to movies table columns
# --> start with just a movies table with all the columns found in the movie json properties
CREATE TABLE IF NOT EXISTS movies (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    plot text,
    posters text,
    rating char(1),
    director_id INT unsigned NOT NULL,
    primary key (id),
    foreign key (director_id) references directors (id)
);
DESCRIBE movies;

CREATE TABLE IF NOT EXISTS directors (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(128),
    primary key (id)
);
DESCRIBE directors;

CREATE TABLE IF NOT EXISTS movie_genre (
    movie_id INT unsigned NOT NULL,
    genre_id INT unsigned NOT NULL,
    id INT not null,
    foreign key (movie_id) references Movies (id),
    foreign key (genre_id) references movie_genre (id)
);
DESCRIBE movie_genre;

CREATE TABLE IF NOT EXISTS actors (
    id INT unsigned NOT NULL,
    name VARCHAR(255) NOT NULL
);
DESCRIBE actors;

CREATE TABLE IF NOT EXISTS movie_actors (
    movie_id INT unsigned NOT NULL,
    actor_id INT unsigned NOT NULL,
    foreign key (movie_id) references movies (id),
    foreign key (actor_id) references actors (id)
);
DESCRIBE movie_actors;


# 6a. Run the script to make sure it works

# 7. refactor to extract the directors to a new table with just an id and name
# --> change the movies table to reference the directors table via Foreign Key
# --> now that movies is dependent on directors, you need to move directors above movies in the script

# 8. Go add DROP IF EXIST statements for movies and directors

# 9. RUN IT!




